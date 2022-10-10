package com.demo.cropdeal.cropitems.service;

import java.util.List;

import com.demo.cropdeal.cropitems.model.Cropitem;
import org.bson.types.ObjectId;

public interface CropitemService {
	//Defined the methods which is implemented in cropItemServiceImpl
	Cropitem savecropItem(Cropitem cropitem);
	List<Cropitem> getAllcropItems();
	Cropitem getcropItemById(String id);
	Cropitem updatecropItem(Cropitem cropitem,String id);
	void deletecropItem(String id);
	List<Cropitem> findByIdInList(List<String> idList);
	
}