package com.dari.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dari.spring.entity.Picture;
import com.dari.spring.entity.Property;
import com.dari.spring.entity.ResponsePicture;
import com.dari.spring.repository.PropertyRepository;
import com.dari.spring.service.PictureService;






@RestController
public class PictureController {

	@Autowired
	PictureService PS;

	 @Autowired
	 PropertyRepository Pr;

	@PostMapping("/uplooad/dbbb/{id}")
	public ResponsePicture uploadDb(@RequestParam("picture") MultipartFile multipartpicture,@PathVariable("id") int id) {

		
		
		Property A = Pr.findById(id).get();
		Picture pi = PS.uploadToDb( id,multipartpicture);
		ResponsePicture rs = new ResponsePicture();
		if (pi!= null) {
			rs.setId(pi.getId());
			rs.setType(pi.getType());
			rs.setStatus(true);
			rs.setMessage("Picture Uploaded Successfully!");
			return rs;

		}
		rs.setMessage("Oops! something went wrong please re-upload.");
		return rs;
	}

}
