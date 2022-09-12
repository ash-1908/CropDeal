package com.demo.cropdeal.user.repository;

import com.demo.cropdeal.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User getByUserId(Long userId);
    User getByUserName(String username);
	User getByMobileNo(long mobileNo);
	User getByEmailId(String emailId);
    
	
}
