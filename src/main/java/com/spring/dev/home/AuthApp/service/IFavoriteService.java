package com.spring.dev.home.AuthApp.service;

import java.util.List;

import com.spring.dev.home.AuthApp.model.Favorite;
import com.spring.dev.home.AuthApp.model.Property;


public interface IFavoriteService {
	
	public boolean ajouterFavorite(Integer user, Integer property);
	public boolean rechercherFavorite(Favorite f);
	public void deleteFavoriteById(int FavoriteId);
	public List<Favorite> getAllFavorites(int id);
	public List<Favorite> getfavoriteswhoseassetgotupdated(Property P);
}
