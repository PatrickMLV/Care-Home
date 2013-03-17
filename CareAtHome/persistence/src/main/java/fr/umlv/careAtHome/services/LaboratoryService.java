package fr.umlv.careAtHome.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.umlv.careAtHome.persistence.beans.Laboratory;
import fr.umlv.careAtHome.persistence.dao.ILaboratoryDAO;

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

}
