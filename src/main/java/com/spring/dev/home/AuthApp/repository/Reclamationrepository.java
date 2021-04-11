package com.spring.dev.home.AuthApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.dev.home.AuthApp.model.Reclamation;

@Repository
public interface Reclamationrepository extends JpaRepository<Reclamation, Long> {

	
}