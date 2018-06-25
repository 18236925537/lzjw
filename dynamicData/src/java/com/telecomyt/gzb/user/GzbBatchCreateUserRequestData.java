package com.telecomyt.gzb.user;

public class GzbBatchCreateUserRequestData {
	private String common_password;
	private GzbUserInfo[] items;
	public String getCommon_password() {
		return common_password;
	}
	public void setCommon_password(String common_password) {
		this.common_password = common_password;
	}
	public GzbUserInfo[] getItems() {
		return items;
	}
	public void setItems(GzbUserInfo[] items) {
		this.items = items;
	}
	
	
}
