package com.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.dao.UserDAO;
import com.emp.model.Users;
import com.emp.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDao;
	
	@Override
	public Users getUserByEmail(String emailId) {
		return userDao.getUserByEmail(emailId);
	}

	@Override
	public List<Users> getByUserName(String userName) {
		return null;
	}

	@Override
	public int getContinousFailedLogin(Users user) {
		return 0;
	}

	@Override
	public int getContinousFailedLogin(String emailId) {
		return 0;
	}

}
