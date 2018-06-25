/** 
 *  项目名称:lzjw 
 * 文件名称:OpenSnsLoginResponseData.java 
 * 包名:com.telecomyt.entity 
 * 创建日期:2018年5月13日下午10:16:58 
 * Copyright (c) 2018, zhoupengbing@telecomyt.com.cn All Rights Reserved.  
 */  
package com.telecomyt.entity;

/** 
 * 项目名称：lzjw    
 * 类名称：OpenSnsLoginResponseData    
 * 类描述：    
 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn    
 * 创建时间：2018年5月13日 下午10:16:58    
 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn 
 * 修改时间：2018年5月13日 下午10:16:58    
 * 修改备注：       
 * @version      
 */
public class OpenSnsLoginResponseData {
	
	private Data data;
	private String code;
	/**
	 * 
	 *  项目名称：lzjw    
	 * 类名称：Data    
	 * 类描述：    
	 * 创建人：周鹏兵 zhoupengbing@telecomyt.com.cn    
	 * 创建时间：2018年5月13日 下午11:56:25    
	 * 修改人：周鹏兵 zhoupengbing@telecomyt.com.cn 
	 * 修改时间：2018年5月13日 下午11:56:25    
	 * 修改备注：       
	 * @version OpenSnsLoginResponseData
	 */
	private DataUser data_1;
	public class DataUser{
		
	}
	public class Data{
		
		private String open_id;
		private OpenSnsUser auth;
		private String timestamp;
		
		public class OpenSnsUser{
			
			private String uid;
			private String username;
			private String last_login_time;
			private int role_id;
			private int audit;
			
			public String getUid() {
				return uid;
			}
			public void setUid(String uid) {
				this.uid = uid;
			}
			public String getUsername() {
				return username;
			}
			public void setUsername(String username) {
				this.username = username;
			}
			public String getLast_login_time() {
				return last_login_time;
			}
			public void setLast_login_time(String last_login_time) {
				this.last_login_time = last_login_time;
			}
			public int getRole_id() {
				return role_id;
			}
			public void setRole_id(int role_id) {
				this.role_id = role_id;
			}
			public int getAudit() {
				return audit;
			}
			public void setAudit(int audit) {
				this.audit = audit;
			}
			
		}

		public String getOpen_id() {
			return open_id;
		}

		public void setOpen_id(String open_id) {
			this.open_id = open_id;
		}

		public OpenSnsUser getAuth() {
			return auth;
		}

		public void setAuth(OpenSnsUser auth) {
			this.auth = auth;
		}

		public String getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(String timestamp) {
			this.timestamp = timestamp;
		}
		
	}

	public Data getData() {
		return data;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public DataUser getData_1() {
		return data_1;
	}

	public void setData_1(DataUser data_1) {
		this.data_1 = data_1;
	}
	
}
