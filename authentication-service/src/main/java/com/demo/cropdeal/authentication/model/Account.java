package com.demo.cropdeal.authentication.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Entity
public class Account implements UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(length = 60)
	private String email;
	@Column(length = 60)
	private String password;
	private String fullName;
	private Boolean active;
	private String roles;
	@Column(length = 13)
	private String phoneNumber;
	@Column(length = 20)
	private String resetCode = null;
	
	public Account() {
	
	}
	
	public Account(MyRequestModel requestModel) {
		this.email = requestModel.email;
		this.password = requestModel.password;
		this.fullName = requestModel.fullName;
		this.active = requestModel.active;
		this.roles = requestModel.roles;
		this.phoneNumber = requestModel.phoneNumber;
		this.resetCode = requestModel.resetCode;
	}
	
	//	OVERRIDING METHODS FROM USERDETAILS INTERFACE
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.stream(roles.split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}
	
	@Override
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String getUsername() {
		return this.email;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

//	GETTERS AND SETTERS
	
	@Override
	public boolean isEnabled() {
		return active;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public Boolean getActive() {
		return active;
	}
	
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	public String getRoles() {
		return roles;
	}
	
	public void setRoles(String roles) {
		this.roles = roles;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getResetCode() {
		return resetCode;
	}
	
	public void setResetCode(String resetCode) {
		this.resetCode = resetCode;
	}
}
