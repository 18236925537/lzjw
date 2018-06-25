package com.telecomyt.gzb.user;

/**
 * @author: tyy
 * @time: Jan 18, 2017 5:49:01 PM
 */

public class GzbAuthUserRequestData {
	private String access_token;
	private String auth_key;
	private String password;
	
	public String getAuth_key() {
		return auth_key;
	}

	public void setAuth_key(String auth_key) {
		this.auth_key = auth_key;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
}
