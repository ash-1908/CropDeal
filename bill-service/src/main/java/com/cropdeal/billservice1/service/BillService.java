package com.cropdeal.billservice1.service;

import com.cropdeal.billservice1.entity.Bill;
import com.cropdeal.billservice1.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {
	
	@Autowired
	private BillRepository repository;
	@Autowired
	private EmailSenderService senderService;
	
	public Bill saveBill(Bill bill) {
		senderService.sendSimpleEmail("muratdeniz0005@gmail.com", "Thanks for purchasing item...!", "Cropdeal-Bill");
		return repository.save(bill);
	}
	
	public List<Bill> getAllBills() {
		return repository.findAll();
	}
	
	public Bill getBillById(int billid) {
		return repository.findById(billid);
	}
}