package com.spring.dev.home.AuthApp.controller;

import java.text.ParseException;
import java.util.List;

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

import com.spring.dev.home.AuthApp.model.Subscription;
import com.spring.dev.home.AuthApp.service.SubscriptionService;



@RestController
public class SubscriptionController {
	
	@Autowired
	SubscriptionService ss ;
	Subscription subscription  ;
	
	
	@GetMapping("/subscriptions/total")
	public int numberOfSubscription () {
		return ss.CountSubscriptions();
	}
	
	/*@GetMapping("/subscriptions/today")
	public float subscriptionsToday() {
		return ss.countPrice();
	}*/
	
	 @GetMapping("subscriptions/all")
	public List<Subscription> getAllSUbscription() {
		return  ss.listAll() ;
		
	}
	 
	 @GetMapping("/subscriptions/{idSubscription}")
	    public Subscription get(@PathVariable("idSubscription") Long idSubscription) {
	        return this.ss.getByIdSubscription(idSubscription);
	    }
	
	 
	@PostMapping("/subscription/add")
	public Subscription saveSubscription(@RequestBody Subscription subscription) throws ParseException{
		return ss.addSubscription(subscription) ;
	}
	
	@DeleteMapping("/subscription/delete/{idSubscription}")
	public String deleteSubscription(@PathVariable Long idSubscription) throws ParseException{
		return ss.delete(idSubscription);
	}
	@PutMapping("/subscription/update/{idSubscription}")
	@ResponseBody
	public ResponseEntity<String> updateSubscription(@PathVariable("idSubscription")Long idSubscription,@RequestBody Subscription subscription) {
		ss.updateSubscription(idSubscription, subscription);
		return new ResponseEntity<>("Update successful", HttpStatus.CREATED);
	
	}
	
}
