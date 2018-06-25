/** 
 *  项目名称:lzjw_third 
 * 文件名称:SyncFileResponseData.java 
 * 包名:com.telecomyt.template 
 * 创建日期:2018年5月25日下午12:54:30 
 * Copyright (c) 2018, zhoupengbing@telecomyt.com.cn All Rights Reserved.  
 */  
package com.telecomyt.template;

import java.util.List;

import com.telecomyt.entity.News;

/** 
 *  项目名称：lzjw_third    
 * 类名称：SyncFileResponseData    
 * 类描述：    
 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn    
 * 创建时间：2018年5月25日 下午12:54:30    
 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn 
 * 修改时间：2018年5月25日 下午12:54:30    
 * 修改备注：       
 * @version      
 */
public class SyncFileResponseData {
	
	private String code;
	private String message;
	private List<News>data;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<News> getData() {
		return data;
	}
	public void setData(List<News> data) {
		this.data = data;
	}
	
}
