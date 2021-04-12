package com.dari.spring.service;

import org.springframework.web.multipart.MultipartFile;

import com.dari.spring.entity.Picture;



public interface PictureService {
	
	
	public Picture uploadToDb(int id ,MultipartFile picture);

}
