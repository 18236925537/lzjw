/** 
 *  项目名称:lzjw 
 * 文件名称:NewInfo.java 
 * 包名:com.telecomyt.entity 
 * 创建日期:2018年5月13日下午6:28:59 
 * Copyright (c) 2018, zhoupengbing@telecomyt.com.cn All Rights Reserved.  
 */  
package com.telecomyt.entity;

import java.util.List;

import com.sun.corba.se.impl.orbutil.closure.Constant;
import com.telecomyt.enums.Constants;
import com.telecomyt.exception.GsonDataConvertException;
import com.telecomyt.utils.GsonUtil;

/** 
 * 项目名称：lzjw    
 * 类名称：NewInfo    
 * 类描述：    
 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn    
 * 创建时间：2018年5月13日 下午6:28:59    
 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn 
 * 修改时间：2018年5月13日 下午6:28:59    
 * 修改备注：       
 * @version      
 */
public class NewInfo {
	
	private int id;
	private String _class;//级目录下分类
	private String listTitle;//文章列表标题
	private String listTime;//文章列表时间
	private String articleTitle;//文章标题
	private String articleSecondTitle;//文章副标题
	private String articleDetail;//文章内容
	private String articlePictureName;//文章标题图片名
	private String articlePictureValue;//文章标题图片路径
	private String articleAttachmentName;//文章附件名
	private String articleAttachmentValue;//文章附件路径
	private String attachPath;//附件转换之后的地址
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String get_class() {
		return _class;
	}
	public void set_class(String _class) {
		this._class = _class;
	}
	public String getListTitle() {
		return listTitle;
	}
	public void setListTitle(String listTitle) {
		this.listTitle = listTitle;
	}
	public String getListTime() {
		return listTime;
	}
	public void setListTime(String listTime) {
		this.listTime = listTime;
	}
	public String getArticleTitle() {
		return articleTitle;
	}
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	public String getArticleSecondTitle() {
		return articleSecondTitle;
	}
	public void setArticleSecondTitle(String articleSecondTitle) {
		this.articleSecondTitle = articleSecondTitle;
	}
	public String getArticleDetail() {
		return articleDetail;
	}
	public void setArticleDetail(String articleDetail) {
		this.articleDetail = articleDetail;
	}
	public String getArticlePictureName() {
		return articlePictureName;
	}
	public void setArticlePictureName(String articlePictureName) {
		this.articlePictureName = articlePictureName;
	}
	public String getArticlePictureValue() {
		return articlePictureValue;
	}
	public void setArticlePictureValue(String articlePictureValue) {
		try {
			FilePath path = GsonUtil.fromJson("{list:"+articlePictureValue+"}",FilePath.class);
			if(articlePictureValue != null && !articlePictureValue.equals("")){
				if(path != null){
					List<FileInfo> list = path.getList();
					String regFrom = "";
					String regTo = "";
					if(list != null && list.size() > 0){
						for (FileInfo fileInfo : list) {
							regFrom = "/"+fileInfo.getUrl().split("//")[1].replaceFirst("/",":").split(":")[1];
							regTo = fileInfo.getPath().replace("full",Constants.SERVER_IMAGE_PATH);
							//区厅要闻图片式全路径
							articleDetail = articleDetail.replace(fileInfo.getUrl(),regTo).replace("..", "");
							//其他新闻是相对路径
							articleDetail = articleDetail.replace(regFrom,regTo);
						}
					}
					this.articleDetail = articleDetail;
					this.articlePictureValue = articlePictureValue;
				}
			}else{
				this.articlePictureValue = articlePictureValue;
			}
		} catch (GsonDataConvertException e) {
			e.printStackTrace();
		}
	}
	public String getArticleAttachmentName() {
		return articleAttachmentName;
	}
	public void setArticleAttachmentName(String articleAttachmentName) {
		this.articleAttachmentName = articleAttachmentName;
	}
	public String getArticleAttachmentValue() {
		return articleAttachmentValue;
	}
	public void setArticleAttachmentValue(String articleAttachmentValue) {
		try {
			String attachFile = "";
			if(articleAttachmentValue != null && !articleAttachmentValue.equals("")){
				FilePath path = GsonUtil.fromJson("{list:"+articleAttachmentValue+"}",FilePath.class);
				if(path != null){
					List<FileInfo> list = path.getList();
					if(list != null && list.size() > 0){
						for (FileInfo fileInfo : list) {
							String attachPath = fileInfo.getPath().replace("full",Constants.SERVER_ATTACH_PATH);
							if(attachFile != null && !attachFile.equals("")){
								attachFile = attachFile + "," + attachPath;
							}else{
								attachFile = attachPath;
							}
						}
						this.articleAttachmentValue = attachFile;
					}else{
						this.articleAttachmentValue = articleAttachmentValue;
					}
				}else{
					this.articleAttachmentValue = articleAttachmentValue;
				}
			}else{
				this.articleAttachmentValue = articleAttachmentValue;
			}
			
		} catch (GsonDataConvertException e) {
			e.printStackTrace();
		}
	}
	public String getAttachPath() {
		return attachPath;
	}
	public void setAttachPath(String attachPath) {
		this.attachPath = attachPath;
	}
}
