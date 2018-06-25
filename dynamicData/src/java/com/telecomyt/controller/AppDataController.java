/** 
 *  项目名称:lzjw 
 * 文件名称:AppDataController.java 
 * 包名:com.telecomyt.controller 
 * 创建日期:2018年5月28日下午9:57:13 
 * Copyright (c) 2018, zhoupengbing@telecomyt.com.cn All Rights Reserved.  
 */  
package com.telecomyt.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.telecomyt.dao.ILiuZhouDao;
import com.telecomyt.dao.IUserDao;
import com.telecomyt.entity.AppInfo;
import com.telecomyt.enums.Constants;
import com.telecomyt.exception.GsonDataConvertException;
import com.telecomyt.service.IAppService;
import com.telecomyt.template.GetRegionDataREsponse;
import com.telecomyt.template.PersonInfoData;
import com.telecomyt.template.QueryPersonInfoResponseData;
import com.telecomyt.utils.GsonUtil;
import com.telecomyt.utils.HttpUtil;
import com.telecomyt.utils.HttpsPost;
import com.telecomyt.utils.SyncFileUtils;

import net.sf.json.JSONObject;

/** 
 * 项目名称：lzjw    
 * 类名称：AppDataController    
 * 类描述： 应用服务类   
 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn    
 * 创建时间：2018年5月28日 下午9:57:13    
 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn 
 * 修改时间：2018年5月28日 下午9:57:13    
 * 修改备注：       
 * @version      
 */
@Controller
@RequestMapping(value="/service")
public class AppDataController {
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private IAppService appService;
	
	@Autowired
	private ILiuZhouDao liuZhouDao;
	
	@Autowired
	private IUserDao userDao;
	
	/**
	 * gzbClickAppReturnMsg(获取点击app之后返回的信息--应用存在就更新code--不存在就保存应用信息)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年6月5日 下午4:02:57    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年6月5日 下午4:02:57    
	 * 修改备注： 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/app")
	public void gzbClickAppReturnMsg(HttpServletRequest request){
		//解析出请求参数
		String code = request.getParameter("code");
		String corpId = request.getParameter("corp_id");
		String appPackage = request.getParameter("app_package");
		String appName = request.getParameter("app_name");
		this.appService.updateAppInfo(code,corpId,appPackage,appName);
	}
	
	/**
	 * getAPpInfo(获取app的信息)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年6月5日 下午5:14:13    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年6月5日 下午5:14:13    
	 * 修改备注： 
	 * @param appPackage
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/app/info")
	public String getAPpInfo(String appPackage){
		String response = this.appService.getAppInfo(appPackage);
		return response;
	}
	
	/**
	 * queryPersonInfo(查询常住人口信息)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月28日 下午9:59:52    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月28日 下午9:59:52    
	 * 修改备注： 
	 * @param idCard 查询者的身份证号
	 * @param condition 查询条件
	 * @param name 查询者的姓名
	 * @param orgaCode 查询者的机构编码
	 * @param deviceId 设备的唯一标识
	 * @return
	 * @throws GsonDataConvertException 
	 */
	@ResponseBody
	@RequestMapping(value="/czrk")
	public String queryPersonInfo(String idCard,String name,String orgaCode,String deviceId,String condition) throws GsonDataConvertException{
		String imei = this.userDao.getUserImei(idCard);
		//如果没有就给默认的
		if(deviceId.equals("")){
			deviceId = Constants.DEVICE_ID;
		}
		String response = SyncFileUtils.queryPerson(name, idCard, orgaCode, imei,condition);
		QueryPersonInfoResponseData data = GsonUtil.fromJson(response, QueryPersonInfoResponseData.class);
		List<PersonInfoData>info = new ArrayList<>();
		if(data != null){
			List<PersonInfoData> resultData = data.getResultData();
			if(resultData != null && resultData.size() > 0){
				PersonInfoData personInfo = resultData.get(0);
				PersonInfoData person = liuZhouDao.queryPersonInfo(personInfo.getWhcd(),personInfo.getMz(),personInfo.getHyzk(),personInfo.getHkszd(),personInfo.getJgssx());
				personInfo.setWhcd(person.getWhcd());
				personInfo.setMz(person.getMz());
				personInfo.setHyzk(person.getHyzk());
				personInfo.setHkszd(person.getHkszd());
				personInfo.setJgssx(person.getJgssx());
				info.add(personInfo);
			}
		}
		data.setResultData(info);
		return GsonUtil.toJson(data);
	}
	
