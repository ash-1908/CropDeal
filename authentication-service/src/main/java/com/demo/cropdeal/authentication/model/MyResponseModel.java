package com.demo.cropdeal.authentication.model;

import org.bson.types.ObjectId;

public class MyResponseModel {
	
	private String jwt;
	private String id;
	private String name;
	private String role;
	
	private String email;
	
	private String phone;
	
	public MyResponseModel(){}
	
	public MyResponseModel(String jwt) {
		this.jwt = jwt;
	}
	public MyResponseModel( String id, String name, String role) {
		
		this.id = id;
		this.name = name;
		this.role = role;
	}
	public MyResponseModel(String jwt, String id, String name, String role) {
		this.jwt = jwt;
		this.id = id;
		this.name = name;
		this.role = role;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getJwt() {
		return jwt;
	}
	
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
}
