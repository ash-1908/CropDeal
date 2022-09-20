package com.demo.cropdeal.user.service;

import com.demo.cropdeal.user.dto.UserDto;
import com.demo.cropdeal.user.model.User;
import org.bson.types.ObjectId;

public interface IUserService {
	
     String addUser(UserDto userDto);
     String deleteUser(String userId);
     User getUser(String userId);
     User updateUser(String userId,User user);
     
     
}
