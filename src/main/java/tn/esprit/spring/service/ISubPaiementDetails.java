package tn.esprit.spring.service;

import tn.esprit.spring.entity.SubPaiementDetails;

public interface ISubPaiementDetails {

	public void save(SubPaiementDetails subdet);
	public SubPaiementDetails addSubDetails(SubPaiementDetails subdet);
	public String delete(Long cardNum) ;
}
