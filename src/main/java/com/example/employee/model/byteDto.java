package com.example.employee.model;

public class byteDto {
	private String  bs;
	private EmailData data;
	public byteDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public byteDto(String bs, EmailData data) {
		super();
		this.bs = bs;
		this.data = data;
	}
	public String getBs() {
		return bs;
	}
	public void setBs(String bs) {
		this.bs = bs;
	}
	public EmailData getData() {
		return data;
	}
	public void setData(EmailData data) {
		this.data = data;
	}
	
	
}