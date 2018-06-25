/** 
 *  项目名称:lzjw 
 * 文件名称:NewList.java 
 * 包名:com.telecomyt.entity 
 * 创建日期:2018年5月13日下午4:35:45 
 * Copyright (c) 2018, zhoupengbing@telecomyt.com.cn All Rights Reserved.  
 */  
package com.telecomyt.entity;

import java.util.List;

/** 
 * 项目名称：lzjw    
 * 类名称：NewList    
 * 类描述： 新闻列表   
 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn    
 * 创建时间：2018年5月13日 下午4:35:45    
 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn 
 * 修改时间：2018年5月13日 下午4:35:45    
 * 修改备注：       
 * @version      
 */
public class NewList {
	
	private List<Data>newList;
	private int currentPage;
	private int totalpage;
	
	public List<Data> getNewList() {
		return newList;
	}
	public void setNewList(List<Data> newList) {
		this.newList = newList;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
}
