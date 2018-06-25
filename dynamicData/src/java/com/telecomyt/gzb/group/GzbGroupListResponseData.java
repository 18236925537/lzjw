package com.telecomyt.gzb.group;

public class GzbGroupListResponseData {
	private String resp_code;
	private String resp_msg;
	private GzbGroupInfo[] items;
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
	public GzbGroupInfo[] getItems() {
		return items;
	}
	public void setItems(GzbGroupInfo[] items) {
		this.items = items;
	}
	

}
