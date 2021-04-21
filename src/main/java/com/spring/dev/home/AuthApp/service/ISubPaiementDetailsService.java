package com.spring.dev.home.AuthApp.service;

import java.util.List;

import com.spring.dev.home.AuthApp.model.SubPaiementDetails;


public interface ISubPaiementDetailsService {

	public void save(SubPaiementDetails subdet);
	public List<SubPaiementDetails> listAll();
	public SubPaiementDetails addSubDetails(SubPaiementDetails subdet);
	public String delete(Long cardNum) ;
}
