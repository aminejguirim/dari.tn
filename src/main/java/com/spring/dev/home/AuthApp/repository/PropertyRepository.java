package com.spring.dev.home.AuthApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.dev.home.AuthApp.model.Property;





@Repository
public interface PropertyRepository extends CrudRepository<Property, Integer>,JpaRepository<Property, Integer> {
	
	// Shows all requests to add advertisements FOR ADMIN
		List<Property> findByStatusFalse();
		
		List<Property> findByStateAndAvailabilityAndStatusTrue(String state, String availability);
 

}
