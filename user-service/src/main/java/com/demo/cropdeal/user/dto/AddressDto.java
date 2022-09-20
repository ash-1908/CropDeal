package com.demo.cropdeal.user.dto;

import com.demo.cropdeal.user.model.Address;
import org.bson.types.ObjectId;

import javax.persistence.Id;

public class AddressDto {
	
	@Id
	private String id;
	
	private String houseNo;
	
	private String streetName;
	
	private String localityName;
	
	private int pincode;
	
	private String city;
	
	private String state;
	
	private String country;
	
	public AddressDto() {
	}
	
	public AddressDto(String houseNo, String streetName, String localityName, int pincode, String city, String state,
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
	
	public Address getAddressFromAddressDto(AddressDto addressdto) {
		var address1 =new Address();
		address1.setCity(addressdto.getCity());
		address1.setCountry(addressdto.getCountry());
		address1.setHouseNo(addressdto.getHouseNo());
		address1.setId(addressdto.getId());
		address1.setLocalityName(addressdto.getLocalityName());
		address1.setPincode(addressdto.getPincode());
		address1.setState(addressdto.getState());
		address1.setStreetName(addressdto.getStreetName());
		return address1;
	}

}
