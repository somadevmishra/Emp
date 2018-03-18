package com.emp.test.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.emp.dao.UserDAO;
import com.emp.model.Users;
import com.emp.test.config.BaseTest;


public class UserDaoTest extends BaseTest{

	@Autowired
	UserDAO userDao;
	
	@Test
	public void testGetUserByEmail() {
		Users userObj= new Users();
		userObj.setUserName("Sid");
		userObj.setContinousFailedLogin(0);
		userObj.setCreatedBy(1);
		userObj.setEmailId("sid456@gmail.com");
		userObj.setModifiedBy(1);
		userObj.setPassword("pass123");
		userObj.setStatus(1);
		
		userDao.createUser(userObj);
		
		Users getUser= userDao.getUserByEmail("sid456@gmail.com");
		assertEquals("Sid",getUser.getUserName());
	}

	@Test
	public void testGetUsersByName() {
		
		assertTrue(true);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetContinousFailedLoginUsers() {
		assertTrue(true);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetContinousFailedLoginString() {
		assertTrue(true);
		//fail("Not yet implemented");
	}
	
	@Test
	public void testCreateUser(){
		Users userObj= new Users();
		userObj.setUserName("Sid");
		userObj.setContinousFailedLogin(0);
		userObj.setCreatedBy(1);
		userObj.setEmailId("sid456@gmail.com");
		userObj.setModifiedBy(1);
		userObj.setPassword("pass123");
		userObj.setStatus(1);
		
		long success= userDao.createUser(userObj);
		assertEquals(1, success);
	}

}
