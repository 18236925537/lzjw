package com.telecomyt.gzb;

import org.apache.axis.encoding.Base64;
import org.apache.log4j.Logger;

import com.telecomyt.enums.Constants;
import com.telecomyt.gzb.group.GzbCreateGroupResponseData;
import com.telecomyt.gzb.group.GzbPushMessageResponseData;
import com.telecomyt.gzb.message.Custom;
import com.telecomyt.gzb.message.Data;
import com.telecomyt.gzb.message.Message;
import com.telecomyt.gzb.message.PushMessage;
import com.telecomyt.gzb.message.Text;
import com.telecomyt.utils.GsonUtil;
import com.telecomyt.utils.HttpPost;
import com.telecomyt.utils.HttpsPost;
import com.telecomyt.utils.PropertiesUtil;

import net.sf.json.JSONObject;

public class GzbMessageApi {
    private static Logger logger = Logger.getLogger(GzbGroupApi.class);
	//请求路径
    private static final String BASE_API_URI = Constants.GZB_REQUEST_URL;
	
	public static GzbPushMessageResponseData pushMessage(String from ,String[] to_users,String pushNotification)throws Exception{
		String access_token = GzbUserApi.getToken().getAccess_token();
		String pushMessageUrl = BASE_API_URI+"/message/send?access_token="+access_token;
		System.out.println("pushMessageUrl:"+pushMessageUrl);
		
		JSONObject obj = new JSONObject();
		obj.put("from", from);
		obj.put("to_all", false);
		obj.put("to_users", to_users);
		obj.put("msg_type", "custom");
		Message message = new Message();
		message.setContent(pushNotification);
		System.out.println(GsonUtil.toJson(message));//{"content":"{\"msgType\":\"1\",\"message\":\"邀请lunry9/lunry8参加会议\",\"data\":{\"roomKey\":\"123key321\"}}"}
		Custom custom=new Custom(Base64.encode(GsonUtil.toJson(message).getBytes()));
		obj.put("custom", custom);
		String response = HttpPost.addJson(pushMessageUrl,GsonUtil.toJson(obj),"utf-8");
		logger.info("\n\n自定义通知信息请求数据:"+obj);
		logger.info("\n\n自定义通知信息返回数据:"+response);
		GzbPushMessageResponseData gzbPushMessageResponseData = GsonUtil.fromJson(response, GzbPushMessageResponseData.class);
		
		return gzbPushMessageResponseData;
	}
	
	public static void main(String[] args) throws Exception {
		String from ="u110175";
		String[] to_users={"u110173","u110174","u110175"};
		
		Data data = new Data("123key321");
		PushMessage pm = new PushMessage("1","lunry7邀请lunry9/lunry8参加会议",data);
		String pushMessage = GsonUtil.toJson(pm);
		
		String content="邀请lunry9参加会议";
		GzbPushMessageResponseData gzbPushMessage = 
				pushMessage(from , to_users, pushMessage);
		String json = GsonUtil.toJson(gzbPushMessage);
		System.out.println("json:"+json);
		
		//data.setRoomKey("123key321");
		/*pm.setData(data);
		pm.setMessage("邀请lunry9/lunry8参加会议");
		pm.setMsgType("1");*/
		
	}
	
	public static GzbCreateGroupResponseData receiveMessage(String to_all,String to_users,String msg_type,Custom custom)throws Exception{
		String access_token = GzbUserApi.getToken().getAccess_token();
		String pushMessageUrl = BASE_API_URI+"/message/send?access_token="+access_token;
		System.out.println("pushMessageUrl:"+pushMessageUrl);
		
		JSONObject obj = new JSONObject();
		if(to_all != null || to_all !="");
		obj.put("to_all", to_all);//群组名
		if(to_users != null || to_users!="");
		obj.put("to_users", to_users);//群组名
		if(msg_type != null || msg_type!="");
		obj.put("msg_type", msg_type);//群组名
		if(custom != null);
		obj.put("custom", custom);//群组名
		return null;
	}
	
	public static GzbCreateGroupResponseData sendMessage(String from,String to_all,String to_users,String msg_type,Text text)throws Exception{
		String access_token = GzbUserApi.getToken().getAccess_token();
		String createGroupUrl = BASE_API_URI+"/eim/api//message/send?access_token="+access_token;
		System.out.println("createGroupUrl:"+createGroupUrl);
		
		JSONObject obj = new JSONObject();
		if(from != null || from !="");
		obj.put("from", from);//群组名
		if(to_all != null || to_all!="");
		obj.put("to_all", to_all);//群组名
		if(to_users != null || to_users!="");
		obj.put("to_users", to_users);//群组名
		if(msg_type != null || msg_type!="");
		obj.put("msg_type", msg_type);//群组名
		if(text != null);
		obj.put("text", text);//群组名
		return null;
	}
		

}
