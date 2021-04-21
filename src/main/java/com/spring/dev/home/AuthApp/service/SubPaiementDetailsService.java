package com.spring.dev.home.AuthApp.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dev.home.AuthApp.model.SubPaiementDetails;
import com.spring.dev.home.AuthApp.repository.SubPaiementDetailsRepository;



@Service
public class SubPaiementDetailsService implements ISubPaiementDetailsService {


	@Autowired
	SubPaiementDetailsRepository sdr;
	SubPaiementDetails subdet ;
	
	private static final Logger L = LogManager.getLogger(UserService.class) ;
	
	public void save(SubPaiementDetails subdet) {
		sdr.save(subdet) ;
	}
	
	public List<SubPaiementDetails> listAll() {
		return sdr.findAll() ;
	}
	 
	public SubPaiementDetails addSubDetails(SubPaiementDetails subdet){
		return sdr.save(subdet) ;
	}
	
	public String delete(Long cardNum) {
		sdr.deleteById(cardNum);
		return "Detail removed" ; 
	}
}
