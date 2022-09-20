
package com.demo.cropdeal.cropitems.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.cropdeal.cropitems.model.Cropitem;
import com.demo.cropdeal.cropitems.service.CropitemService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class CropitemController {

	private CropitemService cropitemService;

	public CropitemController(CropitemService cropitemService) {
		super();
		this.cropitemService = cropitemService;
	}
	
//	@RequestMapping("/userId")
//	public List<User>getCropitemByFarmerId(@PathVariable("userId")String userId){
//		RestTemplate restTemplate=new RestTemplate();
//		String url;
//		restTemplate.getForObject(url:"http://localhost:8082/", User.class);
//	}
	
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
	@GetMapping("/cropitems/{id}")
	public ResponseEntity<Cropitem> getcropItemById(@PathVariable("id") String cropitemId){
		return new ResponseEntity<Cropitem>(cropitemService.getcropItemById(cropitemId),HttpStatus.OK);
	}
	
	// build update cropitem REST API
		// http://localhost:8085/api/cropitems/1
	@PutMapping("/cropitems/{id}")
	public ResponseEntity<Cropitem> updatecropItem(@PathVariable("id") String id
			             ,@RequestBody Cropitem cropitem){
		return new ResponseEntity<Cropitem>(cropitemService.updatecropItem(cropitem,id),HttpStatus.OK);
		
	}
	
	// build delete cropitem REST API
		// http://localhost:8085/api/cropitems/1
	@DeleteMapping("/cropitems/{id}")
	public ResponseEntity<String>deletecropItem(@PathVariable("id")String id){
		// delete cropitem from DB
		cropitemService.deletecropItem(id);
		return new ResponseEntity<String>("crop deleted successfully!",HttpStatus.OK);
	}
	
//	GET LIST OF CROP ITEMS - BASED ON LIST OF OBJECT IDS
	
}
