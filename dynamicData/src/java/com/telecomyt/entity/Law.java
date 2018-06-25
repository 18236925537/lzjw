/** 
 *  项目名称:lzjw 
 * 文件名称:Law.java 
 * 包名:com.telecomyt.entity 
 * 创建日期:2018年5月16日下午7:25:38 
 * Copyright (c) 2018, zhoupengbing@telecomyt.com.cn All Rights Reserved.  
 */  
package com.telecomyt.entity;

/** 
 *  项目名称：lzjw    
 * 类名称：Law    
 * 类描述：    
 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn    
 * 创建时间：2018年5月16日 下午7:25:38    
 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn 
 * 修改时间：2018年5月16日 下午7:25:38    
 * 修改备注：       
 * @version      
 */
public class Law {
	
	private int id;
	private String firstTitle;
	private String secondTitle;
	private String detail;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstTitle() {
		return firstTitle;
	}
	public void setFirstTitle(String firstTitle) {
		this.firstTitle = firstTitle;
	}
	public String getSecondTitle() {
		return secondTitle;
	}
	public void setSecondTitle(String secondTitle) {
		this.secondTitle = secondTitle;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
}
