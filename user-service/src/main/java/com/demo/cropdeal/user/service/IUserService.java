package com.demo.cropdeal.user.service;

import com.demo.cropdeal.user.dto.UserDto;
import com.demo.cropdeal.user.model.User;
import org.bson.types.ObjectId;

public interface IUserService {
	
     String addUser(UserDto userDto);
     String deleteUser(ObjectId userId);
     User getUser(ObjectId userId);
     User updateUser(ObjectId userId,User user);
     
     
}
