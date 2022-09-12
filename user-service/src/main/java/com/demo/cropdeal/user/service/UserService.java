
package com.demo.cropdeal.user.service;
import java.util.ArrayList;
import java.util.List;

import com.demo.cropdeal.user.dto.UserDto;
import com.demo.cropdeal.user.model.Address;
import com.demo.cropdeal.user.model.Bank;
import com.demo.cropdeal.user.model.User;
import com.demo.cropdeal.user.repository.BankRepository;
import com.demo.cropdeal.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
public class UserService implements IUserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BankRepository bankRepository;

	@Autowired
	EmailSenderService emailSenderService;

	
	@Override
	public String addUser(UserDto userDto) {
		
		  String s1 =" ";
			 
		   var user=userDto.getUserFromUserDto(userDto);
		   
	      boolean usernameAbsent=userRepository.getByUserName(user.getUserName())==null;
	      boolean MobileNoAbsent=userRepository.getByMobileNo(user.getMobileNo())==null;
	      boolean EmaiLIdAbsent=userRepository.getByEmailId(user.getEmailId())==null;
	      boolean  AccountNoAbsent=bankRepository.getByAccountNo(user.getBank().getAccountNo())==null;
	       
	       if( usernameAbsent&&MobileNoAbsent&&EmaiLIdAbsent&&AccountNoAbsent) {
	    	   userRepository.save(user);
	    	   emailSenderService.sendEmail(user.getEmailId(),user.getUserFullName()+" you are registered successfully..as "+user.getUserType(), "Registration Status");
	    	   return "user Added";
	       }
	       else {
	    	   if(usernameAbsent==false) {
	    		  s1= s1 + "  *username already taken*";
	    	      }
	    	  
    		  if(MobileNoAbsent==false) {
    			  s1= s1 +"  *mobile number already exists*";
	    	      }
	    	 
	    	  if(EmaiLIdAbsent==false) {
	    		  s1= s1 +"  *email already taken*";
	    	      }
	    	  if(AccountNoAbsent==false) {
	    		  s1= s1 +"  *account number already exists*";
	    	      }
	    	  
	    	 
	    	  
	       }
	       return s1;
	       
	       
	       
		
	}

	@Override
	public String deleteUser(Long userId) {
		
		/*
		 * fetch user from db
		 * check if user is not null
		 *     - if not null then delete the user 
		 *           cross check by fetching same user from db and comparing with null
		 *           return msg "user deleted successfully"
		 *     - else return msg "invalid id user not present"
		 */
		var user=userRepository.getByUserId(userId);
		if(user!=null) {
			userRepository.deleteById(userId);

				return "user deleted successfully";
			
		}
		return "invalid id user not present";
	}

	@Override
	public User getUser(Long userId) {
		
		/*
		 * if user data is present in database then return user
		 * 
		 * For this fetch user using the given id
		 * check if user is not null 
		 *   -if not null then return user data
		 * 
		 */
		
		var user = userRepository.getByUserId(userId);
		if(user!=null) {
			return user;
		}
		
		return null;
	}
	
	public List<User> getAllUsers() {
		List<User> users=userRepository.findAll();
		if(users!=null) {
			return users;
		}
		else
			return new ArrayList<>();
		
	}
	
	public String markUserStatus(Long userId,String status) {
		User user=userRepository.getByUserId(userId);
		if(user!=null) {
			user.setUserStatus(status);
			userRepository.save(user);
			if(userRepository.getByUserId(userId).getUserStatus().equals(status))
				return "updated user status as "+user.getUserStatus();
			else
				return "user not updated";
		}
		else
			return "invalid user id";
		
		
		
	}
	
	
	

	@Override
	public User updateUser(Long userId, User user) {
		
		//fetch user from database using given id
        var user1=userRepository.getByUserId(userId);
		
        /*
         
          check if requested  user data is not null
          check all the fields with null value and update that user fetched from database 
          with given details that are not null
           
       */
        
		if(user!=null) {
		if(user.getEmailId()!=null ) {
			user1.setEmailId(user.getEmailId());
		}
		if((user.getMobileNo()!=0)) {
			user1.setMobileNo(user.getMobileNo());
		}
		if(user.getPassword()!=null ) {
			user1.setPassword(user.getPassword());
		}
		if(user.getUserFullName()!=null ) {
			user1.setUserFullName(user.getUserFullName());
		}
		if(user.getUserType()!=null ) {
			user1.setUserType(user.getUserType());
		}
		/*
		 * 
		 if(user.getUserStatus()!=null ) {
			user1.setUserStatus(user.getUserStatus());
		}
		
		*/
		
		var bank1=updateBank(user,user1);
		
		var address1 =updateAddress(user,user1);
		
           user1.setBank(bank1);
           user1.setAddress(address1);
		
		    userRepository.save(user1);
		    return user1;
	 }
		
	
	  return user1;
	
	}
	
	public Bank updateBank(User user, User user1) {
		var bank1=user1.getBank();
	    if(user.getBank()!=null) {
		
		if(user.getBank().getAccountHolderName()!=null ) {
		bank1.setAccountHolderName(user.getBank().getAccountHolderName());
		}
		
		if(user.getBank().getAccountNo()!=null ) {
		bank1.setAccountNo(user.getBank().getAccountNo());
		}
		
		if(user.getBank().getBankBranch()!=null ) {
		bank1.setBankBranch(user.getBank().getBankBranch());
		}
		
		
         if(user.getBank().getBankIFSC()!=null ) {
        	 bank1.setBankIFSC(user.getBank().getBankIFSC());
		}

         if(user.getBank().getBankName()!=null ) { 
    	   bank1.setBankName(user.getBank().getBankName());
         }
         
         
	    }
	    else {
		bank1=user1.getBank();
	    }
		
		return bank1;
	}
	
	public Address updateAddress(User user, User user1) {
		
         var address1 =user1.getAddress();
         if(user.getAddress()!=null) {
         
		    if(user.getAddress().getCity()!=null ) {
		    	address1.setCity(user.getAddress().getCity());
		    }
        
		    if(user.getAddress().getCountry()!=null ) {
		    	address1.setCountry(user.getAddress().getCountry());
		    }
 
          
		    if(user.getAddress().getHouseNo()!=null ) {
		    	address1.setHouseNo(user.getAddress().getHouseNo());
		    }
		

		    if(user.getAddress().getLocalityName()!=null ) {
		    	address1.setLocalityName(user.getAddress().getLocalityName());
		    }
        
		    if(user.getAddress().getPincode()!=0 ) {
		    	address1.setPincode(user.getAddress().getPincode());
		    }

		
		    if(user.getAddress().getState()!=null ) {
		    	address1.setState(user.getAddress().getState());
        
		    }
        
		    if(user.getAddress().getStreetName()!=null ) {
		    	address1.setStreetName(user.getAddress().getStreetName());
		    }
		
         }
         
         	else {
        	    address1=user1.getAddress();
         	}
		  return address1;
		
	}


	
	

}
