/** 
 *  项目名称:lzjw 
 * 文件名称:UserServiceImpl.java 
 * 包名:com.telecomyt.service.impl 
 * 创建日期:2018年5月8日上午10:12:33 
 * Copyright (c) 2018, zhoupengbing@telecomyt.com.cn All Rights Reserved.  
 */  
package com.telecomyt.service.impl;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import com.telecomyt.dao.ILiuZhouDao;
import com.telecomyt.dao.IUserDao;
import com.telecomyt.data.DataBaseContextHolder;
import com.telecomyt.data.DataSourceType;
import com.telecomyt.entity.LzUser;
import com.telecomyt.entity.ResponseData;
import com.telecomyt.entity.User;
import com.telecomyt.enums.Constants;
import com.telecomyt.gzb.GzbUserApi;
import com.telecomyt.gzb.depart.GzbDepartApi;
import com.telecomyt.gzb.depart.GzbDepartInfoResponseData;
import com.telecomyt.gzb.user.GzbGetByCodeResponseData;
import com.telecomyt.gzb.user.GzbGetUserResponseData;
import com.telecomyt.gzb.user.GzbSearchUserResponseData;
import com.telecomyt.gzb.user.GzbUpdateUserResponseData;
import com.telecomyt.gzb.user.GzbUserDetailInfo;
import com.telecomyt.gzb.user.GzbUserInfo;
import com.telecomyt.gzb.user.ResposeGZBImage;
import com.telecomyt.service.IUserService;
import com.telecomyt.template.AppVersion;
import com.telecomyt.template.UpdateSnsSignature;
import com.telecomyt.utils.ExcelUtil;
import com.telecomyt.utils.GsonUtil;

import common.Logger;

/** 
 * 项目名称：lzjw    
 * 类名称：UserServiceImpl    
 * 类描述：    
 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn    
 * 创建时间：2018年5月8日 上午10:12:33    
 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn 
 * 修改时间：2018年5月8日 上午10:12:33    
 * 修改备注：       
 * @version      
 */
@Service("userService")
public class UserServiceImpl implements IUserService{
	
	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private ILiuZhouDao liuZhouDao;
	
	@Autowired
	private IUserDao userDao;
	
