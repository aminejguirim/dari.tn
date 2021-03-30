package com.dari.spring.service;

import com.dari.spring.entity.Client;
import com.dari.spring.entity.Favorite;
import com.dari.spring.entity.Property;
import java.util.List;
public interface IFavoriteService {

	
	
	public void ajouterFavorite(Client user, Property property);

	public void deleteFavoriteById(int FavoriteId);

	public List<Favorite> getAllFavorites();
}
