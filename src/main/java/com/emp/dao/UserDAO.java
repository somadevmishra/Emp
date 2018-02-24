package com.emp.dao;

import java.util.List;

import com.emp.model.Users;

public interface UserDAO{

	Users getUserByEmail(String emailId);
	
	List<Users> getUsersByName (String userName);
	
	int getContinousFailedLogin(Users user);
	
	int getContinousFailedLogin(String emailId);
	
	long createUser(Users user);
}
