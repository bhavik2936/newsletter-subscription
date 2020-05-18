package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
