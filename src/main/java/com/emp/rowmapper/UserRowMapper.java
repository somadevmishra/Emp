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
		user.setUserName(rs.getString("userName"));
		user.setEmailId(rs.getString("emailId"));
		user.setPassword(rs.getString("password"));
		user.setStatus(rs.getInt("status"));
		user.setContinousFailedLogin(rs.getInt("continousFailedLogin"));
		user.setCreatedOn(rs.getDate("createdOn"));
		user.setModifiedOn(rs.getDate("modifiedOn"));
		user.setCreatedBy(rs.getInt("createdBy"));
		user.setModifiedBy(rs.getInt("modifiedBy"));
		return user;
	}

}
