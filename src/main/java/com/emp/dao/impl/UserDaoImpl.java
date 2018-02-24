package com.emp.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.emp.dao.UserDAO;
import com.emp.model.Users;
import com.emp.rowmapper.UserRowMapper;

@Repository
public class UserDaoImpl implements UserDAO {

	private static final String GET_USER_BY_EMAIL = "SELECT * FROM USER WHERE EMAILID = ?";

	private static final String GET_USERS_BY_NAME = "SELECT * FROM USER WHERE NAME = ?";

	private static final String GET_CONTINOUS_FAILED_LOGIN = "SELECT CONTINOUS_FAILED_LOGIN FROM USER WHERE EMILID= ? ";
	
	private static final String CREATE_USER= "Insert into user (Name, password, emailid, created_on, status, last_modified_on, continous_failed_login, created_by, modified_by) "
			+ "values(:name, :password, :emailid, :created_on, :status, :last_modified_on, :continous_failed_login, :created_by, :modified_by)";
	@Autowired
	UserRowMapper userRowMapper;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedJdbcTemplate;

	@Override
	public Users getUserByEmail(String emailId) {

		String[] params={emailId};
		List<Users> users=jdbcTemplate.query(GET_USER_BY_EMAIL, params, userRowMapper);
		return users.get(0);
	}

	@Override
	public List<Users> getUsersByName(String userName) {
		
		String[] params={userName};
		
		return jdbcTemplate.query(GET_USERS_BY_NAME, params, userRowMapper);
	}

	@Override
	public int getContinousFailedLogin(Users user) {
		return getContinousFailedLogin(user.getEmailId());
	}

	@Override
	public int getContinousFailedLogin(String emailId) {
		
		String[] params={emailId};
		
		return jdbcTemplate.queryForObject(GET_CONTINOUS_FAILED_LOGIN, params, Integer.class);
	}

	@Override
	public long createUser(Users user) {
		
		Map<String, Object> params = new HashMap<>();
		params.put("name", user.getUserName());
		params.put("password", user.getPassword());
		params.put("emailid", user.getEmailId());
		params.put("created_on", new Date());
		params.put("status", user.getStatus());
		params.put("last_modified_on", new Date());
		params.put("continous_failed_login", user.getContinousFailedLogin());
		params.put("created_by", user.getCreatedBy());
		params.put("modified_by", user.getModifiedBy());

		return namedJdbcTemplate.update(CREATE_USER, params);
	}

}
