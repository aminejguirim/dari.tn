package com.spring.dev.home.AuthApp.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dev.home.AuthApp.repository.Clientrepository;

@Service
public class ClientServiceImp implements IClientService {

	@Autowired
	
Clientrepository clientrepository;

	private static final Logger L = LogManager.getLogger(ClientServiceImp.class);
	
}
