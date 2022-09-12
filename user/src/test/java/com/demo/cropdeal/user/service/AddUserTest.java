package com.demo.cropdeal.user.service;


import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.demo.cropdeal.user.dto.AddressDto;
import com.demo.cropdeal.user.dto.BankDto;
import com.demo.cropdeal.user.dto.UserDto;
import com.demo.cropdeal.user.model.User;
import com.demo.cropdeal.user.repository.BankRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.cropdeal.user.repository.UserRepository;


@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = {AddUserTest.class})
 class AddUserTest {
	
	UserDto userDto;
	
	@InjectMocks
	private UserService userService;
	
	@Mock
	private UserRepository userRepository;
	
	@Mock
	BankRepository bankRepository;
	
	@Mock
	EmailSenderService emailSenderService;

	List<UserDto> list=new ArrayList<>();

	UserDto createUser() {
		var user=new UserDto();
		user.setUserId((long)111);
		user.setUserName("Harry123");
		user.setUserType("Dealer");
		user.setUserId((long) 111);
		user.setUserFullName("Harry potter");
		user.setEmailId("harry@gmail.com");
		user.setPassword("hp@123");
		user.setMobileNo((long) 979876577);
		var bank =new BankDto();
	    bank.setAccountHolderName("Harry potter");
		bank.setAccountNo((long)1324038664);
		bank.setBankBranch("Dublin");
		bank.setBankIFSC("BOA78754485");
		bank.setBankName("Bank of America");
		var add=new AddressDto();
	    add.setCity("Boston");
	    add.setCountry("America");
	    add.setState("Georgia");
	    add.setHouseNo("2");
	    add.setLocalityName("Wilson Area");
	    add.setPincode(921034);
	    
	    add.setStreetName("Wilson Street");
		
	    user.setBank(bank);
	    user.setAddress(add);
		return user;
	}
	
	@Test
	void testAddingUserGivesAppropriateStringOutput() {
		
		UserDto user=createUser();
	    
		list.add(user);
		
		when(userRepository.getByUserName(user.getUserName())).thenReturn(null);
		when(userRepository.getByMobileNo(user.getMobileNo())).thenReturn(null);
		when(userRepository.getByEmailId(user.getEmailId())).thenReturn(null);
		when(bankRepository.getByAccountNo(user.getBank().getAccountNo())).thenReturn(null);
		
		when(userRepository.save(Mockito.any(User.class))).thenReturn(user.getUserFromUserDto(user));
		String actualResult=userService.addUser(user);
		String expectedResult="user Added";
		assertEquals(expectedResult,actualResult);
	
	}
	
	@Test
	void testAddUserWhenUserWithMobileNoIsAlreadyPresent() {
		
		UserDto user=createUser();
		User u1=user.getUserFromUserDto(user);
		list.add(user);
		
		when(userRepository.getByUserName(user.getUserName())).thenReturn(null);
		when(userRepository.getByMobileNo(user.getMobileNo())).thenReturn(u1);
		when(userRepository.getByEmailId(user.getEmailId())).thenReturn(null);
		when(bankRepository.getByAccountNo(user.getBank().getAccountNo())).thenReturn(null);

		String actualResult=userService.addUser(user);
		String expectedResult="   *mobile number already exists*";
		assertEquals(expectedResult,actualResult);
		
		
	}
	
	@Test
	void testRepositorySaveMethod() {
		
		UserDto user=createUser();
		when(userRepository.save(Mockito.any(User.class))).thenReturn(user.getUserFromUserDto(user));
		assertEquals("hp@123",userRepository.save(user.getUserFromUserDto(user)).getPassword());
		assertEquals("Harry123",userRepository.save(user.getUserFromUserDto(user)).getUserName());
		assertEquals("harry@gmail.com",userRepository.save(user.getUserFromUserDto(user)).getEmailId());
		assertEquals("Harry potter",userRepository.save(user.getUserFromUserDto(user)).getUserFullName());
		
		assertEquals("Dealer",userRepository.save(user.getUserFromUserDto(user)).getUserType());
		assertEquals("Bank of America",userRepository.save(user.getUserFromUserDto(user)).getBank().getBankName());
		assertEquals("BOA78754485",userRepository.save(user.getUserFromUserDto(user)).getBank().getBankIFSC());
		assertEquals("Wilson Street",userRepository.save(user.getUserFromUserDto(user)).getAddress().getStreetName());
		assertEquals("America",userRepository.save(user.getUserFromUserDto(user)).getAddress().getCountry());
		assertEquals("Wilson Area",userRepository.save(user.getUserFromUserDto(user)).getAddress().getLocalityName());
		
		
	}
	
	@Test
	void testUserData() {
		
		
		UserDto user=createUser();
		when(userRepository.save(Mockito.any(User.class))).thenReturn(user.getUserFromUserDto(user));
		assertEquals(111,userRepository.save(user.getUserFromUserDto(user)).getUserId());
	}
	
	
	@Test
	void testcount() {
		UserDto user=createUser();
		assertEquals(0,list.size());
		list.add(user);
		assertEquals(1,list.size());
	}
	

}
