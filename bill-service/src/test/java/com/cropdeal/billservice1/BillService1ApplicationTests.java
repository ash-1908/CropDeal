package com.cropdeal.billservice1;

//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cropdeal.billservice1.entity.Bill;
import com.cropdeal.billservice1.repository.BillRepository;
import com.cropdeal.billservice1.service.BillService;


@SpringBootTest
class BillService1ApplicationTests {
	@Autowired
	private BillService billService;
	@Autowired
	private BillRepository billRepository;


	@Test
	@DisplayName("AddBill")
	void addBill() {
		Bill b=new Bill();
		b.setBillid(1);
		b.setDealername("abc");
		b.setDealerusername("c");
		b.setFarmername("aaa");
		b.setFarmerusername("r");
		b.setCropqnt(2);
		b.setCropprice(80);
		b.setTotalprice(160);
		b.setBilldate("7");
		billRepository.save(b);
		
	}
	@Test
	@DisplayName("GetAllBill")
	void getAllBill() {
		List<Bill> list=billRepository.findAll();
		assertNotNull(list);
//}
	//@Test
	//@DisplayName("GetUser")
	//void getBill() {
	//	Bill b=billRepository.findById(1).getBillid();
		//assertAll(
			//	()->assertEquals(1,b.getBillid()),
			//	()->assertEquals("Aditi@gmail.com",b.getDealername()),
				//()->assertEquals("abc",b.getDealerusername()),
			//	()->assertEquals("bbb",b.getFarmername()),
				//()->assertEquals("h",b.getFarmerusername()),
				//()->assertEquals(10,b.getCropqnt()),
				//()->assertEquals(80,b.getCropprice()),
				//()->assertEquals(800,b.getTotalprice()),
				//()->assertEquals(4,b.getBilldate())
				
				
		//);

	}

}
	
