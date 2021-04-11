package com.dari.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dari.spring.entity.VisitTime;


@Repository
public interface VisitTimeRepository extends CrudRepository<VisitTime, Integer>  {
	
	@Query("select c from VisitTime c where c.property.id=?1")
	List<VisitTime> findAllVisitTimeByProperty(int idProperty);

}
