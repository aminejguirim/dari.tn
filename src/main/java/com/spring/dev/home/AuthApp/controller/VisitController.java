package com.spring.dev.home.AuthApp.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dev.home.AuthApp.model.Visit;
import com.spring.dev.home.AuthApp.model.VisitTime;
import com.spring.dev.home.AuthApp.service.VisitServiceImpl;





@RestController
public class VisitController {
	
	@Autowired
	VisitServiceImpl vs;
	
	//http://localhost:8082/Dari/servlet/Property/Visit/addVisit/{idproperty}/{date}/{client}/{time}
		@PostMapping("/Property/Visit/addVisit/{idproperty}/{client}/{time}")
		@ResponseBody
		public ResponseEntity<String> ajouterVisit(@PathVariable("idproperty") int idproperty,
														
														@PathVariable("client") int client,
														@PathVariable("time") int visits) throws ParseException
		{
			
			
			

			vs.createVisit(idproperty,client,visits);
			return new ResponseEntity<>("Appointment Added successfully.", HttpStatus.CREATED);
			
		}
		
		//http://localhost:8082/Dari/servlet/Asset/RDV/{id}/Modify/{date}/{place}
				@PutMapping("Asset/RDV/{id}/Modify/{place}")
				public ResponseEntity<String> modifierVisit(@PathVariable("id")int id,@PathVariable("place")String place ) 
				{
 
					vs.updateVisit(id,  place);
					return new ResponseEntity<>("modification succeded.", HttpStatus.ACCEPTED);
				}
				
				// http://localhost:8082/Dari/servlet/Property/Visit/delete/{id}
				@PostMapping("Property/Visit/delete/{id}")
				public ResponseEntity<String> supprimerRdv(@PathVariable("id")int id)
				{
					vs.deleteVisit(id);
					return new ResponseEntity<>("suppression reussie.", HttpStatus.OK);
				}
		
				// http://localhost:8082/Dari/servlet/Property/Visit/{id}
				@GetMapping("Property/Visit/{id}")
				public Visit afficherVisit(@PathVariable("id") int id)
				{
					return vs.findVisitById(id);
				}
				
				// http://localhost:8082/Dari/servlet/Asset/RDV/VisitByPropertyByDate/{id}/{date}
				@GetMapping("Property/Visit/VisitByPropertyByDate/{id}/{date}")
				public List<Visit> afficherVisitByPropertyByDate(@	PathVariable("id") int id, @PathVariable("date") String date) throws ParseException
				{
					Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(date); 
					return vs.findAppointmentsByPropertyByDay(id, date1);
				}
				
				// http://localhost:8082/Dari/servlet/Property/Visit/count/{idProperty}
				@GetMapping("Property/Visit/count/{idProperty}")
				public Long CountVisit(@PathVariable("idProperty") int idProperty)
				{
					return vs.countAllAppointments(idProperty);
				}
		
		///////////////////////////////////////////////////////////////////////////////////////////
		
		//http://localhost:8082/Dari/servlet/Property/addVisitTime/{id}
		@PostMapping("/Property/addVisitTime/{id}")
		@ResponseBody
		public ResponseEntity<String> ajouterRdvts(@PathVariable("id") int id,@RequestBody VisitTime vt)
		{
			vs.createVisitTime(id,vt);
			return new ResponseEntity<>("Ajout reussie.", HttpStatus.CREATED);
		}
		
		//http://localhost:8082/Dari/servlet/Propert/VisitTime/{id}/Modify/{date}/{hdebut}/{hfin}/{mdebut}/{mfin}
		@PutMapping("Propert/VisitTime/{id}/Modify/{date}/{hstart}/{hend}/{mstart}/{mend}")
		public ResponseEntity<String> modifierVisitTime(@PathVariable("id")int id,@PathVariable("date")String date,@PathVariable("hstart")int hstart ,@PathVariable("hend")int hend ,@PathVariable("mstart")int mstart ,@PathVariable("mend")int mend ) throws ParseException
		{

			Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(date);
			if ((hstart > hend)||(hstart>23) || (hend>23)){
				return new ResponseEntity<>("Verify the time u've just added.", HttpStatus.BAD_REQUEST);
			}else {
			vs.updateVisitTime(id, date1, hstart, hend, mstart, mend);
			return new ResponseEntity<>("modification succeded.", HttpStatus.ACCEPTED);
			}
		}
		
		// http://localhost:8082/Dari/servlet/Property/VisitTime/delete/{id}
		@PostMapping("Property/VisitTime/delete/{id}")
		public ResponseEntity<String> supprimerVisitTime(@PathVariable("id")int id)
		{
			vs.deleteVisitTime(id);
			return new ResponseEntity<>("suppression reussie.", HttpStatus.OK);
		}
		
		// http://localhost:8081/Dari/servlet/Property/VisitTime/{id}
		@GetMapping("Property/VisitTime/{id}")
		public VisitTime afficherVisitTime(@PathVariable("id") int id)
		{
			return vs.findVisitTimeById(id);
		}
		
		// http://localhost:8082/Dari/servlet/Property/VisitTime/FinByProperty/{idProperty}
		@GetMapping("Property/VisitTime/FinByProperty/{idProperty}")
		public List<VisitTime> afficherVisitsTimeByProperty(@PathVariable("idProperty") int idProperty)
		{
			return vs.findAllVisitsTimeOfProperty(idProperty);
		}
		
		

}
