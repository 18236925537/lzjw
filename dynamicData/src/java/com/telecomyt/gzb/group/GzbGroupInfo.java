package com.telecomyt.gzb.group;

public class GzbGroupInfo {
	private String chatroom_id;
	private String subject;
	private String description;
	private String admin;
	private String []users;
	private Privilege privileges;
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
