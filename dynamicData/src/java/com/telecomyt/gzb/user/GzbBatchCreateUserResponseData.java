package com.telecomyt.gzb.user;

public class GzbBatchCreateUserResponseData {
	private String resp_code;
	private String resp_msg;
	private GzbUserInfo[] items;
	public String getResp_code() {
		return resp_code;
	}
	public void setResp_code(String resp_code) {
		this.resp_code = resp_code;
	}
	public String getResp_msg() {
		return resp_msg;
	}
	public void setResp_msg(String resp_msg) {
		this.resp_msg = resp_msg;
	}
	public GzbUserInfo[] getItems() {
		return items;
	}
	public void setItems(GzbUserInfo[] items) {
		this.items = items;
	}
	

}
