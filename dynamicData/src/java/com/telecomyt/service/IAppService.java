/** 
 *  项目名称:lzjw 
 * 文件名称:IAppservice.java 
 * 包名:com.telecomyt.service 
 * 创建日期:2018年6月5日下午4:32:00 
 * Copyright (c) 2018, zhoupengbing@telecomyt.com.cn All Rights Reserved.  
 */  
package com.telecomyt.service;

/** 
 *  项目名称：lzjw    
 * 类名称：IAppservice    
 * 类描述：    
 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn    
 * 创建时间：2018年6月5日 下午4:32:00    
 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn 
 * 修改时间：2018年6月5日 下午4:32:00    
 * 修改备注：       
 * @version      
 */
public interface IAppService {

	/**updateAppInfo(更新应用的信息)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年6月5日 下午4:32:50    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年6月5日 下午4:32:50    
	 * 修改备注： 
	 * @param code
	 * @param corpId
	 * @param appPackage
	 * @param appName
	 * @return     
	 */
	void updateAppInfo(String code, String corpId, String appPackage, String appName);

	/**getAppInfo(根据应用的包名获取应用的信息)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年6月5日 下午5:15:29    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年6月5日 下午5:15:29    
	 * 修改备注： 
	 * @param appPackage
	 * @return     
	 */
	String getAppInfo(String appPackage);
	
}
