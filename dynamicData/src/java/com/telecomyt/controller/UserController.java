/** 
 * 项目名称:lzjw 
 * 文件名称:UserController.java 
 * 包名:com.telecomyt.controller 
 * 创建日期:2018年5月8日上午9:43:21 
 * Copyright (c) 2018, zhoupengbing@telecomyt.com.cn All Rights Reserved.  
 */  
package com.telecomyt.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.telecomyt.entity.LzUser;
import com.telecomyt.entity.OpenSnsLoginResponseData;
import com.telecomyt.entity.ResponseData;
import com.telecomyt.exception.GsonDataConvertException;
import com.telecomyt.gzb.GzbUserApi;
import com.telecomyt.gzb.depart.GzbDepartApi;
import com.telecomyt.gzb.user.GzbGetByCodeResponseData;
import com.telecomyt.gzb.user.GzbGetUserResponseData;
import com.telecomyt.gzb.user.GzbSearchUserResponseData;
import com.telecomyt.opensns.OpenSnsApi;
import com.telecomyt.service.IUserService;
import com.telecomyt.utils.GsonUtil;
import com.telecomyt.utils.HttpUtil;
import com.telecomyt.utils.HttpsGet;
import com.telecomyt.utils.OpenSNSApi;

/** 
 * 项目名称：lzjw    
 * 类名称：UserController    
 * 类描述：用户控制层
 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn    
 * 创建时间：2018年5月8日 上午9:43:21    
 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn 
 * 修改时间：2018年5月8日 上午9:43:21    
 * 修改备注：       
 * @version      
 */
@Controller
public class UserController {

	Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private IUserService userService;
	
	/**
	 * login(用户登陆接口)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年6月3日 下午1:41:33    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年6月3日 下午1:41:33    
	 * 修改备注： 
	 * @param gzbUserName gzb用户名	
	 * @param gzbPassword gzb密码
	 * @param versionName 版本号
	 * @param versionCode 版本号
	 * @param imei
	 * @return 登陆返回信息
	 */
	@ResponseBody
	@RequestMapping(value="/login")
	public String login(String gzbUserName,String gzbPassword,String versionName,int versionCode,String imei){
		String response = this.userService.login(gzbUserName,gzbPassword,versionName,versionCode,imei);
		return response;
	}
	
	
	
	/**
	 * updateAvatar(更新用户的头像)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月8日 上午9:49:32    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月8日 上午9:49:32    
	 * 修改备注： 
	 * @return
	 */
	@RequestMapping("/updateAvatar")
	public String updateAvatar(){
		InputStream in = null;
		String response = "";
		try {
			// 获取上传的文件
			in = new FileInputStream("E:/image.xlsx");
			response = userService.updateAvatar(in);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return response;
	}
	
	/**
	 * getGzbUserInfo(获取gzb用户信息)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月22日 上午10:50:22    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月22日 上午10:50:22    
	 * 修改备注： 
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value="/user/info")
	public String getGzbUserInfo(String code,String corp_id) throws Exception{
		logger.info("\n\n code==="+code+"==corp_id==="+corp_id+"\n\n");
		String response = this.userService.getGzbUserInfo(code);
		logger.info("\n\n 获取gzb用户返回信息=="+response+"\n\n");
		return response;
	}
	
	/**
	 * login(这里用一句话描述这个方法的作用)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月26日 下午11:28:42    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月26日 下午11:28:42    
	 * 修改备注： 
	 * @param username
	 * @param password
	 * @return
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping(value="/opensns/login")
	public String login(String username) throws IOException{
		String login = OpenSnsApi.login(username);
		System.out.println(login);
		return login;
	}
	
	/**
	 * checkPwd(验证用户的账号密码)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年6月5日 上午9:48:25    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年6月5日 上午9:48:25    
	 * 修改备注： 
	 * @param username
	 * @param pwd
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/checkPwd")
	public String checkPwd(String username,String pwd) throws Exception{
		ResponseData data = new ResponseData();
		LzUser user = this.userService.authUser(username,pwd);
		if(user != null){
			data.setCode("200");
			data.setMessage("密码正确");
			data.setData(null);
		}else{
			data.setCode("400");
			data.setMessage("密码不正确");
			data.setData(null);
		}
		return GsonUtil.toJson(data);
	}
	
	/**
	 * updatePwd(更改密码)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年6月3日 下午4:04:56    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年6月3日 下午4:04:56    
	 * 修改备注： 
	 * @param username
	 * @param oldPwd
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updatePwd")
	public String updatePwd(String username,String oldPwd,String newPwd){
		String response = this.userService.updatePwd(username,oldPwd,newPwd);
		return response;
	}
	
	/**
	 * regionTest(辖区概况接口测试)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月31日 下午4:06:47    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月31日 下午4:06:47    
	 * 修改备注： 
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value="/region")
	public String regionTest() throws Exception{
		String url = "http://20.124.143.122:7001/app/Data2Service?appid=LCJW&resid=AAAWKSAAJAAAEEmAAA";
		String response = HttpUtil.get(url);
		System.out.println("测试辖区概况接口返回信息\n"+response);
		return response;
	}
	
	/**
	 * updateSnsUserSignature(更改sns用户的签名为机构名称)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年6月3日 下午4:38:19    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年6月3日 下午4:38:19    
	 * 修改备注： 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/signature")
	public String updateSnsUserSignature(){
		String response = this.userService.updateSignature();
		return response;
	}
	
}
