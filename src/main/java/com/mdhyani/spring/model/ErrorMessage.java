package com.mdhyani.spring.model;

public class ErrorMessage {
	
@Override
	public String toString() {
		return "ErrorMessage [errorMessage=" + errorMessage + ", errorCode=" + errorCode + "]";
	}

private String errorMessage;
	
	private int errorCode;

	public String getMessage() {
		return errorMessage;
	}

	public void setMessage(String message) {
		this.errorMessage = message;
	}

	public int getStatus() {
		return errorCode;
	}

	public void setStatus(int status) {
		this.errorCode = status;
	}

}
