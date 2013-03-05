package mock.services;

import mock.beans.Responsable;
import mock.dao.IResponsableDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
