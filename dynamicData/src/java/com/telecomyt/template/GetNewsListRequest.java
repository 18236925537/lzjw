/** 
 *  项目名称:lzjw 
 * 文件名称:GetNewsListRequest.java 
 * 包名:com.telecomyt.template 
 * 创建日期:2018年5月24日下午9:07:26 
 * Copyright (c) 2018, zhoupengbing@telecomyt.com.cn All Rights Reserved.  
 */  
package com.telecomyt.template;

/** 
 * 项目名称：lzjw    
 * 类名称：GetNewsListRequest    
 * 类描述：    
 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn    
 * 创建时间：2018年5月24日 下午9:07:26    
 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn 
 * 修改时间：2018年5月24日 下午9:07:26    
 * 修改备注：       
 * @version      
 */
public class GetNewsListRequest {
	
	private String name;
	private int pageCount;
	private int currentPage;
	private int lastNewId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getLastNewId() {
		return lastNewId;
	}
	public void setLastNewId(int lastNewId) {
		this.lastNewId = lastNewId;
	}
	
}
