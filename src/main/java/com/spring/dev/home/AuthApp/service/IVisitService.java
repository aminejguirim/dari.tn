package com.spring.dev.home.AuthApp.service;

import java.util.Date;
import java.util.List;

import com.spring.dev.home.AuthApp.model.Visit;
import com.spring.dev.home.AuthApp.model.VisitTime;



public interface IVisitService {
	
	public void createVisit(int id,  int client, int time);
	public void updateVisit(int idVisit,  String place);
	public void deleteVisit(int idVisit);
	public Visit findVisitById(int idVisit);
	public List<Visit> findAppointmentsByPropertyByDay(int idProperty, Date day);
	public Long countAllAppointments(int idProperty);
	
	////////////////////////////////////////////////////////////////////
	
	public VisitTime createVisitTime(int id,VisitTime vt);
	public void updateVisitTime(int id, Date date, int hstart,int hend,int mstart,int mend ) ;
	public void deleteVisitTime(int id);
	public VisitTime findVisitTimeById(int id);
	public List<VisitTime> findAllVisitsTimeOfProperty(int idProperty);
	

}
