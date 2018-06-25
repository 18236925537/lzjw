package com.telecomyt.gzb.user;

import java.util.List;

public class GzbGetUserResponseData {
	
	private String position;
	private String signature;
	private String resp_code;
	private String resp_msg;
	private String user_id;
	private String name;
	private String email;
	private String custom_id;
	private String birthday;
	private String engilsh_name;
	private String ext_phone;
	private String mobile;
	private String mobile_role;
	private String mobile_status;
	private String gender;
	private String job_number;
	private String member_alias;
	private String avartar;
	private String avatar;
	private String status;
	private List<String>departments;
	private List<String>org_views;
	private Ext ext;
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCustom_id() {
		return custom_id;
	}
	public void setCustom_id(String custom_id) {
		this.custom_id = custom_id;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getEngilsh_name() {
		return engilsh_name;
	}
	public void setEngilsh_name(String engilsh_name) {
		this.engilsh_name = engilsh_name;
	}
	public String getExt_phone() {
		return ext_phone;
	}
	public void setExt_phone(String ext_phone) {
		this.ext_phone = ext_phone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getMobile_role() {
		return mobile_role;
	}
	public void setMobile_role(String mobile_role) {
		this.mobile_role = mobile_role;
	}
	public String getMobile_status() {
		return mobile_status;
	}
	public void setMobile_status(String mobile_status) {
		this.mobile_status = mobile_status;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getJob_number() {
		return job_number;
	}
	public void setJob_number(String job_number) {
		this.job_number = job_number;
	}
	public String getMember_alias() {
		return member_alias;
	}
	public void setMember_alias(String member_alias) {
		this.member_alias = member_alias;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public List<String> getDepartments() {
		return departments;
	}
	public void setDepartments(List<String> departments) {
		this.departments = departments;
	}
	public List<String> getOrg_views() {
		return org_views;
	}
	public void setOrg_views(List<String> org_views) {
		this.org_views = org_views;
	}
	public Ext getExt() {
		return ext;
	}
	public void setExt(Ext ext) {
		this.ext = ext;
	}
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
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAvartar() {
		return avartar;
	}
	public void setAvartar(String avartar) {
		this.avartar = avartar;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public class Ext{
		private String x2;//警号
		private String x3;//机构编码
		public String getX2() {
			return x2;
		}
		public void setX2(String x2) {
			this.x2 = x2;
		}
		public String getX3() {
			return x3;
		}
		public void setX3(String x3) {
			this.x3 = x3;
		}
		
	}
}
