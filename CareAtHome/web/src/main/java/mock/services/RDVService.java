package mock.services;

import java.util.Date;
import java.util.List;

import mock.beans.RDV;
import mock.dao.IRDVDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
