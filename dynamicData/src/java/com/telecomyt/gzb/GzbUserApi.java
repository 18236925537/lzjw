package com.telecomyt.gzb;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import org.junit.Test;
import com.telecomyt.gzb.user.GzbAuthUserResponseData;
import com.telecomyt.gzb.user.GzbBatchCreateUserResponseData;
import com.telecomyt.gzb.user.GzbBatchGetUserResponseData;
import com.telecomyt.gzb.user.GzbCreateUserResponseData;
import com.telecomyt.gzb.user.GzbDeleteUserResponseData;
import com.telecomyt.gzb.user.GzbGetByCodeResponseData;
import com.telecomyt.gzb.user.GzbGetTokenResponseData;
import com.telecomyt.gzb.user.GzbGetUserResponseData;
import com.telecomyt.gzb.user.GzbSearchUserResponseData;
import com.telecomyt.gzb.user.GzbUpdateUserResponseData;
import com.telecomyt.gzb.user.GzbUserInfo;
import com.telecomyt.gzb.user.ResposeGZBImage;
import com.telecomyt.utils.GsonUtil;
import com.telecomyt.utils.HttpPost;
import com.telecomyt.utils.HttpUtil;
import common.Logger;
import net.sf.json.JSONObject;
import sun.net.www.protocol.http.HttpURLConnection;

public class GzbUserApi {
	
	private static Logger logger = Logger.getLogger(GzbUserApi.class);
	
	//请求路径
//	private static final String BASE_API_URI = PropertiesUtil.getAttribute(Constants.SETTING_PROPERTIES, Constants.PROPERTIES_ELEMENT_GZB_REQUEST_URL);
//	private static final String APP_KEY = PropertiesUtil.getAttribute(Constants.SETTING_PROPERTIES, Constants.PROPERTIES_ELEMENT_GZB_APP_KEY);
//	private static final String APP_SECRET = PropertiesUtil.getAttribute(Constants.SETTING_PROPERTIES, Constants.PROPERTIES_ELEMENT_GZB_APP_SECRET);
	//公网
	private static final String BASE_API_URI = "http://20.124.143.124:9090/eim/api";
	private static final String BASE_API_IP = "http://20.124.143.124:9090";
	private static final String APP_KEY = "a10009";
	private static final String APP_SECRET = "OtyCUuPiQo5MJ1gNE4MeCnsBJNzxddRH";
	private static final String AGENT_ID = "10001";
	private static final String AGENT_SECRET = "vab9DPAfjORYfdF8gsMgnuLUO4iOxgsf";
		
	/**
	 * 根据key和secret获取access_token
	 * @param app_key
	 * @param app_secret
	 * @return
	 * @throws Exception
	 */
	public static GzbGetTokenResponseData getToken() throws  Exception{
		String getTokenUrl = BASE_API_URI+"/get_token?app_id="+APP_KEY+"&app_secret="+APP_SECRET;
		String response = HttpUtil.get(getTokenUrl);
		GzbGetTokenResponseData gzbGetTokenResponseData = GsonUtil.fromJson(response, GzbGetTokenResponseData.class);
		return gzbGetTokenResponseData;
	}
	
