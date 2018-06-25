/** 
 *  项目名称:lzjw 
 * 文件名称:GzbDepartApi.java 
 * 包名:com.telecomyt.gzb.depart 
 * 创建日期:2018年5月22日下午2:48:09 
 * Copyright (c) 2018, zhoupengbing@telecomyt.com.cn All Rights Reserved.  
 */  
package com.telecomyt.gzb.depart;

import com.telecomyt.gzb.GzbUserApi;
import com.telecomyt.gzb.user.GzbGetTokenResponseData;
import com.telecomyt.utils.GsonUtil;
import com.telecomyt.utils.HttpUtil;

import common.Logger;

/** 
 * 项目名称：lzjw    
 * 类名称：GzbDepartApi    
 * 类描述：获取部门信息
 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn    
 * 创建时间：2018年5月22日 下午2:48:09    
 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn 
 * 修改时间：2018年5月22日 下午2:48:09    
 * 修改备注：       
 * @version      
 */
public class GzbDepartApi {
	
private static Logger logger = Logger.getLogger(GzbDepartApi.class);
	
	//请求路径
//	private static final String BASE_API_URI = PropertiesUtil.getAttribute(Constants.SETTING_PROPERTIES, Constants.PROPERTIES_ELEMENT_GZB_REQUEST_URL);
//	private static final String APP_KEY = PropertiesUtil.getAttribute(Constants.SETTING_PROPERTIES, Constants.PROPERTIES_ELEMENT_GZB_APP_KEY);
//	private static final String APP_SECRET = PropertiesUtil.getAttribute(Constants.SETTING_PROPERTIES, Constants.PROPERTIES_ELEMENT_GZB_APP_SECRET);
	//公网
	private static final String BASE_API_URI = "http://20.124.143.124:9090/eim/api";
	private static final String AGENT_ID = "10001";
	private static final String AGENT_SECRET = "vab9DPAfjORYfdF8gsMgnuLUO4iOxgsf";
	
	public static GzbGetTokenResponseData getComToken() throws  Exception{
		String getTokenUrl = BASE_API_URI+"/get_token?agent_id="+AGENT_ID+"&agent_secret="+AGENT_SECRET;
		System.out.println("getTokenUrl:"+getTokenUrl);
		String response = HttpUtil.get(getTokenUrl);
		System.out.println("获取access_token的返回数据："+response);
		GzbGetTokenResponseData gzbGetTokenResponseData = GsonUtil.fromJson(response, GzbGetTokenResponseData.class);
		return gzbGetTokenResponseData;
	}
	
	/**
	 * getDepart(获取部门信息)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月22日 下午2:50:05    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月22日 下午2:50:05    
	 * 修改备注： 
	 * @param depart_id
	 * @return
	 * @throws Exception 
	 */
	public static GzbDepartInfoResponseData getDepart(String depart_id) throws Exception{
		String access_token = getComToken().getAccess_token();
		String getDepart = BASE_API_URI+"/department/get?access_token="+access_token+"&department_id="+depart_id+"&fetch_user="+false;
		String response = HttpUtil.get(getDepart);
		GzbDepartInfoResponseData data = GsonUtil.fromJson(response,GzbDepartInfoResponseData.class);
		return data;
	}
}
