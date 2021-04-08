package com.spring.dev.home.AuthApp.service;

import java.util.List;

import com.spring.dev.home.AuthApp.model.User;



public interface IUserCrudService {
	
	List<User> retrieveAllUsers();
	User addUser(User u);
	User retrieveUser(String id);
}
