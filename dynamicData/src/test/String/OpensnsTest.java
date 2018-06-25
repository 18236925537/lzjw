/** 
 *  项目名称:lzjw_third 
 * 文件名称:OpensnsTest.java 
 * 包名:String 
 * 创建日期:2018年5月24日下午7:25:51 
 * Copyright (c) 2018, zhoupengbing@telecomyt.com.cn All Rights Reserved.  
 */  
package String;

import java.io.IOException;

import org.junit.Test;

import com.telecomyt.opensns.OpenSnsApi;

/** 
 * 项目名称：lzjw_third    
 * 类名称：OpensnsTest    
 * 类描述：opensns测试用例
 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn    
 * 创建时间：2018年5月24日 下午7:25:51    
 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn 
 * 修改时间：2018年5月24日 下午7:25:51    
 * 修改备注：       
 * @version      
 */
public class OpensnsTest {
	
	/**
	 * loginTest(测试登陆)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月24日 下午7:26:56    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月24日 下午7:26:56    
	 * 修改备注：
	 */
	@Test
	public void loginTest(){
		try {
			String login = OpenSnsApi.login("450501196211030619@lzpolice.com");
			System.out.println("--------------------"+login);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
