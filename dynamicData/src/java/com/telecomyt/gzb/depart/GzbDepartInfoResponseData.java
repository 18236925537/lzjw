/** 
 *  项目名称:lzjw 
 * 文件名称:GzbDepartInfo.java 
 * 包名:com.telecomyt.gzb.depart 
 * 创建日期:2018年5月22日下午3:25:32 
 * Copyright (c) 2018, zhoupengbing@telecomyt.com.cn All Rights Reserved.  
 */  
package com.telecomyt.gzb.depart;

/** 
 *  项目名称：lzjw    
 * 类名称：GzbDepartInfo    
 * 类描述：    
 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn    
 * 创建时间：2018年5月22日 下午3:25:32    
 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn 
 * 修改时间：2018年5月22日 下午3:25:32    
 * 修改备注：       
 * @version      
 */
public class GzbDepartInfoResponseData {
	
	/**
	 * {
    "department_alias": "",
    "department_id": "d10027",
    "name": "警务保障处",
    "order": 9,
    "parent_id": "d10001",
    "resp_code": 200,
    "resp_msg": "success"
}
	 */
	private String department_alias;
	private String department_id;
	private String name;
	private String order;
	private String parent_id;
	private String resp_msg;
	private String resp_code;
	
	public String getDepartment_alias() {
		return department_alias;
	}
	public void setDepartment_alias(String department_alias) {
		this.department_alias = department_alias;
	}
	public String getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getParent_id() {
		return parent_id;
	}
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	public String getResp_msg() {
		return resp_msg;
	}
	public void setResp_msg(String resp_msg) {
		this.resp_msg = resp_msg;
	}
	public String getResp_code() {
		return resp_code;
	}
	public void setResp_code(String resp_code) {
		this.resp_code = resp_code;
	}
}
