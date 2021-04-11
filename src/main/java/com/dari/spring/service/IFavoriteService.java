package com.dari.spring.service;


import java.util.List;

import com.dari.spring.entity.Favorite;
import com.dari.spring.entity.Property;



public interface IFavoriteService {
	
	public boolean ajouterFavorite(Integer user, Integer property);
	public boolean rechercherFavorite(Favorite f);
	public void deleteFavoriteById(int FavoriteId);
	public List<Favorite> getAllFavorites(int id);
	

}
