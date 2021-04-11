package com.dari.spring.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dari.spring.entity.User;

;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>,JpaRepository<User, Integer> {

}
