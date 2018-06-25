/** 
 *  项目名称:lzjw 
 * 文件名称:SecondTitle.java 
 * 包名:com.telecomyt.entity 
 * 创建日期:2018年5月13日下午3:29:50 
 * Copyright (c) 2018, zhoupengbing@telecomyt.com.cn All Rights Reserved.  
 */  
package com.telecomyt.entity;

/** 
 * 项目名称：lzjw    
 * 类名称：SecondTitle    
 * 类描述：二级目录实体类
 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn    
 * 创建时间：2018年5月13日 下午3:29:50    
 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn 
 * 修改时间：2018年5月13日 下午3:29:50    
 * 修改备注：       
 * @version      
 */
public class SecondTitle {
	
	private String name;
	private String subName;
	private boolean isEnd;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean getIsEnd() {
		return isEnd;
	}
	public void setIdEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
		if(subName != null && !subName.equals(" ") && !subName.equals("")){
			this.isEnd = false;
		}else{
			this.isEnd = true;
		}
	} 
}
