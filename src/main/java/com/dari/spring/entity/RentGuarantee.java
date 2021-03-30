package com.dari.spring.entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="RentGuarantees")

public class RentGuarantee implements Serializable {
	
	
	
	private static final long serialVersionUID = 1L;
	
	
	
	public RentGuarantee()
	{
		super();
	}
	
	

	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id; 
	
	
	@Temporal (TemporalType.DATE)
	private Date creationDate;
	
	
	@Temporal (TemporalType.DATE)
	private Date expirationDate;
	
	@Column(name="STATUS")
	private boolean status;
	
	
	
   
	
	
	


	@OneToOne(cascade = CascadeType.ALL, mappedBy="rentGuarantee")
	private GuaranteeDocument guaranteeDocument;
	
	@ManyToOne
	@JoinColumn(name ="id RentG") 
	
	private Property property;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
		
	@JsonManagedReference(value="guarantee-document")
	public GuaranteeDocument getDocument() {
		return guaranteeDocument;
	}


	public void setDocument(GuaranteeDocument guaranteeDocument) {
		this.guaranteeDocument = guaranteeDocument;
	} 
	
	@JsonBackReference
	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	 
		

		public RentGuarantee(int id, Date creationDate, Date expirationDate, boolean status, GuaranteeDocument guaranteeDocument,
				Client client, Property property) {
			super();
			this.id = id;
			this.creationDate = creationDate;
			this.expirationDate = expirationDate;
			this.status = status;
			this.guaranteeDocument = guaranteeDocument;
			
			this.property = property;
		}
	
}
