package com.demo.cropdeal.user.service;

import com.demo.cropdeal.user.dto.UserDto;
import com.demo.cropdeal.user.model.Address;
import com.demo.cropdeal.user.model.Bank;
import com.demo.cropdeal.user.model.CropItem;
import com.demo.cropdeal.user.model.User;
import com.demo.cropdeal.user.repository.AddressRepository;
import com.demo.cropdeal.user.repository.BankRepository;
import com.demo.cropdeal.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;



@Service
public class UserService implements IUserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BankRepository bankRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	EmailSenderService emailSenderService;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public String addUser(UserDto userDto) {
		
		String s1 = " ";
		
		var user = userDto.getUserFromUserDto(userDto);
		
		boolean usernameAbsent = userRepository.getByUserName(user.getUserName()) == null;
		boolean MobileNoAbsent = userRepository.getByPhoneNumber(user.getPhoneNumber()) == null;
		boolean AccountNoAbsent = bankRepository.getByAccountNo(user.getBank().getAccountNo()) == null;
		
		if (usernameAbsent && MobileNoAbsent && AccountNoAbsent) {
			User userFromDB = userRepository.getByEmail(user.getEmail());
			
			user.setId(userFromDB.getId());
			user.setPassword(userFromDB.getPassword());
			user.setRoles(userFromDB.getRoles());
			user.setEmail(userFromDB.getEmail());
			
			User user1;
			Bank bank=bankRepository.save(user.getBank());
			
			Address address=addressRepository.save(user.getAddress());
			user1=userRepository.save(user);
			System.out.println("bank id "+bank.getId()+"address id "+address.getId()+"user id:"+user1.getId());
			
			
			
			emailSenderService.sendEmail(user.getEmail(),
				user.getFullName() + " you are registered successfully..as " + user.getRoles(), "Registration Status");
			return "user Added";
		} else {
			if (usernameAbsent == false) {
				s1 = s1 + "  *username already taken*";
			}
			
			if (MobileNoAbsent == false) {
				s1 = s1 + "  *mobile number already exists*";
			}
			
			
			if (AccountNoAbsent == false) {
				s1 = s1 + "  *account number already exists*";
			}
			
			
		}
		return s1;
		
		
	}
	
	@Override
	public  String deleteUser(String userId) {
		
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
			
			long accountNo=user.getBank().getAccountNo();
			String addressId=user.getAddress().getId();
    		bankRepository.deleteByAccountNo(accountNo);
		    addressRepository.deleteById(addressId);
			userRepository.deleteById(userId);
			System.out.println("deleted user bank details "+bankRepository.getByAccountNo(user.getBank().getAccountNo()));
			
			return "user deleted successfully";
			
		}
		else
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
	
	
	
	public List<User> getAllUsers() {
		List<User> users = userRepository.findAll();
		if (users != null) {
			System.out.println(users);
			return users;
			
		} else {
			return new ArrayList<>();
		}
		
	}

	
	public String markUserStatus(String userId, boolean userStatus) {
		User user = userRepository.getById(userId);
		
		if (user != null) {
			user.setActive(userStatus);
			userRepository.save(user);
			if (userRepository.getById(userId).getActive().equals(userStatus)) {
				return "updated user status as " + (user.getActive() ? "active" : "in-active");
			} else {
				return "user not updated";
			}
		} else {
			return "invalid user id";
		}
		
		
	}
	
	public Boolean addCrops(String userId,String cropId){
		
		User user=userRepository.getById(userId);
		List<String> list=user.getCropIds();
		list.add(cropId);
		user.setCropIds(list);
		userRepository.save(user);
		return true;
		
	}
	
	public List<String> getUserCropIdList(String userId){
		User user=userRepository.getById(userId);
		if(user.getCropIds()!=null) {
			return user.getCropIds();
		}
		else 
			return new ArrayList<>();
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
			
			
			if (user.getRoles() != null && user.getRoles().isBlank() == false) {
				
				String userRole = user.getRoles().split("_")[1];
				user1.setRoles(userRole);
			}
			
			if(user.getUserName()!=null&&user.getUserName().isBlank()==false) {
				user1.setUserName(user.getUserName());
			}
			
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
		
	
			var bank1 = updateBank(user, user1);
			
			var address1 = updateAddress(user, user1);
			bankRepository.save(bank1);
			user1.setBank(bank1);
			
			addressRepository.save(address1);
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
			
		} 
		return address1;
		
	}


	
	
}
