/** 
 * 项目名称:data 
 * 文件名称:LiuZhouData.java 
 * 包名:com.telecomyt.controller 
 * 创建日期:2018年5月7日下午3:39:30 
 * Copyright (c) 2018, zhoupengbing@telecomyt.com.cn All Rights Reserved.  
 */  
package com.telecomyt.controller;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Date;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.RequestParamMapMethodArgumentResolver;

import com.telecomyt.entity.SyncFileData;
import com.telecomyt.enums.Constants;
import com.telecomyt.exception.GsonDataConvertException;
import com.telecomyt.service.IDataService;
import com.telecomyt.template.AddSyncRecordRequest;
import com.telecomyt.template.GetLawFirstTitleRequest;
import com.telecomyt.template.GetLawInfoRequest;
import com.telecomyt.template.GetNewInfoRequest;
import com.telecomyt.template.GetNewsListRequest;
import com.telecomyt.template.GetThirdTitleRequest;
import com.telecomyt.template.SyncNewDataRequest;
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
//@Controller
//@EnableScheduling
public class LiuZhouDataController_third {
	
	Logger logger = Logger.getLogger(this.getClass());
	
	//执行次数
	private int count = 0;
	
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
	 * initRequest(从http请求中获取参数)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月24日 下午8:41:25    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月24日 下午8:41:25    
	 * 修改备注： 
	 * @param request
	 * @return
	 */
	public String initRequest(HttpServletRequest request){
		StringBuffer info=new StringBuffer();  
		try{
			BufferedInputStream buf = new BufferedInputStream(request.getInputStream());  
			byte[] buffer=new byte[1024];   
			int iRead; 
			while((iRead=buf.read(buffer))!=-1){  
				info.append(new String(buffer,0,iRead,"UTF-8"));  
			}
		}catch(Exception e){
			e.printStackTrace();
		}
        return info.toString();
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
	@RequestMapping(value="/getSecondTitle",method=RequestMethod.POST)
	public String getSecondTitle(){
//		logger.info("\n\n 开始获取二级列表信息\n\n");
		String response = this.dataService.getSecondTitle();
//		logger.info("\n获取二级的列表信息为\n"+response+"\n\n");
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
	 * @throws GsonDataConvertException 
	 */
	@ResponseBody
	@RequestMapping(value="/getThirdTitle",method=RequestMethod.POST)
	public String getThirdTitle(HttpServletRequest request) throws GsonDataConvertException{
		String initRequest = initRequest(request);
		GetThirdTitleRequest data = GsonUtil.fromJson(initRequest,GetThirdTitleRequest.class);
//		logger.info("\n\n 获取三级列表请求信息"+data.getSecondName()+"\n\n");
		String response = this.dataService.getThirdTitle(data.getSecondName());
//		logger.info("\n获取三级的列表信息为\n"+response+"\n\n");
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
	@RequestMapping(value="/getNewList")
	public String getNewsList(HttpServletRequest request) throws GsonDataConvertException{
		String initRequest = initRequest(request);
		GetNewsListRequest data = GsonUtil.fromJson(initRequest,GetNewsListRequest.class);
//		logger.info("\n\n 要获取"+data.getName()+"的列表信息\n\n");
		String response = this.dataService.getNewsList(data.getName(),data.getPageCount(),data.getCurrentPage(),data.getLastNewId());
//		logger.info("\n获取"+name+"的列表信息为\n"+response+"\n\n");
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
	@RequestMapping(value="/getNewInfo",method=RequestMethod.POST)
	public String getNewInfo(HttpServletRequest request) throws GsonDataConvertException{
		String initRequest = initRequest(request);
		GetNewInfoRequest data = GsonUtil.fromJson(initRequest, GetNewInfoRequest.class);
//		logger.info("\n\n 获取新闻详情信息\n\n");
		String response = this.dataService.getNewInfo(data.getNewId());
//		logger.info("\n获取新闻详情信息为\n"+response+"\n\n");
		return response;
	}
	
     /**
	 * syncFileData(定时抓取同步文件)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月16日 下午5:31:47    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月16日 下午5:31:47    
	 * 修改备注：
	 */
	@ResponseBody
	@RequestMapping("/syncFile")
	public String syncFileData(){
		logger.info("\n\n 开始获取需要同步的文件 \n\n");
		String response = this.dataService.syncNewFileData();
		return response;
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
	@RequestMapping(value="/lawFirstTitle",method=RequestMethod.POST)
	public String getLawFirstTitle(HttpServletRequest request) throws GsonDataConvertException{
		String initRequest = initRequest(request);
		GetLawFirstTitleRequest data = GsonUtil.fromJson(initRequest,GetLawFirstTitleRequest.class);
//		logger.info("\n\n 获取法律法规的一级目录信息\n\n");
		String response = this.dataService.getLawFirstTitle(data.getKey());
//		logger.info("\n获取法律法规的一级目录返回信息为\n"+response+"\n\n");
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
	@RequestMapping(value="/lawInfo",method=RequestMethod.POST)
	public String getLawInfo(HttpServletRequest request) throws GsonDataConvertException{
		String initRequest = initRequest(request);
		GetLawInfoRequest data = GsonUtil.fromJson(initRequest,GetLawInfoRequest.class);
//		logger.info("\n\n 获取法律详情信息参数:"+data.getTitleName()+"\n\n");
		String response = this.dataService.getLawInfo(data.getTitleName());
//		logger.info("\n\n 获取法律详情信息为\n"+response+"\n\n");
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
	@RequestMapping(value="/lawSecondTitle",method=RequestMethod.POST)
	public String getSecondTitle(HttpServletRequest request) throws GsonDataConvertException{
		String initRequest = initRequest(request);
		GetLawInfoRequest data = GsonUtil.fromJson(initRequest,GetLawInfoRequest.class);
//		logger.info("\n\n 获取法律法规的二级标题信息\n\n");
		String response = this.dataService.getSecondTitle(data.getTitleName());
//		logger.info("\n获取法律法规的二级标题返回信息为\n"+response+"\n\n");
		return response;
	}
	
	/**
	 * addFollow(测试添加关注)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月25日 下午9:17:05    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月25日 下午9:17:05    
	 * 修改备注： 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/addFollow",method=RequestMethod.POST)
	public String addFollow(){
		logger.info("\n\n start ===addFollow====\n\n");
		String response = this.dataService.addFollow();
		return response;
	}
	
	/**
	 * saveSyncRecord(保存同步文件记录)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月25日 下午1:39:48    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月25日 下午1:39:48    
	 * 修改备注： 
	 * @param request
	 * @return
	 * @throws GsonDataConvertException
	 */
	@ResponseBody
	@RequestMapping(value="/saveSync")
	public String saveSyncRecord(HttpServletRequest request) throws GsonDataConvertException{
		String initRequest = initRequest(request);
		AddSyncRecordRequest data = GsonUtil.fromJson(initRequest,AddSyncRecordRequest.class);
		String response = this.dataService.saveSyncRecord(data.getNewId(),data.getIsSuccess());
		return response;
	}
	
	/**
	 * syncNewData(获取新的新闻记录--一次同步10条)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月25日 下午9:56:46    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月25日 下午9:56:46    
	 * 修改备注： 
	 * @param request
	 * @return
	 * @throws GsonDataConvertException
	 */
	@ResponseBody
	@RequestMapping(value="/syncNewData")
	public String syncNewData(HttpServletRequest request) throws GsonDataConvertException{
		String initRequest = initRequest(request);
		SyncNewDataRequest data = GsonUtil.fromJson(initRequest,SyncNewDataRequest.class);
		String response = this.dataService.syncNewData(data.getNewId());
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
	@Scheduled(cron="0 0/30 * * * ?")
	public void run_bat() {
		System.out.println("=================start============");
         Process ps;
         try {
        	 String batName = Constants.SPRIDER_QIDON＿BAT_LOCATION;
             ps = Runtime.getRuntime().exec("cmd.exe /C start "+batName);
             InputStream in = ps.getInputStream(); 
             int c; 
             while ((c = in.read()) != -1) { 
            	// 如果你不需要看输出，这行可以注销掉
            	 System.out.print(c); 
             } 
             in.close(); 
             ps.waitFor();
         } catch (Exception e) {
             e.printStackTrace();
         }
         count += 1;
         System.out.println("=============finish============="); 
         System.out.println("定时在"+new Date()+"执行了第"+count+"次");
	}

}
