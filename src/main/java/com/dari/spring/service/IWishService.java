package com.dari.spring.service;

import java.util.List;

import com.dari.spring.entity.Property;
import com.dari.spring.entity.Wish;

public interface IWishService {
	
	
	
	

	public List<Wish> getAllWishById(int id);
	
	void addWish(int user, Wish W);
	public List<Property> searchassetadvlikewish(Wish W);
	
	public boolean comparewishasset(Wish W, Property P);
	
}