	@Override
	public String updateAvatar(InputStream in){
		try {
			int num = 0;
			List<String>error = new ArrayList<>();
			List<List<Object>> listob = ExcelUtil.getBankListByExcel(in,"image.xlsx");
			for (int i = 0; i < listob.size(); i++) {
				try {
					List<Object> ob = listob.get(i);
					//身份证号
					String idCard = String.valueOf(ob.get(1));
					String name = String.valueOf(ob.get(0));
					System.out.println("idCard=="+idCard);
					String avatarPath = "E:/image/"+idCard+".jpg";
					ResposeGZBImage updateAvatar = GzbUserApi.updateAvatar(avatarPath);
					if(updateAvatar != null && updateAvatar.getResp_code().equals("200")){
						//成功
						if(updateAvatar.getResp_code().equals("200")){
							GzbSearchUserResponseData searchUser = GzbUserApi.searchUser(idCard,"");
							if(searchUser != null){
								GzbUserInfo[] items = searchUser.getItems();
								String password = idCard.substring(idCard.length()-6,idCard.length());
								GzbUserInfo gzbUserInfo = items[0];
								GzbUpdateUserResponseData updateUser = GzbUserApi.updateUser(gzbUserInfo.getUser_id(),name, 
										password, updateAvatar.getDown_url(),"");
								if(updateUser != null && updateUser.getResp_code().equals("200")){
									num += 1;
								}
							}
						}
					}else{
						error.add(idCard);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			logger.info("\n\n 更改了===="+num+"个警员的头像信息\n\n");
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	@Override
	public String getGzbUserInfo(String code) {
		ResponseData data = new ResponseData();
		GzbUserDetailInfo info = new GzbUserDetailInfo();
		try{
			if(code != null && !code.equals("")){
				GzbGetByCodeResponseData byCode = GzbUserApi.getByCode(code);
				if(byCode != null && byCode.getResp_code().equals("200")){
					GzbGetUserResponseData user = GzbUserApi.getUser(byCode.getUser_id());
					if(user != null && !user.getUser_id().equals("")){
						info.setName(user.getName());
						info.setAvatar(user.getAvartar());
						info.setIdCard(user.getCustom_id());
						info.setTelephone(user.getMobile());
						info.setPoliceNumber(user.getExt().getX2());
						info.setDepartCode(user.getExt().getX3());
						GzbDepartInfoResponseData depart = GzbDepartApi.getDepart(user.getDepartments().get(0));
						if(depart != null && depart.getResp_code().equals("200")){
							info.setDepartment(depart.getName());
						}
						data.setCode("10000");
						data.setMessage("get user info success");
						data.setData(info);
					}else{
						data.setCode("10002");
						data.setData(null);
						data.setMessage("the user is not exit");
					}
				}else{
					data.setCode("10001");
					data.setData(null);
					data.setMessage("the code is expire or illegal");
				}
			}else{
				data.setCode("10003");
				data.setData(null);
				data.setMessage("the code is null");
			}
		}catch(Exception e){
			e.printStackTrace();
			data.setCode("10004");
			data.setData(null);
			data.setMessage("get user info fail");
		}
		return GsonUtil.toJson(data);
	}

	@Override
	public String login(String gzbUserName, String gzbPassword, String versionName, int versionCode, String imei) {
		ResponseData data = new ResponseData();
		Map<String,String>loginResponseData = new HashMap<>();
		try{
			LzUser authUser = authUser(gzbUserName,gzbPassword);
			if(authUser != null){
				//先验证版本号是否是最新的
				AppVersion code = this.userDao.getAppVersionCode();
				//版本号低于系统版本号
				if(versionCode < code.getVersionCode()){
					data.setCode("201");
					data.setMessage("当前版本号为"+versionName+",低于系统版本号"+code.getVersionName()+",请到应用商店下载最新的应用登陆");
					data.setData(null);
				}else{
					//版本高于数据库存储的系统的版本 更新系统数据库版本信息
					if(versionCode > code.getVersionCode()){
						Date updateDate = new Date();
						this.userDao.addAppVersion(versionCode,versionName,updateDate);
					}
					//版本号和系统版本号一致
					GzbSearchUserResponseData searchUser = GzbUserApi.searchUser(gzbUserName,"");
					//验证用户是否存在
					if(searchUser != null && searchUser.getTotal_items().length() > 0){
						//更新用户的imei号信息
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
						this.userDao.updateUserImei(gzbUserName,imei,new Date());
						//用户信息
						//sns
						loginResponseData.put("snsIp",Constants.OPENSNS_SERVER_URL);
						loginResponseData.put("snsToken",Constants.OPENSNS_ACCESS_TOKEN);
						loginResponseData.put("snsUserName",gzbUserName+"@lzPolice.com");
						loginResponseData.put("snsUserPassword","000000");
						//gzb
						loginResponseData.put("gzbIp",Constants.GZB_APP_IP);
						loginResponseData.put("gzbPort",Constants.GZB_APP_PORT);
						loginResponseData.put("gzbAppKey",Constants.GZB_APP_KEY);
						loginResponseData.put("gzbAppSecret",Constants.GZB_APP_SECRET);
						//html
						loginResponseData.put("lawHtmlUrl",Constants.LAW_HTML_URL);
						loginResponseData.put("snsCrowdUrl",Constants.CROWD_HTML_URL);
						loginResponseData.put("newHtmlUrl",Constants.NEWS_HTML_URL);
						loginResponseData.put("circleFavoriteHtmlUrl",Constants.CIRCLE_FAVORITE_HTML_URL);
						loginResponseData.put("noticeUserHtmlUrl",Constants.NOTICE_USER_HTML_URL);
						loginResponseData.put("noticeDynamicHtmlUrl",Constants.NOTICE_DYNAMIC_HTML_URL);
						loginResponseData.put("noticeSystemHtmlUrl",Constants.NOTICE_SYSTEM_HTML_URL);
						loginResponseData.put("circleHotHtmlUrl",Constants.CIRCLE_HOT_HTML_URL);
						loginResponseData.put("circleBaseHtmlUrl",Constants.CIRCLE_BASE_HTML_URL);
						loginResponseData.put("situationUrl",Constants.CHART_HTML_URL);
						data.setCode("200");
						data.setMessage("登陆成功");
						data.setData(loginResponseData);
					}else{
						data.setCode("200");
						data.setMessage("登陆成功");
						data.setData(loginResponseData);
					}
				}
			}else{
				data.setCode("401");
				data.setMessage("用户名或者密码错误");
				data.setData(null);
			}
		}catch(Exception e){
			e.printStackTrace();
			data.setCode("400");
			data.setMessage("登陆失败");
			data.setData(null);
		}
		return GsonUtil.toJson(data);
	}

	@Override
	public String updatePwd(String username, String oldPwd, String newPwd) {
		ResponseData data = new ResponseData();
		try{
			GzbSearchUserResponseData searchUser = GzbUserApi.searchUser(username,"");
			if(searchUser != null && searchUser.getTotal_items().length() > 0){
				GzbUserInfo info = searchUser.getItems()[0];
				GzbUpdateUserResponseData updateUser = GzbUserApi.updateUser(info.getUser_id(),info.getName(),newPwd,info.getAvatar(),info.getStatus());
				if(updateUser.getResp_code().equals("200")){
					this.userDao.updateUserPwd(username,newPwd);
					data.setCode("200");
					data.setMessage("更改密码成功");
					data.setData(null);
				}else{
					data.setCode("400");
					data.setMessage("更改密码失败");
					data.setData(null);
				}
			}else{
				data.setCode("201");
				data.setMessage("用户不存在");
				data.setData(null);
			}
		}catch(Exception e){
			e.printStackTrace();
			data.setCode("400");
			data.setMessage("更改密码失败");
			data.setData(null);
		}
		return GsonUtil.toJson(data);
	}

	
	@Override
	public String updateSignature() {
		ResponseData data = new ResponseData();
		try{
			//切换成sns数据源
			DataBaseContextHolder.setCustomerType(DataSourceType.SNS);
			List<UpdateSnsSignature>list = this.userDao.getAllSnsUsers();
			System.out.println("sns用户信息============"+GsonUtil.toJson(list.get(0)));
//			for (UpdateSnsSignature user : list) {
////				this.userDao.updateSnsUserSig(user.getUid(),user.getArea());
//			}
			//切换成lzjw的数据源
			DataBaseContextHolder.setCustomerType(DataSourceType.LZJW);
			String userImei = this.userDao.getUserImei("110101199910101234");
			System.out.println("lzjw用户的imei号=============="+userImei);
		}catch(Exception e){
			e.printStackTrace();
			data.setCode("400");
			data.setMessage("更改签名失败");
			data.setData(null);
		}
		return "111111";
	}

	@Override
	public LzUser authUser(String username, String pwd) {
		LzUser user = null;
		try{
			user = this.userDao.authUser(username,pwd);
		}catch(Exception e){
			e.printStackTrace();
		}
		return user;
	}
		
}
