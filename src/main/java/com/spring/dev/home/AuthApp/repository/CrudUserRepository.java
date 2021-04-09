package com.spring.dev.home.AuthApp.repository;

import org.springframework.data.repository.CrudRepository;


import com.spring.dev.home.AuthApp.model.User;

public interface CrudUserRepository extends CrudRepository<User,Long> {

}
