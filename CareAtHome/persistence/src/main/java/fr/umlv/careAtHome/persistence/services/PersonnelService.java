package fr.umlv.careAtHome.persistence.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.umlv.careAtHome.persistence.beans.Personnel;
import fr.umlv.careAtHome.persistence.dao.IPersonnelDAO;

public class PersonnelService {
	
	@Autowired
	IPersonnelDAO personnelDAO;
	
	public Personnel searchcaregiverByName(String firstname){
		return null;
	}
	
	public Personnel getcaregiverByUuid(int uuid){
		return null;
	}
	
	public List<Personnel> getcaregiverByUuids(List<Integer> uuids){
		return null;
	}


}
