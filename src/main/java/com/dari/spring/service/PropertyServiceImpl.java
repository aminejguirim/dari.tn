package com.dari.spring.service;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dari.spring.entity.Property;
import com.dari.spring.entity.User;
import com.dari.spring.repository.PropertyRepository;
import com.dari.spring.repository.UserRepository;



@Service
public class PropertyServiceImpl implements IPropertyService {
	
	@Autowired
	PropertyRepository aar;

	@Autowired
	UserRepository uar;
	
	
	
	@Override
	public Property save(Property property) {	
		return aar.save(property);
	}

	
	/* Sends a request to add advertisement
		//public void addProperty(int idUser, Property property) {
			//LocalDate today = LocalDate.now();
			//String cat = property.getCategory().toString();
			String cat1 = cat.substring(0, 2);

			int hour = LocalDateTime.now().getHour();
			String h = String.valueOf(hour);
			int min = LocalDateTime.now().getMinute();
			String m = String.valueOf(min);
			int sec = LocalDateTime.now().getSecond();
			String s = String.valueOf(sec);

			String ref = today.toString() + cat1.toUpperCase() + h + m + s;

			User u = uar.findById(idUser).get();
			u.addProperty(property);
			property.setRef(ref);
			property.setStatus(false);
			aar.save(property);
		}*/
		
		// Administrator accepts advertisement
		public void acceptProperty(int id) {
			Property property = aar.findById(id).get();
			property.setStatus(true);

			//String ref = property.getRef();
			aar.save(property);
			// log.debug("Accepted advertisement by Administrator for Asset: {}",
			// ref);
		}
		
		// Shows all requests to add advertisements FOR ADMIN
		public List<Property> findByStatusFalse() {
			return aar.findByStatusFalse();
		}

		@Override
		public void updateProperty(int id, Property newProperty) {
			Property property = aar.findById(id).get();
			property.setPrice(newProperty.getPrice());
			property.setDescription(newProperty.getDescription());
			property.setType(newProperty.getType());
			property.setSurface(newProperty.getSurface());
			property.setStreet(newProperty.getStreet());
			property.setCity(newProperty.getCity());
			property.setState(newProperty.getState());
			property.setPostalCode(newProperty.getPostalCode());
			property.setNbrRooms(newProperty.getNbrRooms());
			property.setNbrFloor(newProperty.getNbrFloor());
			property.setFloor(newProperty.getFloor());
			property.setParking(newProperty.isParking());
			property.setNbrBathrooms(newProperty.getNbrBathrooms());
			property.setFurnished(newProperty.isFurnished());
			property.setCategory(newProperty.getCategory());
			aar.save(property);
			
		}
		
		public void deleteProperty(int id) {
			aar.deleteById(id);
		}
		
		public Property findpropertybyid(int id) {
			return aar.findById(id).get();
		}
		
		// Search by State
		public List<Property> findByStateAndStatusTrue(String state) {
			return aar.findByStateAndAvailabilityAndStatusTrue(state, "Available");
		}
		
		
		@Override
		public double averagepricebystate(String state) {
			List<Property> liste = aar.findByStateAndAvailabilityAndStatusTrue(state, "Available");
			double moyenne = 0;
			double prix = 0;
			int number = liste.size();
			for (int i = 0; i < number; i++) {
				prix = prix + liste.get(i).getPrice();
			}

			moyenne = prix / number;
			return moyenne;
		}
		

}



