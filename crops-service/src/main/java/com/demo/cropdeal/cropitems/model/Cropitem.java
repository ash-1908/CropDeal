package com.demo.cropdeal.cropitems.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Document("crops")
public class Cropitem {

	@Id
	private ObjectId id;
	
	private String name;
	
	private String type;
	
	private String qnt;
	
	private String price;
	
	public Cropitem() {
	}
	
	public Cropitem(String name, String type, String qnt, String price) {
		this.name = name;
		this.type = type;
		this.qnt = qnt;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getQnt() {
		return qnt;
	}
	
	public void setQnt(String qnt) {
		this.qnt = qnt;
	}
	
	public String getPrice() {
		return price;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
}
