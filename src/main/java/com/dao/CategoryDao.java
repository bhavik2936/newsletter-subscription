package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.CategoryBean;
import com.bean.UserBean;

@Repository
public class CategoryDao {

	@Autowired
	JdbcTemplate stmt;

	public List<CategoryBean> fetchCategories() {
		try {
			return stmt.query("SELECT * FROM tbl_categories WHERE is_active = true", new RowMapper<CategoryBean>() {
				@Override
				public CategoryBean mapRow(ResultSet rs, int rowNum) throws SQLException {
					CategoryBean categoryBean = new CategoryBean();
					categoryBean.setCategory_id(rs.getInt("category_id"));
					categoryBean.setCategory_name(rs.getString("category_name"));
					categoryBean.setIs_active(rs.getBoolean("is_active"));
					return categoryBean;
				}
			});
		} catch (DataAccessException e) {
			return null;
		}
	}
	
	public int subscribeCategories(UserBean userBean) {
		try {
			for (CategoryBean categoryBean : userBean.getCategories()) {
				stmt.update("INSERT INTO tbl_user_category (user_id, category_id) VALUES (?, ?)", userBean.getUser_id(), categoryBean.getCategory_id());
			}			
			return 1;
		} catch (DataAccessException e) {
			return 0;
		}
	}
}
