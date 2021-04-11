package com.spring.dev.home.AuthApp.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import org.springframework.web.bind.annotation.RestController;

import com.spring.dev.home.AuthApp.model.Wish;
import com.spring.dev.home.AuthApp.service.WishServiceImpl;






@RestController
public class WishController {
	
	
	
	

	
	@Autowired
	WishServiceImpl service;
	
	
	
	// Add Wish and notify client if an assetadv is a close example
	@GetMapping("/retrieve-wish")
		
				
				@PostMapping("/clients/{id}/wishes/add")
				public Wish AjouterWish(@PathVariable("id") int id, @RequestBody Wish W) {
					
					service.addWish(id, W);
					return W;
				}
			
		
		
}	
