package fr.umlv.careAtHome.persistence.services;

import org.springframework.beans.factory.annotation.Autowired;

import fr.umlv.careAtHome.persistence.beans.Responsable;
import fr.umlv.careAtHome.persistence.dao.IResponsableDAO;

public class ResponsableService {
	
	@Autowired
	IResponsableDAO responsableDAO;
	
	public Responsable getResponsableByUuid(int uuid){
		return null;
	}

}
