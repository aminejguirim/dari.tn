package com.dari.spring.service;

import com.dari.spring.entity.Localisation;

public interface ILocalisationService {

	public Localisation createLocalisation(Localisation local);
	
	public void updateLocalisation(int id, float latitude, float longtitude);
	
	
	public String findLocalisationOfAsset(int idAsset); 
	public void deleteLocalisation(int id);
	
	
	
}