/** 
 * 项目名称:data 
 * 文件名称:LiuZhouData.java 
 * 包名:com.telecomyt.controller 
 * 创建日期:2018年5月7日下午3:39:30 
 * Copyright (c) 2018, zhoupengbing@telecomyt.com.cn All Rights Reserved.  
 */  
package com.telecomyt.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.telecomyt.entity.ResponseData;
import com.telecomyt.entity.SyncFileData;
import com.telecomyt.exception.GsonDataConvertException;
import com.telecomyt.service.IDataService;
import com.telecomyt.template.SyncFileResponseData;
import com.telecomyt.utils.GsonUtil;
import com.telecomyt.utils.SyncFileUtils;
import common.Logger;

/** 
 * 项目名称：data    
 * 类名称：LiuZhouData    
 * 类描述：柳州数据处理类
 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn    
 * 创建时间：2018年5月7日 下午3:39:30    
 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn 
 * 修改时间：2018年5月7日 下午3:39:30    
 * 修改备注：       
 * @version      
 */
//@SuppressWarnings("unchecked")
//@Controller
//@EnableScheduling
public class LiuZhouDataController_second{
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private IDataService dataService;
	
	/**
	 * initData(初始化矫正数据)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月7日 下午3:41:12    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月7日 下午3:41:12    
	 * 修改备注： 
	 * @return
	 */
	/*@ResponseBody
	@RequestMapping(value="")*/
	public String initData(){
		String response = this.dataService.initLiuZhouData();
		return response;
	}
	
	/**
	 * getSecondTitle(获取二级)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月13日 下午2:53:11    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月13日 下午2:53:11    
	 * 修改备注： 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getSecondTitle")
	public String getSecondTitle(){
		String response = "";
		try {
			SyncFileData syncData = SyncFileUtils.syncData("/lzjw/getSecondTitle","");
			if(syncData != null && syncData.getResCode().equals("10000")){
				response = syncData.getResData();
			}else{
				response = "响应码为"+syncData.getResCode()+"--响应内容为:"+syncData.getReason();
			}
		} catch (GsonDataConvertException e) {
			e.printStackTrace();
		}
		return response;
	}
	
	/**
	 * getSecondTitle(获取三级)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月13日 下午2:53:11    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月13日 下午2:53:11    
	 * 修改备注： 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getThirdTitle")
	public String getThirdTitle(String secondName){
		String response = "";
		try {
			//请求参数
			Map params = new HashMap<>();
			params.put("secondName", secondName);
			SyncFileData syncData = SyncFileUtils.syncData("/lzjw/getThirdTitle",GsonUtil.toJson(params));
			if(syncData != null && syncData.getResCode().equals("10000")){
				response = syncData.getResData();
			}else{
				response = "响应码为"+syncData.getResCode()+"--响应内容为:"+syncData.getReason();
			}
		} catch (GsonDataConvertException e) {
			e.printStackTrace();
		}
		return response;
	}

	
	/**
	 * getNewsList(获取新闻分页列表)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月13日 上午11:24:12    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月13日 上午11:24:12    
	 * 修改备注： 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getNewList")
	public String getNewsList(String name,int pageCount,int currentPage,int lastNewId){
		String response = "";
		try {
			//请求参数
			Map params = new HashMap<>();
			params.put("name", name);
			params.put("pageCount", pageCount);
			params.put("currentPage", currentPage);
			params.put("lastNewId", lastNewId);
			SyncFileData syncData = SyncFileUtils.syncData("/lzjw/getNewList",GsonUtil.toJson(params));
			if(syncData != null && syncData.getResCode().equals("10000")){
				response = syncData.getResData();
			}else{
				response = "响应码为"+syncData.getResCode()+"--响应内容为:"+syncData.getReason();
			}
		} catch (GsonDataConvertException e) {
			e.printStackTrace();
		}
		return response;
	}
	
	/**
	 * getNewInfo(获取新闻详情)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月13日 下午6:08:38    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月13日 下午6:08:38    
	 * 修改备注： 
	 * @param newId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getNewInfo")
	public String getNewInfo(String newId){
		String response = "";
		try {
			//请求参数
			Map params = new HashMap<>();
			params.put("newId", newId);
			SyncFileData syncData = SyncFileUtils.syncData("/lzjw/getNewInfo",GsonUtil.toJson(params));
			if(syncData != null && syncData.getResCode().equals("10000")){
				response = syncData.getResData();
			}else{
				response = "响应码为"+syncData.getResCode()+"--响应内容为:"+syncData.getReason();
			}
		} catch (GsonDataConvertException e) {
			e.printStackTrace();
		}
		return response;
	}
	
//	/**
//	 * syncFileData(定时抓取同步文件)   
//	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
//	 * 创建时间：2018年5月16日 下午5:31:47    
//	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
//	 * 修改时间：2018年5月16日 下午5:31:47    
//	 * 修改备注：三十分钟同步一次
//	 */
//	@Scheduled(cron="0 */30 * * * ?")
//	public void syncFileData(){
//		String response = "";
//		try{
//			SyncFileData syncData = SyncFileUtils.syncData("/lzjw/syncFile","");
//			if(syncData.getResCode().equals("10000")){
//				SyncFileResponseData data = GsonUtil.fromJson(syncData.getResData(),SyncFileResponseData.class);
//				response = this.dataService.syncFileData(data.getData());
//			}else{
//				response = "响应码为"+syncData.getResCode()+"--响应内容为:"+syncData.getReason();
//			}
//			logger.info("\n\n 同步文件返回信息"+response+"\n\n");
//		}catch(Exception e){
//			e.printStackTrace();
//		}
////		System.out.println("aaaa");
//	}
	
