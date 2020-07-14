package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

	@RequestMapping("/signup")
	public String signup() {
		return "abc";
	}
	
	@RequestMapping("/signup-success")
	public String signupsuccess() {
		return "ok";
	}
}
