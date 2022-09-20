package com.demo.cropdeal.authentication.model;

import org.bson.types.ObjectId;

public class MyResponseModel {
	
	private String jwt;
	private ObjectId id;
	private String name;
	private String role;
	
	public MyResponseModel(){}
	
	public MyResponseModel(String jwt) {
		this.jwt = jwt;
	}
	public MyResponseModel( ObjectId id, String name, String role) {
		
		this.id = id;
		this.name = name;
		this.role = role;
	}
	public MyResponseModel(String jwt, ObjectId id, String name, String role) {
		this.jwt = jwt;
		this.id = id;
		this.name = name;
		this.role = role;
	}
	
	
	public String getJwt() {
		return jwt;
	}
	
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	
	public ObjectId getId() {
		return id;
	}
	
	public void setId(ObjectId id) {
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
