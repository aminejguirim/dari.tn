package com.spring.dev.home.AuthApp.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.dev.home.AuthApp.model.Visit;





@Repository
public interface VisitRepository extends CrudRepository<Visit, Integer>  {
	
	@Query("select v from Visit v  join  v.property p    where p.id=:idProperty and v.date=:date")
	List<Visit> findAppointmentByPropertyByDay(@Param("idProperty") int idProperty, @Param("date") Date date);
	
	@Query("Select count (v) from Visit v join  v.property p  where p.id=:idProperty ")
	Long CountVisitByPropertyId(@Param("idProperty") int idProperty);

}