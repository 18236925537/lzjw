package com.telecomyt.gzb;

import org.apache.log4j.Logger;

import com.telecomyt.enums.Constants;
import com.telecomyt.gzb.group.GzbCreateGroupResponseData;
import com.telecomyt.gzb.group.GzbDeleteGroupResponseData;
import com.telecomyt.gzb.group.GzbExitGroupResponseData;
import com.telecomyt.gzb.group.GzbGetGroupResponseData;
import com.telecomyt.gzb.group.GzbGroupListResponseData;
import com.telecomyt.gzb.group.GzbUpdateGroupResponseData;
import com.telecomyt.gzb.group.Privilege;
import com.telecomyt.utils.GsonUtil;
import com.telecomyt.utils.HttpPost;
import com.telecomyt.utils.HttpUtil;
import com.telecomyt.utils.PropertiesUtil;

import net.sf.json.JSONObject;

public class GzbGroupApi {
	private static Logger logger = Logger.getLogger(GzbGroupApi.class);
	
	//请求路径
	private static final String BASE_API_URI = Constants.GZB_REQUEST_URL;
//	private static final String BASE_API_URI = "http://gzb.telecomyt.com.cn:9090/eim/api";
		
	/**
	 * 1.1创建群组
	 * @param access_token
	 * @param subject
	 * @param description
	 * @param admin
	 * @param users
	 * @param privileges
	 * @return
	 * @throws Exception
	 */
	public static GzbCreateGroupResponseData createGroup(String subject, String description, String admin, String[] users, Privilege privileges)throws Exception{
		
		String access_token = GzbUserApi.getToken().getAccess_token();
		String createGroupUrl = BASE_API_URI+"/chatroom/create?access_token="+access_token;
		System.out.println("createGroupUrl:"+createGroupUrl);
		
		JSONObject obj = new JSONObject();
		if(subject != null || subject!="");
		obj.put("subject", subject);//群组名
		if(description != null || description!="");
		obj.put("description", description);//群组描述（签名）
		if(admin != null || admin!="");
		obj.put("admin", admin);
		if(users != null);
		obj.put("users", users);
		if(privileges != null);
		obj.put("privileges", privileges);
		logger.info("\n\n发送创建群组数据:"+obj);
		String response = HttpPost.addJson(createGroupUrl,GsonUtil.toJson(obj),"utf-8");
		logger.info("\n\n返回创建群组数据:"+response);
		
		GzbCreateGroupResponseData gzbCreateGroupResponseData = GsonUtil.fromJson(response, GzbCreateGroupResponseData.class);
		
		return gzbCreateGroupResponseData;
	}
	/**
	 * 1.2更新群组
	 * @param access_token
	 * @param chatroom_id
	 * @param subject
	 * @param description
	 * @param admin
	 * @param add_users
	 * @param del_users
	 * @param privileges
	 * @return
	 * @throws Exception
	 */
	public static GzbUpdateGroupResponseData updateGroup(String chatroom_id, String subject, String description, String admin, String []add_users, String []del_users, Privilege privileges)throws Exception{
		
		String access_token = GzbUserApi.getToken().getAccess_token();
		String updateGroupUrl = BASE_API_URI+"/chatroom/update?access_token="+access_token;
		System.out.println("updateGroupUrl:"+updateGroupUrl);
		
		JSONObject obj = new JSONObject();
		if(chatroom_id != null || chatroom_id!="");
		obj.put("chatroom_id", chatroom_id);
		if(subject != null || subject!="");
		obj.put("subject", subject);//群组名
		if(description != null || description!="");
		obj.put("description", description);//群组描述（签名）
		if(admin != null || admin!="");
		obj.put("admin", admin);
		if(add_users != null);
		obj.put("add_users", add_users);
		if(del_users != null);
		obj.put("del_users", del_users);
		if(privileges != null);
		obj.put("privileges", privileges);
		logger.info("\n\n发送更新群组数据:"+obj);
		String response = HttpPost.addJson(updateGroupUrl,GsonUtil.toJson(obj),"utf-8");
		logger.info("\n\n返回更新群组数据:"+response);
		
		GzbUpdateGroupResponseData gzbUpdateGroupResponseData = GsonUtil.fromJson(response, GzbUpdateGroupResponseData.class);
		
		return gzbUpdateGroupResponseData;
	}
	/**
	 * 1.3退出群组
	 * @param access_token
	 * @param chatroom_id
	 * @param user_id
	 * @return
	 * @throws Exception
	 */
	public static GzbExitGroupResponseData exitGroup( String chatroom_id, String user_id)throws Exception{
		
		String access_token = GzbUserApi.getToken().getAccess_token();
		String exitGroupUrl = BASE_API_URI+"/chatroom/exit?access_token="+access_token;
		System.out.println("exitGroupUrl:"+exitGroupUrl);
		
		JSONObject obj = new JSONObject();
		if(chatroom_id != null || chatroom_id!="");
		obj.put("chatroom_id", chatroom_id);
		if(user_id != null || user_id!="");
		obj.put("user_id", user_id);
		logger.info("\n\n发送退出群组数据:"+obj);
		String response = HttpPost.addJson(exitGroupUrl,GsonUtil.toJson(obj),"utf-8");
		logger.info("\n\n返回退出群组数据:"+response);
		
		GzbExitGroupResponseData gzbExitGroupResponseData = GsonUtil.fromJson(response, GzbExitGroupResponseData.class);
		
		return gzbExitGroupResponseData;
	}

