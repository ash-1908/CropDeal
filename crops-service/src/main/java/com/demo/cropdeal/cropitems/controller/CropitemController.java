
package com.demo.cropdeal.cropitems.controller;

import java.util.List;

import com.demo.cropdeal.cropitems.model.MyRequestModel;
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
import com.demo.cropdeal.cropitems.model.User;
import com.demo.cropdeal.cropitems.service.CropitemService;

import javax.ws.rs.core.Response;

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
//		String url="http://localhost:8082/add-crop/{userId}";
//	User users=restTemplate.getForObject(url,User.class,userId);
//	
//	Cropitem cropitem=CropitemRepository.getById(id);
//	cropitem.setCropIds(list);
//	user=userRepository.save(user); 
//	System.out.println(user);
//	return crop;
//	return User;
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
	
	@GetMapping("/cropitems/list")
	public ResponseEntity<List<Cropitem>> findAllCropItemsInList(@RequestBody MyRequestModel req) {
		return new ResponseEntity<>(cropitemService.findByIdInList(req.getIdList()), HttpStatus.OK);
	}
}
