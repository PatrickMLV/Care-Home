package fr.umlv.careAtHome.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.umlv.careAtHome.persistence.beans.RDV;
import fr.umlv.careAtHome.persistence.dao.IRDVDAO;

@Transactional
@Service("RDVService")
public class RDVService {

	@Autowired
	IRDVDAO irdvdao;

	@Transactional()
	public RDV addRDV(int uuid, int uuidPersonnel, int uuidPatient,
			String priotiry, Date date) {
		RDV rdv = new RDV();
		rdv.setUuidPatient(uuidPatient);
		rdv.setPriotiry(priotiry);
		rdv.setDate(date);
		rdv.setUuidPersonnel(uuidPersonnel);
		irdvdao.persist(rdv);
		return rdv;
	}

	@Transactional()
	public List<RDV> getTour(int uuidPersonnel) {
		return irdvdao.getTour(uuidPersonnel);
	}
}
