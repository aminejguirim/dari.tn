package com.dari.spring.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;




@Entity

@Table(name="Client")
public class Client {
	
	
	
	
	
	
	
	
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="IDC")
	private int idc; 

	
	
	
	
	
	
	public int getIdc() {
		return idc;
	}

	public void setIdc(int idc) {
		this.idc = idc;
	}



		
}


