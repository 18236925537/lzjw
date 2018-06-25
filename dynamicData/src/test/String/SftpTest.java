/** 
 *  项目名称:lzjw 
 * 文件名称:SftpTest.java 
 * 包名:String 
 * 创建日期:2018年5月26日上午10:34:12 
 * Copyright (c) 2018, zhoupengbing@telecomyt.com.cn All Rights Reserved.  
 */  
package String;

import org.junit.Test;

import com.telecomyt.utils.SftpUtils;

/** 
 *  项目名称：lzjw    
 * 类名称：SftpTest    
 * 类描述：    
 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn    
 * 创建时间：2018年5月26日 上午10:34:12    
 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn 
 * 修改时间：2018年5月26日 上午10:34:12    
 * 修改备注：       
 * @version      
 */
public class SftpTest {
	
	@Test
	public void downloadTest() throws Exception{
		SftpUtils sftp = new SftpUtils("dxydlcjw","dxyt2018=-","20.124.145.190",22);
		SftpUtils.downFile(sftp,"/upload/file_lz/test/","5fb35f4cee1f49918e93699a17168b8278a2157d.doc","20.124.143.141:8866/file_lz/test/1111.doc",true);
	}
	
}
