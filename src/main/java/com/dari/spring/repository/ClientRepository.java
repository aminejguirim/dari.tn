package com.dari.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.dari.spring.entity.Client;


public interface ClientRepository extends CrudRepository< Client, Long>{

}