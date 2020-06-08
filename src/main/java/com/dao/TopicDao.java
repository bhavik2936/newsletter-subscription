package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.TopicBean;
import com.bean.UserBean;
import com.service.MailSender;

@Repository
public class TopicDao {

	@Autowired
	JdbcTemplate stmt;
	@Autowired
	MailSender mailSender;

	public List<UserBean> getTopicSubscribers(TopicBean topicBean) {
		int category_id = topicBean.getCategories().get(0).getCategory_id();

		try {
			if (category_id != 0) {
				return stmt.query(
						"SELECT * FROM tbl_users u JOIN tbl_user_category c ON u.user_id = c.user_id WHERE c.category_id = ? AND c.is_active = true",
						new Object[] { topicBean.getCategories().get(0).getCategory_id() }, new RowMapper<UserBean>() {
							@Override
							public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
								UserBean userBean = new UserBean();
								userBean.setUser_id(rs.getInt("user_id"));
								userBean.setEmail(rs.getString("email"));
								userBean.setIs_active(rs.getBoolean("is_active"));
								return userBean;
							}
						});
			} else {
				return stmt.query("SELECT * FROM tbl_users WHERE is_active = true", new RowMapper<UserBean>() {
					@Override
					public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
						UserBean userBean = new UserBean();
						userBean.setUser_id(rs.getInt("user_id"));
						userBean.setEmail(rs.getString("email"));
						userBean.setIs_active(rs.getBoolean("is_active"));
						return userBean;
					}
				});
			}
		} catch (DataAccessException e) {
			return null;
		}
	}

	public int notifySubscribers(TopicBean topicBean) {
		List<UserBean> userList = getTopicSubscribers(topicBean);
		int count = 0;
		
		for (UserBean userBean : userList) {
			if (mailSender.sendMail(userBean.getEmail(), topicBean.getSubject(), topicBean.getMessage())) {
				count++;
			}
		}
		return count;
	}
}
