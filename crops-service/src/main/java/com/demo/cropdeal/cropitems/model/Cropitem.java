package com.demo.cropdeal.cropitems.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="crop")
public class Cropitem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cropid;
	
	@Column(name = "crop_name", nullable = false)
	private String cropname;
	
	@Column(name = "crop_type")
	private String croptype;
	
	@Column(name = "crop_qnt")
	private String cropqnt;
	
	@Column(name = "crop_price")
	private String cropprice;
	
	/*public long getId() {
		return cropid;
	}

	public void setId(long cropid) {
		this.cropid = cropid;
	}
*/
	public String getCropname() {
		return cropname;
	}

	public long getCropid() {
		return cropid;
	}

	public void setCropid(long cropid) {
		this.cropid = cropid;
	}

	public void setCropname(String cropname) {
		this.cropname = cropname;
	}

	public String getCroptype() {
		return croptype;
	}

	public void setCroptype(String croptype) {
		this.croptype = croptype;
	}

	public String getCropqnt() {
		return cropqnt;
	}

	public void setCropqnt(String cropqnt) {
		this.cropqnt = cropqnt;
	}

	public String getCropprice() {
		return cropprice;
	}

	public void setCropprice(String cropprice) {
		this.cropprice = cropprice;
	}

	public Cropitem(long cropid, String cropname, String croptype, String cropqnt, String cropprice) {
		super();
		this.cropid = cropid;
		this.cropname = cropname;
		this.croptype = croptype;
		this.cropqnt = cropqnt;
		this.cropprice = cropprice;
	}
	
	public Cropitem() {
		
	}
}
