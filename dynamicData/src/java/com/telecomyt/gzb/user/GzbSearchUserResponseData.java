package com.telecomyt.gzb.user;

public class GzbSearchUserResponseData {
	private String resp_code;
	private String resp_msg;
	private String start_index;
	private String max_items;
	private String total_items;
	private String current_items;
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
	public String getStart_index() {
		return start_index;
	}
	public void setStart_index(String start_index) {
		this.start_index = start_index;
	}
	public String getMax_items() {
		return max_items;
	}
	public void setMax_items(String max_items) {
		this.max_items = max_items;
	}
	public String getTotal_items() {
		return total_items;
	}
	public void setTotal_items(String total_items) {
		this.total_items = total_items;
	}
	public String getCurrent_items() {
		return current_items;
	}
	public void setCurrent_items(String current_items) {
		this.current_items = current_items;
	}
	public GzbUserInfo[] getItems() {
		return items;
	}
	public void setItems(GzbUserInfo[] items) {
		this.items = items;
	}
	

}
