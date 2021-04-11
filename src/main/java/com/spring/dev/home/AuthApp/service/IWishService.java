package com.spring.dev.home.AuthApp.service;

import java.util.List;

import com.spring.dev.home.AuthApp.model.Property;
import com.spring.dev.home.AuthApp.model.Wish;



public interface IWishService {
	
	
	
	

	public List<Wish> getAllWishById(int id);
	
	void addWish(int user, Wish W);
	public List<Property> searchassetadvlikewish(Wish W);
	
	public boolean comparewishasset(Wish W, Property P);
	
}
