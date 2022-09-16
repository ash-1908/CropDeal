package com.demo.cropdeal.user.service;

import com.demo.cropdeal.user.model.Address;
import com.demo.cropdeal.user.model.Bank;
import com.demo.cropdeal.user.model.User;
import com.demo.cropdeal.user.repository.UserRepository;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = {DeleteUserTest.class})
class DeleteUserTest {
	
	@InjectMocks
	private UserService userService;
	
	@Mock
	private UserRepository userRepository;
	
	List<User> list = new ArrayList<>();
	
	
//	@Order(4)
//	@Test
//	void testUsingInvalidIdToDeleteUser() {
//
//		assertEquals("invalid id user not present", userService.deleteUser(user.getId()));
//
//	}
	
	@Test
	@Order(1)
	void testWhenIdIsNull() {
		
		assertEquals("invalid id user not present", userService.deleteUser(null));
		
	}
	
	@Order(2)
	@Test
	void testDatabaseRecordCount() {
		
		
		when(userRepository.count()).thenReturn((long) list.size());
		assertEquals(0, userRepository.count());
		
	}
	
	@Order(3)
	@Test
	void testUsingValidIdToDeleteUser() {
		var user = new User();
		user.setUserName("Harry123");
		user.setRoles("ROLE_DEALER");
		user.setFullName("Harry potter");
		user.setPassword("hp@123");
		user.setPhoneNumber("979876577");
		var bank = new Bank();
		bank.setAccountHolderName("Harry potter");
		bank.setAccountNo((long) 1324038664);
		bank.setBankBranch("Dublin");
		bank.setBankIFSC("BOA78754485");
		bank.setBankName("Bank of America");
		
		var add = new Address();
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
		
		when(userRepository.getById(Mockito.any(ObjectId.class))).thenReturn(user);
		assertEquals("user deleted successfully", userService.deleteUser(user.getId()));
		
		
	}
	
	
}
