package com.spring.dev.home.AuthApp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
public class Wish implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private User user;
	private String ref;
	@Enumerated(EnumType.STRING)
	private PropertyType type;
	@Temporal(TemporalType.DATE)
	private Date addedDate;
	private float price;
	private float surface;
	private String street;
	private String city;
	private String state;
	private String postalCode;
	private int nbrRooms;
	private int nbrFloor; // Numbers of floors in the building
	private int floor; // Appartment is situated at floor number X
	private int nbrBathrooms;
	private boolean furnished;
	private boolean garage;
	private boolean parking;
	private boolean pool;
	@Enumerated(EnumType.STRING)
	private PropertyCategory category;
	
	

	public Wish() {
		super();

	}

//const

	public Wish(int id, User user, String ref, PropertyType type, Date addedDate, float price, float surface, String street,
			String city, String state, String postalCode, int nbrRooms, int nbrFloor, int floor, int nbrBathrooms,
			boolean furnished, boolean garage, boolean parking, boolean pool, PropertyCategory category 
			) {
		super();
		this.id = id;
		this.user = user;
		this.ref = ref;
		this.type = type;
		this.addedDate = addedDate;
		this.price = price;
		this.surface = surface;
		this.street = street;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.nbrRooms = nbrRooms;
		this.nbrFloor = nbrFloor;
		this.floor = floor;
		this.nbrBathrooms = nbrBathrooms;
		this.furnished = furnished;
		this.garage = garage;
		this.parking = parking;
		this.pool = pool;
		this.category = category;
		
				}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@JsonBackReference(value="user-wish")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public PropertyType getType() {
		return type;
	}

	public void setType(PropertyType type) {
		this.type = type;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getSurface() {
		return surface;
	}

	public void setSurface(float surface) {
		this.surface = surface;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getNbrRooms() {
		return nbrRooms;
	}

	public void setNbrRooms(int nbrRooms) {
		this.nbrRooms = nbrRooms;
	}

	public int getNbrFloor() {
		return nbrFloor;
	}

	public void setNbrFloor(int nbrFloor) {
		this.nbrFloor = nbrFloor;
	}

	public int getNbrBathrooms() {
		return nbrBathrooms;
	}

	public void setNbrBathrooms(int nbrBathrooms) {
		this.nbrBathrooms = nbrBathrooms;
	}

	public boolean isFurnished() {
		return furnished;
	}

	public void setFurnished(boolean furnished) {
		this.furnished = furnished;
	}

	public boolean isGarage() {
		return garage;
	}

	public void setGarage(boolean garage) {
		this.garage = garage;
	}

	public boolean isParking() {
		return parking;
	}

	public void setParking(boolean parking) {
		this.parking = parking;
	}

	public PropertyCategory getCategory() {
		return category;
	}

	public void setCategory(PropertyCategory category) {
		this.category = category;
	}


	

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public boolean isPool() {
		return pool;
	}

	public void setPool(boolean pool) {
		this.pool = pool;
	}

}
