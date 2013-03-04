package fr.umlv.careAtHome.persistence.services;

import org.springframework.beans.factory.annotation.Autowired;

import fr.umlv.careAtHome.persistence.beans.Laboratory;
import fr.umlv.careAtHome.persistence.dao.ILaboratoryDAO;

public class LaboratoryService {
	
	@Autowired
	ILaboratoryDAO laboratoryDAO;
	
	public Laboratory getLaboratoryByUuid(int uuid){
		return null;
	}

}
