package com.cropdeal.billservice1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cropdeal.billservice1.entity.Bill;
import com.cropdeal.billservice1.service.BillService;

@RestController
@RequestMapping("/bills1")
public class BillRestController {

        @Autowired
        private  BillService service;
       @PostMapping("/add")
        public Bill addBill(@RequestBody Bill bill) {
        		
       return service.saveBill(bill) ;
        }	
        
        
        @GetMapping("/all")
        public List<Bill> findAllBills() {
            return service.getAllBills() ;
    }
        @GetMapping("/{billid}")
        public Bill findBillById(@PathVariable int billid) {
            return service.getBillById(billid) ;
}
}
      /*  @PostMapping("/add") 
        public ResponseEntity<Bill> addBill(@RequestBody Bill bill){
        	return new ResponseEntity<>(service.saveBill(bill),HttpStatus.CREATED);
        }
        @GetMapping("/all")
        public ResponseEntity<List<Bill>>findAllBills() {
            return ResponseEntity.ok(service.getAllBills());
        }
        @GetMapping("/{billid}")
        public ResponseEntity<Bill> findBillById(@PathVariable int billid) {
            return ResponseEntity.ok(service.getBillById(billid));
}*/
