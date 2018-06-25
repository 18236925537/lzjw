/** 
 *  项目名称:lzjw 
 * 文件名称:StringTest.java 
 * 包名:String 
 * 创建日期:2018年5月12日下午3:38:55 
 * Copyright (c) 2018, zhoupengbing@telecomyt.com.cn All Rights Reserved.  
 */  
package String;

import org.junit.Test;
import com.telecomyt.gzb.GzbUserApi;
import com.telecomyt.gzb.user.GzbSearchUserResponseData;
import com.telecomyt.template.GetRegionDataREsponse;
import com.telecomyt.utils.GsonUtil;

/** 
 * 项目名称：lzjw    
 * 类名称：StringTest    
 * 类描述：测试字符串的类    
 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn    
 * 创建时间：2018年5月12日 下午3:38:55    
 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn 
 * 修改时间：2018年5月12日 下午3:38:55    
 * 修改备注：       
 * @version      
 */
public class StringTest {
	
	@Test
	public void substringTest() throws Exception{
		GzbSearchUserResponseData searchUser = GzbUserApi.searchUser("u110081", "");
		System.out.println(GsonUtil.toJson(searchUser));
	}
	
	@Test
	public void spiltTest(){
//		String a = "http://10.150.1.37/userfiles/201512160002(2).jpg";
//		System.out.println("/"+a.split("//")[1].replaceFirst("/",":").split(":")[1]);
		String a = "2018/05/09";
		System.out.println(a.split("/").length);
	}
	
	@Test
	public void gsonTest() throws Exception{
		GzbSearchUserResponseData searchUser = GzbUserApi.searchUser("110101199910101234", "");
		System.out.println(searchUser.getTotal_items().length());
	}
}
