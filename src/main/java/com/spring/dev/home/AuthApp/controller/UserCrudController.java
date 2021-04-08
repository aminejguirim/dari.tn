package com.spring.dev.home.AuthApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dev.home.AuthApp.model.User;
import com.spring.dev.home.AuthApp.service.IUserCrudService;

@RestController
public class UserCrudController {
	
	@Autowired
	IUserCrudService userService;
	
	@GetMapping("/retrieve-all-users")
	@ResponseBody
	public List<User> getUsers() {
	List<User> list = userService.retrieveAllUsers();
	return list;
	}
}
