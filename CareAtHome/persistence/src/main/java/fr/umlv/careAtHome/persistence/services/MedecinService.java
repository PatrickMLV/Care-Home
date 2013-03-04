package fr.umlv.careAtHome.persistence.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.umlv.careAtHome.persistence.beans.Medecin;
import fr.umlv.careAtHome.persistence.dao.IMedecinDAO;

@Transactional
@Service("MedecinService")
public class MedecinService {

	@Autowired
	IMedecinDAO medecinDAO;

	public MedecinService(IMedecinDAO medecinDAO) {
		this.medecinDAO = medecinDAO;
	}

	@Transactional()
	public Medecin getMedecinByUuid(int uuid) {
		return medecinDAO.getMedecinByUuid(uuid);
	}

}
