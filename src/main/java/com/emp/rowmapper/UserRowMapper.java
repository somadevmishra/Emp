package com.emp.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.emp.model.Users;

@Component
public class UserRowMapper implements RowMapper<Users> {
	
	@Override
	public Users mapRow(ResultSet rs, int rowNumber) throws SQLException {
		
		Users user= new Users();
		user.setId(rs.getInt("id"));
		user.setUserName(rs.getString("Name"));
		user.setEmailId(rs.getString("emailId"));
		user.setPassword(rs.getString("password"));
		user.setStatus(rs.getInt("status"));
		user.setContinousFailedLogin(rs.getInt("continous_failed_login"));
		user.setCreatedOn(rs.getDate("created_on"));
		user.setModifiedOn(rs.getDate("last_modified_on"));
		user.setCreatedBy(rs.getInt("created_by"));
		user.setModifiedBy(rs.getInt("modified_by"));
		return user;
	}

}
