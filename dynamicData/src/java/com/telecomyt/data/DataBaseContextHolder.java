/** 
 *  项目名称:lzjw_test 
 * 文件名称:DataBaseContextHolder.java 
 * 包名:com.telecomyt.data 
 * 创建日期:2018年6月6日上午11:32:15 
 * Copyright (c) 2018, zhoupengbing@telecomyt.com.cn All Rights Reserved.  
 */  
package com.telecomyt.data;

/** 
 * 项目名称：lzjw_test    
 * 类名称：DataBaseContextHolder    
 * 类描述：    
 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn    
 * 创建时间：2018年6月6日 上午11:32:15    
 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn 
 * 修改时间：2018年6月6日 上午11:32:15    
 * 修改备注：       
 * @version      
 */
public class DataBaseContextHolder {
	
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

	public static void setCustomerType(String customerType) {
		contextHolder.set(customerType);
	}

	public static String getCustomerType() {
		return contextHolder.get();
	}

	public static void clearCustomerType() {
		contextHolder.remove();
	}
	
}
