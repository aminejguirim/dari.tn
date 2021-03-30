package com.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entity.Client;

@Repository
public interface Clientrepository extends JpaRepository<Client, Long>{

	
	
}
