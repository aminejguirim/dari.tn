package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
@Entity
@Table(name="T_CLIENT")
public class Client implements Serializable  {
	private static final long serialVersionUID = 1L;
	@Column(name="ID_CLIENT")
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
private Long idClient ;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="client")
	private List<Subscription> subscription;


public Long getIdClient() {
	return idClient;
}
public void setIdClient(Long idClient) {
	this.idClient = idClient;
}
}
