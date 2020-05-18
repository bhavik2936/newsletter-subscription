package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;

@Repository
public class UserDao {
	
	@Autowired
	JdbcTemplate stmt;

	public int subscribeUser(UserBean userBean) {
		
		try {
			
		userBean = stmt.queryForObject("SELECT * FROM tbl_users WHERE email = ? AND is_active = true", new Object[] {userBean.getEmail()}, new RowMapper<UserBean>() {
			@Override
			public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserBean userBean = new UserBean();
				userBean.setUser_id(rs.getInt("user_id"));
				userBean.setEmail(rs.getString("email"));
				userBean.setIs_active(rs.getBoolean("is_active"));
				return userBean;
			}
		});
		} catch (DataAccessException reg) {
			try {
//				return stmt.update("INSERT INTO tbl_users (email) VALUES (?)", userBean.getEmail());
				return 1;
			} catch (DataAccessException nreg) {
				return 0;
			}
		}
		return 2;
	}
}
