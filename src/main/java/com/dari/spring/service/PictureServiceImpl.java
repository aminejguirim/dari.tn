package com.dari.spring.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dari.spring.entity.Picture;
import com.dari.spring.entity.Property;
import com.dari.spring.repository.PictureRepository;
import com.dari.spring.repository.PropertyRepository;





@Service
public class PictureServiceImpl implements PictureService {

	
	private String uploadFolderPath ="/Users/LENOVO/Desktop/projet/image1";
	 @Autowired
		private PictureRepository fr;
	 @Autowired
	 PropertyRepository Pr;
	 
	 
	
	public Picture uploadToDb(int id ,MultipartFile multipartpicture) {
		  Picture p = new Picture();
		  Property A =Pr.findById(id).get();

		  
			try{
			p.setProperty(A);	
			p.setImage(multipartpicture.getBytes());
			p.setType(multipartpicture.getContentType());
	        p.setName(multipartpicture.getOriginalFilename());
	        A.addPicture(p);
	        Picture pictureToRet = fr.save(p);
	        return pictureToRet;
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	
	
	
}
