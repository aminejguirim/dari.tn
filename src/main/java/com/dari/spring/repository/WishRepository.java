package com.dari.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dari.spring.entity.Wish;


@Repository
public interface WishRepository extends CrudRepository<Wish, Integer> {

}
