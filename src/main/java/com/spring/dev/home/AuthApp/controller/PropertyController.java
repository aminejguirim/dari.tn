package com.spring.dev.home.AuthApp.controller;

import java.util.List;

import javax.mail.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;



import org.springframework.web.bind.annotation.RestController;

import com.spring.dev.home.AuthApp.model.Property;
import com.spring.dev.home.AuthApp.repository.PropertyRepository;
import com.spring.dev.home.AuthApp.repository.UserRepository;
import com.spring.dev.home.AuthApp.service.IPropertyService;
import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;

@RestController
public class PropertyController {

	

	@Autowired
	IPropertyService aas;

	@Autowired
	PropertyRepository aar;
	
	@Autowired
	UserRepository ur;

	
	
	
	// http://localhost:6000/SpringMVC/servlet/add-prop
		@PostMapping("/save-prop")
		@ResponseBody
		public Property addProp(@RequestBody Property aa) {
		Property prop = aas.save(aa);
		return prop;
		}
		
	
	// http://localhost:8082/Dari/servlet/addProperty/{iduser}
		/*	@PostMapping("/addProperty/{iduser}")
			@ResponseBody
			public ResponseEntity<String> addAssetAdv(@PathVariable("iduser") int iduser, @RequestBody Property aa) {
				User u =ur.findById(iduser).get();
				if ((aa.getPrice() < 0) || (aa.getSurface()<0) ) {
					return new ResponseEntity<>("Price has to be superior than 0", HttpStatus.BAD_REQUEST);
				} 
					aas.addProperty(iduser, aa);
					
					String s = "+216" + aa.getUser().getPhoneNumber();
					sendSms(s, "+14044917812", "ahla nadou <3");
					
					
					return new ResponseEntity<>("Request sent for property " + aa.getRef(), HttpStatus.CREATED);
					
			}*/
	

	
	
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
		
		// http://localhost:8082/Dari/servlet/State/{state}
		@GetMapping("/State/{state}")
		@ResponseBody
		public List<Property> findByStateAndStatusTrue(@PathVariable("state") String state) {
			return aas.findByStateAndStatusTrue(state);
		}
		
		// http://localhost:8082/Dari/servlet/assetadvs/{state}/averageprice
		// general average price per state
		@GetMapping("/assetadvs/{state}/averageprice")
		public double averagepricebystate(@PathVariable("state") String state) {
			return aas.averagepricebystate(state);
		}
		
		public void sendSms(String to, String from, String body) {

			try {
				Twilio.init("AC4a30225de4e58465a1bb6e3a9b0348d5", "36f1f7e143fd687d791e1db7d3fbeefc");
				Message message = Message.creator(new PhoneNumber(to), new PhoneNumber(from), body).create();

			} catch (Exception e) {

				e.printStackTrace();

			}

		}
	
	
}