	/**
	 * getRegionData(获取辖区概况数据信息)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月31日 下午5:46:49    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月31日 下午5:46:49    
	 * 修改备注： 
	 * @return
	 * @throws IOException 
	 * @throws GsonDataConvertException 
	 */
	@ResponseBody
	@RequestMapping(value="/region")
	public String getRegionData() throws IOException, GsonDataConvertException{
		String response = HttpUtil.get(Constants.SERVER_REGION_URL);
		GetRegionDataREsponse data = GsonUtil.fromJson(response,GetRegionDataREsponse.class);
		logger.info("获取查询辖区概况返回信息"+response);
		return GsonUtil.toJson(data);
	}
	
	/**
	 * getCarInfo(获取车辆信息)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年6月4日 下午1:45:53    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年6月4日 下午1:45:53    
	 * 修改备注： 
	 * @param name 当前用户的姓名
	 * @param idCard 当前用户的身份证号
	 * @param condition 查询条件
	 * @param orgaCode 当前用户的机构编码
	 * @param imei 当前用户的设备id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/car")
	public String getCarInfo(String name,String idCard,String condition,String orgaCode){
		String deviceId = this.userDao.getUserImei(idCard);
		//如果没有就给默认的
		if(deviceId.equals("")){
			deviceId = Constants.DEVICE_ID;
		}
		String carInfoUrl = Constants.CAR_SERVER_URL;
		Map<String,String> obj = new HashMap<>();
		obj.put("uid",Constants.UID);
		obj.put("staffCode",idCard);
		obj.put("devId  ",deviceId);
		obj.put("appCode",Constants.APP_ID);
		obj.put("devAddress","SFZMHM='"+condition+"'");
		obj.put("XM",name);
		obj.put("GMSFHM",idCard);
		obj.put("GAJGJGDM",orgaCode);
		obj.put("condition","");
		String response = HttpsPost.addJson(carInfoUrl,GsonUtil.toJson(obj),"utf-8");
		logger.info("\n\n获取车辆信息的返回数据:\n"+response);
		return response;
	}
	
	/**
	 * checkImage(人像比对)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年6月4日 下午3:13:55    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年6月4日 下午3:13:55    
	 * 修改备注： 
	 * @param idCard
	 * @param imageStr
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/image")
	public String checkImage(String idCard,String imageStr){
		String deviceId = this.userDao.getUserImei(idCard);
		//如果没有就给默认的
		if(deviceId.equals("")){
			deviceId = Constants.DEVICE_ID;
		}
		String checkImageUrl = Constants.CHECK_IMAGE_URL;
		//请求参数
		Map<String,String> obj = new HashMap<>();
		obj.put("uid",Constants.UID);
		obj.put("staffCode",idCard);
		obj.put("devId  ",deviceId);
		obj.put("appCode",Constants.APP_ID);
		obj.put("visitlog.reqEsbTime","");
		obj.put("strImage",imageStr);
		//相似程度
		obj.put("threshold","80");
		//返回的结果数
		obj.put("topNumber","2");
		String response = HttpsPost.addJson(checkImageUrl,GsonUtil.toJson(obj),"utf-8");
		logger.info("\n\n获取人像比对的返回数据:\n"+response);
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value="/testInsert")
	public void  testInsertReturnData(){
		AppInfo info = new AppInfo();
		info.setAppCode("0000000000");
		info.setAppId("00000");
		info.setAppName("000000");
		info.setAppPackage("0000000000");
		info.setUpdateDate(new Date());
		int id = this.userDao.addAppInfo(info);
		System.out.println("id==="+info.getId());
	}
}
