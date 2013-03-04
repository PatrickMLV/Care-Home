package fr.umlv.careAtHome.persistence.services;

import org.springframework.beans.factory.annotation.Autowired;

import fr.umlv.careAtHome.persistence.beans.Medecin;
import fr.umlv.careAtHome.persistence.dao.IMedecinDAO;

public class MedecinService {
	
	@Autowired
	IMedecinDAO medecinDAO;
	
	public Medecin getMedecinByUuid(int uuid){
		return null;
	}

}
