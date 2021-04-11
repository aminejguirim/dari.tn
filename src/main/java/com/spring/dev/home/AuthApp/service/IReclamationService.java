package com.spring.dev.home.AuthApp.service;

import com.spring.dev.home.AuthApp.model.Reclamation;

public interface IReclamationService {
	
	public Reclamation saveReclamation(Reclamation reclamation) ;
	public String deleteReclamations(Long idRec) ;
	
	

}