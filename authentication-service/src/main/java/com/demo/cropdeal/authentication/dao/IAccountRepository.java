package com.demo.cropdeal.authentication.dao;

import com.demo.cropdeal.authentication.model.Account;
import org.bson.types.ObjectId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAccountRepository extends MongoRepository<Account, ObjectId> {
	
	//	returns an entry from account database with particular email
	Optional<Account> findByEmail(String userName);
	
	Optional<Account> findByResetCode(String resetCode);
	
}
