/** 
 *  项目名称:lzjw 
 * 文件名称:SyncTest.java 
 * 包名:String 
 * 创建日期:2018年5月24日下午3:35:54 
 * Copyright (c) 2018, zhoupengbing@telecomyt.com.cn All Rights Reserved.  
 */  
package String;

import org.junit.Test;

import com.telecomyt.entity.SyncFileData;
import com.telecomyt.exception.GsonDataConvertException;
import com.telecomyt.utils.GsonUtil;
import com.telecomyt.utils.SyncFileUtils;

/** 
 * 项目名称：lzjw    
 * 类名称：SyncTest    
 * 类描述：测试同步
 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn    
 * 创建时间：2018年5月24日 下午3:35:54    
 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn 
 * 修改时间：2018年5月24日 下午3:35:54    
 * 修改备注：       
 * @version      
 */
public class SyncTest {
	
	/**
	 * syncFileTest(测试文件同步)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月24日 下午3:36:26    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月24日 下午3:36:26    
	 * 修改备注：
	 */
	@Test
	public void syncFileTest(){
		
		try {
			SyncFileData syncFile = SyncFileUtils.syncFile("00a624a28a5eab3524bdeec5cc70697b23fad2ed.xls",2);
			System.out.println(GsonUtil.toJson(syncFile));
		} catch (GsonDataConvertException e) {
			e.printStackTrace();
		}
		
	}
	
}
