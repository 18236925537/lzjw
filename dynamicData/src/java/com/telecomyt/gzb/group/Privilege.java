package com.telecomyt.gzb.group;

public class Privilege {
	private boolean member_invite_enabled;
	private boolean member_exit_enabled;
	public boolean isMember_invite_enabled() {
		return member_invite_enabled;
	}
	public void setMember_invite_enabled(boolean member_invite_enabled) {
		this.member_invite_enabled = member_invite_enabled;
	}
	public boolean isMember_exit_enabled() {
		return member_exit_enabled;
	}
	public void setMember_exit_enabled(boolean member_exit_enabled) {
		this.member_exit_enabled = member_exit_enabled;
	}
	public Privilege() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Privilege(boolean member_invite_enabled, boolean member_exit_enabled) {
		super();
		this.member_invite_enabled = member_invite_enabled;
		this.member_exit_enabled = member_exit_enabled;
	}

	

}
