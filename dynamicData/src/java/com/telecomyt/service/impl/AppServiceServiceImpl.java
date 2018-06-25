/** 
 *  项目名称:lzjw 
 * 文件名称:AppServiceServiceImpl.java 
 * 包名:com.telecomyt.service.impl 
 * 创建日期:2018年6月5日下午4:39:05 
 * Copyright (c) 2018, zhoupengbing@telecomyt.com.cn All Rights Reserved.  
 */  
package com.telecomyt.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecomyt.dao.IAppDao;
import com.telecomyt.entity.AppInfo;
import com.telecomyt.entity.ResponseData;
import com.telecomyt.service.IAppService;
import com.telecomyt.utils.GsonUtil;

import common.Logger;

/** 
 *  项目名称：lzjw    
 * 类名称：AppServiceServiceImpl    
 * 类描述：    
 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn    
 * 创建时间：2018年6月5日 下午4:39:05    
 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn 
 * 修改时间：2018年6月5日 下午4:39:05    
 * 修改备注：       
 * @version      
 */
@Service("appService")
public class AppServiceServiceImpl implements IAppService{
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private IAppDao appDao;
	
	@Override
	public void updateAppInfo(String code, String corpId, String appPackage, String appName) {
		//验证app是否存在
		AppInfo app = this.appDao.getApp(appPackage);
		if(app != null){
			logger.info("\n\n 应用存在--更新应用信息\n\n");
			this.appDao.updateApp(app.getId(),code,corpId,app.getAppClickCount()+1,new Date());
		}else{
			logger.info("\n\n 应用不存在--添加应用信息\n\n");
			this.appDao.addAppInfo(appPackage,appName,code,corpId,new Date());
		}
	}

	@Override
	public String getAppInfo(String appPackage) {
		ResponseData data = new ResponseData();
		try{
			AppInfo app = this.appDao.getApp(appPackage);
			if(app != null){
				data.setCode("200");
				data.setMessage("获取应用信息成功");
				data.setData(app);
			}else{
				data.setCode("201");
				data.setMessage("应用不存在");
				data.setData(app);
			}
		}catch(Exception e){
			data.setCode("400");
			data.setMessage("获取应用信息失败");
			data.setData(null);
		}
		return GsonUtil.toJson(data);
	}
	
}
