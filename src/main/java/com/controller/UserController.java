package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.tags.form.ErrorsTag;

import com.bean.AdminBean;
import com.dao.AdminDao;
import com.dao.UserDao;

//works as a Controller
@Controller
public class UserController {
	
	@Autowired
	UserDao userDao;
	@Autowired
	AdminDao adminDao;

//	serves GET method of HTTP for base URL '/'
	@GetMapping("/")
	public String dashboard() {
		return "Dashboard";
	}
	
//	admin panel login
	@GetMapping("/admin")
	public String adminPanel() {
		return "AdminPanel";
	}
	
//	admin panel access
	@PostMapping("/admin")
	public String authenticateAdmin(AdminBean adminBean) {
		if (adminDao.authenticate(adminBean)) {
			return "redirect:/newsletter";
		} else {
			return "AdminPanel";
		}
	}
	
//	topic publishment model
	@GetMapping("/newsletter")
	public String newsletter() {
		return "Newsletter";
	}
}
