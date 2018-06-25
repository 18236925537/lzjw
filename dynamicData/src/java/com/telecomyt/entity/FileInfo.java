/** 
 *  项目名称:lzjw 
 * 文件名称:FileInfo.java 
 * 包名:com.telecomyt.entity 
 * 创建日期:2018年5月13日下午7:39:08 
 * Copyright (c) 2018, zhoupengbing@telecomyt.com.cn All Rights Reserved.  
 */  
package com.telecomyt.entity;

/** 
 *  项目名称：lzjw    
 * 类名称：FileInfo    
 * 类描述：    
 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn    
 * 创建时间：2018年5月13日 下午7:39:08    
 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn 
 * 修改时间：2018年5月13日 下午7:39:08    
 * 修改备注：       
 * @version      
 */
public class FileInfo {
	
	private String url;//服务器地址
	private String checksum;
	private String path;//本地地址
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getChecksum() {
		return checksum;
	}
	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
}
