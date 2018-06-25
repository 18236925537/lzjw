package com.telecomyt.gzb.user;

public class GzbGetTokenResponseData {
	private String resp_msg;
	private String resp_code;
	private String expire_in;
	private String access_token;
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
	public String getExpire_in() {
		return expire_in;
	}
	public void setExpire_in(String expire_in) {
		this.expire_in = expire_in;
	}
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	

}
