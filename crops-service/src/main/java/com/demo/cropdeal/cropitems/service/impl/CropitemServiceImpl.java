package com.demo.cropdeal.cropitems.service.impl;

import com.demo.cropdeal.cropitems.exception.ResourceNotFoundException;
import com.demo.cropdeal.cropitems.model.Cropitem;
import com.demo.cropdeal.cropitems.repository.CropitemRepository;
import com.demo.cropdeal.cropitems.service.CropitemService;
import com.demo.cropdeal.cropitems.service.EmailSenderService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CropitemServiceImpl implements CropitemService {
	
	private CropitemRepository cropitemRepository;
	
	@Autowired
	EmailSenderService emailsenderService;
	
	public CropitemServiceImpl(CropitemRepository cropitemRepository) {
		super();
		this.cropitemRepository = cropitemRepository;
	}
	
	@Override
	public Cropitem savecropItem(Cropitem cropitem) {
		emailsenderService.sendSimpleEmail("divyathorat2255@gmail.com",
			cropitem.getName() + "     " + cropitem.getType() + "     " + cropitem.getQnt() + "     " +
				cropitem.getPrice(), "This is the new crop added in the list please check......");
		return cropitemRepository.save(cropitem);
	}
	
	@Override
	public List<Cropitem> getAllcropItems() {
		return cropitemRepository.findAll();
	}
	
	@Override
	public Cropitem getcropItemById(ObjectId cropid) {
	/*	Optional<cropItem> cropitem=cropitemRepository.findById(cropid);
		
		if(cropitem.isPresent()) {
			return cropitem.get();
		}else {
			throw new ResourceNotFoundException("cropItem","cropId",cropid);
		}*/
		
		return cropitemRepository.findById(cropid).orElseThrow(() ->
			new ResourceNotFoundException("cropItem", "cropId", cropid));
	}
	
	@Override
	public Cropitem updatecropItem(Cropitem cropitem, ObjectId cropid) {
		// we need to check whether cropitem with given id is exist in DB or not
		Cropitem existingcropItem = cropitemRepository.findById(cropid).orElseThrow(
			() -> new ResourceNotFoundException("cropItem", "cropId", cropid));
		
		existingcropItem.setName(cropitem.getName());
		existingcropItem.setType(cropitem.getType());
		existingcropItem.setQnt(cropitem.getQnt());
		existingcropItem.setPrice(cropitem.getPrice());
		
		cropitemRepository.save(existingcropItem);
		return existingcropItem;
	}
	
	@Override
	public void deletecropItem(ObjectId cropid) {
		// check whether a cropitem exist in a DB or not
		cropitemRepository.findById(cropid).orElseThrow(() ->
			new ResourceNotFoundException("cropItem", "cropId", cropid));
		cropitemRepository.deleteById(cropid);
		
	}
	
}
