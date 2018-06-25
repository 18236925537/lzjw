package com.telecomyt.exception;

public class GsonDataConvertException extends Exception {
	private static final long serialVersionUID = 2008300569012967267L;
	private Integer exception_code;
	private String exception_message;

	public Integer getException_code() {
		return exception_code;
	}

	public void setException_code(Integer exception_code) {
		this.exception_code = exception_code;
	}

	public String getException_message() {
		return exception_message;
	}

	public void setException_message(String exception_message) {
		this.exception_message = exception_message;
	}

	public GsonDataConvertException() {
		super();
	}

	public GsonDataConvertException(String exception_message) {
		super();
		this.exception_message = exception_message;
	}

	public GsonDataConvertException(Integer exception_code, String exception_message) {
		super();
		this.exception_code = exception_code;
		this.exception_message = exception_message;
	}

}
