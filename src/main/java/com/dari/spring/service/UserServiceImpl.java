package com.dari.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dari.spring.entity.User;
import com.dari.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService{
	
	
	@Autowired
	UserRepository urs;
	
	@Override
	public void SignUP(User user) {
		// TODO Auto-generated method stub
		urs.save(user);
	}

	
}

	
