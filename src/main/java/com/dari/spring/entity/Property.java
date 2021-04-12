package com.dari.spring.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;

import org.hibernate.annotations.CreationTimestamp;

import com.dari.spring.entity.Localisation;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
public class Property implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private User user;
	
	private String ref;
	private String description;
	
	
	@Enumerated(EnumType.STRING)
	private PropertyType type;
	
	@CreationTimestamp
	private Date addedDate;
	
	private float price;
	private float surface;
	private String street;
	private String city;
	private String state;
	private String postalCode;
	private int nbrRooms;
	private int nbrFloor; // Numbers of floors in the building
	private int floor; // Apartment is situated at floor number X
	private int nbrBathrooms;
	private boolean furnished;
	private boolean garage;
	private boolean parking;
	private boolean pool;
	
	@Enumerated(EnumType.STRING)
	private PropertyCategory category;
	
	private String availability; // "Available" or "Sold" or "Rented"
	private boolean status; // True = administrator confirmed it; False= Administrator refused the adv
	
	@OneToOne(mappedBy="property")
	private Localisation localisation;
	
	@OneToMany(mappedBy = "property" , fetch=FetchType.LAZY)   
    private List<Visit> visit = new ArrayList<>();
	
	@OneToMany(mappedBy = "property", fetch = FetchType.LAZY)
	private List<VisitTime> time = new ArrayList<>();
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@JsonBackReference(value="user-property")
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
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
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
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
	public boolean isPool() {
		return pool;
	}
	public void setPool(boolean pool) {
		this.pool = pool;
	}
	public PropertyCategory getCategory() {
		return category;
	}
	public void setCategory(PropertyCategory category) {
		this.category = category;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Property() {
		super();
	}
	
	
	public Property(int id) {
		super();
		this.id = id;
	}

	
	public Localisation getLocalisation() {
		return localisation;
	}
	public void setLocalisation(Localisation localisation) {
		this.localisation = localisation;
	}
	
	
	@JsonManagedReference(value="visit-property")
	public List<Visit> getVisit() {
		return visit;
	}
	public void setVisit(List<Visit> visit) {
		this.visit = visit;
	}
	
	@JsonManagedReference(value="property-time")
	public List<VisitTime> getTime() {
		return time;
	}
	public void setTime(List<VisitTime> time) {
		this.time = time;
	}
	
	
	public void addVisit(Visit visit)
	{
		this.visit.add(visit);
		visit.setProperty(this);
	}
	
	public void addTime(VisitTime vit)
	{
		this.time.add(vit);
		vit.setProperty(this);
	}
	
	
	
	public Property(int id, User user, String ref, String description, PropertyType type, Date addedDate, float price,
			float surface, String street, String city, String state, String postalCode, int nbrRooms, int nbrFloor,
			int floor, int nbrBathrooms, boolean furnished, boolean garage, boolean parking, boolean pool,
			PropertyCategory category, String availability, boolean status,Localisation localisation) {
		super();
		this.id = id;
		this.user = user;
		this.ref = ref;
		this.description = description;
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
		this.availability = availability;
		this.status = status;
		this.localisation = localisation;
	}
	
	

}