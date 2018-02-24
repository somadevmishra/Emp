package com.emp.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.emp.model.Users;

public interface UserService extends UserDetailsService {

	Users getUserByEmail(String emailId);
	
	List<Users> getByUserName (String userName);
	
	int getContinousFailedLogin(Users user);
	
	int getContinousFailedLogin(String emailId);
}
