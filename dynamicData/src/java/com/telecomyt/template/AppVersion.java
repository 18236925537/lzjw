/** 
 *  项目名称:lzjw 
 * 文件名称:AppVersion.java 
 * 包名:com.telecomyt.template 
 * 创建日期:2018年6月3日下午3:45:02 
 * Copyright (c) 2018, zhoupengbing@telecomyt.com.cn All Rights Reserved.  
 */  
package com.telecomyt.template;

import java.util.Date;

/** 
 *  项目名称：lzjw    
 * 类名称：AppVersion    
 * 类描述：    
 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn    
 * 创建时间：2018年6月3日 下午3:45:02    
 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn 
 * 修改时间：2018年6月3日 下午3:45:02    
 * 修改备注：       
 * @version      
 */
public class AppVersion {
	
	private int id;
	private String versionName;
	private int versionCode;
	private Date updateDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVersionName() {
		return versionName;
	}
	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}
	public int getVersionCode() {
		return versionCode;
	}
	public void setVersionCode(int versionCode) {
		this.versionCode = versionCode;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
}
