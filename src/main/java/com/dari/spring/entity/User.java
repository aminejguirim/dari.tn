package com.dari.spring.entity;




import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String login;
	
	private String password;
	
	private String phoneNumber;
	
	private String postalCode;
	
	
	
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="user")
	private List<Property> property;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="user")
	private List<Favorite> favoris=new ArrayList<Favorite>();

	



	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getFirstName() {
		return firstName;
	}




	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getLogin() {
		return login;
	}




	public void setLogin(String login) {
		this.login = login;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getPhoneNumber() {
		return phoneNumber;
	}




	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}




	public String getPostalCode() {
		return postalCode;
	}




	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}




	public List<Property> getProperty() {
		return property;
	}




	public void setProperty(List<Property> property) {
		this.property = property;
	}
	
	public void addProperty(Property aa)
	{
		this.property.add(aa);
		aa.setUser(this);
	}
	
	@JsonManagedReference(value="user-favoris")
	public List<Favorite> getFavoris() {
		return favoris;
	}

	public void setFavoris(List<Favorite> favoris) {
		this.favoris = favoris;
	}



	


	public User() {
		super();
	}




	public User(int id) {
		super();
		this.id = id;
	}
	
	public void addFavorite(Favorite F)
	{
		F.setUser(this);
		this.favoris.add(F);
	}




	
	


}