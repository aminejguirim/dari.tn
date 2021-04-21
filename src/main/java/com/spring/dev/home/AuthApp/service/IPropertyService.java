package com.spring.dev.home.AuthApp.service;

import java.util.List;

import com.spring.dev.home.AuthApp.model.Property;

public interface IPropertyService {
	
	
	public void addProperty(int iduser, Property asset);
	public void acceptProperty (int id);
	public List<Property> findByStatusFalse();
	public void updateProperty(int id, Property property);
	public void deleteProperty(int id);
	
	public Property findpropertybyid(int id);
	
	
	
	////////////////////////////////////////// Price ////////////////////////////////////////////////
	
	public List<Property> findByPriceAndStatusTrue(float price);
	
	public List<Property> findByPriceMinMaxPriceAsc(float pricemin,float pricemax);
	public List<Property> findByPriceMinMaxPriceDesc(float pricemin,float pricemax);
	
	public List<Property> findByPriceMinMaxSurfaceAsc(float pricemin,float pricemax);
	public List<Property> findByPriceMinMaxSurfaceDesc(float pricemin,float pricemax);
	
	/////////////////////////////////////////// Surface /////////////////////////////////////////////
	
	public List<Property> findBySurfaceAndStatusTrue(float surface);
	public List<Property> findBySurfaceAndStatusTrueOrderByPriceAsc(float surface);
	public List<Property> findBySurfaceAndStatusTrueOrderByPriceDesc(float surface);
	
	////////////////////////////////////////// City ///////////////////////////////////////////////
	
	public List<Property> findByCityAndStatusTrue(String city);
	public List<Property> findByCityAndStatusTrueOrderByPriceAsc(String city);
	public List<Property> findByCityAndStatusTrueOrderByPriceDesc(String city);
	
	//////////////////////////////////////// State //////////////////////////////////////////////
	
	public List<Property> findByStateAndStatusTrue(String state);
	public List<Property> findByStateAndStatusTrueOrderByPriceAsc(String state);
	public List<Property> findByStateAndStatusTrueOrderByPriceDesc(String state);
	
	////////////////////////////////////// Rooms ////////////////////////////////////////////////
	
	public List<Property> findByNbrRoomsAndStatusTrue(int nbrRooms);
	public List<Property> findByNbrRoomsAndStatusTrueOrderByPriceAsc(int nbrRooms);
	public List<Property> findByNbrRoomsAndStatusTrueOrderByPriceDesc(int nbrRooms);
	
	public List<Property> findByNbrRoomsAndNbrFloorAndNbrBathroomsAndStatusTrue(int nbrRooms,int nbrFloor,int nbrBathrooms);
	
    ////////////////////////////////////// Statistic ////////////////////////////////////////////////
	
	public double averagepricebystate(String state);
	public double averagepricebycity(String city);
	
	public double averagesurfacebystate(String state);
	public double averagesurfacebycity(String city);
	
	public double pricepermeterstate(String state);

}
