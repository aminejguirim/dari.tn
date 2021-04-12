package tn.amir.projet.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.amir.projet.entity.User;
import tn.amir.projet.repository.UserRepository;
import tn.amir.projet.services.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	UserRepository urs;
	
	@Override
	public void SignUP(User user) {
		// TODO Auto-generated method stub
		urs.save(user);
	}


}
