package com.telecomyt.utils;
/*package com.pam.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.pam.entity.Person;
import com.pam.exception.GsonDataConvertException;
import com.pam.template.RequestStr;
import com.pam.template.SendLoginNoticeRequestData;
import com.pam.template.SendNoticeRequestData;
import com.pam.template.SendNoticeRequestMessageData;
import com.pam.template.SendNoticeRequestParamData;

import net.sf.json.JSONObject;

*//** 
* @author zpb
* @date 2018年1月16日 下午3:04:11 
* 类说明 
*//*
public class HttpSendNoticeUtils {
	
	//统一推送的地址
	private static final String BASE_API_URI = "http://20.1.11.52:5988";
	//请求信息
	private static final String BWLYIPDZ = "20.1.11.91";//报文来源ip地址
	private static final String BWLYDKH = "80";//报文来源端口
	private static final String FWQQ_BWBH = "SR020001011091201709191541010000001";//报文编号
	private static final String FWQQZ_ZCXX = "A00111000000000000610";//服务请求者_注册信息
	private static final String FWBS = "S00101100000000007010";// 服务标识
	private static final String FWQQ_RQSJ = "20170629170707";// 服务标识
	private static final String FFBS = "FUN001";//方法标识
	private static final String XXCZRY_XM = "张三";// 信息操作人员_姓名 
	private static final String XXCZRY_GMSFHM = "130579198607244513";// 信息操作人员_编号
	private static final String XXCZRY_GAJGJGDM = "110102020000";//信息操作人员_机构代码
	private static final String FWQQSB_BH = "866620054421684";//服务请求设备IMEI号
	private static final String FWQQ_SJSJLX ="service_request";//服务请求审计事件类型
	private static final String FFMC = "user_login";//根据用户名来进行推送
	
	*//**
	 * 加塞的统一推送
	 * 根据user_name进行推送
	 * @throws GsonDataConvertException 
	 * SendNoticeResponseData
	 *//*
	public static String sendNoticeByUsername(String personOrga,String imei,String name,String call_identity_card,String called_identity_card,String called_name,String type) throws GsonDataConvertException{
		String sendNoticeByUsernameUrl = BASE_API_URI+"/http/GA000Comm";
		//当前时间
		String date = DateUtils.dateToString(new Date());
		String fwqq_bwbh = "SR020001011091"+date+ArrayUtil.correctNumber((int)(Math.random()*1000)+"");
		JSONObject obj = new JSONObject();
		obj.put("BWLYIPDZ",BWLYIPDZ);
		obj.put("FWQQ_BWBH",fwqq_bwbh);
		obj.put("FWQQ_RQSJ",date);
		obj.put("BWLYDKH",BWLYDKH);
		obj.put("FWQQZ_ZCXX",FWQQZ_ZCXX);
		obj.put("FWBS",FWBS);
		obj.put("FFBS",FFBS);
		obj.put("XXCZRY_XM",name);
		obj.put("XXCZRY_GMSFHM",call_identity_card);
		obj.put("FWQQSB_BH",imei);
		obj.put("XXCZRY_GAJGJGDM",personOrga);
		obj.put("FWQQ_SJSJLX",FWQQ_SJSJLX);
		//设置请求的具体参数信息
		SendNoticeRequestData data = new SendNoticeRequestData();
		SendNoticeRequestParamData params = new SendNoticeRequestParamData();
		SendNoticeRequestMessageData message = new SendNoticeRequestMessageData();
		String info = "";
		if(type.equals("0")){
			info = name+"正在呼叫"+called_name;
		}else{
			info = name+"邀请"+called_name+"加入会议";
		}
		message.setNotification(info);
		params.setMessage(GsonUtil.toJson(message));
		params.setPackageName("com.telecomyt.videolibrary");
		params.setUsernames(new String[]{called_identity_card});
		data.setMethod(FFMC);
		data.setParams(params);
		obj.put("FWQQ_NR",data);
		String response = HttpPost.addJson(sendNoticeByUsernameUrl,obj,"utf-8");
		System.out.println(GsonUtil.toJson(response));
//		SendNoticeResponseData responseData = GsonUtil.fromJson(response, SendNoticeResponseData.class);
		return response;
	}
	
	*//**
	 * 调用登录接口的推送
	 * @return
	 *//*
	public static String sendLoginNotice(String userName,String name,String appId){
		String sendNoticeByUsernameUrl = BASE_API_URI+"/http/GA000Comm";
		//当前时间
		String date = DateUtils.dateToString(new Date());
		String fwqq_bwbh = "SR020001011091"+date+ArrayUtil.correctNumber((int)(Math.random()*1000)+"");
		JSONObject obj = new JSONObject();
		obj.put("BWLYIPDZ",BWLYIPDZ);
		obj.put("FWQQ_BWBH",fwqq_bwbh);
		obj.put("FWQQ_RQSJ",date);
		obj.put("BWLYDKH",BWLYDKH);
		obj.put("FWQQZ_ZCXX",FWQQZ_ZCXX);
		obj.put("FWBS",FWBS);
		obj.put("FFBS",FFBS);
		obj.put("XXCZRY_XM",name);
		obj.put("XXCZRY_GMSFHM",userName);
		obj.put("FWQQSB_BH",FWQQSB_BH);
		obj.put("XXCZRY_GAJGJGDM",XXCZRY_GAJGJGDM);
		obj.put("FWQQ_SJSJLX",FWQQ_SJSJLX);
		//设置请求的具体参数信息
		SendNoticeRequestData data = new SendNoticeRequestData();
		SendLoginNoticeRequestData params = new SendLoginNoticeRequestData();
		SendNoticeRequestMessageData message = new SendNoticeRequestMessageData();
		data.setMethod(FFMC);
		params.setUser_name(userName);
		params.setAppid(appId);
		params.setMethod(FFMC);
		data.setParams(params);
		obj.put("FWQQ_NR",data);
		String response = HttpPost.addJson(sendNoticeByUsernameUrl,obj,"utf-8");
		System.out.println(GsonUtil.toJson(response));
//		SendNoticeResponseData responseData = GsonUtil.fromJson(response, SendNoticeResponseData.class);
		return response;
	}
	
	public static void main(String[] args) {
		sendLoginNotice("110101199910101235","王欢欢","fbe6f664c1bc27d0d49fbf4b4eea9d6c");
	}
	
	
	
}
*/