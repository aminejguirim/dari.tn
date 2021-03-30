package com.dari.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dari.spring.entity.Favorite;




@Repository

public interface FavoriteRepository extends CrudRepository< Favorite, Integer> {
	
	

}
