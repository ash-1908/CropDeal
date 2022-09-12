package com.cropdeal.billservice1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cropdeal.billservice1.entity.Bill;
import com.cropdeal.billservice1.repository.BillRepository;
import java.util.List;
@Service
public class BillService {
	
@Autowired
private BillRepository repository;
public Bill saveBill(Bill bill) {

	return repository.save(bill);
}

public List<Bill> getAllBills(){
	return repository.findAll();
}
public Bill getBillById(int billid){
	return repository.findById(billid);
}
}