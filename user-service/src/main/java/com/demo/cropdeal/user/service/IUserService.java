package com.demo.cropdeal.user.service;

import com.demo.cropdeal.user.dto.UserDto;
import com.demo.cropdeal.user.model.User;

public interface IUserService {
	
     String addUser(UserDto userDto);
     String deleteUser(Long userId);
     User getUser(Long userId);
     User updateUser(Long userId,User user);
     
     
}
