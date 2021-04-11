package com.dari.spring.service;

import java.util.Date;
import java.util.List;

import com.dari.spring.entity.Visit;
import com.dari.spring.entity.VisitTime;


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