package com.dao;

import org.springframework.stereotype.Repository;

import com.bean.AdminBean;

@Repository
public class AdminDao {

	public boolean authenticate(AdminBean adminBean) {
		try {
			if (adminBean.getUsername().equals(System.getenv("adminUsername"))
					&& adminBean.getPassword().equals(System.getenv("adminPassword"))) {
				return true;
			}
		} catch (NullPointerException e) {
			return false;
		}
		return false;
	}
}
