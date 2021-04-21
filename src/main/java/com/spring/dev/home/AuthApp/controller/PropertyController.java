package com.spring.dev.home.AuthApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dev.home.AuthApp.model.Property;
import com.spring.dev.home.AuthApp.model.User;
import com.spring.dev.home.AuthApp.repository.PropertyRepository;
import com.spring.dev.home.AuthApp.repository.UserRepository;
import com.spring.dev.home.AuthApp.service.IPropertyService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;



@RestController
public class PropertyController {
	
	@Autowired
	IPropertyService aas;

	@Autowired
	PropertyRepository aar;
	
	@Autowired
	UserRepository ur;

	@Autowired
	private JavaMailSender emailSender;
	
	// http://localhost:8082/Dari/servlet/addProperty/{iduser}
		@PostMapping("/addProperty/{iduser}")
		@ResponseBody
		public ResponseEntity<String> addAssetAdv(@PathVariable("iduser") int iduser, @RequestBody Property aa) {
			User u=ur.findById(iduser).get();
			

				aas.addProperty(iduser, aa);
				
				String s = "+216" + aa.getUser().getPhoneNumber();

				sendSms(s, "+14044917812", "You have requested to add a property");

				
				sendEmail(u.getEmail(), "Request sent",
						"You have requested to add a property , please wait for the administrator to accept it");
				return new ResponseEntity<>("Request sent for property " + aa.getRef(), HttpStatus.CREATED);
				
		}
	
