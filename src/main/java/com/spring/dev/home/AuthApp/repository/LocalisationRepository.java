package com.spring.dev.home.AuthApp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.dev.home.AuthApp.model.Localisation;

@Repository
public interface LocalisationRepository extends CrudRepository<Localisation,Integer >{
	
	
	@Query("Select l.longtitude  from Localisation l where l.property.id=:idProperty")
	String findLongtitudeByAsset(@Param("idProperty") int idProperty);
	
	@Query("Select l.latitude  from Localisation l where l.property.id=:idProperty")
	String findLatitudeByAsset(@Param("idProperty") int idProperty);
}
