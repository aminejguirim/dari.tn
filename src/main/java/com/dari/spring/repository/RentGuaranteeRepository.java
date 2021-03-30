package com.dari.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dari.spring.entity.RentGuarantee;




@Repository

public interface RentGuaranteeRepository extends CrudRepository <RentGuarantee, Integer> {

}
