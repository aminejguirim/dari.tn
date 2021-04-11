package com.spring.dev.home.AuthApp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;





@Entity
public class Localisation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private float latitude;
	
	private float longtitude;
	
	@OneToOne
	private Property property;


	public Localisation() {
		super();
	}
	
	public Localisation(int id, float latitude, float longtitude, Property property ) {
		
		this.id = id;
		this.latitude = latitude;
		this.longtitude = longtitude;
		this.property = property;
	}
	

	public Localisation(float latitude, float longtitude, Property property) {
		super();
		this.latitude = latitude;
		this.longtitude = longtitude;
		this.property = property;
	}
	
	

	public Localisation(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public float getLatitude() {
		return latitude;
	}


	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}


	public float getLongtitude() {
		return longtitude;
	}


	public void setLongtitude(float longtitude) {
		this.longtitude = longtitude;
	}

	public Property getProperty() {
		return property;
	}


	public void setAsset(Property property) {
		this.property = property;
	}
	
	
}