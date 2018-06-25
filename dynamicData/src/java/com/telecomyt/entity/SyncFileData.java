/** 
 *  项目名称:lzjw 
 * 文件名称:SyncFileData.java 
 * 包名:com.telecomyt.entity 
 * 创建日期:2018年5月16日下午5:54:54 
 * Copyright (c) 2018, zhoupengbing@telecomyt.com.cn All Rights Reserved.  
 */  
package com.telecomyt.entity;

/** 
 * 项目名称：lzjw    
 * 类名称：SyncFileData    
 * 类描述：    
 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn    
 * 创建时间：2018年5月16日 下午5:54:54    
 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn 
 * 修改时间：2018年5月16日 下午5:54:54    
 * 修改备注：       
 * @version      
 */
public class SyncFileData {
	
	//一次通讯的唯一标识UID。
	private String sid;
	//响应码 
	private String resCode;
	//备注
	private String reason;
	//返回结果
	private String resData;
	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getResCode() {
		return resCode;
	}
	public void setResCode(String resCode) {
		this.resCode = resCode;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getResData() {
		return resData;
	}
	public void setResData(String resData) {
		this.resData = resData;
	}
	
}
