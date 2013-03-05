package mock.services;

import java.util.List;

import mock.beans.Personnel;
import mock.dao.IPersonnelDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("PersonnelService")
public class PersonnelService {

	@Autowired
	IPersonnelDAO personnelDAO;

	public PersonnelService(IPersonnelDAO personnelDAO) {
		this.personnelDAO = personnelDAO;
	}

	@Transactional()
	public List<Personnel> searchcaregiverByName(String firstname) {
		return personnelDAO.searchcaregiverByName(firstname);
	}

	@Transactional()
	public Personnel getcaregiverByUuid(int uuid) {
		return personnelDAO.getcaregiverByUuid(uuid);
	}

	@Transactional()
	public List<Personnel> getcaregiverByUuids(List<Integer> uuids) {
		return personnelDAO.getcaregiverByUuids(uuids);
	}
	
	@Transactional()
	public List<Personnel> getAllPersonnel() {
		return personnelDAO.getAllPersonnel();
	}
	
	@Transactional()
	public void create(Personnel personnel) {
		personnelDAO.persist(personnel);
	}

}
