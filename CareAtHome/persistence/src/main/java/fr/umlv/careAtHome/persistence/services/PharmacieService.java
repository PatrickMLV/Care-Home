package fr.umlv.careAtHome.persistence.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.umlv.careAtHome.persistence.beans.Pharmacie;
import fr.umlv.careAtHome.persistence.dao.IPharmacieDAO;

@Transactional
@Service("PharmacieService")
public class PharmacieService {

	@Autowired
	IPharmacieDAO pharmacieDAO;

	public PharmacieService(IPharmacieDAO pharmacieDAO) {
		this.pharmacieDAO = pharmacieDAO;
	}

	@Transactional()
	public Pharmacie getPharmacieByUuid(int uuid) {
		return pharmacieDAO.getPharmacieByUuid(uuid);
	}

}
