/** 
 *  项目名称:lzjw 
 * 文件名称:IAppDao.java 
 * 包名:com.telecomyt.dao 
 * 创建日期:2018年6月5日下午4:42:09 
 * Copyright (c) 2018, zhoupengbing@telecomyt.com.cn All Rights Reserved.  
 */  
package com.telecomyt.dao;

import java.util.Date;
import org.apache.ibatis.annotations.Param;
import com.telecomyt.entity.AppInfo;

/** 
 * 项目名称：lzjw    
 * 类名称：IAppDao    
 * 类描述：app数据接口类    
 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn    
 * 创建时间：2018年6月5日 下午4:42:09    
 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn 
 * 修改时间：2018年6月5日 下午4:42:09    
 * 修改备注：       
 * @version      
 */
public interface IAppDao {

	/**getApp(获取app信息)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年6月5日 下午4:52:52    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年6月5日 下午4:52:52    
	 * 修改备注： 
	 * @param appPackage 应用包名
	 * @return     
	 */
	AppInfo getApp(@Param("appPackage")String appPackage);

	/**updateApp(更新app信息)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年6月5日 下午4:54:07    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年6月5日 下午4:54:07    
	 * 修改备注： 
	 * @param id app记录的主键id
	 * @param count 应用的点击次数
	 * @param date 应用的更新时间   
	 */
	void updateApp(@Param("id")int id,@Param("appCode")String code,@Param("appCorpId")String corpId,@Param("appClickCount")int count,@Param("date")Date date);

	/**addAppInfo(添加应用信息)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年6月5日 下午4:56:16    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年6月5日 下午4:56:16    
	 * 修改备注： 
	 * @param appPackage 应用的包名
	 * @param appName 应用的名称
	 * @param code 点击应用获取的code
	 * @param corpId 点击应用获取的corpId
	 * @param date 应用的更新时间
	 */
	void addAppInfo(@Param("appPackage")String appPackage,@Param("appName")String appName,@Param("appCode")String code,@Param("appCorpId")String corpId,@Param("date")Date date);

}
