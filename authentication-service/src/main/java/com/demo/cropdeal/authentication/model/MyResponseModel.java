package com.demo.cropdeal.authentication.model;

public class MyResponseModel {
	
	private String jwt;
	
	public MyResponseModel(String jwt) {
		this.jwt = jwt;
	}
	
	public String getJwt() {
		return jwt;
	}
	
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
}
