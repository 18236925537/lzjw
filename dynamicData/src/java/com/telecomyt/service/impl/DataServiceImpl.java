package com.telecomyt.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.telecomyt.dao.ILiuZhouDao;
import com.telecomyt.entity.Data;
import com.telecomyt.entity.FileInfo;
import com.telecomyt.entity.FilePath;
import com.telecomyt.entity.Law;
import com.telecomyt.entity.NewInfo;
import com.telecomyt.entity.NewList;
import com.telecomyt.entity.News;
import com.telecomyt.entity.ResponseData;
import com.telecomyt.entity.SecondTitle;
import com.telecomyt.entity.SyncFileData;
import com.telecomyt.entity.ThirdTitle;
import com.telecomyt.entity.User;
import com.telecomyt.exception.GsonDataConvertException;
import com.telecomyt.service.IDataService;
import com.telecomyt.task.AddFollowTask;
import com.telecomyt.utils.ArrayUtil;
import com.telecomyt.utils.CustomStringUtil;
import com.telecomyt.utils.ExcelUtil;
import com.telecomyt.utils.GsonUtil;
import com.telecomyt.utils.HttpPost;
import com.telecomyt.utils.SFTPUtil;
import com.telecomyt.utils.SftpUtils;
import com.telecomyt.utils.SyncFileUtils;

import net.sf.json.JSONObject;

/** 
* @author zpb
* @date 2018年3月13日 下午3:09:31 
* 类说明 
*/
@Service("dataService")
public class DataServiceImpl implements IDataService{
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private ILiuZhouDao liuZhouDao;
	
	@Override
	public String initLiuZhouData() {
		List<User>userList = this.liuZhouDao.getUserList();
		logger.info("\n\n 获取到的用户数量是:"+userList.size()+"\n\n");
		if(userList != null && userList.size() > 0){
			for (User user : userList) {
				this.liuZhouDao.update(user);
			}
			return "success";
		}
		return "failure";
	}
	
	/**
	 * 原来的接口
	 */
	public String getNewsListOld(String name,int pageCount,int pageNum,int lastNewId) {
		ResponseData data = new ResponseData();
		try{
			List<Data>dataList = new ArrayList<>();
			NewList list = new NewList();
			int startIndex =  -1;
			List<Data>newList = this.liuZhouDao.getNewList(name,pageCount,lastNewId);
			if(newList != null && newList.size() > 0){
				for (Data newData : newList) {
					if(newData != null){
						//lastNewId = 0 第一次查询
						if(lastNewId == 0){
							if(startIndex < pageCount -1){
								dataList.add(newData);
								startIndex += 1;
							}
						}else{
							//startIndex为-1--》还没到上次分页的最后一条记录
							if(lastNewId != 0 && startIndex == -1){
								if(newData.getId() == lastNewId){
									startIndex = 0;
								}
								//去除相应数目的新闻信息
							}else if(startIndex >=0 && startIndex < pageCount){
								dataList.add(newData);
								startIndex += 1;
							}
						}
					}
				}
				list.setCurrentPage(pageNum);
				list.setNewList(dataList);
				list.setTotalpage(newList.size());
			}
			data.setCode("200");
			data.setMessage("获取新闻列表信息成功");
			data.setData(list);
		}catch(Exception e){
			e.printStackTrace();
			data.setCode("400");
			data.setMessage("获取新闻列表信息失败");
			data.setData(null);
		}
		return GsonUtil.toJson(data);
	}
	
	@Override
	public String getNewsList(String name,int pageCount,int pageNum,int lastNewId) {
		ResponseData data = new ResponseData();
		try{
			List<Data>dataList = new ArrayList<>();
			NewList list = new NewList();
			int startIndex = 0;
			if(pageNum > 0){
				startIndex = pageCount * (pageNum - 1);
				List<Data>newList = this.liuZhouDao.getNewList(name,pageCount,startIndex);
				int totalCount = this.liuZhouDao.getNewListCount(name);
				list.setCurrentPage(pageNum);
				list.setNewList(newList);
				list.setTotalpage(totalCount);
			}
			data.setCode("200");
			data.setMessage("获取新闻列表信息成功");
			data.setData(list);
		}catch(Exception e){
			e.printStackTrace();
			data.setCode("400");
			data.setMessage("获取新闻列表信息失败");
			data.setData(null);
		}
		return GsonUtil.toJson(data);
	}
	
