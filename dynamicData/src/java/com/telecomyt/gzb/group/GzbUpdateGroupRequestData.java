package com.telecomyt.gzb.group;

public class GzbUpdateGroupRequestData {
	private String token;
	private String chatroom_id;
	private String subject;
	private String description;
	private String admin;
	private String[] add_users;
	private String[] del_users;
	private Privilege privileges;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
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
	public String[] getAdd_users() {
		return add_users;
	}
	public void setAdd_users(String[] add_users) {
		this.add_users = add_users;
	}
	public String[] getDel_users() {
		return del_users;
	}
	public void setDel_users(String[] del_users) {
		this.del_users = del_users;
	}
	public Privilege getPrivileges() {
		return privileges;
	}
	public void setPrivileges(Privilege privileges) {
		this.privileges = privileges;
	}
	

}
