package tn.amir.projet.services.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.amir.projet.entity.Property;
import tn.amir.projet.entity.User;
import tn.amir.projet.repository.PropertyRepository;
import tn.amir.projet.repository.UserRepository;
import tn.amir.projet.services.IPropertyService;

@Service
public class PropertyServiceImpl implements IPropertyService {
	
	@Autowired
	PropertyRepository aar;

	@Autowired
	UserRepository uar;
	
	
	
	// Sends a request to add advertisement
		public void addProperty(int idUser, Property property) {
			LocalDate today = LocalDate.now();
			String cat = property.getCategory().toString();
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
		}
		
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
		
		///////////////////////////////////// Price /////////////////////////////////////////////
		
		public List<Property> findByPriceMinMaxPriceAsc(float pricemin,float pricemax) {
			return aar.findByPriceMinMaxPriceAsc(pricemin, pricemax, "Available",true);
		}
		
		public List<Property> findByPriceMinMaxPriceDesc(float pricemin,float pricemax) {
			return aar.findByPriceMinMaxPriceDesc(pricemin, pricemax, "Available",true);
		}
		
		public List<Property> findByPriceMinMaxSurfaceAsc(float pricemin,float pricemax) {
			return aar.findByPriceMinMaxSurfaceAsc(pricemin, pricemax, "Available",true);
		}
		
		public List<Property> findByPriceMinMaxSurfaceDesc(float pricemin,float pricemax) {
			return aar.findByPriceMinMaxSurfaceDesc(pricemin, pricemax, "Available",true);
		}
		
		public List<Property> findByPriceAndStatusTrue(float price) {
			return aar.findByPriceAndAvailabilityAndStatusTrue(price, "Available");
		}
		
		/////////////////////////////////// Surface ////////////////////////////////////////////////
		
		public List<Property> findBySurfaceAndStatusTrue(float surface) {
			return aar.findBySurfaceAndAvailabilityAndStatusTrue(surface, "Available");
		}
		
		public List<Property> findBySurfaceAndStatusTrueOrderByPriceAsc(float surface) {
			return aar.findBySurfaceAndAvailabilityAndStatusTrueOrderByPriceAsc(surface, "Available");
		}
		
		public List<Property> findBySurfaceAndStatusTrueOrderByPriceDesc(float surface) {
			return aar.findBySurfaceAndAvailabilityAndStatusTrueOrderByPriceDesc(surface, "Available");
		}
		
		////////////////////////////////// City //////////////////////////////////////////////////////
		
		public List<Property> findByCityAndStatusTrue(String city) {
			return aar.findByCityAndAvailabilityAndStatusTrue(city, "Available");
		}
		
		public List<Property> findByCityAndStatusTrueOrderByPriceAsc(String city) {
			return aar.findByCityAndAvailabilityAndStatusTrueOrderByPriceAsc(city, "Available");
		}
		
		public List<Property> findByCityAndStatusTrueOrderByPriceDesc(String city) {
			return aar.findByCityAndAvailabilityAndStatusTrueOrderByPriceDesc(city, "Available");
		}
		
		//////////////////////////////// State ////////////////////////////////////////////////////
		
		
		public List<Property> findByStateAndStatusTrue(String state) {
			return aar.findByStateAndAvailabilityAndStatusTrue(state, "Available");
		}
		
		public List<Property> findByStateAndStatusTrueOrderByPriceAsc(String state) {
			return aar.findByStateAndAvailabilityAndStatusTrueOrderByPriceAsc(state, "Available");
		}
		
		public List<Property> findByStateAndStatusTrueOrderByPriceDesc(String state){
			return aar.findByStateAndAvailabilityAndStatusTrueOrderByPriceDesc(state, "Available");
		}
		
        //////////////////////////////// Rooms ////////////////////////////////////////////////////
		
		public List<Property> findByNbrRoomsAndStatusTrue(int nbrRooms) {
			return aar.findByNbrRoomsAndAvailabilityAndStatusTrue(nbrRooms, "Available");
		}
		
		public List<Property> findByNbrRoomsAndStatusTrueOrderByPriceAsc(int nbrRooms) {
			return aar.findByNbrRoomsAndAvailabilityAndStatusTrueOrderByPriceAsc(nbrRooms, "Available");
		}
		
		public List<Property> findByNbrRoomsAndStatusTrueOrderByPriceDesc(int nbrRooms) {
			return aar.findByNbrRoomsAndAvailabilityAndStatusTrueOrderByPriceDesc(nbrRooms, "Available");
		}
		
		public List<Property> findByNbrRoomsAndNbrFloorAndNbrBathroomsAndStatusTrue(int nbrRooms, int nbrFloor,
				int nbrBathrooms) {
			return aar.findByNbrRoomsAndNbrFloorAndNbrBathroomsAndAvailabilityAndStatusTrue(nbrRooms, nbrFloor,
					nbrBathrooms, "Available");
		}


}
