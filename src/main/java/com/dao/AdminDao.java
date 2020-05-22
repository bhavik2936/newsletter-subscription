package com.dao;

import org.springframework.stereotype.Repository;

import com.bean.AdminBean;

@Repository
public class AdminDao {

	public boolean authenticate(AdminBean adminBean) {
		if (adminBean.getUsername().equals(System.getenv("adminUsername")) && adminBean.getPassword().equals(System.getenv("adminPassword"))) {
			return true;
		}
		return false;
	}
}
