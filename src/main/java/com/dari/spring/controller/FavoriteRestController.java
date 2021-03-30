package com.dari.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dari.spring.entity.Client;
import com.dari.spring.entity.Favorite;
import com.dari.spring.entity.Property;
import com.dari.spring.service.IFavoriteService;
import com.dari.spring.service.IPropertyService;

public class FavoriteRestController {
	

@RestController
public class PropertyRestController {
	
	@Autowired
	IFavoriteService favService;

	// http://localhost:6000/SpringMVC/servlet/retrieve-all-fav
	@GetMapping("/retrieve-all-fav")
	@ResponseBody
	public List<Favorite> getfavorite() {
	List<Favorite> list = favService.getAllFavorites();
	return list;
	
	}
	
	

	// http://localhost:6000/SpringMVC/servlet/add-fav
	@PostMapping("/add-fav")
	@ResponseBody
	public Favorite addFav(@RequestBody Favorite f) {
	
	Favorite favorite = favService.ajouterFavorite( user,  property);
	return favorite;
	}
	
	
	// http://localhost:6000/SpringMVC/servlet/remove-fav/{fav-id}
	@DeleteMapping("/remove-prop/{prop-id}")
	@ResponseBody
	public void removeUser(@PathVariable("fav-id") int FavoriteId) {
	favService.deleteFavoriteById(FavoriteId);
	}

	

}

}
