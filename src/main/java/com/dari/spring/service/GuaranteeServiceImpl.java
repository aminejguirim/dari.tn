package com.dari.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dari.spring.entity.Client;
import com.dari.spring.entity.GuaranteeDocument;
import com.dari.spring.entity.Property;
import com.dari.spring.entity.RentGuarantee;
import com.dari.spring.repository.ClientRepository;
import com.dari.spring.repository.DocumentsRepository;
import com.dari.spring.repository.PropertyRepository;
import com.dari.spring.repository.RentGuaranteeRepository;

public class GuaranteeServiceImpl {
	
	

	@Autowired
	DocumentsRepository drep;
	@Autowired
	RentGuaranteeRepository grep;
	@Autowired
	PropertyRepository prep;
	@Autowired
	ClientRepository urep;
		
	
	public void ajouterGuarantee(int id, int client, RentGuarantee G) {
		Client C=(Client) urep.findById((long) client).get();
		Property p=prep.findById((long) id).get();
		P.addGuarantee(G);
		C.addguarantee(G);
		grep.save(G);
	}

	public void uploaddocumentsguarantee(int id, GuaranteeDocument D) {
		RentGuarantee G=grep.findById(id).get();
		D.setRentGuarantee(G);
		G.setDocument(D);
		drep.save(D);
	}

	public GuaranteeDocument getdocumentbyid(int id) {
		return drep.findById(id).get();
	}

	public RentGuarantee findrentguaranteebyiduserandpropertyid(int id, int id2) {
		List<RentGuarantee> liste=(List<RentGuarantee>) grep.findAll();
		for(int i=0;i<liste.size();i++)
		{
			if((liste.get(i).getProperty().getId()==id2)&&(liste.get(i).getClient().getId()==id))
			{
				return liste.get(i);
			}
		}
		return null;
	}

	public void deleterentguarantee(int id) {
		RentGuarantee G=grep.findById(id).get();
		grep.delete(G);	
	}

	public GuaranteeDocument documentnotbyid(GuaranteeDocument D) {
		return drep.finddocumentnotbyid(D.getRentGuarantee(), D.getImageCin(), D.getEngagementProof(), D.getPayProof(), D.getImageJustifPay());		
	}

	public RentGuarantee findrentguarantee(int id) {
		return grep.findById(id).get();
	}

	public void validateguarantee(RentGuarantee G) {
		grep.save(G);
		
	}
	

	public List<RentGuarantee> allguaranteesofasset(int id) {
		Property p=prep.findById((long) id).get();
		return A.getGuarantees();
	}
	
	

}
