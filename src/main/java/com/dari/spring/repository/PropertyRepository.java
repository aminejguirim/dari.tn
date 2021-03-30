package com.dari.spring.repository;
  

import org.springframework.stereotype.Repository;

import org.springframework.data.repository.CrudRepository;


import com.dari.spring.entity.Property;


@Repository

public interface PropertyRepository extends CrudRepository <Property , Long> {

}
