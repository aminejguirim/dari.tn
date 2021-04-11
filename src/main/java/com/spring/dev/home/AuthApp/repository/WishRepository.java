package com.spring.dev.home.AuthApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.dev.home.AuthApp.model.Wish;

@Repository
public interface WishRepository extends CrudRepository<Wish, Integer> {

}
