package com.spring.dev.home.AuthApp.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dev.home.AuthApp.model.Favorite;
import com.spring.dev.home.AuthApp.model.Property;
import com.spring.dev.home.AuthApp.model.User;
import com.spring.dev.home.AuthApp.repository.FavoriteRepository;
import com.spring.dev.home.AuthApp.repository.PropertyRepository;
import com.spring.dev.home.AuthApp.repository.UserRepository;






@Service
public class FavoriteServiceImpl implements IFavoriteService {
	
	@Autowired
	FavoriteRepository favo;

	@Autowired
	UserRepository us;

	@Autowired
	PropertyRepository prop;

	// ajout favorite
		@Override
		public boolean ajouterFavorite(Integer user, Integer property) {
			Property P = prop.findById(property).get();
			User U = (User) us.findById(user).get();
			Favorite f = new Favorite();
			f.setUser(U);
			f.setProperty(P);

			if (this.rechercherFavorite(f) == false) {
				U.addFavorite(f);
				favo.save(f);
				return true;
			}

			return false;
		}
		
		// Rechercher Favorites
		@Override
		public boolean rechercherFavorite(Favorite f) {
			Favorite search = favo.findfavoritenotbyid(f.getUser(), f.getProperty()).orElse(null);
			if (search != null)
				return true;
			else
				return false;
		}

		@Override
		public void deleteFavoriteById(int favoriteId) {
			favo.deleteById(favoriteId);
			
		}

		@Override
		public List<Favorite> getAllFavorites(int id) {
			User u = us.findById(id).get();
			return u.getFavoris();
		}
		
}
