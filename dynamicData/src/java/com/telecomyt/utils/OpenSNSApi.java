/** 
 *  项目名称:lzjw 
 * 文件名称:OpenSNSApi.java 
 * 包名:com.telecomyt.utils 
 * 创建日期:2018年5月13日下午10:06:32 
 * Copyright (c) 2018, zhoupengbing@telecomyt.com.cn All Rights Reserved.  
 */  
package com.telecomyt.utils;
import com.telecomyt.entity.OpenSnsLoginResponseData;
import com.telecomyt.enums.Constants;
import com.telecomyt.exception.GsonDataConvertException;
import net.sf.json.JSONObject;

/** 
 * 项目名称：lzjw    
 * 类名称：OpenSNSApi    
 * 类描述：OpenSNSapi
 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn    
 * 创建时间：2018年5月13日 下午10:06:32    
 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn 
 * 修改时间：2018年5月13日 下午10:06:32    
 * 修改备注：       
 * @version      
 */
public class OpenSNSApi {
	
	/**
	 * login(登陆接口)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月13日 下午10:07:33    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月13日 下午10:07:33    
	 * 修改备注： 
	 * @param username 用戶名
	 * @param password 密码
	 * @return
	 * @throws GsonDataConvertException 
	 */
	public static String login(String username,String password) throws GsonDataConvertException{
//		String loginUrl = Constants.OPENSNS_SERVER_URL+"/api/authorization";
		String loginUrl = "http://61.148.30.210:33892/api/authorization";
		JSONObject obj = new JSONObject();
		obj.put("username",username);
		obj.put("password", password);
//		obj.put("access_token", Constants.OPENSNS_ACCESS_TOKEN);
		obj.put("access_token", "db69fc039dcbd2962cb4d28f5891aae1");
		obj.put("method", "POST");
		String response = HttpPost.addJson(loginUrl,GsonUtil.toJson(obj),"utf-8");
		System.out.println("登陆opensns返回信息"+response);
//		OpenSnsLoginResponseData loginData = GsonUtil.fromJson(response,OpenSnsLoginResponseData.class);
		return response;
	}
	
	public static void main(String[] args) throws GsonDataConvertException {
		String response = login("18236925537@163.com", "123456");
		System.out.println(response);
	}
}
