package com.demo.cropdeal.user.repository;

import com.demo.cropdeal.user.model.Address;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address, String> {
	
	
}
