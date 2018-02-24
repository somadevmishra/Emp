package com.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getContinousFailedLogin(Users user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getContinousFailedLogin(String emailId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return (UserDetails) userDao.getUserByEmail(emailId);
	}

}
