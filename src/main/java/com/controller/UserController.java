package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.UserBean;
import com.dao.UserDao;

//works as a Controller
@Controller
public class UserController {
	
	@Autowired
	UserDao userDao;

//	serves GET method of HTTP for base URL '/'
	@GetMapping("/")
	public String dashboard() {
		return "Dashboard";
	}
	
//	add new user email to subscription list
	@PostMapping("/")
	public String subscribeEmail(UserBean userBean, BindingResult result) {
		int count = userDao.subscribeUser(userBean);
		if (count == 0) {
			result.addError(new ObjectError("email", "Couldn't subscribe user"));
		} else if (count == 2) {
			result.addError(new ObjectError("email", "User already subscribed to mailing list"));
		}
		return "Dashboard";
	}
}
