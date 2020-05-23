package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bean.AdminBean;
import com.dao.AdminDao;
import com.dao.UserDao;

//works as a Controller and defining session attributes
@Controller
@SessionAttributes("adminBean")
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

//	setting model attribute
	@ModelAttribute("adminBean")
	public AdminBean setModelAttributeAdminBean(AdminBean adminBean) {
		return adminBean;
	}

//	admin panel login
	@GetMapping("/admin")
	public String adminPanel(@ModelAttribute("adminBean") AdminBean adminBean) {
		if (adminDao.authenticate(adminBean)) {
			return "redirect:/newsletter";
		}
		return "AdminPanel";
	}

//	admin panel access
	@PostMapping("/admin")
	public String authenticateAdmin(@ModelAttribute("adminBean") AdminBean adminBean) {
		if (adminDao.authenticate(adminBean)) {
			return "redirect:/newsletter";
		}
		return "AdminPanel";
	}

//	topic publishment model
	@GetMapping("/newsletter")
	public String newsletter(@ModelAttribute("adminBean") AdminBean adminBean) {
		if (adminDao.authenticate(adminBean)) {
			return "Newsletter";
		}
		return "redirect:/admin";
	}

	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:/admin";
	}
}