	@Override
	public String getSecondTitle() {
		ResponseData data = new ResponseData();
		try{
			List<SecondTitle>list= this.liuZhouDao.getSendTitle();
			data.setCode("200");
			data.setMessage("获取二级列表信息成功");
			data.setData(list);
		}catch(Exception e){
			e.printStackTrace();
			data.setCode("400");
			data.setMessage("获取二级列表信息失败");
			data.setData(null);
		}
		return GsonUtil.toJson(data);
	}

	@Override
	public String getThirdTitle(String secondName) {
		ResponseData data = new ResponseData();
		try{
			List<ThirdTitle>list= this.liuZhouDao.getThirdTitle(secondName);
			data.setCode("200");
			data.setMessage("获取三级信息成功");
			data.setData(list);
		}catch(Exception e){
			e.printStackTrace();
			data.setCode("400");
			data.setMessage("获取三级信息失败");
			data.setData(null);
		}
		return GsonUtil.toJson(data);
	}

	@Override
	public String getNewInfo(String newId) {
		ResponseData data = new ResponseData();
		try{
			NewInfo newInfo = this.liuZhouDao.getNewInfo(newId);
			data.setCode("200");
			data.setMessage("获取新闻详情成功");
			data.setData(newInfo);
		}catch(Exception e){
			e.printStackTrace();
			data.setCode("400");
			data.setMessage("获取新闻详情失败");
			data.setData(null);
		}
		return GsonUtil.toJson(data);
	}

	@Override
	public String syncFileData() {
		ResponseData data = new ResponseData();
		try{
			List<News>newList = this.liuZhouDao.getSyncNewList();
			if(newList != null && newList.size() > 0){
				for (News news : newList) {
					//===================================文件同步=====================================================//
					//图片文件同步
					FilePath imagePath = GsonUtil.fromJson("{list:"+news.getArticlePictureValue()+"}",FilePath.class);
					List<FileInfo> list = imagePath.getList();
					boolean syncImage = true;
					if(list != null && list.size() > 0){
						syncImage = syncFile(list,1);
					}
					//附件文件同步
					boolean syncAttach = true;
					FilePath attPath = GsonUtil.fromJson("{list:"+news.getArticleAttachmentValue()+"}",FilePath.class);
					List<FileInfo> attList = attPath.getList();
					if(attList != null && attList.size() > 0){
						syncAttach = syncFile(attList,2);
					}
					//同步完成添加同步记录
					Map<String,String>params = new HashMap();
					params.put("newId",news.getId()+"");
					if(syncAttach && syncImage){
						this.liuZhouDao.addSyncFileRecord(news.getId(),1); 
					}else{
						this.liuZhouDao.addSyncFileRecord(news.getId(),0);
					}
//					SyncFileData syncData = SyncFileUtils.syncData("/lzjw/saveSync",GsonUtil.toJson(params));
//					if(syncData.getResCode().equals("10000")){
//						logger.info("\n\n 保存一条同步记录成功\n\n");
//					}else{
//						logger.info("\n\n 保存一条同步记录失败"+GsonUtil.toJson(syncData)+"\n\n");
//					}
					//===================================文件下载================================================//
					Thread.sleep(1000);
					syncImage = true;
					syncAttach = true;
					logger.info("\n\n=======开始下载文件=======\n\n");
					if(list != null && list.size() > 0){
						syncImage = downLoadFile(list, 1);
					}
					if(attList != null && attList.size() > 0){
						syncAttach = downLoadFile(attList,2);
					}
					if(syncAttach && syncImage){
						logger.info("\n\n======下载文件成功======\n\n");
					}
				}
				data.setCode("200");
				data.setMessage("同步文件成功");
				data.setData(null);
			}else{
				logger.info("\n\n 没有要同步的文件\n\n");
				data.setCode("200");
				data.setMessage("没有要同步的文件");
				data.setData(null);
			}
		}catch(Exception e){
			e.printStackTrace();
			logger.info("\n\n ====同步文件失败 ====\n\n");
			data.setCode("400");
			data.setMessage("同步文件失败");
			data.setData(null);
		}
		return GsonUtil.toJson(data);
	}
	