	/**
	 * getComToken(获取企业的access_token)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年6月3日 下午2:18:42    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年6月3日 下午2:18:42    
	 * 修改备注： 
	 * @return
	 * @throws Exception
	 */
	public static GzbGetTokenResponseData getComToken() throws  Exception{
		String getTokenUrl = BASE_API_URI+"/get_token?agent_id="+AGENT_ID+"&agent_secret="+AGENT_SECRET;
		System.out.println("getTokenUrl:"+getTokenUrl);
		String response = HttpUtil.get(getTokenUrl);
		System.out.println("获取access_token的返回数据："+response);
		GzbGetTokenResponseData gzbGetTokenResponseData = GsonUtil.fromJson(response, GzbGetTokenResponseData.class);
		return gzbGetTokenResponseData;
	}
	/**
	 *1.1 根据token进行用户身份验证
	 * @param access_token
	 * @return
	 * @throws Exception
	 */
	public static GzbAuthUserResponseData authUser(String auth_key,String password) throws  Exception{
	    String access_token = getComToken().getAccess_token();
		String authUserUrl = BASE_API_URI+"/member/auth?access_token="+access_token+"&auth_key="+auth_key+"&password="+auth_key;
		String response = HttpUtil.get(authUserUrl);
		System.out.println(response);
		GzbAuthUserResponseData gzbAuthUserResponseData = GsonUtil.fromJson(response, GzbAuthUserResponseData.class);
		
		return gzbAuthUserResponseData;
	}
	/**
	 * 1.2根据token创建用户
	 * @param access_token
	 * @param name
	 * @param password
	 * @param avatar
	 * @return
	 * @throws Exception
	 */
	public static GzbCreateUserResponseData createUser(String name,String password,String avatar)throws Exception{
		
		String access_token = getToken().getAccess_token();
		String createUserUrl = BASE_API_URI+"/user/create?"+"access_token="+access_token;
		System.out.println("createUserUrl"+createUserUrl);
		
		JSONObject obj = new JSONObject();  
		if(name != null || !name.equals("")){
			obj.put("name", name); // 姓名
		}
		if(password != null || !password.equals("")){
			obj.put("password", password);
		}
		if(avatar != null || !avatar.equals("")){
			obj.put("avatar", avatar);
		}
		logger.info("\n\n发送创建用户信息数据:"+obj);
		String response = HttpPost.post(createUserUrl,obj,"utf-8");
		logger.info("\n\n返回创建用户信息数据:"+response);
		GzbCreateUserResponseData gzbCreateUserResponseData = GsonUtil.fromJson(response, GzbCreateUserResponseData.class);
		
		return gzbCreateUserResponseData;
	}
	/**
	 * 1.3根据token批量创建用户
	 * @param access_token
	 * @param name
	 * @param password
	 * @param avatar
	 * @return
	 * @throws Exception
	 */
	public static GzbBatchCreateUserResponseData batchCreateUser(String common_password, GzbUserInfo[] items)throws Exception{
		String access_token = getToken().getAccess_token();
		String createUserUrl = BASE_API_URI+"/user/create_batch?"+"access_token="+access_token;
		System.out.println("createUserUrl"+createUserUrl);
		
		JSONObject obj = new JSONObject(); 
		if(common_password != null || common_password!="");
		obj.put("common_password", common_password);
		if(items != null);
		obj.put("items", items);
		logger.info("\n\n发送批量创建用户信息数据:"+obj);
		String response = HttpPost.post(createUserUrl,obj,"utf-8");
		logger.info("\n\n返回批量创建用户信息数据:"+response);
		GzbBatchCreateUserResponseData gzbBatchCreateUserResponseData = GsonUtil.fromJson(response, GzbBatchCreateUserResponseData.class);
		
		return gzbBatchCreateUserResponseData;
	}
	
