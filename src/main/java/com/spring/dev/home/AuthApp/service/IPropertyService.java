package com.spring.dev.home.AuthApp.service;

import java.util.List;

import com.spring.dev.home.AuthApp.model.Property;

public interface IPropertyService {
	
	
	Property save(Property property);
	//public void addProperty(int iduser, Property asset);
	public void acceptProperty (int id);
	public List<Property> findByStatusFalse();
	public void updateProperty(int id, Property property);
	public void deleteProperty(int id);
	
	public Property findpropertybyid(int id);
	public List<Property> findByStateAndStatusTrue(String state);
	
	public double averagepricebystate(String state);

}
