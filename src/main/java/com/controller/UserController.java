package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//works as a REST Controller
@RestController
public class UserController {

//	serves GET method of HTTP for base URL / 
	@GetMapping("/")
	public String dashboard() {
		return "This is my Blog, and It works";
	}
}
