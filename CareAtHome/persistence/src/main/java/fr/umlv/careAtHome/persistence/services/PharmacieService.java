package fr.umlv.careAtHome.persistence.services;

import org.springframework.beans.factory.annotation.Autowired;

import fr.umlv.careAtHome.persistence.beans.Pharmacie;
import fr.umlv.careAtHome.persistence.dao.IPharmacieDAO;

public class PharmacieService {

		
		@Autowired
		IPharmacieDAO pharmacieDAO;
		
		public Pharmacie getPharmacieByUuid(int uuid){
			return null;
		}



}
