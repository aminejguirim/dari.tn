package com.spring.dev.home.AuthApp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.spring.dev.home.AuthApp.model.User;

public interface CrudUserRepository extends CrudRepository<User,Long> {

	@Query(value="SELECT count(*) FROM USER",nativeQuery = true)
	public int retrieveUsers();
	
}
