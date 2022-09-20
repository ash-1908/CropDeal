package com.demo.cropdeal.user.repository;

import com.demo.cropdeal.user.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	User getById(String userId);
    User getByUserName(String username);
	User getByPhoneNumber(String mobileNo);
	User getByEmail(String emailId);
	void deleteById(String userId);
    
	
}
