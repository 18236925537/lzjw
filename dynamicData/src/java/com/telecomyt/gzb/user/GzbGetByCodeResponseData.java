/** 
 *  项目名称:lzjw 
 * 文件名称:GzbGetByCodeResponseData.java 
 * 包名:com.telecomyt.gzb.user 
 * 创建日期:2018年5月22日下午1:50:54 
 * Copyright (c) 2018, zhoupengbing@telecomyt.com.cn All Rights Reserved.  
 */  
package com.telecomyt.gzb.user;

/** 
 *  项目名称：lzjw    
 * 类名称：GzbGetByCodeResponseData    
 * 类描述：    
 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn    
 * 创建时间：2018年5月22日 下午1:50:54    
 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn 
 * 修改时间：2018年5月22日 下午1:50:54    
 * 修改备注：       
 * @version      
 */
public class GzbGetByCodeResponseData {
	
	private String resp_code;
	private String resp_msg;
	private String client_type;
	private String name;
	private String user_id;
	private String agent_id;
	
	public String getResp_code() {
		return resp_code;
	}
	public void setResp_code(String resp_code) {
		this.resp_code = resp_code;
	}
	public String getResp_msg() {
		return resp_msg;
	}
	public void setResp_msg(String resp_msg) {
		this.resp_msg = resp_msg;
	}
	public String getClient_type() {
		return client_type;
	}
	public void setClient_type(String client_type) {
		this.client_type = client_type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getAgent_id() {
		return agent_id;
	}
	public void setAgent_id(String agent_id) {
		this.agent_id = agent_id;
	}
	
}
