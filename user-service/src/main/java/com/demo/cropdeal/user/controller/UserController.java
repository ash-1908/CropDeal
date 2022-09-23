package com.demo.cropdeal.user.controller;

import com.demo.cropdeal.user.dto.UserDto;
import com.demo.cropdeal.user.model.CropItem;
import com.demo.cropdeal.user.model.User;
import com.demo.cropdeal.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/add-user")
	@ApiOperation(value = "Add user details",
		notes = "enter all the required and valid user details to add the user in database", response = String.class)
	public ResponseEntity<String> addUser(@RequestBody UserDto userDto) {
		
		return new ResponseEntity<>(userService.addUser(userDto), HttpStatus.OK);
	}
	
	
	@GetMapping("/get-user/{userId}")
	public ResponseEntity<User> getUser(@PathVariable String userId) {
		
		return new ResponseEntity<>(userService.getUser(userId), HttpStatus.OK);
	}
	
	//get all the users from database
	
	@GetMapping("/get-all-users")
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
	}
	
	@GetMapping("/get-user-by-email/{email}")
	public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
		
		return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.OK);
	}
	
	
	@PutMapping("/add-crop/{userId}/{cropId}")
	public ResponseEntity<Boolean> addCrop(@PathVariable String userId,@PathVariable String cropId){
		
		return new ResponseEntity<Boolean>(userService.addCrops(userId, cropId),HttpStatus.OK);
		
		
	}
	
	
	@GetMapping("/get-cropIds/{userId}")
   public ResponseEntity<List<String>> getUserCropIdList(@PathVariable String userId){
		
		return new ResponseEntity<>(userService.getUserCropIdList(userId),HttpStatus.OK);
		
		
	}
	
	
	@DeleteMapping("/delete-user/{userId}")
	@ApiOperation(value = "Delete user details by id", notes = "enter valid user id to be deleted from the  database",
		response = String.class)
	public ResponseEntity<String> deleteUser(@PathVariable String userId) {
		
		return new ResponseEntity<>(userService.deleteUser(userId), HttpStatus.OK);
		
	}
	
	
	
	@PutMapping("/update-user/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable String userId, @RequestBody User user) {
		
		return new ResponseEntity<>(userService.updateUser(userId, user), HttpStatus.OK);
	}
	
	@PatchMapping("/update-user-status/{userId}")
	public ResponseEntity<String> updateUserStatus(@PathVariable String userId, @RequestBody Boolean status) {
		
		return new ResponseEntity<String>(userService.markUserStatus(userId, status), HttpStatus.OK);
	}
	
//	GET CROPITEM LIST - GET USER ID FROM PARAMS
//	add a cropitem to user crop items list - id from param
}
