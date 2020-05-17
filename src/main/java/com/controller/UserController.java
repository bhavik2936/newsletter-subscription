package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//works as a Controller
@Controller
public class UserController {

//	serves GET method of HTTP for base URL '/'
	@GetMapping("/")
	public String dashboard() {
		return "Dashboard";
	}
	
//	add new user email to subscription list
	@PostMapping("/")
	public String subscribeEmail() {
		return "Dashboard";
	}
}
