package com.demo.cropdeal.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Address {
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false,unique=true,name="address_id"
	)
	private Long id ;
	
	@Column(nullable=false)
    private String	houseNo ;
	
	@Column(nullable=false)
    private String streetName ;
	
	@Column(nullable=false)
    private String localityName ;
	
	@Column(nullable=false)
    private int pincode ;
	
	@Column(nullable=false)
	private String	city ;
	
	@Column(nullable=false)
    private String state ;
	
	@Column(nullable=false)
	private String country ;
	

	public Long getId() {
		return id;
	}

	public void setId(Long uid) {
		id = uid;
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
