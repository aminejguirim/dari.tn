package com.spring.dev.home.AuthApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dev.home.AuthApp.model.Reclamation;
import com.spring.dev.home.AuthApp.service.ReclamationServiceImp;

@RestController
public class ReclamationController {

	@Autowired
	private ReclamationServiceImp service ;
	@PostMapping("/reclamation/add")
	public Reclamation addReclamation(@RequestBody Reclamation reclamation) {
		return service.saveReclamation(reclamation) ;
		
	}
	@GetMapping("/reclamation/getall")
	public List<Reclamation> findAllReclamations(){
		return service.getReclamations();
		
	}
	
      @DeleteMapping("/reclamation/delete/{idRec}")
    	  public String deleteReclamation(@PathVariable Long idRec){
    	  return service.deleteReclamations(idRec);
		
	}
	
      
}
