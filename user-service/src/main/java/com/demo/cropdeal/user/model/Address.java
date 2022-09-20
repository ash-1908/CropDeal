package com.demo.cropdeal.user.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document("address")
public class Address {
	
	@Id
	private String id;
	
	private String houseNo;
	
	private String streetName;
	
	private String localityName;
	
	private int pincode;
	
	private String city;
	
	private String state;
	
	private String country;
	
	public Address() {
	}
	
	public Address(String houseNo, String streetName, String localityName, int pincode, String city, String state,
	               String country) {
		this.houseNo = houseNo;
		this.streetName = streetName;
		this.localityName = localityName;
		this.pincode = pincode;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getHouseNo() {
		return houseNo;
	}
	
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	
	public String getStreetName() {
		return streetName;
	}
	
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	
	public String getLocalityName() {
		return localityName;
	}
	
	public void setLocalityName(String localityName) {
		this.localityName = localityName;
	}
	
	public int getPincode() {
		return pincode;
	}
	
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		return "Address [Id=" + id + ", houseNo=" + houseNo + ", streetName=" + streetName + ", localityName="
			+ localityName + ", pincode=" + pincode + ", city=" + city + ", state=" + state + ", country=" + country
			+ "]";
	}
	
	
}
