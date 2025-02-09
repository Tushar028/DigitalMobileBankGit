package com.infy.error;

import java.time.LocalDateTime;

public class ErrorInfo {

	private String errorMessage;
	private Integer errorCode;
	private LocalDateTime errorTimeStamp;
	
	public ErrorInfo() {
		super();
	}

	public ErrorInfo(String errorMessage, Integer errorCode, LocalDateTime errorTimeStamp) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
		this.errorTimeStamp = errorTimeStamp;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public LocalDateTime getErrorTimeStamp() {
		return errorTimeStamp;
	}

	public void setErrorTimeStamp(LocalDateTime errorTimeStamp) {
		this.errorTimeStamp = errorTimeStamp;
	}
	
	
}
