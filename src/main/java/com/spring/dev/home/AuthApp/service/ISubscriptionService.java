package com.spring.dev.home.AuthApp.service;

import java.text.ParseException;
import java.util.Date ;
import java.util.List;

import com.spring.dev.home.AuthApp.model.Subscription;
import com.spring.dev.home.AuthApp.model.SubscriptionType;


public interface ISubscriptionService {
	
	public List<Subscription> listAll();
	public Subscription addSubscription(Subscription subscription) throws ParseException ;
	public void save(Subscription subscription) ;
	public String delete(Long idSubscription) throws ParseException ;
	Date expiration(int n);
	int timespan(SubscriptionType st);

	public int CountSubscriptions();
	public void sendEmail (String to , String body , String topic);
	public void updateSubscription (Long idSubscription , Subscription subscription) ;
	public Subscription renewSubscription(Subscription s) throws ParseException;
	/*public void runAfterStartup() throws ParseException ;*/
	 public Subscription getByIdSubscription(Long idSubscription);
	Subscription findSubscriptionbyid(Long idSubscription);
	/*public List<Subscription> findTodaySubscriptions();*/
	/*public float countPrice() ;*/
	float packPrice(SubscriptionType st);
	

}
