package com.emp.service;

import java.util.List;

import com.emp.model.Users;

public interface UserService {

	Users getUserByEmail(String emailId);
	
	List<Users> getByUserName (String userName);
	
	int getContinousFailedLogin(Users user);
	
	int getContinousFailedLogin(String emailId);
}
