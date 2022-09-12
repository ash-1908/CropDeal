package com.demo.cropdeal.user.service;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.demo.cropdeal.user.model.Address;
import com.demo.cropdeal.user.model.Bank;
import com.demo.cropdeal.user.model.User;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.cropdeal.user.repository.UserRepository;



@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = {DeleteUserTest.class})
class DeleteUserTest {

	@InjectMocks
	private UserService userService;
	
	@Mock
	private UserRepository userRepository;

	List<User> list=new ArrayList<>();
	
	
	
	@Order(4)
	@Test
    void testUsingInvalidIdToDeleteUser() {
	
	assertEquals("invalid id user not present",userService.deleteUser((long) 1));
	
	}
	
	@Test
	@Order(1)
    void testWhenIdIsNull() {
	
	assertEquals("invalid id user not present",userService.deleteUser(null));
	
	}
	
	@Order(2)
	@Test
     void testDatabaseRecordCount() {

		
		when(userRepository.count()).thenReturn((long) list.size());
		assertEquals(0,userRepository.count());
	
	}
	
	@Order(3)
	@Test
     void testUsingValidIdToDeleteUser() {
		var user=new User();
		user.setUserName("Harry123");
		user.setUserType("Dealer");
		user.setUserId((long) 111);
		user.setUserFullName("Harry potter");
		user.setPassword("hp@123");
		user.setMobileNo((long) 979876577);
		var bank =new Bank();
	    bank.setAccountHolderName("Harry potter");
		bank.setAccountNo((long)1324038664);
		bank.setBankBranch("Dublin");
		bank.setBankIFSC("BOA78754485");
		bank.setBankName("Bank of America");
		
		var add=new Address();
	    add.setCity("Boston");
	    add.setCountry("America");
	    add.setState("Georgia");
	    add.setHouseNo("2");
	    add.setLocalityName("Wilson Area");
	    add.setPincode(921034);
	    
	    add.setStreetName("Wilson Street");
		
	    user.setBank(bank);
	    user.setAddress(add);
	    
		list.add(user);
		
		when(userRepository.getByUserId((long)111)).thenReturn(user);
		assertEquals("user deleted successfully",userService.deleteUser((long)111));
		
	
	}	
	
	
	

}
