package com.demo.cropdeal.user.dto;

import com.demo.cropdeal.user.model.User;
import com.demo.cropdeal.user.model.CropItem;
import io.swagger.annotations.ApiModelProperty;
import org.bson.types.ObjectId;

import java.util.List;

public class UserDto {
	
	@ApiModelProperty(notes = "unique id of user")
	private String id;
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
	BankDto bank;
	
	@ApiModelProperty(notes = "Address of user")
	AddressDto address;
	
	private List<CropItem> cropItems;
	
	public UserDto() {
	}
	
	public User getUserFromUserDto(UserDto userDto) {
		var user = new User();
		
		user.setAddress(userDto.address.getAddressFromAddressDto(userDto.getAddress()));
		user.setBank(userDto.bank.getBankFromBankDto(userDto.getBank()));
		user.setEmail(userDto.getEmail());
		user.setPhoneNumber(userDto.getPhoneNumber());
		user.setPassword(userDto.getPassword());
		user.setFullName(userDto.getFullName());
		user.setId(userDto.getId());
		user.setUserName(userDto.getUserName());
		user.setActive(userDto.getActive());
		user.setRoles(userDto.getRoles());
		return user;
		
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
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
	
	public BankDto getBank() {
		return bank;
	}
	
	public void setBank(BankDto bank) {
		this.bank = bank;
	}
	
	public AddressDto getAddress() {
		return address;
	}
	
	public void setAddress(AddressDto address) {
		this.address = address;
	}
	
	public List<CropItem> getCropItems() {
		return cropItems;
	}
	
	public void setCropItems(List<CropItem> cropItems) {
		this.cropItems = cropItems;
	}
	
}



