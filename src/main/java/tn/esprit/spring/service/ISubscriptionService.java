package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Subscription;


public interface ISubscriptionService {
	public List<Subscription> listAll() ;
	public void save(Subscription subscription);
	public Subscription addSubscription(Subscription subscription);
	public String delete(Long idClient) ;

}
