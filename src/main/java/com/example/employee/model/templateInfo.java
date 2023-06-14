package com.example.employee.model;

public class templateInfo {
	
    private int id;
    private String templateName;
	public templateInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public templateInfo(int id, String templateName) {
		super();
		this.id = id;
		this.templateName = templateName;
	}
	
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}   

	
}
