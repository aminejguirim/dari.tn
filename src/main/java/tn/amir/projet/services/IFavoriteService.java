package tn.amir.projet.services;

import java.util.List;

import tn.amir.projet.entity.Favorite;
import tn.amir.projet.entity.Property;

public interface IFavoriteService {
	
	public boolean ajouterFavorite(Integer user, Integer property);
	public boolean rechercherFavorite(Favorite f);
	public void deleteFavoriteById(int FavoriteId);
	public List<Favorite> getAllFavorites(int id);
	public List<Favorite> getfavoriteswhoseassetgotupdated(Property P);

}
