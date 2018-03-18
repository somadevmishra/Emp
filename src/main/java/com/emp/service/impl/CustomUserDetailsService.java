package com.emp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.emp.dao.UserDAO;
import com.emp.model.CustomUserDetails;
import com.emp.model.Users;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserDAO userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userDao.getUserByEmail(username); 
		return new CustomUserDetails (user);
	}

}
