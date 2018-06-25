/** 
 *  项目名称:lzjw 
 * 文件名称:LzUser.java 
 * 包名:com.telecomyt.entity 
 * 创建日期:2018年6月5日上午9:40:58 
 * Copyright (c) 2018, zhoupengbing@telecomyt.com.cn All Rights Reserved.  
 */  
package com.telecomyt.entity;

import java.util.Date;

/** 
 * 项目名称：lzjw    
 * 类名称：LzUser    
 * 类描述： 人员信息
 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn    
 * 创建时间：2018年6月5日 上午9:40:58    
 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn 
 * 修改时间：2018年6月5日 上午9:40:58    
 * 修改备注：       
 * @version      
 */
public class LzUser {
	
	private String id;
	private String name;
	private String idCard;
	private String password;
	private Date updateDate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
