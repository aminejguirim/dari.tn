package com.spring.dev.home.AuthApp.service;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dev.home.AuthApp.model.User;
import com.spring.dev.home.AuthApp.repository.CrudUserRepository;

@Service
public class UserCrudServiceImpl implements IUserCrudService {

	@Autowired
	CrudUserRepository UserRepo;
	
	private static final Logger L = LogManager.getLogger(UserCrudServiceImpl.class);

	@Override
	public List<User> retrieveAllUsers() {
		List<User> users = (List<User>) UserRepo.findAll();
		for (User user : users) {
			L.info("user :" + user);
		}
		return users ;
	}
	

	@Override
	public User addUser(User u) {
		// TODO Auto-generated method stub
		return UserRepo.save(u);
	}

	@Override
	public void deleteUser(String id) {
		// TODO Auto-generated method stub
		UserRepo.deleteById(Long.parseLong(id));
	}

	@Override
	public User updateUser(User u) {
		// TODO Auto-generated method stub
		return UserRepo.save(u);
	}

	@Override
	public User retrieveUser(String id) {
		// TODO Auto-generated method stub
		return (User) UserRepo.findAll();
	}

	@Override
	public void deleteUserById(long id) {
		// TODO Auto-generated method stub
		this.deleteUserById(id);
	}
	

	

}
