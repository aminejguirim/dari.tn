package com.spring.dev.home.AuthApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dev.home.AuthApp.model.SubPaiementDetails;
import com.spring.dev.home.AuthApp.service.SubPaiementDetailsService;



@RestController
public class SubPaiemenetDetailsController {
	@Autowired
	SubPaiementDetailsService sds ;
	SubPaiementDetails subdet ;
	
	@GetMapping("/details/all")
    public ResponseEntity<List<SubPaiementDetails>> getAllDetails() {
        return ResponseEntity.ok(sds.listAll());
    }
	
	@PostMapping("/details/add")
	public SubPaiementDetails saveSubdets(@RequestBody SubPaiementDetails subdet){
		return sds.addSubDetails(subdet) ;
	}
	
	@DeleteMapping("/detail/delete/{cardNum}")
	public String deleteSubDetails(@PathVariable Long cardNum){
		return sds.delete(cardNum);
	}

}
