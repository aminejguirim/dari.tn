package com.spring.dev.home.AuthApp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="T_RECLAMATION")
public class Reclamation implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idRec")
	private Long idRec ;
    @Column(name="description")
	private String description ;
	@Enumerated
	@Column(name="typeRec")
	private TypeRec typeRec ;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dateDebut")
	private Date dateDebut ;
	@Temporal(TemporalType.DATE)
	@Column(name="dateFin")
	private Date dateFin ;
	
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user ;
	
	public Long getIdRec()
	{
		return idRec;
	}
	public void setIdRec(Long idRec) {
		this.idRec = idRec;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public TypeRec getTypeRec() {
		return typeRec;
	}
	public void setTypeRec(TypeRec typeRec) {
		this.typeRec = typeRec;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	
	
	
	
	
	
	
	

}
