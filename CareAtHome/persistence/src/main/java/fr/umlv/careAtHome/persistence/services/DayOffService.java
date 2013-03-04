package fr.umlv.careAtHome.persistence.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import fr.umlv.careAtHome.persistence.dao.IDayOffDAO;

public class DayOffService {
	
	@Autowired
	IDayOffDAO dayOffDAO;
	
	
	public boolean setDayOffDemand(int actorUuid, Date beginDate, Date endDate){
		return false;
	}
	
}
