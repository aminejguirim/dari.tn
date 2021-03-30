package com.esprit.spring.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.repository.Clientrepository;

@Service
public class ClientServiceImp implements IClientService {

	@Autowired
	
Clientrepository clientrepository;

	private static final Logger L = LogManager.getLogger(ClientServiceImp.class);
	
}
