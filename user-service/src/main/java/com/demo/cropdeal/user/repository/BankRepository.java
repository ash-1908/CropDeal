package com.demo.cropdeal.user.repository;

import org.bson.types.ObjectId;
import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.cropdeal.user.model.Bank;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BankRepository extends MongoRepository<Bank, String> {

	Bank getByAccountNo(Long accountNo);

}
