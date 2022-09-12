package com.demo.cropdeal.authentication.model;

public class MyRequestModel {
	protected String email;
	protected String password;
	protected String fullName;
	protected Boolean active;
	protected String roles;
	protected String phoneNumber;
	protected String resetCode;
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public Boolean getActive() {
		return active;
	}
	
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	public String getRoles() {
		return roles;
	}
	
	public void setRoles(String roles) {
		this.roles = roles;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getResetCode() {
		return resetCode;
	}
	
	public void setResetCode(String resetCode) {
		this.resetCode = resetCode;
	}
	
	//	util methods to validate
	public Boolean signUpValidation() {
		// returns true if object is valid
		return (email != null && !email.isBlank()) && (password != null && !password.isBlank()) &&
			(fullName != null && !fullName.isBlank()) && (active != null && active) && (roles != null && !roles.isBlank());
	}
	
	public Boolean signInValidation() {
		// returns true if object is valid
		return (email != null && !email.isBlank()) && (password!= null && !password.isBlank());
	}
	
	public Boolean resetPasswordValidation() {
		// returns true if object is valid
		return !password.isBlank();
	}
	
}
