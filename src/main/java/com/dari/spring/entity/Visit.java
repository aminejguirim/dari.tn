package com.dari.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Visit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	

	@Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date date;
	
	@ManyToOne(fetch = FetchType.EAGER )
	@JoinColumn(name = "property")
	private Property property;
	
	
	private String place;
	
	@OneToOne(fetch= FetchType.EAGER)
	private User client;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private VisitTime time;

	public Visit(int id, Date date, Property property, String place, User client, VisitTime time) {
		super();
		this.id = id;
		this.date = date;
		this.property = property;
		this.place = place;
		this.client = client;
		this.time = time;
	}

	public Visit() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@JsonBackReference(value="visit-property")
	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@JsonBackReference(value="visit-user")
	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	@JsonBackReference(value="time-visits")
	public VisitTime getTime() {
		return time;
	}

	public void setTime(VisitTime time) {
		this.time = time;
	}

	
	
	
	

}
