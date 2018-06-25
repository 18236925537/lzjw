/** 
 *  项目名称:lzjw 
 * 文件名称:PostTest.java 
 * 包名:String 
 * 创建日期:2018年5月26日下午11:46:16 
 * Copyright (c) 2018, zhoupengbing@telecomyt.com.cn All Rights Reserved.  
 */  
package String;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import com.telecomyt.utils.GsonUtil;
import com.telecomyt.utils.HttpPost;

/** 
 *  项目名称：lzjw    
 * 类名称：PostTest    
 * 类描述：    
 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn    
 * 创建时间：2018年5月26日 下午11:46:16    
 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn 
 * 修改时间：2018年5月26日 下午11:46:16    
 * 修改备注：       
 * @version      
 */
public class PostTest {
	
	 /**
	  * @param args
	  */
	public InputStream postMethod(String param, String urlStr,  
            String contentType) {  
  
        InputStream is = null;  
        try {  
            byte[] xmlData = param.getBytes("UTF-8");  
            URL url = new URL(urlStr);  
            URLConnection urlCon = url.openConnection();  
            urlCon.setDoOutput(false);  
            urlCon.setDoInput(true);  
            urlCon.setConnectTimeout(40000);  
            urlCon.setReadTimeout(40000);  
            urlCon.setUseCaches(false);  
            urlCon.setRequestProperty("Content-Type", contentType);  
            urlCon.setRequestProperty("Content-length",  
                    String.valueOf(xmlData.length));  
            DataOutputStream printout = new DataOutputStream(  
                    urlCon.getOutputStream());  
            printout.write(xmlData);  
            printout.flush();  
            printout.close();  
            is = urlCon.getInputStream();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return is;  
    }  
	
}