	/**1.4解散群组（补）
	 * @param chatroom_ids
	 * @param user_id
	 * @return
	 * @throws Exception
	 */
	public static GzbDeleteGroupResponseData deleteGroup( String []chatroom_ids, String user_id)throws Exception{
		
		String access_token = GzbUserApi.getToken().getAccess_token();
		String deleteGroupUrl = BASE_API_URI+"/chatroom/delete?access_token="+access_token;
		System.out.println("deleteGroupUrl:"+deleteGroupUrl);
		
		JSONObject obj = new JSONObject();
		if(chatroom_ids != null);
		obj.put("chatroom_ids", chatroom_ids);
		if(user_id != null || user_id!="");
		obj.put("user_id", user_id);
		logger.info("\n\n发送解散群组数据:"+obj);
		String response = HttpPost.addJson(deleteGroupUrl,GsonUtil.toJson(obj),"utf-8");
		logger.info("\n\n返回解散群组数据:"+response);
		
		GzbDeleteGroupResponseData gzbDeleteGroupResponseData = GsonUtil.fromJson(response, GzbDeleteGroupResponseData.class);
		
		return gzbDeleteGroupResponseData;
	}
	
	/**
	 * 1.4获取群组
	 * @param access_token
	 * @param chatroom_id
	 * @return
	 * @throws Exception
	 */
	public static GzbGetGroupResponseData getGroup(String chatroom_id)throws Exception{
		
		String access_token = GzbUserApi.getToken().getAccess_token();
		String getGroupUrl = BASE_API_URI+"/chatroom/get?access_token="+access_token+"&chatroom_id="+chatroom_id;
		System.out.println("getGroupUrl:"+getGroupUrl);
		
		String response = HttpUtil.get(getGroupUrl);
		logger.info("\n\n返回获取群组信息数据:"+response);
		GzbGetGroupResponseData gzbGetGroupResponseData = GsonUtil.fromJson(response, GzbGetGroupResponseData.class);
		
		return gzbGetGroupResponseData;
	}
	/**
	 * 1.5群组列表
	 * @param access_token
	 * @param user_id
	 * @return
	 * @throws Exception
	 */
	public static GzbGroupListResponseData groupList(String user_id)throws Exception{
		
		String access_token = GzbUserApi.getToken().getAccess_token();
		String groupListUrl = BASE_API_URI+"/chatroom/get_by_user?access_token="+access_token+"&user_id="+user_id;
		System.out.println("groupListUrl:"+groupListUrl);
		
		String response = HttpUtil.get(groupListUrl);
		logger.info("\n\n返回群组列表信息数据:"+response);
		GzbGroupListResponseData gzbGroupListResponseData = GsonUtil.fromJson(response, GzbGroupListResponseData.class);
		
		return gzbGroupListResponseData;
	}
	public static void main(String[] args) throws Exception {
		//1、1创建工作宝群组
		/*String admin = "u110145";
		String [] users = {"u110145","u110146","u110143"};
		Privilege privilege =new Privilege(true,true);
		
		GzbCreateGroupResponseData gzbCreateGroupResponseData =
				createGroup("lunry5的群","for test",admin,users,privilege);
		System.out.println("结果："+GsonUtil.toJson(gzbCreateGroupResponseData));*/
	/*1、3退出群组信息数据
	 * 	String chatroom_id = "14722064130939370640_room";
		String user_id = "ua198_u110060";
		GzbExitGroupResponseData gzbUpdateGroupResponseData =
				exitGroup(chatroom_id, user_id);
		System.out.println("结果："+GsonUtil.toJson(gzbUpdateGroupResponseData));
		*/
/*	1、2发送更新群组数据	
		String chatroom_id = "14722064130939370640_room";
		String []add_users = {"u110042","u110145","u110146"};
		GzbUpdateGroupResponseData gzbUpdateGroupResponseData =
				updateGroup(chatroom_i
GsonUtil.toJson(gzbUpdateGroupResponseData));
		*/
	
		//1、4删除群组
		String []del_room = {"342595904138190848_room"};
		GzbDeleteGroupResponseData deleteGroup = GzbGroupApi.deleteGroup(del_room, "u110175");
		String num = deleteGroup.getResp_code();
		System.out.println("num::"+num);
        //1.5获取群组信息
//		String access_token = "NjkyMTZkNTg1N2ZlNDg5ZDE5MGNiMjdjNDhlZWZiYjE1MTBhNjAzOQ==";
		/*String chatroom_id = "342533554815180800_room";
		GzbGetGroupResponseData gzbGetGroupResponseData =
				getGroup(chatroom_id);
		System.out.println("结果："+GsonUtil.toJson(gzbGetGroupResponseData));*/
		//1、6获取群组信息数据
		/*String chatroom_id = "14722064130939377412_room";
		GzbGetGroupResponseData gzbGetGroupResponseData =getGroup(chatroom_id);
		System.out.println("结果："+GsonUtil.toJson(gzbGetGroupResponseData));*/
		
	
	}
	
}
