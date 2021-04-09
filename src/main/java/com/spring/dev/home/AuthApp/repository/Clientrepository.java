package com.spring.dev.home.AuthApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.dev.home.AuthApp.model.Client;

@Repository
public interface Clientrepository extends JpaRepository<Client, Long>{

	
	
}
