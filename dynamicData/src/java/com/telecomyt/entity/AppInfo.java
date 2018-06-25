/** 
 *  项目名称:lzjw 
 * 文件名称:AppInfo.java 
 * 包名:com.telecomyt.entity 
 * 创建日期:2018年6月5日下午4:44:50 
 * Copyright (c) 2018, zhoupengbing@telecomyt.com.cn All Rights Reserved.  
 */  
package com.telecomyt.entity;

import java.util.Date;

/** 
 *  项目名称：lzjw    
 * 类名称：AppInfo    
 * 类描述：    
 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn    
 * 创建时间：2018年6月5日 下午4:44:50    
 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn 
 * 修改时间：2018年6月5日 下午4:44:50    
 * 修改备注：       
 * @version      
 */
public class AppInfo {
	
	private int id;
	private String appPackage;
	private String appName;
	private String appCode;
	private String appCorpId;
	private String appId;
	private int appClickCount;
	private Date updateDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAppPackage() {
		return appPackage;
	}
	public void setAppPackage(String appPackage) {
		this.appPackage = appPackage;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getAppCode() {
		return appCode;
	}
	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}
	public String getAppCorpId() {
		return appCorpId;
	}
	public void setAppCorpId(String appCorpId) {
		this.appCorpId = appCorpId;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public int getAppClickCount() {
		return appClickCount;
	}
	public void setAppClickCount(int appClickCount) {
		this.appClickCount = appClickCount;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
