package com.demo.cropdeal.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.cropdeal.user.model.Bank;

public interface BankRepository extends JpaRepository<Bank, Long> {

	Bank getByAccountNo(Long accountNo);

}
