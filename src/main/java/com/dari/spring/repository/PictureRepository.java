package com.dari.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dari.spring.entity.Picture;



@Repository
public interface PictureRepository extends CrudRepository<Picture, Long> {

}
