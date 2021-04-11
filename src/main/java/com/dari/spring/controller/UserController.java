package com.dari.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dari.spring.entity.User;
import com.dari.spring.service.IUserService;

@RestController
public class UserController {

	
	@Autowired
	IUserService us;
	
	// http://localhost:8081/Dari/servlet/SignUP
		@PostMapping("/SignUP")
		@ResponseBody
		public void SignUP(@RequestBody User u) {
			us.SignUP(u);
		}
	
}
