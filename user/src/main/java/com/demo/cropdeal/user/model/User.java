package com.demo.cropdeal.user.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "Details about the user")
public class User {
	
	 @ApiModelProperty(notes = "unique id of user")
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name ="user_id" )
      private Long userId ;
	
	 @ApiModelProperty(notes = "The user's full name")
	  @Column(nullable=false)
      private String userFullName ;
	
	  @Column(nullable=false)
	  @ApiModelProperty(notes = "type of user Farmer/Dealer")
      private String userType ;
	
	  @Column(unique = true)
	  @ApiModelProperty(notes = "unique username of user")
	  private String userName ;
	  
	  @ApiModelProperty(notes = "password of  user")
	  private String password ; 
	  
	  @ApiModelProperty(notes = "mobile number of user")
	  @Column(nullable=false,unique = true)
	  private long mobileNo;
	  
	  @Column(nullable=false,unique = true)
	  @ApiModelProperty(notes = "email id of user")
	  private String emailId;
	
	
	  @ApiModelProperty(notes = "Activeness of user")
	  private  String userStatus ;
	
	@OneToOne(cascade =CascadeType.ALL)
	 @ApiModelProperty(notes = "User's bank account details")
	   Bank bank;
	
	   @OneToOne(cascade =CascadeType.ALL)
	   @ApiModelProperty(notes = "Address of user")
	   Address address;
	   
	   @OneToMany(cascade = CascadeType.ALL)
	   @Column(nullable=true)
	   private List<cropItem> cropItem;

	    public Long getUserId() {
		    return userId;
	    }

	    public void setUserId(Long userId) {
	    	this.userId = userId;
	    }

	    public String getUserFullName() { 
	    	return userFullName;
	    }

	    public void setUserFullName(String userFullName) {
	    	this.userFullName = userFullName;
	    }

	    public String getUserType() {
	    	return userType;
	    }

	    public void setUserType(String userType) {
	    	this.userType = userType;
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

	    public long getMobileNo() {
	    	return mobileNo;
	    }

	    public void setMobileNo(long mobileNo) {
	    	this.mobileNo = mobileNo;
	    }

	    public String getEmailId() {
	    	return emailId;
	    }

	    public void setEmailId(String emailId) {
	    	this.emailId = emailId;
	    }

	    public String getUserStatus() {
	    	return userStatus;
	    }

	    public void setUserStatus(String userStatus) {
	    	this.userStatus = userStatus;
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



		@Override
		public String toString() {
			return "User [userId=" + userId + ", userFullName=" + userFullName + ", userType=" + userType
					+ ", userName=" + userName + ", password=" + password + ", mobileNo=" + mobileNo + ", emailId="
					+ emailId + ", userStatus=" + userStatus + ", bank=" + bank + ", address=" + address + ", crops="
					+ "]";
		}

	

		
	
	

	}
