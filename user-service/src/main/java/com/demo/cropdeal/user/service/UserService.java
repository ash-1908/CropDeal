package com.demo.cropdeal.user.service;

import com.demo.cropdeal.user.dto.UserDto;
import com.demo.cropdeal.user.model.Address;
import com.demo.cropdeal.user.model.Bank;
import com.demo.cropdeal.user.model.User;
import com.demo.cropdeal.user.repository.BankRepository;
import com.demo.cropdeal.user.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService implements IUserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BankRepository bankRepository;
	
	@Autowired
	EmailSenderService emailSenderService;
	
	
	@Override
	public String addUser(UserDto userDto) {
		
		String s1 = " ";
		
		var user = userDto.getUserFromUserDto(userDto);
		
		boolean usernameAbsent = userRepository.getByUserName(user.getUserName()) == null;
		boolean MobileNoAbsent = userRepository.getByPhoneNumber(user.getPhoneNumber()) == null;
		boolean EmaiLIdAbsent = userRepository.getByEmail(user.getEmail()) == null;
		boolean AccountNoAbsent = bankRepository.getByAccountNo(user.getBank().getAccountNo()) == null;
		
		if (usernameAbsent && MobileNoAbsent && EmaiLIdAbsent && AccountNoAbsent) {
			String userRole = user.getRoles().split("_")[1];
			// first save the address object
			// after this try calling getId method, if it returns null then do this:
			// address = addressRepository.save(address); -> now you can get the id
			// here you will first save address object and bank object, then you will get the id of that object
			// set the id of bank and address in user object
			userRepository.save(user);
			emailSenderService.sendEmail(user.getEmail(),
				user.getFullName() + " you are registered successfully..as " + userRole, "Registration Status");
			
			System.out.println(user.getId());
			return "user Added";
			
			
		} else {
			if (usernameAbsent == false) {
				s1 = s1 + "  *username already taken*";
			}
			
			if (MobileNoAbsent == false) {
				s1 = s1 + "  *mobile number already exists*";
			}
			
			if (EmaiLIdAbsent == false) {
				s1 = s1 + "  *email already taken*";
			}
			if (AccountNoAbsent == false) {
				s1 = s1 + "  *account number already exists*";
			}
			
			
		}
		return s1;
		
		
	}
	
	@Override
	public String deleteUser(String userId) {
		
		/*
		 * fetch user from db
		 * check if user is not null
		 *     - if not null then delete the user
		 *           cross check by fetching same user from db and comparing with null
		 *           return msg "user deleted successfully"
		 *     - else return msg "invalid id user not present"
		 */
		var user = userRepository.getById(userId);
		if (user != null) {
			userRepository.deleteById(userId);
			
			return "user deleted successfully";
			
		}
		return "invalid id user not present";
	}
	
	@Override
	public User getUser(String userId) {
		
		/*
		 * if user data is present in database then return user
		 *
		 * For this fetch user using the given id
		 * check if user is not null
		 *   -if not null then return user data
		 *
		 */
		
		var user = userRepository.getById(userId);
		if (user != null) {
			return user;
		}
		
		return null;
	}
	
	
	public User getUserByEmail(String email) {
		
		/*
		 * if user data is present in database then return user
		 *
		 * For this fetch user using the given email id
		 * check if user is not null
		 *   -if not null then return user data
		 *
		 */
		
		var user = userRepository.getByEmail(email);
		if (user != null) {
			return user;
		}
		
		return null;
	}
	
	
	public User getUserByUsername(String username) {
		
		
		var user = userRepository.getByUserName(username);
		if (user != null) {
			return user;
		}
		
		return null;
	}
	
	
	public List<User> getAllUsers() {
		List<User> users = userRepository.findAll();
		if (users != null) {
			return users;
		} else {
			return new ArrayList<>();
		}
		
	}
	
	public String markUserStatus(String userId, Boolean status) {
		User user = userRepository.getById(userId);
		if (user != null) {
			user.setActive(status);
			userRepository.save(user);
			if (userRepository.getById(userId).getActive().equals(status)) {
				return "updated user status as " + (user.getActive() ? "active" : "in-active");
			} else {
				return "user not updated";
			}
		} else {
			return "invalid user id";
		}
		
		
	}
	
	
	@Override
	public User updateUser(String userId, User user) {
		
		//fetch user from database using given id
		var user1 = userRepository.getById(userId);
		
        /*
         
          check if requested  user data is not null
          check all the fields with null value and update that user fetched from database 
          with given details that are not null
           
       */
		
		if (user != null) {
			if (user.getEmail() != null && user.getEmail().isBlank() == false) {
				user1.setEmail(user.getEmail());
			}
			if (user.getPhoneNumber()  != null && user.getPhoneNumber().isBlank() == false) {
				user1.setPhoneNumber(user.getPhoneNumber());
			}
			if (user.getPassword() != null) {
				user1.setPassword(user.getPassword());
			}
			if (user.getFullName().length() != 0) {
				user1.setFullName(user.getFullName());
			}
			user1.setActive(user.getActive());
			
		/*
		 * 
		 if(user.getUserStatus()!=null ) {
			user1.setUserStatus(user.getUserStatus());
		}
		
		*/
			
			var bank1 = updateBank(user, user1);
			
			var address1 = updateAddress(user, user1);
			
			user1.setBank(bank1);
			user1.setAddress(address1);
			
			userRepository.save(user1);
			return user1;
		}
		
		
		return user1;
		
	}
	
	public Bank updateBank(User user, User user1) {
		var bank1 = user1.getBank();
		if (user.getBank() != null) {
			
			if (user.getBank().getAccountHolderName() != null && user.getBank().getAccountHolderName().isBlank() == false) {
				bank1.setAccountHolderName(user.getBank().getAccountHolderName());
			}
			
			if (user.getBank().getAccountNo() != null && user.getBank().getAccountNo() != 0) {
				bank1.setAccountNo(user.getBank().getAccountNo());
			}
			
			if (user.getBank().getBankBranch() != null && user.getBank().getBankBranch().isBlank() == false) {
				bank1.setBankBranch(user.getBank().getBankBranch());
			}
			
			
			if (user.getBank().getBankIFSC() != null && user.getBank().getBankIFSC().isBlank() == false) {
				bank1.setBankIFSC(user.getBank().getBankIFSC());
			}
			
			if (user.getBank().getBankName() != null && user.getBank().getBankName().isBlank() == false) {
				bank1.setBankName(user.getBank().getBankName());
			}
			
			
		} else {
			bank1 = user1.getBank();
		}
		
		return bank1;
	}
	
	public Address updateAddress(User user, User user1) {
		
		var address1 = user1.getAddress();
		if (user.getAddress() != null) {
			
			if (user.getAddress().getCity() != null && user.getAddress().getCity().isBlank() == false) {
				address1.setCity(user.getAddress().getCity());
			}
			
			if (user.getAddress().getCountry() != null && user.getAddress().getCountry().isBlank() == false) {
				address1.setCountry(user.getAddress().getCountry());
			}
			
			
			if (user.getAddress().getHouseNo() != null && user.getAddress().getHouseNo().isBlank() == false) {
				address1.setHouseNo(user.getAddress().getHouseNo());
			}
			
			
			if (user.getAddress().getLocalityName() != null && user.getAddress().getLocalityName().isBlank() == false) {
				address1.setLocalityName(user.getAddress().getLocalityName());
			}
			
			if (user.getAddress().getPincode() != 0) {
				address1.setPincode(user.getAddress().getPincode());
			}
			
			
			if (user.getAddress().getState() != null && user.getAddress().getState().isBlank() == false) {
				address1.setState(user.getAddress().getState());
				
			}
			
			if (user.getAddress().getStreetName() != null && user.getAddress().getStreetName().isBlank() == false) {
				address1.setStreetName(user.getAddress().getStreetName());
			}
			
		} else {
			address1 = user1.getAddress();
		}
		return address1;
		
	}
	
	
}
