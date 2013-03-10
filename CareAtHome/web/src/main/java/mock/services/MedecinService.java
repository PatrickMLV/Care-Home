package mock.services;

import mock.beans.Medecin;
import mock.dao.IMedecinDAO;

import java.util.List;

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
	
	@Transactional()
	public List<Medecin> getAllMedecin() {
		return medecinDAO.findAll();
	}
	
	@Transactional()
	public void createMedecin(Medecin medecin) {
		medecinDAO.persist(medecin);
	}
	
	@Transactional()
	public void updateMedecin(Medecin medecin) {
		medecinDAO.merge(medecin);
	}
	
	@Transactional()
	public void deleteMedecin(Medecin medecin) {
		medecinDAO.remove(medecin);
	}

}
