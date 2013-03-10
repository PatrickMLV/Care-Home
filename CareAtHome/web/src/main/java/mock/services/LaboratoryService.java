package mock.services;

import java.util.List;

import mock.beans.Laboratory;
import mock.dao.ILaboratoryDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("LaboratoryService")
public class LaboratoryService {

	@Autowired
	ILaboratoryDAO laboratoryDAO;

	public LaboratoryService(ILaboratoryDAO laboratoryDAO) {
		this.laboratoryDAO = laboratoryDAO;
	}

	@Transactional()
	public Laboratory getLaboratoryByUuid(int uuid) {
		return laboratoryDAO.getLaboratoryByUuid(uuid);
	}
	
	@Transactional()
	public List<Laboratory> getAllLaboratory() {
		return laboratoryDAO.findAll();
	}
	
	@Transactional()
	public void createLaboratory(Laboratory laboratory) {
		laboratoryDAO.persist(laboratory);
	}
	
	@Transactional()
	public void updateLaboratory(Laboratory laboratory) {
		laboratoryDAO.merge(laboratory);
	}
	
	@Transactional()
	public void deleteLaboratory(Laboratory laboratory) {
		laboratoryDAO.remove(laboratory);
	}

}
