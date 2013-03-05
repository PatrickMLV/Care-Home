package mock.services;

import mock.beans.Cadre;
import mock.dao.ICadreDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("CadreService")
public class CadreService {

	@Autowired
	ICadreDAO cadreDAO;

	public CadreService(ICadreDAO cadreDAO) {
		this.cadreDAO = cadreDAO;
	}

	@Transactional()
	public Cadre getCadreByUuid(int uuid) {
		return cadreDAO.getCadreByUuid(uuid);
	}

}
