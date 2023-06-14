package com.example.employee.model;

import org.springframework.http.HttpStatus;

public class responseDto {
	private HttpStatus httpStatus;
	private Boolean status;
	private String result;
	private String message;
	
	public responseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public responseDto(HttpStatus httpStatus, Boolean status, String result, String message) {
		super();
		this.httpStatus = httpStatus;
		this.status = status;
		this.result = result;
		this.message = message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	} 
	

}
