package com.dari.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dari.spring.entity.Client;
import com.dari.spring.entity.Favorite;
import com.dari.spring.entity.Property;
import com.dari.spring.repository.FavoriteRepository;

@Service
public class FavoriteServiceImpl implements IFavoriteService {

	@Autowired
	FavoriteRepository favoriterepository;


//	@Autowired
//	AssetAdvRepository AssetAdvRepository;

	@Override
	public void ajouterFavorite(Client user, Property property) {
		Favorite FavoriteEntity = new Favorite();
		FavoriteEntity.setProperty(property);
		FavoriteEntity.setUser(user);
		favoriterepository.save(FavoriteEntity);
	}

	public void deleteFavoriteById(int FavoriteId) {

		Favorite FavoriteEntity = favoriterepository.findById(FavoriteId).get();
		favoriterepository.delete(FavoriteEntity);

	}

	public List<Favorite> getAllFavorites() {
		return (List<Favorite>) favoriterepository.findAll();
	}

}