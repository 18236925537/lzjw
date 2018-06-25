/** 
 *  项目名称:data 
 * 文件名称:User.java 
 * 包名:com.telecomyt.entity 
 * 创建日期:2018年5月7日下午3:56:34 
 * Copyright (c) 2018, zhoupengbing@telecomyt.com.cn All Rights Reserved.  
 */  
package com.telecomyt.entity;

/** 
 *  项目名称：data    
 * 类名称：User    
 * 类描述： 用户实体
 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn    
 * 创建时间：2018年5月7日 下午3:56:34    
 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn 
 * 修改时间：2018年5月7日 下午3:56:34    
 * 修改备注：       
 * @version      
 */
public class User {
	
	private int id;
	private String alias;
	private String phone;
	private String idCard;
	private String orgaCode;
	private String orgaName;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getOrgaCode() {
		return orgaCode;
	}
	public void setOrgaCode(String orgaCode) {
		this.orgaCode = orgaCode;
	}
	public String getOrgaName() {
		return orgaName;
	}
	public void setOrgaName(String orgaName) {
		this.orgaName = orgaName;
	}
	
}
