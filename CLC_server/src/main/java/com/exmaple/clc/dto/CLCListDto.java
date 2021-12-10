package com.exmaple.clc.dto;

import java.security.Timestamp;

public class CLCListDto {

	private String moive_id;
	private String id;
	private String password;
	private String subject;
	private String rating;
	private String content;
	private String register_date;
	
	public CLCListDto() {}
	
	public CLCListDto(String moive_id, String id, String password, String subject, String rating, String content, String register_date) {
		
		this.moive_id = moive_id;
		this.id = id;
		this.password = password;
		this.subject = subject;
		this.rating = rating;
		this.content = content;
		this.register_date = register_date;
		
	}

	
	public String getMoive_id() {
		return moive_id;
	}

	public void setMoive_id(String moive_id) {
		this.moive_id = moive_id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegister_date() {
		return register_date;
	}

	public void setRegister_date(String register_date) {
		this.register_date = register_date;
	}
	
}
