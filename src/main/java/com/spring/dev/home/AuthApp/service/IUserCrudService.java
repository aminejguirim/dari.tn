package com.spring.dev.home.AuthApp.service;

import java.util.List;

import com.spring.dev.home.AuthApp.model.User;

public interface IUserCrudService {
	
	public List<User> retrieveAllUsers();
	
	User addUser(User u);
	
	void deleteUser(String id);
	
	User updateUser(User u);
	
	User retrieveUser(String id);
	void deleteUserById(long id);

}