	/**1.4更新用户信息
	 * @param access_token
	 * @param user_id
	 * @param name
	 * @param password
	 * @param avatar
	 * @param status
	 * @return
	 * @throws Exception
	 */
	public static GzbUpdateUserResponseData updateUser(String user_id,String name,String password,String avatar,String status)throws Exception{
			
		  String access_token = getToken().getAccess_token();
			String updateUserUrl = BASE_API_URI+"/user/update?"+"access_token="+access_token;
			System.out.println("updateUserUrl:"+updateUserUrl);
			
			JSONObject obj = new JSONObject();
			if(user_id != null || !user_id.equals("")){
				obj.put("user_id", user_id);
			}
			if(name != null || !name.equals("")){
				obj.put("name", name); // 姓名
			}
			if(password != null || !password.equals("")){
				obj.put("password", password);
			}
			if(avatar != null || !avatar.equals("")){
				obj.put("avatar", avatar);
			}
			if(status != null || !status.equals("")){
				obj.put("status", status);
			}
			logger.info("\n\n发送更新用户信息数据:"+obj);
			String response = HttpPost.post(updateUserUrl,obj,"utf-8");
			logger.info("\n\n返回更新用户信息数据:"+response);
			
			GzbUpdateUserResponseData gzbUpdateUserResponseData = GsonUtil.fromJson(response, GzbUpdateUserResponseData.class);
			
			return gzbUpdateUserResponseData;
	}
	/**
	 * 1.5删除用户
	 * @param access_token
	 * @param user_id
	 * @return
	 * @throws Exception
	 */
	public static GzbDeleteUserResponseData deleteUser(String user_id)throws Exception{
		
		String access_token = getToken().getAccess_token();
		String deleteUserUrl = BASE_API_URI + "/user/delete?" + "access_token=" + access_token + "&user_id=" + user_id;
		System.out.println("deleteUserUrl:" + deleteUserUrl);
		
		String response = HttpUtil.get(deleteUserUrl);
		logger.info("\n\n返回删除用户数据:"+response);
		GzbDeleteUserResponseData gzbDeleteUserResponseData = GsonUtil.fromJson(response, GzbDeleteUserResponseData.class);
		
		return gzbDeleteUserResponseData;
	}
	/**
	 * 1.6批量删除用户
	 * @param access_token
	 * @param user_ids
	 * @return
	 * @throws Exception
	 */
	public static GzbDeleteUserResponseData batchDeleteUser(String[] user_ids)throws Exception{
		
		String access_token = getToken().getAccess_token();
		String batchDeleteUserUrl = BASE_API_URI+"/user/delete_batch?"+"access_token="+access_token;
		System.out.println("batchDeleteUserUrl:"+batchDeleteUserUrl);
		
		JSONObject obj = new JSONObject();
		if(user_ids != null);
		obj.put("users", user_ids);
		logger.info("\n\n发送批量删除用户信息数据:"+obj);
		String response = HttpPost.post(batchDeleteUserUrl,obj,"utf-8");
		logger.info("\n\n返回批量删除用户信息数据:"+response);
		GzbDeleteUserResponseData gzbDeleteUserResponseData = GsonUtil.fromJson(response, GzbDeleteUserResponseData.class);
		
		return gzbDeleteUserResponseData;
	}
	/**
	 * 1.7获取成员
	 * @param access_token
	 * @param user_id
	 * @return
	 * @throws Exception
	 */
	public static GzbGetUserResponseData getUser(String user_id)throws Exception{
		
		String access_token = getComToken().getAccess_token();
//		String getUserUrl = BASE_API_URI+"/member/get?"+"access_token="+access_token+"&user_id="+user_id;
		String getUserUrl = BASE_API_URI+"/member/get?"+"access_token="+access_token+"&user_id="+user_id+"&return_type=detail";
		String response = HttpUtil.get(getUserUrl);
		GzbGetUserResponseData gzbGetUserResponseData = GsonUtil.fromJson(response, GzbGetUserResponseData.class);
		
		return gzbGetUserResponseData;
	}
	/**
	 * 1.8批量获取成员
	 * @param group_id
	 * @return
	 * @throws Exception
	 */
	public static GzbBatchGetUserResponseData batchGetUser(String[] user_ids)throws Exception{

		String access_token = getToken().getAccess_token();
		String batchGetUserUrl = BASE_API_URI+"/user/get_batch?"+"access_token="+access_token;
		System.out.println("batchGetUserUrl:"+batchGetUserUrl);
		
		JSONObject obj = new JSONObject();
		if(user_ids != null);
		obj.put("users", user_ids);
		logger.info("\n\n发送批量获取成员信息数据:"+obj);
		String response = HttpPost.post(batchGetUserUrl,obj,"utf-8");
		logger.info("\n\n返回批量获取成员信息数据:"+response);
		GzbBatchGetUserResponseData gzbBatchGetUserResponseData = GsonUtil.fromJson(response, GzbBatchGetUserResponseData.class);
		
		return gzbBatchGetUserResponseData;
	}
	
	/**
	 * 1.9搜索成员
	 * @param group_id
	 * @return
	 * @throws Exception
	 */
	public static GzbSearchUserResponseData searchUser( String key,String max_items)throws Exception{

		String access_token = getToken().getAccess_token();
		String searchUserUrl = BASE_API_URI+"/user/search?"+"access_token="+access_token;
		System.out.println("searchUserUrl:"+searchUserUrl);
		JSONObject obj = new JSONObject();
		if(key != null || key!="");
		obj.put("key", key);
		obj.put("return_type", "detail");
		if(max_items != null || max_items!="");
		obj.put("max_items", max_items);
		logger.info("\n\n发送搜索成员信息数据:"+obj);
		String response = HttpPost.post(searchUserUrl,obj,"utf-8");
		logger.info("\n\n返回搜索成员信息数据:"+response);
		GzbSearchUserResponseData gzbSearchUserResponseData =  GsonUtil.fromJson(response, GzbSearchUserResponseData.class);
		
		return gzbSearchUserResponseData;
	}
	
	/**
	 * authUser(验证用户信息)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年6月4日 下午7:32:43    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年6月4日 下午7:32:43    
	 * 修改备注： 
	 * @param key
	 * @param password
	 * @return
	 * @throws Exception 
	 */
	public static String authUser1(String key,String password) throws Exception{
		String access_token = getToken().getAccess_token();
		String authUrl = BASE_API_URI+"/user/auth?"+"access_token="+access_token+"&auth_key="+key+"&password="+password;
		String response = HttpUtil.get(authUrl);
		return response;
	}
	
