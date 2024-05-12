package com.tech.Entities;

public class Record {
	
	private int request_id;
	private String title;
	private String description;
	private String request_by;
	private String request_date;
	private String request_dept;
	private String approval_person;
	private String approval_date;
	private String status;
	public int getRequest_id() {
		return request_id;
	}
	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRequest_by() {
		return request_by;
	}
	public void setRequest_by(String request_by) {
		this.request_by = request_by;
	}
	public String getRequest_date() {
		return request_date;
	}
	public void setRequest_date(String request_date) {
		this.request_date = request_date;
	}
	public String getRequest_dept() {
		return request_dept;
	}
	public void setRequest_dept(String request_dept) {
		this.request_dept = request_dept;
	}
	public String getApproval_person() {
		return approval_person;
	}
	public void setApproval_person(String approval_person) {
		this.approval_person = approval_person;
	}
	public String getApproval_date() {
		return approval_date;
	}
	public void setApproval_date(String approval_date) {
		this.approval_date = approval_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Record( String title, String description, String request_by, String request_date,String request_dept) {
		super();
		this.title = title;
		this.description = description;
		this.request_by = request_by;
		this.request_date = request_date;
		this.request_dept = request_dept;
	}
	public Record() {
		
	}
	
	
}
