package com.demo.cropdeal.user.model;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document("crops")
public class CropItem {
	
	@Id
	private String id;
	
	private String name;
	
	private String type;
	
	private String qnt;
	
	private String price;
	
	public CropItem() {
	}
	
	public CropItem(String name, String type, String qnt, String price) {
		this.name = name;
		this.type = type;
		this.qnt = qnt;
		this.price = price;
	}
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "CropItem [id=" + id + ", name=" + name + ", type=" + type + ", qnt=" + qnt + ", price=" + price + "]";
	}
	
	
}