	/**
	 * getByCode(这里用一句话描述这个方法的作用)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月22日 上午11:31:19    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月22日 上午11:31:19    
	 * 修改备注： 
	 * @return
	 * @throws Exception 
	 */
	public static GzbGetByCodeResponseData getByCode(String code) throws Exception{
		String access_token = getToken().getAccess_token();
		String getByCodeUrl = BASE_API_URI+"/member/getByCode?"+"access_token="+access_token+"&code="+code;
		String response = HttpUtil.get(getByCodeUrl);
		GzbGetByCodeResponseData data = GsonUtil.fromJson(response, GzbGetByCodeResponseData.class);
		return data;
	}
	
	/**
	 * uploadFile(更新用户头像)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月8日 上午11:08:33    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月8日 上午11:08:33    
	 * 修改备注： 
	 * @return
	 * @throws Exception
	 */
	 public static ResposeGZBImage updateAvatar(String filePath) throws Exception {
		ResposeGZBImage resposeGZBImage =null;
		String access_token = getToken().getAccess_token();
		String uploadMediaUrl = BASE_API_IP+"/fs/upload?type=image&access_token="+access_token;
		HttpURLConnection conn = null;
		/// boundary就是request头和上传文件内容的分隔符(可自定义任意一组字符串)
		String BOUNDARY = "******";
		String end = "\r\n";
		String  preFix = ("\r\n--" + BOUNDARY + "--\r\n");
		try {
			// (HttpConst.uploadImage 上传到服务器的地址
			URL url = new URL(uploadMediaUrl);
			conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(30000);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			// 设置请求方法
			conn.setRequestMethod("POST");
			// 设置header
			conn.setRequestProperty("Accept","*/*");
			conn.setRequestProperty("Connection", "keep-alive");
			conn.setRequestProperty("Content-Type","multipart/form-data; boundary=" + BOUNDARY);
			// 获取写输入流
			DataOutputStream out = new DataOutputStream(conn.getOutputStream());
			 //向服务器写入数据  这里就需要完全根据以上协议格式来写，需要仔细，避免出错。  
            out.writeBytes("---"+BOUNDARY+end);//这是第一行  并回车换行  
            //这是第二行，文件名和对应服务器的  
            out.writeBytes("Content-Disposition: form-data; name=\"data\"; filename=\""+filePath+"\""+end);//这是第二行  
            out.writeBytes(end);//空一行  
            //以下写入图片  
            FileInputStream fileInputStream=new FileInputStream(new File(filePath));  
            byte[]b=new byte[1024*4];//缓冲区  
            int len;  
            //循环读数据  
            while((len=fileInputStream.read(b))!=-1){  
                out.write(b, 0, len);  
            }  
            //写完数据后 回车换行  
            out.writeBytes(end);  
            out.writeBytes("--" + BOUNDARY + "--" + end);  
            out.flush();//清空  
            //创建一个输入流对象  获取返回的信息  是否上传成功  
            BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream()));  
            StringBuffer sb=new StringBuffer();  
            String str;  
            while((str=reader.readLine())!=null){  
                sb.append(str);  
            }  
            //关闭流信息  
            if(out!=null){
            	out.close();
            }  
            if(reader!=null){
            	reader.close();  
            }
            System.out.print("返回结果："+sb.toString()); 
            resposeGZBImage = GsonUtil.fromJson(sb.toString(),ResposeGZBImage.class);
		}catch(Exception e){
			e.printStackTrace();
		}
		return resposeGZBImage;
	}
	
	 public static void main(String[] args) {
		 try {
			ResposeGZBImage updateAvatar = updateAvatar("E:/33869333968622164.jpg");
			System.out.println("======================="+GsonUtil.toJson(updateAvatar));
			if(updateAvatar.getResp_code().equals("200")){
				GzbUserInfo user = searchUser("11010219730810235X", "").getItems()[0];
				GzbUpdateUserResponseData updateUser = updateUser(user.getUser_id(),user.getName(),"10235X",updateAvatar.getDown_url(),"normal");
				if(updateUser.getResp_code().equals("200")){
					System.out.println("success");
				}
			}else{
				System.out.println("failure");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 
	 @Test
	 public void test01() throws Exception{
		GzbSearchUserResponseData searchUser = searchUser("450501196211030619", "");
		System.out.println(GsonUtil.toJson(searchUser));
		GzbGetUserResponseData user = getUser(searchUser.getItems()[0].getUser_id());
		System.out.println(GsonUtil.toJson(user));
	 }
	 
}
