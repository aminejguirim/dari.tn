package com.dari.spring.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;

import com.dari.spring.entity.Property;
import com.dari.spring.entity.User;
import com.dari.spring.entity.Wish;
import com.dari.spring.repository.PropertyRepository;
import com.dari.spring.repository.UserRepository;
import com.dari.spring.repository.WishRepository;



@Service
public class WishServiceImpl implements IWishService{
	UserRepository UserRepository;
	WishRepository WishRepository;
	PropertyRepository PropertyRepository;
	
	public List<Wish> getAllWishById(int id) {
		User u = (User) UserRepository.findById(id).get();
		return u.getWish();
	}
	
	

	
	@Override
	public void addWish(int user, Wish W) {
		User U = (User) UserRepository.findById(user).get();
		java.util.Date date = java.sql.Date.valueOf(LocalDate.now());
		W.setAddedDate(date);
		U.addWish(W);
		WishRepository.save(W);
		
		
	}
	
	
	@Override
	public boolean comparewishasset(Wish W, Property P) {

		if (W.getState().equals(P.getState())) {
			if (W.getCity().equals(P.getCity())) {
				if (W.getCategory() == P.getCategory()) {

					if ((W.isFurnished() == P.isFurnished()) 
							&& (W.isParking() == P.isParking())
							
					        && (W.getNbrRooms() == P.getNbrRooms()) 
                            && (W.getNbrBathrooms() == P.getNbrBathrooms())
							&& (W.getSurface() == P.getSurface())) {
						return true;
					}

					return true;
				}
			}
		}
		return false;
	}



@Override
	public List<Property> searchassetadvlikewish(Wish W) {
		List<Property> Properties = (List<Property>) PropertyRepository.findAll()         ;
		List<Property> finalliste = new ArrayList<Property>();
		for (int i = 0; i < Properties.size(); i++) {
			Property P = Properties.get(i);
			if (this.comparewishasset(W, P) == true) {
				finalliste.add(P);
			}
		}
		return finalliste;
	}
	
   

}
