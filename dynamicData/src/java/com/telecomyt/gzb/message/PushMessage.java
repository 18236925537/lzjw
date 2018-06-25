package com.telecomyt.gzb.message;

public class PushMessage {
	private String msgType;
	private String message;
	private Data data;
	
	public PushMessage(String msgType, String message, Data data) {
		super();
		this.msgType = msgType;
		this.message = message;
		this.data = data;
	}
	public PushMessage() {
		super();
	}
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	

}
