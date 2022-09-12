package com.cropdeal.billservice1.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user1_tbl")
public class Bill {

	@Id
	@GeneratedValue
	private int billid;
	private String farmername;
	private String farmerusername;
	private String dealername;
	private String dealerusername;
	private int cropqnt;
	private double cropprice;
	private double totalprice;
	private String billdate;
	private String payment;
	
}
