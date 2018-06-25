/** 
 * 项目名称:data 
 * 文件名称:LiuZhouData.java 
 * 包名:com.telecomyt.controller 
 * 创建日期:2018年5月7日下午3:39:30 
 * Copyright (c) 2018, zhoupengbing@telecomyt.com.cn All Rights Reserved.  
 */  
package com.telecomyt.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.telecomyt.entity.ResponseData;
import com.telecomyt.entity.SyncFileData;
import com.telecomyt.enums.Constants;
import com.telecomyt.exception.GsonDataConvertException;
import com.telecomyt.service.IDataService;
import com.telecomyt.template.SyncFileResponseData;
import com.telecomyt.template.SyncNewDataResponseData;
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
@SuppressWarnings("unchecked")
@Controller
@EnableScheduling
public class LiuZhouDataController{
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private IDataService dataService;
	
	/**
	 * syncNewData(定期同步三类区新闻表的数据)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月25日 下午9:11:29    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月25日 下午9:11:29    
	 * 修改备注：优化新闻查询速度
	 */
//	@Scheduled(cron="0 */5 * * * ?")
	public void syncNewData(){
		try {
			//查询当前数据库新闻最大的id
			String lagestNewId = this.dataService.getLagestNewId();
			Map<String,String>params = new HashMap();
			params.put("newId", lagestNewId);
			//调用数据同步接口
			logger.info("\n\n=====开始获取需要同步的新闻=====\n\n");
			SyncFileData syncData = SyncFileUtils.syncData("/lzjw/syncNewData",GsonUtil.toJson(params));
			if(syncData.getResCode().equals("10000")){
				SyncNewDataResponseData data = GsonUtil.fromJson(syncData.getResData(),SyncNewDataResponseData.class);
				if(data.getData() != null && data.getData().size() > 0){
					this.dataService.addNew(data.getData());
				}
			}
		} catch (GsonDataConvertException e) {
			e.printStackTrace();
		}
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
		String response = this.dataService.getSecondTitle();
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
		String response = this.dataService.getThirdTitle(secondName);
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
		String response = this.dataService.getNewsList(name, pageCount, currentPage, lastNewId);
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
		String response = this.dataService.getNewInfo(newId);
		return response;
	}
	
	/**
	 * syncFileData(定时抓取同步文件)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月16日 下午5:31:47    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月16日 下午5:31:47    
	 * 修改备注：三十分钟同步一次
	 */
//	@Scheduled(cron="0 */2 * * * ?")
	public void syncFileData(){
		this.dataService.syncFileData();
//		System.out.println("aaaa");
	}
	
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
		String response = this.dataService.getLawFirstTitle(key);
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
		String response = this.dataService.getLawInfo(titleName);
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
		String response = this.dataService.getSecondTitle(titleName);
		return response;
	}
	
	/**
	 * correctTitleTime(格式化标题时间)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月26日 下午3:03:21    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月26日 下午3:03:21    
	 * 修改备注： 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/correct")
	public String correctTitleTime(){
		String response = this.dataService.correctTitleTime();
		return response;
	}
	
	/**
	 * joinCrowd(添加人到圈子)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月27日 下午10:20:23    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月27日 下午10:20:23    
	 * 修改备注： 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/joinCrowd")
	public String joinCrowd(){
		String response = this.dataService.joinCrowd();
		return response;
	}

	/**
	 * run_bat(定时执行bat文件)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年6月6日 上午9:06:34    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年6月6日 上午9:06:34    
	 * 修改备注：
	 */
//	@Scheduled(cron="* */10 * * * ?")
	public void run_bat() {
		System.out.println("=================start============");
		Process ps;
		try {
			String batName = Constants.SPRIDER_QIDON＿BAT_LOCATION;
			ps = Runtime.getRuntime().exec("cmd.exe /C start "+batName);
			InputStream in = ps.getInputStream(); 
			int c; 
			while ((c = in.read()) != -1) {
				//如果你不需要看输出，这行可以注销掉
				System.out.print(c); 
			} 
			in.close(); 
			ps.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("=============finish=============");       
	}
}
