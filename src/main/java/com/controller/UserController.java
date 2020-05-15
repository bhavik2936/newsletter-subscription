package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//works as a Controller
@Controller
public class UserController {

//	serves GET method of HTTP for base URL '/'
	@GetMapping("/")
	public String dashboard() {
		return "Welcome";
	}
}
