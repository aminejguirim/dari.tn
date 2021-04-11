package com.dari.spring.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class VisitTime implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int id;

	private Date date;
	private int hstart;
	private int mstart;
	private int hend;
	private int mend;
	

	/** a timeslot is linked to one Asset */ 
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_property")
	private Property property;
	
	@OneToMany(mappedBy = "time")
	private List<Visit> visits = new ArrayList<>();

	public VisitTime(int id, Date date, int hstart, int mstart, int hend, int mend, Property property,
			List<Visit> visits) {
		super();
		this.id = id;
		this.date = date;
		this.hstart = hstart;
		this.mstart = mstart;
		this.hend = hend;
		this.mend = mend;
		this.property = property;
		this.visits = visits;
	}

	public VisitTime() {
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

	public int getHstart() {
		return hstart;
	}

	public void setHstart(int hstart) {
		this.hstart = hstart;
	}

	public int getMstart() {
		return mstart;
	}

	public void setMstart(int mstart) {
		this.mstart = mstart;
	}

	public int getHend() {
		return hend;
	}

	public void setHend(int hend) {
		this.hend = hend;
	}

	public int getMend() {
		return mend;
	}

	public void setMend(int mend) {
		this.mend = mend;
	}

	@JsonBackReference(value="property-time")
	public Property getProperty() {
		return property;
	}
	
	
	public void setProperty(Property property) {
		this.property = property;
	}

	@JsonManagedReference(value="time-visits")
	public List<Visit> getVisits() {
		return visits;
	}

	public void setVisits(List<Visit> visits) {
		this.visits = visits;
	}
	
	

}
