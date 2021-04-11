package com.dari.spring.repository;
  
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dari.spring.entity.Property;



@Repository
public interface PropertyRepository extends CrudRepository<Property, Integer>,JpaRepository<Property, Integer> {
	
	// Shows all requests to add advertisements FOR ADMIN
		List<Property> findByStatusFalse();
		
		List<Property> findByStateAndAvailabilityAndStatusTrue(String state, String availability);
 

}
