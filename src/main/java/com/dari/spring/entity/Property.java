package com.dari.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table (name ="property")
public class Property implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	//private User user;
	private String ref;
	private String description;
	@Enumerated(EnumType.STRING)
	private PropertyType type;
	
	@Temporal(TemporalType.DATE)
	private Date addedDate;
	
	private float price;
	private float surface;
	private String street;
	private String city;
	private String state;
	private int nbrRooms;
	private int nbrBathrooms;
	private boolean furnished;
	private boolean parking;
	@Enumerated(EnumType.STRING)
	private PropertyCategory category;
	@Enumerated(EnumType.STRING)
	private RentType rentType;
	private String availability; // "Available" or "Sold" or "Rented"
	private boolean status; // True = administrator confirmed it; False= Administrator refused the adv
	
	@OneToMany (mappedBy="property")
	private List<RentGuarantee> guarantees;
	
	
	public List<RentGuarantee> getGuarantees() {
		return guarantees;
	}

	public void setGuarantees(List<RentGuarantee> guarantees) {
		this.guarantees = guarantees;
	}

	@OneToOne

	private PropertySold adsSold;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public int getNbrRooms() {
		return nbrRooms;
	}

	public void setNbrRooms(int nbrRooms) {
		this.nbrRooms = nbrRooms;
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

	public RentType getRentType() {
		return rentType;
	}

	public void setRentType(RentType rentType) {
		this.rentType = rentType;
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

	public PropertySold getAdsSold() {
		return adsSold;
	}

	public void setAdsSold(PropertySold adsSold) {
		this.adsSold = adsSold;
	}

	public Property() {
		super();
	}

	public Property(Long id, String ref, String description, PropertyType type, Date addedDate, float price, float surface,
			String street, String city, String state, int nbrRooms, int nbrBathrooms, boolean furnished,
			boolean parking, PropertyCategory category, RentType rentType, String availability, boolean status,
			PropertySold adsSold) {
		super();
		this.id = id;
		this.ref = ref;
		this.description = description;
		this.type = type;
		this.addedDate = addedDate;
		this.price = price;
		this.surface = surface;
		this.street = street;
		this.city = city;
		this.state = state;
		this.nbrRooms = nbrRooms;
		this.nbrBathrooms = nbrBathrooms;
		this.furnished = furnished;
		this.parking = parking;
		this.category = category;
		this.rentType = rentType;
		this.availability = availability;
		this.status = status;
		this.adsSold = adsSold;
	}
	
	

}	