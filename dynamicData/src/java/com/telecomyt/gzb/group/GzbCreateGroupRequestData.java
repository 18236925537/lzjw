package com.telecomyt.gzb.group;

public class GzbCreateGroupRequestData {
	private String token;
	private String subject;
	private String description;
	private String admin;
	private String users[];
	private Privilege privileges;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
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
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}

}
