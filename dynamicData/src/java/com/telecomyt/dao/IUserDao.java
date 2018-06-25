/** 
 *  项目名称:lzjw 
 * 文件名称:IUserDao.java 
 * 包名:com.telecomyt.dao 
 * 创建日期:2018年6月3日下午2:47:50 
 * Copyright (c) 2018, zhoupengbing@telecomyt.com.cn All Rights Reserved.  
 */  
package com.telecomyt.dao;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.telecomyt.entity.AppInfo;
import com.telecomyt.entity.LzUser;
import com.telecomyt.template.AppVersion;
import com.telecomyt.template.UpdateSnsSignature;

/** 
 *  项目名称：lzjw    
 * 类名称：IUserDao    
 * 类描述：    
 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn    
 * 创建时间：2018年6月3日 下午2:47:50    
 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn 
 * 修改时间：2018年6月3日 下午2:47:50    
 * 修改备注：       
 * @version      
 */
public interface IUserDao {

	/**getAppVersionCode(获取系统中app的版本号)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年6月3日 下午2:49:18    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年6月3日 下午2:49:18    
	 * 修改备注： 
	 * @return     
	 */
	AppVersion getAppVersionCode();

	/**updateAppVersion(更新系统app的版本号)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年6月3日 下午2:55:03    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年6月3日 下午2:55:03    
	 * 修改备注： 
	 * @param versionCode     
	 */
	void addAppVersion(@Param("versionCode")int versionCode,@Param("versionName")String versionName,@Param("updateDate")Date updateDate);

	/**getAllSnsUsers(获取需要更新签名的用户信息)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年6月3日 下午4:42:20    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年6月3日 下午4:42:20    
	 * 修改备注： 
	 * @return     
	 */
	List<UpdateSnsSignature> getAllSnsUsers();

	/**updateSnsUserSig(这里用一句话描述这个方法的作用)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年6月3日 下午4:43:21    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年6月3日 下午4:43:21    
	 * 修改备注： 
	 * @param uid
	 * @param area     
	 */
	void updateSnsUserSig(@Param("uid")String uid,@Param("area")String area);

	/**updateUserImei(更新用户的imei号)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年6月4日 下午2:05:57    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年6月4日 下午2:05:57    
	 * 修改备注： 
	 * @param gzbUserName
	 * @param imei
	 * @param date     
	 */
	void updateUserImei(@Param("idCard")String idCard,@Param("imei")String imei,@Param("updateDate")Date date);

	/**getUserImei(获取用户的imei号)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年6月4日 下午2:17:21    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年6月4日 下午2:17:21    
	 * 修改备注： 
	 * @param idCard
	 * @return     
	 */
	String getUserImei(@Param("idCard")String idCard);

	/**authUser(验证用户的账号密码)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年6月5日 上午9:45:30    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年6月5日 上午9:45:30    
	 * 修改备注： 
	 * @param username
	 * @param pwd
	 * @return     
	 */
	LzUser authUser(@Param("username")String username,@Param("pwd")String pwd);

	/**updateUserPwd(更改用户的密码)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年6月5日 上午9:49:03    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年6月5日 上午9:49:03    
	 * 修改备注： 
	 * @param username
	 * @param newPwd     
	 */
	void updateUserPwd(@Param("username")String username,@Param("newPwd")String newPwd);

	/**addAppInfo(这里用一句话描述这个方法的作用)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年6月12日 下午2:55:30    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年6月12日 下午2:55:30    
	 * 修改备注： 
	 * @return     
	 */
	int addAppInfo(AppInfo info);
	
	
	
}
