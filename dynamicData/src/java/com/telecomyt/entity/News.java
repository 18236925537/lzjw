/** 
 *  项目名称:lzjw 
 * 文件名称:News.java 
 * 包名:com.telecomyt.entity 
 * 创建日期:2018年5月17日下午9:24:39 
 * Copyright (c) 2018, zhoupengbing@telecomyt.com.cn All Rights Reserved.  
 */  
package com.telecomyt.entity;

/** 
 * 项目名称：lzjw    
 * 类名称：News    
 * 类描述： 新闻实体
 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn    
 * 创建时间：2018年5月17日 下午9:24:39    
 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn 
 * 修改时间：2018年5月17日 下午9:24:39    
 * 修改备注：       
 * @version      
 */
public class News {
	
	private int id;
	private String _class;//级目录下分类
	private String listTitle;//文章列表标题
	private String listTime;//文章列表时间
	private String subclassType;
	private String articleTitle;//文章标题
	private String articleSecondTitle;//文章副标题
	private String articleDetail;//文章内容
	private String articlePictureName;//文章标题图片名
	private String articlePictureValue;//文章标题图片路径
	private String articleAttachmentName;//文章附件名
	private String articleAttachmentValue;//文章附件路径
	private String attachPath;
	
	public String getSubclassType() {
		return subclassType;
	}
	public void setSubclassType(String subclassType) {
		this.subclassType = subclassType;
	}
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
		this.articlePictureValue = articlePictureValue;
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
		this.articleAttachmentValue = articleAttachmentValue;
	}
	public String getAttachPath() {
		return attachPath;
	}
	public void setAttachPath(String attachPath) {
		this.attachPath = attachPath;
	}
}
