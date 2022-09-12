package com.cropdeal.billservice1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cropdeal.billservice1.entity.Bill;

public interface BillRepository extends JpaRepository<Bill,Integer>{

Bill findById(int billid);
}
