package com.dari.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dari.spring.entity.Localisation;
import com.dari.spring.repository.LocalisationRepository;


@Service
public class LocalisationServiceImpl implements  ILocalisationService {
	
	
	private final Logger log = LoggerFactory.getLogger(LocalisationServiceImpl.class);

	@Autowired
	LocalisationRepository localRepo;

	@Override
	public Localisation createLocalisation(Localisation local) {
        log.info("Creating localisation {}", local);

		return localRepo.save(local);
	}

	
	
	
	

	@Override
	public void updateLocalisation(int id, float latitude, float longtitude) {
		Localisation local = localRepo.findById(id).get();
		local.setLatitude(latitude);
		local.setLongtitude(longtitude);
        log.info("updating localisation {}", local);
		localRepo.save(local);
	}
	
	@Override
	public String findLocalisationOfAsset(int idProperty) {
		String X = localRepo.findLatitudeByAsset(idProperty);
		String Y = localRepo.findLongtitudeByAsset(idProperty);
		
        log.info("latitude is  {}", X , "Longtitude is {}", Y);

		return "Latitude is "+ X +" Longtitude is " + Y;
	}

	@Override
	public void deleteLocalisation(int id) {
		localRepo.deleteById(id);
	}
}
	
