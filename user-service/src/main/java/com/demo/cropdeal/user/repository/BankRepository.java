package com.demo.cropdeal.user.repository;

import com.demo.cropdeal.user.model.Bank;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BankRepository extends MongoRepository<Bank, String> {

	Bank getByAccountNo(Long accountNo);
	Bank deleteByAccountNo(Long accountNo);

}
