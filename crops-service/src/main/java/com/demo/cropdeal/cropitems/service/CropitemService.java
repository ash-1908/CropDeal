package com.demo.cropdeal.cropitems.service;

import java.util.List;

import com.demo.cropdeal.cropitems.model.Cropitem;
import org.bson.types.ObjectId;


//import com.cg.cropdeal.cropitem.model.TestcropItem;

public interface CropitemService {
	//Defined the methods which is implemented in cropItemServiceImpl
	Cropitem savecropItem(Cropitem cropitem);
	List<Cropitem> getAllcropItems();
	Cropitem getcropItemById(ObjectId cropid);
	Cropitem updatecropItem(Cropitem cropitem,ObjectId cropid);
	void deletecropItem(ObjectId cropid);
	
}