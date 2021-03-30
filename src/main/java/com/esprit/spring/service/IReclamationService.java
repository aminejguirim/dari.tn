package com.esprit.spring.service;

import com.esprit.spring.entity.Reclamation;

public interface IReclamationService {
	
	public Reclamation saveReclamation(Reclamation reclamation) ;
	public String deleteReclamations(Long idRec) ;

}
