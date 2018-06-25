/** 
 *  项目名称:lzjw 
 * 文件名称:OpensnsApi.java 
 * 包名:com.telecomyt.opensns 
 * 创建日期:2018年5月24日下午4:36:43 
 * Copyright (c) 2018, zhoupengbing@telecomyt.com.cn All Rights Reserved.  
 */  
package com.telecomyt.opensns;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.telecomyt.utils.GsonUtil;
import com.telecomyt.utils.HttpClientUtils;
import com.telecomyt.utils.HttpPost;
import com.telecomyt.utils.HttpUtil;

/** 
 * 项目名称：lzjw    
 * 类名称：OpensnsApi    
 * 类描述： opensns的接口类 
 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn    
 * 创建时间：2018年5月24日 下午4:36:43    
 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn 
 * 修改时间：2018年5月24日 下午4:36:43    
 * 修改备注：       
 * @version      
 */
@SuppressWarnings("unused")
public class OpenSnsApi {
	
	static Logger logger = Logger.getLogger(OpenSnsApi.class);
	
	private final static String Server_URL = "http://61.148.30.210:33892";
	private final static String ACCESS_TOKEN = "db69fc039dcbd2962cb4d28f5891aae1";
	
	/**
	 * login(登陆opensns)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月24日 下午7:24:59    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月24日 下午7:24:59    
	 * 修改备注： 
	 * @param username
	 * @return
	 * @throws IOException
	 */
	public static String login(String username) throws IOException{
		Map<String,String>obj = new HashMap<>();
//		JSONObject obj = new JSONObject();
		String loginUrl = Server_URL+"/api/authorization";
		obj.put("username", username);
		obj.put("password","000000");
		obj.put("access_token",ACCESS_TOKEN);
		obj.put("method", "POST");
		String response = HttpPost.addJson(loginUrl,GsonUtil.toJson(obj),"utf-8");
//		JSONObject httpPost = HttpClientUtils.httpPost(loginUrl, obj);
		logger.info("\n\n 登陆opensns返回信息:"+response+"\n\n");
		return response;
	}
	
}
