package mock.services;

import mock.beans.Medecin;
import mock.dao.IMedecinDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
