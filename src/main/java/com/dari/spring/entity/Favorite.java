package com.dari.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Favorite implements Serializable {

	
	
	
	private static final long serialVersionUID = 1L;
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	
	@OneToOne
	private Client user;
	
	@ManyToOne
	private Property property;
	
	

	public Favorite() {
		super();
		
	}
	public Favorite( Client user, Property property) {
		super();
		this.user = user;
		this.property = property;
	}
		
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Client getUser() {
		return user;
	}
	public void setUser(Client user) {
		this.user = user;
	}
	public Property getProperty() {
		return property;
	}
	public void setProperty(Property property) {
		this.property = property;
		
	}
}
