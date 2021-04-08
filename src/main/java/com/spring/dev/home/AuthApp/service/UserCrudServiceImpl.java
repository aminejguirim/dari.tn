package com.spring.dev.home.AuthApp.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dev.home.AuthApp.model.User;
import com.spring.dev.home.AuthApp.repository.UserCrudRepository;



@Service
public class UserCrudServiceImpl implements IUserCrudService {
	
	private static final Logger L = LogManager.getLogger(UserCrudServiceImpl.class);
	
	@Autowired
	public UserCrudRepository userRepository;

	@Override
	public List<User> retrieveAllUsers() {
		List<User> users = (List<User>) userRepository.findAll();
		for (User user : users) {
			L.info("user :" + user);
		}
		return users ;
	}

	@Override
	public User addUser(User u) {
		// TODO Auto-generated method stub
		return userRepository.save(u);
	}

	@Override
	public User retrieveUser(String id) {
		// TODO Auto-generated method stub
		return (User) userRepository.findAll();
	}
	
}
