package com.example.employee.model;

import java.util.List;

public class TemplateResponse {
	
	private List<templateInfo> result;
    private String httpStatus;
    private String message;
    private boolean status;

    public TemplateResponse() {
    	super();
    	// TODO Auto-generated constructor stub
    }

	public TemplateResponse(List<templateInfo> result, String httpStatus, String message, boolean status) {
		super();
		this.result = result;
		this.httpStatus = httpStatus;
		this.message = message;
		this.status = status;
	}

	public List<templateInfo> getResult() {
		return result;
	}

	public void setResult(List<templateInfo> result) {
		this.result = result;
	}

	public String getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
    
    
}
