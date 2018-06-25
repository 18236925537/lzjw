/** 
 *  项目名称:lzjw 
 * 文件名称:AddSyncRecordRequest.java 
 * 包名:com.telecomyt.template 
 * 创建日期:2018年5月25日下午1:30:15 
 * Copyright (c) 2018, zhoupengbing@telecomyt.com.cn All Rights Reserved.  
 */  
package com.telecomyt.template;

/** 
 *  项目名称：lzjw    
 * 类名称：AddSyncRecordRequest    
 * 类描述：    
 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn    
 * 创建时间：2018年5月25日 下午1:30:15    
 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn 
 * 修改时间：2018年5月25日 下午1:30:15    
 * 修改备注：       
 * @version      
 */
public class AddSyncRecordRequest {
	
	private String newId;
	private int isSuccess;
	public String getNewId() {
		return newId;
	}
	public void setNewId(String newId) {
		this.newId = newId;
	}
	public int getIsSuccess() {
		return isSuccess;
	}
	public void setIsSuccess(int isSuccess) {
		this.isSuccess = isSuccess;
	}
	
}
