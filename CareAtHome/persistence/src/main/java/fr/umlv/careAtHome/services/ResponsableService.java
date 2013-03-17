package fr.umlv.careAtHome.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import fr.umlv.careAtHome.persistence.beans.Responsable;
import fr.umlv.careAtHome.persistence.dao.IResponsableDAO;

@Transactional
@Service("ResponsableService")
public class ResponsableService {

	@Autowired
	IResponsableDAO responsableDAO;

	public ResponsableService(IResponsableDAO responsableDAO) {
		this.responsableDAO = responsableDAO;
	}

	@Transactional()
	public Responsable getResponsableByUuid(int uuid) {
		return responsableDAO.getResponsableByUuid(uuid);
	}

}
