package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.UserBean;
import com.dao.UserDao;

//works as REST Controller
@RestController
public class APIController {

	@Autowired
	UserDao userDao;

//	add new user email to subscription list
	@PostMapping("/")
	public int subscribeEmail(UserBean userBean, BindingResult result) {
		return userDao.subscribeUser(userBean);
	}
}
