package com.spring.dev.home.AuthApp.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dev.home.AuthApp.model.Reclamation;
import com.spring.dev.home.AuthApp.repository.Reclamationrepository;

@Service
public class ReclamationServiceImp implements IReclamationService {

	@Autowired
	Reclamationrepository reclamationrepository;

	public Reclamation saveReclamation(Reclamation reclamation) {
		reclamation.setDateDebut(new Date(System.currentTimeMillis()));
		return reclamationrepository.save(reclamation);

	}

	public List<Reclamation> saveReclamations(List<Reclamation> reclamations) {
		return reclamationrepository.saveAll(reclamations);

	}

	public List<Reclamation> getReclamations() {
		return reclamationrepository.findAll();

	}

	public String deleteReclamations(Long idRec) {
		reclamationrepository.deleteById(idRec);
		return "reclamation removed";

	}

	// public Reclamation updateReclamation(Reclamation reclamation) {

	// Reclamation existingReclamation = Reclamationrepository.
}
// }
