package com.telecomyt.gzb.message;

public class Data {
	private String content;
	private String roomKey;
	
	

	public String getRoomKey() {
		return roomKey;
	}

	public void setRoomKey(String roomKey) {
		this.roomKey = roomKey;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Data() {
		super();
	}

	public Data(String content) {
		super();
		this.content = content;
	}
	

}
