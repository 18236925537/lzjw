package com.telecomyt.gzb.group;

public class GzbPushMessageResponseData {
	private String resp_msg;
	private String resp_code;
	private String invalid_chatrooms[];
	private String message_id;
	private String invalid_users[];
	private String invalid_member_aliases[];
	private String invalid_departments[];
	public String getResp_msg() {
		return resp_msg;
	}
	public void setResp_msg(String resp_msg) {
		this.resp_msg = resp_msg;
	}
	public String getResp_code() {
		return resp_code;
	}
	public void setResp_code(String resp_code) {
		this.resp_code = resp_code;
	}
	public String[] getInvalid_chatrooms() {
		return invalid_chatrooms;
	}
	public void setInvalid_chatrooms(String[] invalid_chatrooms) {
		this.invalid_chatrooms = invalid_chatrooms;
	}
	public String getMessage_id() {
		return message_id;
	}
	public void setMessage_id(String message_id) {
		this.message_id = message_id;
	}
	public String[] getInvalid_users() {
		return invalid_users;
	}
	public void setInvalid_users(String[] invalid_users) {
		this.invalid_users = invalid_users;
	}
	public String[] getInvalid_member_aliases() {
		return invalid_member_aliases;
	}
	public void setInvalid_member_aliases(String[] invalid_member_aliases) {
		this.invalid_member_aliases = invalid_member_aliases;
	}
	public String[] getInvalid_departments() {
		return invalid_departments;
	}
	public void setInvalid_departments(String[] invalid_departments) {
		this.invalid_departments = invalid_departments;
	}
	

}
