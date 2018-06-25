/** 
 *  项目名称:lzjw 
 * 文件名称:QueryPersonInfoResponseData.java 
 * 包名:com.telecomyt.template 
 * 创建日期:2018年5月29日下午2:35:13 
 * Copyright (c) 2018, zhoupengbing@telecomyt.com.cn All Rights Reserved.  
 */  
package com.telecomyt.template;

import java.util.List;

/** 
 * 项目名称：lzjw    
 * 类名称：QueryPersonInfoResponseData    
 * 类描述： 查询常住人口返回信息  
 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn    
 * 创建时间：2018年5月29日 下午2:35:13    
 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn 
 * 修改时间：2018年5月29日 下午2:35:13    
 * 修改备注：       
 * @version      
 */
@SuppressWarnings("unused")
public class QueryPersonInfoResponseData {
	
	private String sid;
	private String resultCode;
	private String resultMsg;
	private List<PersonInfoData> resultData;
	
	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public List<PersonInfoData> getResultData() {
		return resultData;
	}

	public void setResultData(List<PersonInfoData> resultData) {
		this.resultData = resultData;
	}
	
}
