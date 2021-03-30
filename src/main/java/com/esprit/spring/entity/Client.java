package com.esprit.spring.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="T_Client")
public class Client implements Serializable {

	
private static final long serialVersionUID = 1L;


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idClient;
@OneToMany(targetEntity=Reclamation.class, mappedBy="client")
private List<Reclamation> reclamations = new ArrayList<>();

public Long getIdClient() {
	return idClient;
}
public void setIdClient(Long idClient) {
	this.idClient = idClient;
}




	
}
