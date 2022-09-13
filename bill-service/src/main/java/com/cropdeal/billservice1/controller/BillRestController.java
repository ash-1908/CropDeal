package com.cropdeal.billservice1.controller;

import com.cropdeal.billservice1.entity.Bill;
import com.cropdeal.billservice1.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bill")
public class BillRestController {
	
	@Autowired
	private BillService service;
	
	@PostMapping("/add")
	public Bill addBill(@RequestBody Bill bill) {
		
		return service.saveBill(bill);
	}
	
	@GetMapping("/all")
	public List<Bill> findAllBills() {
		return service.getAllBills();
	}
	
	@GetMapping("/{billid}")
	public Bill findBillById(@PathVariable int billid) {
		return service.getBillById(billid);
	}
}

