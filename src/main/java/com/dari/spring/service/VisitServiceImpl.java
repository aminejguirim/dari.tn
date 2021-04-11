package com.dari.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dari.spring.entity.Property;
import com.dari.spring.entity.User;
import com.dari.spring.entity.Visit;
import com.dari.spring.entity.VisitTime;
import com.dari.spring.repository.PropertyRepository;
import com.dari.spring.repository.UserRepository;
import com.dari.spring.repository.VisitRepository;
import com.dari.spring.repository.VisitTimeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;



@Service
public class VisitServiceImpl implements IVisitService {
	
	@Autowired
	PropertyRepository prop;
	
	@Autowired
	UserRepository ur;
	
	@Autowired
	VisitRepository vis;
	
	@Autowired
	VisitTimeRepository vtime;
	
	
	 @Autowired
	 private JavaMailSender emailSender;

	@Override
	public void createVisit(int id,  int client, int time) {
		Visit v = new Visit();
		Property p =prop.findById(id).get();
		User u = ur.findById(client).get();
		VisitTime vt = vtime.findById(time).get();
		v.setDate(vt.getDate());
		v.setPlace(p.getStreet());
		v.setClient(u);
		v.setTime(vt);
		p.addVisit(v);
		vis.save(v);
		sendSimpleMessage(v.getClient().getEmail(), "Appointmnet  created", "Your appointment has been approved, \n "
				+ "Details: "+ "Date : "+v.getDate()+" \n Place: "+v.getPlace());
		
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	//TimeSlot SERVICE METHODS
		@Override
		public VisitTime createVisitTime(int id,VisitTime vt) {
			Property p =prop.findById(id).get();
			p.addTime(vt);
			return vtime.save(vt);
		}
		
		@Override
		public void updateVisitTime(int id, Date date, int hstart, int hend, int mstart, int mend) {
			VisitTime vt = vtime.findById(id).get();
			vt.setDate(date);
			vt.setHstart(hstart);
			vt.setHend(hend);
			vt.setMstart(mstart);
			vt.setMend(mend);

			
			 vtime.save(vt);
			
		}

		@Override
		public void deleteVisitTime(int id) {
			vtime.deleteById(id);
			
		}

		@Override
		public VisitTime findVisitTimeById(int id) {
			return vtime.findById(id).get();
		}

		@Override
		public List<VisitTime> findAllVisitsTimeOfProperty(int idProperty) {
			return vtime.findAllVisitTimeByProperty(idProperty);
		}
		
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////
	public void sendSimpleMessage(String to, String subject, String text) {

        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setFrom("daritn4@gmail.com");
        message.setTo(to); 
        message.setSubject(subject); 
        message.setText(text);
        emailSender.send(message);

    }

	@Override
	public void updateVisit(int idVisit,  String place) {
		Visit visit = vis.findById(idVisit).get();
		
		visit.setPlace(place);
		vis.save(visit);
		
	}

	@Override
	public void deleteVisit(int idVisit) {
		vis.deleteById(idVisit);
		
	}

	@Override
	public Visit findVisitById(int idVisit) {
		return vis.findById(idVisit).get();
	}

	@Override
	public List<Visit> findAppointmentsByPropertyByDay(int idProperty, Date day) {
		return vis.findAppointmentByPropertyByDay(idProperty, day);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long countAllAppointments(int idProperty) {
		return vis.CountVisitByPropertyId(idProperty);

	}

	
	

}