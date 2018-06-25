/** 
 *  项目名称:lzjw 
 * 文件名称:SyncFileUtils.java 
 * 包名:com.telecomyt.utils 
 * 创建日期:2018年5月16日下午5:45:47 
 * Copyright (c) 2018, zhoupengbing@telecomyt.com.cn All Rights Reserved.  
 */  
package com.telecomyt.utils;

import java.util.HashMap;
import java.util.Map;

import com.telecomyt.entity.ResponseData;
import com.telecomyt.entity.SyncFileData;
import com.telecomyt.enums.Constants;
import com.telecomyt.exception.GsonDataConvertException;

import net.sf.json.JSONObject;

/** 
 *  项目名称：lzjw    
 * 类名称：SyncFileUtils    
 * 类描述： 同步文件的工具类 
 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn    
 * 创建时间：2018年5月16日 下午5:45:47    
 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn 
 * 修改时间：2018年5月16日 下午5:45:47    
 * 修改备注：       
 * @version      
 */
@SuppressWarnings("unchecked")
public class SyncFileUtils {
	
	/**
	 * syncFile(同步文件)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月16日 下午5:47:30    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月16日 下午5:47:30    
	 * 修改备注： 
	 * @param fileName 同步的文件名
	 * @param type 文件的类型 1 图片 2 附件
	 * @return
	 * @throws GsonDataConvertException 
	 */
	public static SyncFileData syncFile(String fileName,Integer type) throws GsonDataConvertException{
		SyncFileData syncData = new SyncFileData();
		try{
			Map obj = new HashMap<>();
			//统一标识
			obj.put("uid","4050101199910101234");
			//用户标识
			obj.put("staffCode","4050101199910101234");
			//设备标识
			obj.put("devId","833191920102");
			//应用标识
			obj.put("appCode","10000205");//Constants.APP_KEY
			//请求服务id
			obj.put("reqServerId","A2-C3C51B5A1E0B41BB878021E57B6C7A10");//
			//目标服务id
			obj.put("targetServerId","A3-49761BF2D28349CABB02C28E21AF6CAA");//Constants.THIRD_SERVER_ID
			if(type == 1){
				//上传路径
				obj.put("toPath", "/file_lz/images/full/");
				//目标路径
				obj.put("path","/file/images/full/");
			}else if(type == 2){
				//上传路径
				obj.put("toPath", "/file_lz/attachments/full/");
				//目标路径
				obj.put("path", "/file/attachments/full/");
			}
			obj.put("ftpUser","dxydlcjw");
			obj.put("fileName",fileName);
			//传输方向
			obj.put("transflag","2");
			//传输目标类型
			obj.put("transtype",1);//
			String response = HttpsPost.addJson("https://20.124.145.20:9486/services/IDataTransfer/fileTrans",GsonUtil.toJson(obj),"utf-8");
			if(response != null && !response.equals("")){
				syncData = GsonUtil.fromJson(response,SyncFileData.class);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return syncData;
	}
	
	/**
	 * syncData(跨服务器数据交互)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月17日 下午8:26:36    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月17日 下午8:26:36    
	 * 修改备注： 
	 * @param uri 请求的方法路径
	 * @param param 请求的参数名称
	 * @return
	 * @throws GsonDataConvertException 
	 */
	public static SyncFileData syncData(String uri,String param) throws GsonDataConvertException{
		Map obj = new HashMap<>();
//		obj.put("uid",Constants.UID);
//		obj.put("staffCode", Constants.STAFF_CODE);
//		obj.put("devId",Constants.DEVICE_ID);
//		obj.put("appCode",Constants.APP_KEY);
//		obj.put("reqServerId",Constants.SECOND_SERVER_ID);
//		obj.put("targetServerId",Constants.THIRD_SERVER_ID);
		obj.put("uid","4050101199910101234");
		obj.put("staffCode", "4050101199910101234");
		obj.put("devId","833191920102");
		obj.put("appCode","10000205");
		obj.put("reqServerId","A2-C3C51B5A1E0B41BB878021E57B6C7A10");
		obj.put("targetServerId","A3-49761BF2D28349CABB02C28E21AF6CAA");
		obj.put("targetMethod", uri);
		obj.put("devAddress","");
		obj.put("param",param);//Constants.EXCHANGE_DATA_SERVER_URL
		System.out.println("\n获取数据请求参数:"+GsonUtil.toJson(obj)+"\n");
		String response = HttpsPost.addJson("https://20.124.145.20:9486/services/IDataTransfer/dataTrans",GsonUtil.toJson(obj), "utf-8");
		SyncFileData data = GsonUtil.fromJson(response, SyncFileData.class);
		return data;
	}
	
	/**
	 * queryPerson(查询常住人员信息)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月28日 下午9:40:16    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月28日 下午9:40:16    
	 * 修改备注： 
	 * @param url
	 * @return
	 */
	public static String queryPerson(String name,String idCard,String orgaCode,String deviceId,String condition){
		Map obj = new HashMap<>();
		obj.put("uid",idCard);
		obj.put("staffCode",idCard);
		obj.put("devId",deviceId);
		obj.put("appCode",Constants.APP_ID);
		obj.put("devAddress","");
		obj.put("XM",name);
		obj.put("GMSFHM",idCard);
		obj.put("GAJGJGDM",orgaCode);
		obj.put("condition","SFZH='"+condition+"'");//Constants.EXCHANGE_DATA_SERVER_URL
		System.out.println("\n获取常住人口请求参数:"+GsonUtil.toJson(obj)+"\n");
		String data = HttpsPost.addJson(Constants.CZRK_SERVER_URL,GsonUtil.toJson(obj),"utf-8");
		return data;
	}
	
}
