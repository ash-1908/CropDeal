package com.demo.cropdeal.user.repository;

import com.demo.cropdeal.user.model.Address;
import com.demo.cropdeal.user.model.Bank;
import com.demo.cropdeal.user.model.User;
import com.demo.cropdeal.user.service.GetUserTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = {UserRepositoryTestCase.class})
class UserRepositoryTestCase {
	
	@Mock
	private UserRepository userRepository;
	
	GetUserTest getUser;
	
	List<User> list = new ArrayList<>();
	
	@Test
	void userRepositoryTest() {
		var user = new User();
		user.setUserName("Harry123");
		user.setRoles("ROLE_DEALER");
		user.setFullName("Harry potter");
		user.setEmail("harry@gmail.com");
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
		when(userRepository.save(user)).thenReturn(list.get(0));
		User result = userRepository.save(user);
		
		assertEquals((long) 111, result.getId());
		
	}
	
}
