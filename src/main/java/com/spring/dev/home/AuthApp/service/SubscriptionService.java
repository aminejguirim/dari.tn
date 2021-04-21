package com.spring.dev.home.AuthApp.service;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.spring.dev.home.AuthApp.model.Subscription;
import com.spring.dev.home.AuthApp.model.SubscriptionType;
import com.spring.dev.home.AuthApp.model.User;
import com.spring.dev.home.AuthApp.repository.SubscriptionRepository;


@Service
public  class SubscriptionService implements ISubscriptionService {
	
	@Autowired
	SubscriptionRepository sr;
	Subscription subscription ;
	User user;
    SubscriptionType substype;
	private JavaMailSender javaMailSender ;
	private static final Logger L = LogManager.getLogger(UserService.class) ;
	
	
	public void save(Subscription subscription) {
		sr.save(subscription) ;
	}
	
	public List<Subscription> listAll() {
		return sr.findAll() ;
	}
	 
	public Subscription addSubscription(Subscription subscription) throws ParseException{
		subscription.setExpirationDate(this.expiration(this.timespan(subscription.getSubscriptionType()))); 
		subscription.setPrice(this.packPrice(subscription.getSubscriptionType()));
		this.renewSubscription(subscription) ;
		//this.sendEmail("yosri.bhiri@esprit.tn", "body", "topic");	
		return sr.save(subscription) ;
	}
	
	public String delete(Long idSubscription) throws ParseException {
		sr.deleteById(idSubscription);
		System.out.println("Remove is Ready");
		return "Subscription is removed" ; 
	}
	
	public void updateSubscription (Long idSubscription , Subscription subscription) {
		Subscription s= sr.findById(idSubscription).get();
		//s.setClient(subscription.getClient());
		s.setExpirationDate(subscription.getExpirationDate());
		//s.setIdSubscription(subscription.getIdSubscription());
		s.setPrice(subscription.getPrice());
		s.setSubscriptionType(subscription.getSubscriptionType());
		s.setStratingDate(subscription.getStratingDate());
		s.setRenewal(subscription.isRenewal()) ;
		sr.save(s);
	}
	
	@Override
	public Date expiration(int n) {
		Date now = new Date();   
		Calendar myCal = Calendar.getInstance();
		    myCal.setTime(now);   
		myCal.add(Calendar.MONTH, +n);   
		now = myCal.getTime();
		return now;
	}
	
	@Override
	public int timespan(SubscriptionType st) {
		int n;
		switch(st){
		case NORMAL:
			n=1;
			break;
		case PREMIUM:
			n=6;
			break;
		case GOLD:
			n=12;
			break;
		default:
			n=0;
			break;
		}
		return n;
			
		}
	
	public Subscription renewSubscription(Subscription s) throws ParseException {
		//DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date d= new Date();
		//String today =df.format(d);
		if(s.isRenewal()&&s.getExpirationDate().after(d))
		{
		
			s.setExpirationDate(expiration(timespan(s.getSubscriptionType())));
			return s;
		}
		
		else if(s.getExpirationDate().after(d))
			{
			
				delete(s.getIdSubscription());
				
			}
		return null;
	}
	
	public int CountSubscriptions() {
		List <Subscription> subscriptions=(List<Subscription>) sr.findAll();
		
		return subscriptions.size();
	}
	
	/*public double avergeNumberOfUserPerMonth(int month) {
		List<Subscription> Liste = sr.find
		
			
		}*/
	
	@Override
	public float packPrice (SubscriptionType st) {
		
		float defprice = 20 ;
		
		java.util.Date date= new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH);
		if (month == 7 || month == 8 || month ==9 ) {
			
		switch(st){
		case NORMAL : {
			return defprice = 40 ;
		}
		case PREMIUM : {
		return defprice = 80 ;
		}
		case GOLD : {
		return	defprice = 150 ;
		}}
		return (Float) null; }
		
		else {
			switch(st){
			case NORMAL : {
				return defprice = 20 ;
			}
			case PREMIUM : {
			return defprice = 45;
			}
			case GOLD : {
			return	defprice = 120 ;
			}}
			return (Float) null; }
	}
		

		public  void sendEmail (String to , String body , String topic){
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage() ;
			simpleMailMessage.setFrom("daritest10@gmail.com");
			simpleMailMessage.setTo(to);
			simpleMailMessage.setSubject(body);
			simpleMailMessage.setText(body);
			 javaMailSender.send(simpleMailMessage);
		}

		 public Subscription getByIdSubscription(Long idSubscription) {
		        return this.sr.findById(idSubscription).orElseThrow(
		                () -> new IllegalStateException("Order with id " + idSubscription + " does not exist.")
		        );
		    }
		 
		 @Override
			public Subscription findSubscriptionbyid(Long idSubscription) {
				return (Subscription) sr.findById(idSubscription).get();
			}
		 
				/*@EventListener(ApplicationReadyEvent.class)
		public void runAfterStartup() throws ParseException {
		    this.renewSubscription(subscription) ;
		}*/
		
		 /*public List<Subscription> findTodaySubscriptions() {
			return sr.findTodaysSubs() ;
		}*/
		
		/*public float countPrice() {
			return sr.getTotalMoneyEarned(subscription.getStratingDate(), subscription.getExpirationDate()) ;
		}*/
	}

