package com.demo.cropdeal.authentication.dao;

import com.demo.cropdeal.authentication.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Integer> {
	
	//	returns an entry from account database with particular email
	Optional<Account> findByEmail(String userName);
	
	Optional<Account> findByResetCode(String resetCode);
	
}
