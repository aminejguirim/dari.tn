package tn.esprit.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Subscription;
import tn.esprit.spring.repository.SubscriptionRepository;
import tn.esprit.spring.entity.Subscription;

@Service
public class SubscriptionServiceImp implements ISubscriptionService {

	@Autowired
SubscriptionRepository sr ;
Subscription subscription ;

private static final Logger L = LogManager.getLogger(SubscriptionServiceImp.class) ;

public List<Subscription> listAll() {
	return sr.findAll() ;
}
public void save(Subscription subscription) {
	sr.save(subscription) ;
}
public Subscription addSubscription(Subscription subscription){
	return sr.save(subscription) ;
}
public String delete(Long idClient) {
	sr.deleteById(idClient);
	return "Subscription removed" ; 
}
}
