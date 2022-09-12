package com.demo.cropdeal.cropitems.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.cropdeal.cropitems.model.Cropitem;
import com.demo.cropdeal.cropitems.service.CropitemService;


@RestController
@RequestMapping("/api/v1")
public class CropitemController {

	private CropitemService cropitemService;

	public CropitemController(CropitemService cropitemService) {
		super();
		this.cropitemService = cropitemService;
	}
	
	// build create cropitem REST API
	@PostMapping("/cropitems/")
	public ResponseEntity<Cropitem> savecropItem(@RequestBody Cropitem cropitem){
	return new ResponseEntity<Cropitem>(cropitemService.savecropItem(cropitem),HttpStatus.CREATED);	
	}
	
	// build get all cropitems REST API
	@GetMapping("/cropitems/")
	public List<Cropitem> getAllcropItems(){
		return cropitemService.getAllcropItems();
	}
	
	// build get cropitem by id REST API
		// http://localhost:8085/api/cropitems/1
	@GetMapping("/cropitems/{cropid}")
	public ResponseEntity<Cropitem> getcropItemById(@PathVariable("cropid")long cropitemId){
		return new ResponseEntity<Cropitem>(cropitemService.getcropItemById(cropitemId),HttpStatus.OK);
	}
	
	// build update cropitem REST API
		// http://localhost:8085/api/cropitems/1
	@PutMapping("/cropitems/{cropid}")
	public ResponseEntity<Cropitem> updatecropItem(@PathVariable("cropid") long cropid
			             ,@RequestBody Cropitem cropitem){
		return new ResponseEntity<Cropitem>(cropitemService.updatecropItem(cropitem,cropid),HttpStatus.OK);
		
	}
	
	// build delete cropitem REST API
		// http://localhost:8085/api/cropitems/1
	@DeleteMapping("/cropitems/{cropid}")
	public ResponseEntity<String>deletecropItem(@PathVariable("cropid")long cropid){
		// delete cropitem from DB
		cropitemService.deletecropItem(cropid);
		return new ResponseEntity<String>("crop deleted successfully!",HttpStatus.OK);
	}
}
