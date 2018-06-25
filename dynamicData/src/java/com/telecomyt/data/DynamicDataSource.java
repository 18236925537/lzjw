/** 
 *  项目名称:lzjw_test 
 * 文件名称:DynamicDataSource.java 
 * 包名:com.telecomyt.data 
 * 创建日期:2018年6月6日上午11:31:09 
 * Copyright (c) 2018, zhoupengbing@telecomyt.com.cn All Rights Reserved.  
 */  
package com.telecomyt.data;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/** 
 * 项目名称：lzjw_test    
 * 类名称：DynamicDataSource    
 * 类描述：    
 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn    
 * 创建时间：2018年6月6日 上午11:31:09    
 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn 
 * 修改时间：2018年6月6日 上午11:31:09    
 * 修改备注：       
 * @version      
 */
public class DynamicDataSource extends AbstractRoutingDataSource{
	
	@Override
	protected Object determineCurrentLookupKey() {
		return DataBaseContextHolder.getCustomerType();
	}
	
}
