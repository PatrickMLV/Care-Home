package fr.umlv.careAtHome.persistence.services;

import fr.umlv.careAtHome.persistence.beans.Cadre;
import fr.umlv.careAtHome.persistence.dao.ICadreDAO;

import org.springframework.beans.factory.annotation.Autowired;

public class CadreService {
	
	@Autowired
	ICadreDAO cadreDAO;
	
	public Cadre getCadreByUuid(int uuid){
		return null;
	}

}
