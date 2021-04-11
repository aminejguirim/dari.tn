package com.spring.dev.home.AuthApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dev.home.AuthApp.model.Localisation;
import com.spring.dev.home.AuthApp.service.LocalisationServiceImpl;







@RestController
	public class LocalisationController {
		

		@Autowired
		LocalisationServiceImpl ls;
		
		
	
		
		// http://localhost:8081/Dari/servlet/Asset/addLocalisation
		@PostMapping("/Property/addLocalisation")
		public ResponseEntity<String> ajouterLocalisation(@RequestBody Localisation L)
		{
			if(((L.getLatitude()<-90)||(L.getLatitude()>90))||((L.getLongtitude()<-180)||(L.getLongtitude()>180)))
			{
				return new ResponseEntity<>("latitude should be in [-90..90] and longtitude should be in[-180..180].", HttpStatus.BAD_REQUEST);
			} else {
				ls.createLocalisation(L);
				return new ResponseEntity<>("Added Successfully.", HttpStatus.CREATED);
			}
			
			
		}
		
		
		
		
				
		
		
		
		
		@GetMapping("Property/Localisation/{idProperty}")
		public String afficherLocalisation(@PathVariable("idProperty") int idProperty)
		{
			return ls.findLocalisationOfAsset(idProperty);
		}
		
		
		@PutMapping("Asset/Localisation/{id}/Modify/{latitude}/{longtitude}")
		public ResponseEntity<String> modifierLocalisation(@PathVariable("id")int id,@PathVariable("latitude")float latitude,@PathVariable("longtitude")float longtitude )
		{
			if(((latitude<-90)||(latitude>90))||((longtitude<-180)||(longtitude>180)))
			{
				return new ResponseEntity<>("latitude should be in [-90..90] and longtitude should be in[-180..180].", HttpStatus.BAD_REQUEST);
			} else {
			ls.updateLocalisation(id, latitude, longtitude);
			return new ResponseEntity<>("Updated Successfully.", HttpStatus.ACCEPTED);
			}
		}
		
		
		// http://localhost:8081/Dari/servlet/Asset/Localisation/delete/{id}
		@PostMapping("Asset/Localisation/delete/{id}")
		public ResponseEntity<String> supprimerLocalisation(@PathVariable("id")int id)
		{
			ls.deleteLocalisation(id);
			return new ResponseEntity<>("Deleted Successfully.", HttpStatus.OK);
		}
		
		
	}