/** 
 *  项目名称:lzjw 
 * 文件名称:GetRegionDataREsponse.java 
 * 包名:com.telecomyt.template 
 * 创建日期:2018年5月31日下午5:52:21 
 * Copyright (c) 2018, zhoupengbing@telecomyt.com.cn All Rights Reserved.  
 */  
package com.telecomyt.template;

import java.util.List;

import com.google.gson.annotations.SerializedName;

/** 
 * 项目名称：lzjw    
 * 类名称：GetRegionDataREsponse    
 * 类描述：获取管辖区域数据信息 
 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn    
 * 创建时间：2018年5月31日 下午5:52:21    
 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn 
 * 修改时间：2018年5月31日 下午5:52:21    
 * 修改备注：       
 * @version      
 */
public class GetRegionDataREsponse {
	
	//警情数
	private List<Jqs>jqs;
	//警情比
	private List<Jqb>jqb;
	//昨日案发数
	private List<Ajs>ajs;
	//案件比
	private List<Ajb>ajb;
	
	public class Ajb{
		private List<AjbData>data;
		public class AjbData{
			@SerializedName("new")
			private String _new;
			private String old;
			private String type;
			public String get_new() {
				return _new;
			}
			public void set_new(String _new) {
				this._new = _new;
			}
			public String getOld() {
				return old;
			}
			public void setOld(String old) {
				this.old = old;
			}
			public String getType() {
				return type;
			}
			public void setType(String type) {
				this.type = type;
			}
		}
		public List<AjbData> getData() {
			return data;
		}
		public void setData(List<AjbData> data) {
			this.data = data;
		}
	}
	
	public class Ajs{
		private List<AjsData>data;
		public class AjsData{
			private String data;
			private String qt;
			private String xs;
			private String za;
			public String getData() {
				return data;
			}
			public void setData(String data) {
				this.data = data;
			}
			public String getQt() {
				return qt;
			}
			public void setQt(String qt) {
				this.qt = qt;
			}
			public String getXs() {
				return xs;
			}
			public void setXs(String xs) {
				this.xs = xs;
			}
			public String getZa() {
				return za;
			}
			public void setZa(String za) {
				this.za = za;
			}
		}
		public List<AjsData> getData() {
			return data;
		}
		public void setData(List<AjsData> data) {
			this.data = data;
		}
	}
	
	public class Jqb{
		private List<JqbData>data;
		public class JqbData{
			@SerializedName("new")
			private String _new;
			private String old;
			private String type;
			public String get_new() {
				return _new;
			}
			public void set_new(String _new) {
				this._new = _new;
			}
			public String getOld() {
				return old;
			}
			public void setOld(String old) {
				this.old = old;
			}
			public String getType() {
				return type;
			}
			public void setType(String type) {
				this.type = type;
			}
		}
		public List<JqbData> getData() {
			return data;
		}
		public void setData(List<JqbData> data) {
			this.data = data;
		}
	}
	public class Jqs{
		private List<JqsData>data;
		public class JqsData{
			private String data;
			private String qt;
			private String qz;
			private String xs;
			private String za;
			public String getData() {
				return data;
			}
			public void setData(String data) {
				this.data = data;
			}
			public String getQt() {
				return qt;
			}
			public void setQt(String qt) {
				this.qt = qt;
			}
			public String getQz() {
				return qz;
			}
			public void setQz(String qz) {
				this.qz = qz;
			}
			public String getXs() {
				return xs;
			}
			public void setXs(String xs) {
				this.xs = xs;
			}
			public String getZa() {
				return za;
			}
			public void setZa(String za) {
				this.za = za;
			}
		}
		public List<JqsData> getData() {
			return data;
		}
		public void setData(List<JqsData> data) {
			this.data = data;
		}
	}
	public List<Jqs> getJqs() {
		return jqs;
	}
	public void setJqs(List<Jqs> jqs) {
		this.jqs = jqs;
	}
	public List<Jqb> getJqb() {
		return jqb;
	}
	public void setJqb(List<Jqb> jqb) {
		this.jqb = jqb;
	}
	public List<Ajs> getAjs() {
		return ajs;
	}
	public void setAjs(List<Ajs> ajs) {
		this.ajs = ajs;
	}
	public List<Ajb> getAjb() {
		return ajb;
	}
	public void setAjb(List<Ajb> ajb) {
		this.ajb = ajb;
	}
}