	public void sendEmail(String to, String subject, String text) {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("daritn6@gmail.com");
			message.setTo(to);
			message.setSubject(subject);
			message.setText(text);
			emailSender.send(message);
		} catch (Exception e) {

			e.printStackTrace();

		}

	}
	
	// http://localhost:8082/Dari/servlet/acceptProperty/{id}
		@PutMapping("/acceptProperty/{id}")
		@ResponseBody
		public void acceptAssetAdv(@PathVariable("id") int id) {
			aas.acceptProperty(id);
		}
		
		// Shows all requests to add advertisements FOR ADMIN
		// http://localhost:8082/Dari/servlet/StatusFalse
		@GetMapping("/StatusFalse")
		@ResponseBody
		public List<Property> findByStatusFalse() {
			return aas.findByStatusFalse();
		}
		
		// http://localhost:8082/Dari/servlet/updateProperty/{id}

		@PutMapping("/updateProperty/{id}")
		@ResponseBody
		public ResponseEntity<String> updateProperty(@PathVariable("id") int id, @RequestBody Property aa) {
			Property asset = aar.findById(id).get();
				aas.updateProperty(id, aa);
		
		return new ResponseEntity<>("Succesful update for property " + asset.getRef(), HttpStatus.CREATED);
		}
		
		// http://localhost:8082/Dari/servlet/Property/delete/{id}
		@DeleteMapping("Property/delete/{id}")
		public ResponseEntity<String> deleteProperty(@PathVariable("id") int id) {
			aas.deleteProperty(id);
			return new ResponseEntity<>("Suppression reussie.", HttpStatus.OK);
		}
		
		// http://localhost:8082/Dari/servlet/getProperty/{id}
		@GetMapping("/getProperty/{id}")
		@ResponseBody
		public Property getAssetAdv(@PathVariable("id") int id) {
			return aas.findpropertybyid(id);
		}
		
		
		
		public void sendSms(String to, String from, String body) {

			try {
				Twilio.init("AC4a30225de4e58465a1bb6e3a9b0348d5", "9954fb698ee18d2506d6fdaeadbdf682");
				Message message = Message.creator(new PhoneNumber(to), new PhoneNumber(from), body).create();

			} catch (Exception e) {

				e.printStackTrace();

			}

		}
		
		//////////////////////////// Price /////////////////////////////////////////
		
		// http://localhost:8088/Dari/servlet/PriceAsc/{pricemin}/{pricemax}
		@GetMapping("/PriceAsc/{pricemin}/{pricemax}")
		@ResponseBody
		public List<Property> findByPriceAscMaxMin(@PathVariable("pricemin") float pricemin,@PathVariable("pricemax") float pricemax) {
			return aas.findByPriceMinMaxPriceAsc(pricemin,pricemax);
		}
		
		// http://localhost:8088/Dari/servlet/PriceDesc/{pricemin}/{pricemax}
		@GetMapping("/PriceDesc/{pricemin}/{pricemax}")
		@ResponseBody
		public List<Property> findByPriceDescMaxMin(@PathVariable("pricemin") float pricemin,@PathVariable("pricemax") float pricemax) {
			return aas.findByPriceMinMaxPriceDesc(pricemin,pricemax);
		}
		
		// http://localhost:8088/Dari/servlet/PriceSurfAsc/{pricemin}/{pricemax}
		@GetMapping("/PriceSurfAsc/{pricemin}/{pricemax}")
		@ResponseBody
		public List<Property> findByPriceMaxMinSurfaceAsc(@PathVariable("pricemin") float pricemin,@PathVariable("pricemax") float pricemax) {
			return aas.findByPriceMinMaxSurfaceAsc(pricemin,pricemax);
		}
		
		// http://localhost:8088/Dari/servlet/PriceSurfDesc/{pricemin}/{pricemax}
		@GetMapping("/PriceSurfDesc/{pricemin}/{pricemax}")
		@ResponseBody
		public List<Property> findByPriceMaxMinSurfaceDesc(@PathVariable("pricemin") float pricemin,@PathVariable("pricemax") float pricemax) {
			return aas.findByPriceMinMaxSurfaceDesc(pricemin,pricemax);
		}	
		
		// http://localhost:8088/Dari/servlet/Price/{price}
		@GetMapping("/Price/{price}")
		@ResponseBody
		public List<Property> findByPriceAndStatusTrue(@PathVariable("price") float price) {
			return aas.findByPriceAndStatusTrue(price);
		}

	////////////////////////////////////////////// Surface /////////////////////////////////////////////////
		
		// http://localhost:8088/Dari/servlet/Surface/{surface}
		@GetMapping("/Surface/{surface}")
		@ResponseBody
		public List<Property> findBySurfaceAndStatusTrue(@PathVariable("surface") float surface) {
			return aas.findBySurfaceAndStatusTrue(surface);
		}
		
		// http://localhost:8088/Dari/servlet/SurfacePriceAsc/{surface}
		@GetMapping("/SurfacePriceAsc/{surface}")
		@ResponseBody
		public List<Property> findBySurfaceAndStatusTrueOrderByPriceAsc(@PathVariable("surface") float surface) {
			return aas.findBySurfaceAndStatusTrueOrderByPriceAsc(surface);
		}
		
		// http://localhost:8088/Dari/servlet/SurfacePriceDesc/{surface}
		@GetMapping("/SurfacePriceDesc/{surface}")
		@ResponseBody
		public List<Property> findBySurfaceAndStatusTrueOrderByPriceDesc(@PathVariable("surface") float surface) {
			return aas.findBySurfaceAndStatusTrueOrderByPriceDesc(surface);
		}
		
		//////////////////////////////////////// City /////////////////////////////////////////////
		
		// http://localhost:8088/Dari/servlet/City/{city}
		@GetMapping("/City/{city}")
		@ResponseBody
		public List<Property> findByCityAndStatusTrue(@PathVariable("city") String city) {
			return aas.findByCityAndStatusTrue(city);
		}
		
		// http://localhost:8088/Dari/servlet/CityPriceAsc/{city}
		@GetMapping("/CityPriceAsc/{city}")
		@ResponseBody
		public List<Property> findByCityAndStatusTrueOrderByPriceAsc(@PathVariable("city") String city) {
			return aas.findByCityAndStatusTrueOrderByPriceAsc(city);
		}
		
		// http://localhost:8088/Dari/servlet/CityPriceDesc/{city}
		@GetMapping("/CityPriceDesc/{city}")
		@ResponseBody
		public List<Property> findByCityAndStatusTrueOrderByPriceDesc(@PathVariable("city") String city) {
			return aas.findByCityAndStatusTrueOrderByPriceDesc(city);
		}
		
		/////////////////////////////////// State //////////////////////////////////////////
		
		// http://localhost:8082/Dari/servlet/State/{state}
		@GetMapping("/State/{state}")
		@ResponseBody
		public List<Property> findByStateAndStatusTrue(@PathVariable("state") String state) {
			return aas.findByStateAndStatusTrue(state);
		}	
		
		// http://localhost:8088/Dari/servlet/StatePriceAsc/{state}
		@GetMapping("/StatePriceAsc/{state}")
		@ResponseBody
		public List<Property> findByStateAndStatusTrueOrderByPriceAsc(@PathVariable("state") String state) {
			return aas.findByStateAndStatusTrueOrderByPriceAsc(state);
		}
		
		// http://localhost:8088/Dari/servlet/StatePriceDesc/{state}
		@GetMapping("/StatePriceDesc/{state}")
		@ResponseBody
		public List<Property> findByStateAndStatusTrueOrderByPriceDesc(@PathVariable("state") String state) {
			return aas.findByStateAndStatusTrueOrderByPriceDesc(state);
		}
		
        /////////////////////////////////// Rooms //////////////////////////////////////////
		
		// http://localhost:8088/Dari/servlet/NbrRooms/{nbrooms}
		@GetMapping("/NbrRooms/{nbrooms}")
		@ResponseBody
		public List<Property> findByNbrRoomsAndStatusTrue(@PathVariable("nbrooms") int nbrooms) {
			return aas.findByNbrRoomsAndStatusTrue(nbrooms);
		}
		
		// http://localhost:8088/Dari/servlet/NbrRoomsPriceAsc/{nbrooms}
		@GetMapping("/NbrRoomsPriceAsc/{nbrooms}")
		@ResponseBody
		public List<Property> findByNbrRoomsAndStatusTrueOrderByPriceAsc(@PathVariable("nbrooms") int nbrooms) {
			return aas.findByNbrRoomsAndStatusTrueOrderByPriceAsc(nbrooms);
		}
		
		// http://localhost:8088/Dari/servlet/NbrRoomsPriceDesc/{nbrooms}
		@GetMapping("/NbrRoomsPriceDesc/{nbrooms}")
		@ResponseBody
		public List<Property> findByNbrRoomsAndStatusTrueOrderByPriceDesc(@PathVariable("nbrooms") int nbrooms) {
			return aas.findByNbrRoomsAndStatusTrueOrderByPriceDesc(nbrooms);
		}
		
		
		// http://localhost:8088/Dari/servlet/RoomsFloorBRooms/{nbrooms}/{nbfloor}/{nbbroom}
		@GetMapping("/RoomsFloorBRooms/{nbrooms}/{nbfloor}/{nbbroom}")
		@ResponseBody
		public List<Property> findByNbrRoomsAndNbrFloorAndNbrBathroomsAndStatusTrue(@PathVariable("nbrooms") int nbrooms,
				@PathVariable("nbfloor") int nbfloor, @PathVariable("nbbroom") int nbbroom) {
			return aas.findByNbrRoomsAndNbrFloorAndNbrBathroomsAndStatusTrue(nbrooms, nbfloor, nbbroom);
		}
		
	    ////////////////////////////////////// Statistic ////////////////////////////////////////////////
		
		// http://localhost:8088/Dari/servlet/property/{state}/averageprice
		@GetMapping("/property/{state}/averageprice")
		public double averagepricebystate(@PathVariable("state") String state) {
			return aas.averagepricebystate(state);
		}
		
		// http://localhost:8088/Dari/servlet/property/{city}/averageprice
		@GetMapping("/property/{city}/averageprice")
		public double averagepricebycity(@PathVariable("city") String city) {
			return aas.averagepricebycity(city);
		}
		
		
		// http://localhost:8088/Dari/servlet/property/{state}/averagesurface
		@GetMapping("/property/{state}/averagesurface")
		public double averagesurfacebystate(@PathVariable("state") String state) {
			return aas.averagesurfacebystate(state);
		}
		
		// http://localhost:8088/Dari/servlet/property/{city}/averagesurface
		@GetMapping("/property/{city}/averagesurface")
		public double averagesurfacebycity(@PathVariable("city") String city) {
			return aas.averagesurfacebycity(city);
		}
		
		
		// http://localhost:8088/Dari/servlet/property/{state}/pricepermeter
		@GetMapping("/property/{state}/pricepermeter")
		public double pricepermeterstate(@PathVariable("state") String state) {
			return aas.pricepermeterstate(state);
		}

}