	/**
	 * getLawFirstTitle(获取法律法规的一级目录)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月16日 下午7:08:10    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月16日 下午7:08:10    
	 * 修改备注： 
	 * @Param key 搜索关键字
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/lawFirstTitle")
	public String getLawFirstTitle(String key){
		String response = "";
		try {
			//请求参数
			Map params = new HashMap<>();
			params.put("key", key);
			SyncFileData syncData = SyncFileUtils.syncData("/lzjw/lawFirstTitle",GsonUtil.toJson(params));
			if(syncData != null && syncData.getResCode().equals("10000")){
				response = syncData.getResData();
			}else{
				response = "响应码为"+syncData.getResCode()+"--响应内容为:"+syncData.getReason();
			}
		} catch (GsonDataConvertException e) {
			e.printStackTrace();
		}
		return response;
	}
	
	/**
	 * getLawInfo(获取法律详情)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月16日 下午7:45:22    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月16日 下午7:45:22    
	 * 修改备注： 
	 * @param titleName
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/lawInfo")
	public String getLawInfo(String titleName){
		String response = "";
		try {
			//请求参数
			Map params = new HashMap<>();
			params.put("titleName", titleName);
			SyncFileData syncData = SyncFileUtils.syncData("/lzjw/lawInfo",GsonUtil.toJson(params));
			if(syncData != null && syncData.getResCode().equals("10000")){
				response = syncData.getResData();
			}else{
				response = "响应码为"+syncData.getResCode()+"--响应内容为:"+syncData.getReason();
			}
		} catch (GsonDataConvertException e) {
			e.printStackTrace();
		}
		return response;
	}
	
	/**
	 * getSecondTitle(根据一级标题获取二级标题)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月16日 下午7:32:55    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月16日 下午7:32:55    
	 * 修改备注： 
	 * @param titleName 一级标题名字
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/lawSecondTitle")
	public String getSecondTitle(String titleName){
		String response = "";
		try {
			//请求参数
			Map params = new HashMap<>();
			params.put("titleName", titleName);
			SyncFileData syncData = SyncFileUtils.syncData("/lzjw/lawSecondTitle",GsonUtil.toJson(params));
			if(syncData != null && syncData.getResCode().equals("10000")){
				response = syncData.getResData();
			}else{
				response = "响应码为"+syncData.getResCode()+"--响应内容为:"+syncData.getReason();
			}
		} catch (GsonDataConvertException e) {
			e.printStackTrace();
		}
		return response;
	}
	
	@ResponseBody
	@RequestMapping("addFollow")
	public String addFollow(){
		logger.info("\n\n start ===addFollow====\n\n");
		String response = this.dataService.addFollow();
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value="/sync")
	public void syncFileTest(){
		SyncFileData syncFile;
		try {
			syncFile = SyncFileUtils.syncFile("5fb35f4cee1f49918e93699a17168b8278a2157d.doc",2);
			System.out.println("\n同步文件返回信息为:"+GsonUtil.toJson(syncFile));
		} catch (GsonDataConvertException e) {
			e.printStackTrace();
		}
	}
}
