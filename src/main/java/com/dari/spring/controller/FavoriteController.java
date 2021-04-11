package com.dari.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dari.spring.entity.Favorite;
import com.dari.spring.entity.Property;
import com.dari.spring.service.IFavoriteService;

@RestController
public class FavoriteController {
	
	@Autowired
	IFavoriteService FavoriteService;
	
	//add favorite
		@PostMapping("/User/Favorites/addFavorite/{user}/{property}")
		public ResponseEntity<String> ajouterFavorite(@PathVariable Integer user, @PathVariable Integer property) {
			if (FavoriteService.ajouterFavorite(user, property))
				return new ResponseEntity<>("Ajout reussie.", HttpStatus.CREATED);
			else
				return new ResponseEntity<>("Favoris existe deja.", HttpStatus.ALREADY_REPORTED);
		}
		
		@DeleteMapping("/User/Favorites/{id}/delete")
		public ResponseEntity<String> deleteFavoriteById(@PathVariable("id") int id) {
			FavoriteService.deleteFavoriteById(id);
			return new ResponseEntity<>("suppression reussie.", HttpStatus.OK);
		}
		
//		http://localhost:8081/Dari/servlet/User/{id}/Favorite/Notification
		// show favorites
		@GetMapping("/User/{id}/Favorite")
		public List<Favorite> getAllFavorites(@PathVariable("id") int id) {
			return FavoriteService.getAllFavorites(id);
		}
		
		// http://localhost:8081/Dari/servlet/User/{id}/Favorite/Notification
		// notification changed favorite assets
		
		
		
}