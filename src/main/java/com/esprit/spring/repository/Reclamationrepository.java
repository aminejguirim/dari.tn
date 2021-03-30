package com.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entity.Reclamation;

@Repository
public interface Reclamationrepository extends JpaRepository<Reclamation, Long> {

	
}
