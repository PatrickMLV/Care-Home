package mock.services;

import mock.beans.Pharmacie;
import mock.dao.IPharmacieDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
