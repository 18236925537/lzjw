package com.telecomyt.gzb.group;


/**
 * @author Administrator
 *
 */
public class GzbGetGroupResponseData {
	private String resp_code;
	private String resp_msg;
	
	private String chatroom_id;
	private String subject;
	private String description;
	private String admin;
	private String []users;
	private Privilege privileges;
	
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
	public String getChatroom_id() {
		return chatroom_id;
	}
	public void setChatroom_id(String chatroom_id) {
		this.chatroom_id = chatroom_id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String[] getUsers() {
		return users;
	}
	public void setUsers(String[] users) {
		this.users = users;
	}
	public Privilege getPrivileges() {
		return privileges;
	}
	public void setPrivileges(Privilege privileges) {
		this.privileges = privileges;
	}

}
