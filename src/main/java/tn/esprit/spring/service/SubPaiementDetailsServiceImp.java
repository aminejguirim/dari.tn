package tn.esprit.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.SubPaiementDetails;
import tn.esprit.spring.repository.SubPaiementDetailsRepository;

@Service
public class SubPaiementDetailsServiceImp implements ISubPaiementDetails {

	@Autowired
	SubPaiementDetailsRepository sr ;
	SubPaiementDetails subdet ;
	
	private static final Logger L = LogManager.getLogger(SubPaiementDetailsServiceImp.class) ;
	
	public SubPaiementDetails addSubDetails(SubPaiementDetails subdet){
		return sr.save(subdet) ;
	}
	
	public void save(SubPaiementDetails subdet) {
		sr.save(subdet) ;
	}
	
	public List<SubPaiementDetails> listAll() {
		return sr.findAll() ;
	}
	
	public String delete(Long cardNum) {
		sr.deleteById(cardNum);
		return "Detail removed" ; 
	}

}
