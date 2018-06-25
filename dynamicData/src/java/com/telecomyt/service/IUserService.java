/** 
 *  项目名称:lzjw 
 * 文件名称:IUserService.java 
 * 包名:com.telecomyt.service 
 * 创建日期:2018年5月8日上午9:50:02 
 * Copyright (c) 2018, zhoupengbing@telecomyt.com.cn All Rights Reserved.  
 */  
package com.telecomyt.service;

import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

import com.telecomyt.entity.LzUser;

/** 
 * 项目名称：lzjw    
 * 类名称：IUserService    
 * 类描述：用户的逻辑接口
 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn    
 * 创建时间：2018年5月8日 上午9:50:02    
 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn 
 * 修改时间：2018年5月8日 上午9:50:02    
 * 修改备注：       
 * @version      
 */
public interface IUserService {

	/**  updateAvatar(这里用一句话描述这个方法的作用)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月12日 下午3:54:28    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月12日 下午3:54:28    
	 * 修改备注： 
	 * @param in
	 * @param file
	 * @return     
	 */
	String updateAvatar(InputStream in);

	/**getGzbUserInfo(获取gzb用户信息)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月22日 下午3:11:29    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月22日 下午3:11:29    
	 * 修改备注： 
	 * @param code     
	 */
	String getGzbUserInfo(String code);

	/**login(用户登陆)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年6月3日 下午2:11:15    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年6月3日 下午2:11:15    
	 * 修改备注： 
	 * @param gzbUserName
	 * @param gzbPassword
	 * @param versionName
	 * @param versionCode
	 * @param imei
	 * @return     
	 */
	String login(String gzbUserName, String gzbPassword, String versionName,int versionCode, String imei);

	/**updatePwd(更改用户密码)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年6月3日 下午4:05:49    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年6月3日 下午4:05:49    
	 * 修改备注： 
	 * @param username
	 * @param oldPwd
	 * @param newPwd
	 * @return     
	 */
	String updatePwd(String username, String oldPwd, String newPwd);

	/**updateSignature(更改sns用户的签名为机构名称)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年6月3日 下午4:38:44    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年6月3日 下午4:38:44    
	 * 修改备注： 
	 * @return     
	 */
	String updateSignature();

	/**authUser(验证用户收否存在)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年6月5日 上午9:42:21    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年6月5日 上午9:42:21    
	 * 修改备注： 
	 * @param username
	 * @param pwd
	 * @return     
	 */
	LzUser authUser(String username, String pwd);
	
}
