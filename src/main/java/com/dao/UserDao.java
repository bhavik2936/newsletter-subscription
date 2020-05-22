package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;
import com.service.MailSender;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate stmt;
	@Autowired
	MailSender mailSender;

	public int subscribeUser(UserBean userBean) {

		try {

			userBean = stmt.queryForObject("SELECT * FROM tbl_users WHERE email = ? AND is_active = true",
					new Object[] { userBean.getEmail() }, new RowMapper<UserBean>() {
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
				int count = stmt.update("INSERT INTO tbl_users (email) VALUES (?)", userBean.getEmail());
				if (count > 0) {
					mailSender.sendMail(userBean.getEmail(), "Successfully subscribed to Bhavik Parmar's Newsletter",
							"Welcome " + userBean.getEmail()
									+ ",<br>Thanks for subscribing to mailing list, I will reach you out soon.");
				}
				return count;
			} catch (DataAccessException nreg) {
				return 0;
			}
		}
		return 2;
	}
}
