package com.demo.cropdeal.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.List;

@ApiModel(description = "Details about the user")
@Document("user")
public class User {
	@ApiModelProperty(notes = "unique id of user")
	@Id
	private ObjectId id;
	@ApiModelProperty(notes = "The user's full name")
	private String fullName;
	
	@ApiModelProperty(notes = "type of user Farmer/Dealer")
	private String roles;
	
	@ApiModelProperty(notes = "unique username of user")
	private String userName;
	
	@ApiModelProperty(notes = "password of  user")
	private String password;
	
	@ApiModelProperty(notes = "mobile number of user")
	private String phoneNumber;
	
	@ApiModelProperty(notes = "email id of user")
	private String email;
	
	
	@ApiModelProperty(notes = "Activeness of user")
	private Boolean active;
	
	@ApiModelProperty(notes = "User's bank account details")
	@DBRef
	Bank bank;
	
	@ApiModelProperty(notes = "Address of user")
	@DBRef
	Address address;
	
	@DBRef
	private List<cropItem> cropItems;
	
	public User() {
	}
	
	public ObjectId getId() {
		return id;
	}
	
	public void setId(ObjectId id) {
		this.id = id;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getRoles() {
		return roles;
	}
	
	public void setRoles(String roles) {
		this.roles = roles;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Boolean getActive() {
		return active;
	}
	
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	public Bank getBank() {
		return bank;
	}
	
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public List<cropItem> getCropItems() {
		return cropItems;
	}
	
	public void setCropItems(List<cropItem> cropItems) {
		this.cropItems = cropItems;
	}
}