	@Override
	public String syncNewFileData() {
		ResponseData data = new ResponseData();
		try{
			//获取新的新闻记录
			List<News>newList = this.liuZhouDao.getSyncNewList();
			data.setCode("200");
			data.setMessage("获取要同步的新闻信息成功");
			data.setData(newList);
		}catch(Exception e){
			e.printStackTrace();
			data.setCode("400");
			data.setMessage("获取要同步的新闻信息失败");
			data.setData(null);
		}
		return GsonUtil.toJson(data);
	}
	
	/**
	 * syncFile(同步文件)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月17日 下午9:32:56    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月17日 下午9:32:56    
	 * 修改备注： 
	 * @param list
	 * @param type 类型 1-图片 2-附件
	 */
	public boolean syncFile(List<FileInfo> list,int type){
		int sum = 0;
		for (FileInfo fileInfo : list) {
			String path = fileInfo.getPath();
			String fileName = path.split("/")[1];
			try {
				SyncFileData syncFile = SyncFileUtils.syncFile(fileName, type);
				logger.info("\n\n 同步"+fileName+"返回信息=="+GsonUtil.toJson(syncFile)+"\n\n");
				if(syncFile.getResCode().equals("10000") && syncFile.getResCode().equals("10001")){
					sum += 1;
				}
			} catch (GsonDataConvertException e) {
				e.printStackTrace();
			}
		}
		//判断是否同步成功
		if(sum == list.size()){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * downLoadFile(将文件从二来区xftp服务器下载到二类区web服务器)   
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn     
	 * 创建时间：2018年5月25日 下午5:13:30    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn      
	 * 修改时间：2018年5月25日 下午5:13:30    
	 * 修改备注： 
	 * @param list
	 * @param type
	 * @return
	 */
	public boolean downLoadFile(List<FileInfo> list,int type){
		int sum = 0;
		for (FileInfo fileInfo : list) {
			String path = fileInfo.getPath();
			String fileName = path.split("/")[1];
			try {
				String remotePathFile = "";
				String localPathFile = "";
				//图片
				if(type == 1){
					remotePathFile = "/upload/file_lz/images/full/";
					localPathFile = "/usr/local/java/apache-tomcat-8.0.37/webapps/file_lz/images/full/"+fileName;
				}else{
					remotePathFile = "upload/file_lz/attachments/full/";
					localPathFile = "/usr/local/java/apache-tomcat-8.0.37/webapps/file_lz/attachments/full/"+fileName;
				}
				SftpUtils sftp = new SftpUtils("dxydlcjw", "dxyt2018=-", "20.124.145.190",22);
				SftpUtils.downFile(sftp,remotePathFile,fileName,localPathFile, true);
				sum += 1;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//判断是否下载成功
		if(sum == list.size()){
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public String getLawFirstTitle(String key) {
		ResponseData data = new ResponseData();
		try{
			List<Law>lawList = this.liuZhouDao.getLawFirstTitle(key);
			data.setCode("200");
			data.setMessage("获取法律一级标题成功");
			data.setData(lawList);
		}catch(Exception e){
			e.printStackTrace();
			data.setCode("400");
			data.setMessage("获取法律一级标题失败");
			data.setData(null);
		}
		return GsonUtil.toJson(data);
	}

	@Override
	public String getSecondTitle(String titleName) {
		ResponseData data = new ResponseData();
		try{
			List<Law>lawList = this.liuZhouDao.getLawSecondTitle(titleName);
			data.setCode("200");
			data.setMessage("获取法律二级标题成功");
			data.setData(lawList);
		}catch(Exception e){
			e.printStackTrace();
			data.setCode("400");
			data.setMessage("获取法律二级标题失败");
			data.setData(null);
		}
		return GsonUtil.toJson(data);
	}

	@Override
	public String getLawInfo(String titleName) {
		ResponseData data = new ResponseData();
		try{
			Law law = this.liuZhouDao.getLawInfo(titleName);
			data.setCode("200");
			data.setMessage("获取法律详情成功");
			data.setData(law);
		}catch(Exception e){
			e.printStackTrace();
			data.setCode("400");
			data.setMessage("获取法律详情失败");
			data.setData(null);
		}
		return GsonUtil.toJson(data);
	}

	@Override
	public String addFollow() {
		ResponseData data = new ResponseData();
		try{
			List<Integer>ids = this.liuZhouDao.findAllMember();
			for(int i = 1;i < ids.size();i++){
				int follow = ids.get(i);
				List<Integer>idList = new ArrayList<>();
				for(int j = 1;j < ids.size();j++){
					if(i != j){
						idList.add(ids.get(j));
					}
				}
				//开始添加 
				AddFollowTask task = new AddFollowTask(idList,liuZhouDao,follow);
				ForkJoinPool pool = new ForkJoinPool();
				pool.submit(task);
				new Thread().sleep(3*60*1000);
			}
			data.setCode("200");
			data.setMessage("获取法律详情成功");
			data.setData(null);
		}catch(Exception e){
			e.printStackTrace();
			data.setCode("400");
			data.setMessage("获取法律详情失败");
			data.setData(null);
		}
		return GsonUtil.toJson(data);
	}
	
	@Override
	public String saveSyncRecord(String newId,int isSuccess){
		ResponseData data = new ResponseData();
		try{
			this.liuZhouDao.addSyncFileRecord(Integer.valueOf(newId),isSuccess);
			data.setCode("200");
			data.setMessage("获取法律详情成功");
			data.setData(null);
		}catch(Exception e){
			e.printStackTrace();
			data.setCode("400");
			data.setMessage("获取法律详情失败");
			data.setData(null);
		}
		return GsonUtil.toJson(data);
	}

	@Override
	public void addNew(List<News> newList) {
		try{
			for (News news : newList) {
				//格式化标题时间
				String[] time = ArrayUtil.correctListTime(news.getListTime());
				news.setListTime(time[0]+"-"+time[1]+"-"+time[2]);
				this.liuZhouDao.addNew(news);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public String getLagestNewId() {
		String newId = this.liuZhouDao.getLagestNewId();
		return newId;
	}

	@Override
	public String syncNewData(String newId) {
		ResponseData data = new ResponseData();
		try{
			List<News>list = this.liuZhouDao.syncNewData(newId);
			data.setCode("200");
			data.setMessage("获取需要同步的新闻成功");
			data.setData(list);
		}catch(Exception e){
			e.printStackTrace();
			data.setCode("400");
			data.setMessage("获取需要同步的新闻失败");
			data.setData(null);
		}
		return GsonUtil.toJson(data);
	}

	@Override
	public String correctTitleTime() {
		ResponseData data = new ResponseData();
		try{
			List<News>list = this.liuZhouDao.getAllNews();
			//遍历新闻并且格式化新闻时间
			for (News news : list) {
				//时间格式有为2018/05/02
				String[] correctedTime = ArrayUtil.correctListTime(news.getListTime());
				news.setListTime(correctedTime[0]+"-"+correctedTime[1]+"-"+correctedTime[2]);
				this.liuZhouDao.updateNew(news.getId(),news.getListTime());
			}
			data.setCode("200");
			data.setMessage("更新新闻时间成功");
			data.setData(null);
		}catch(Exception e){
			e.printStackTrace();
			data.setCode("400");
			data.setMessage("更新新闻时间失败");
			data.setData(null);
		}
		return GsonUtil.toJson(data);
	}

	@Override
	public String joinCrowd() {
		ResponseData data = new ResponseData();
		try{
			List<String>uids = this.liuZhouDao.getAcenterMemberIds();
			data.setCode("200");
			data.setMessage("获取加入圈子的人信息成功");
			data.setData(uids);
		}catch(Exception e){
			e.printStackTrace();
			data.setCode("400");
			data.setMessage("获取加入圈子的人信息失败");
			data.setData(null);
		}
		return GsonUtil.toJson(data);
	}
	
}
