package fr.umlv.careAtHome.persistence.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.umlv.careAtHome.persistence.beans.RDV;
import fr.umlv.careAtHome.persistence.dao.IRDVDAO;

public class RDVService {

	@Autowired
	IRDVDAO irdvdao;
	
	public boolean addTour(int uuid, int uuidPersonnel, int uuidPatient, int priotiry, Date date) {
		return false;
	}
	
	public List<RDV> getTour(int uuid){
		return null;
	}
}
