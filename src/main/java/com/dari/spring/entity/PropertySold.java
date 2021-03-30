package com.dari.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class PropertySold implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id ;
	
	
	
	@OneToOne(mappedBy="adsSold")
	Property ads;
	
	

	public PropertySold() {
		super();
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Property getAds() {
		return ads;
	}



	public void setAds(Property ads) {
		this.ads = ads;
	}



	public PropertySold(Long id, Property ads) {
		super();
		this.id = id;
		this.ads = ads;
	}

	

}