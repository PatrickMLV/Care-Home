package mock.dao;


import java.util.List;

import mock.beans.Personnel;
import fr.umlv.m2.jee.dao.hibernate.IHibernateDAO;


public interface IPersonnelDAO extends IHibernateDAO<Long, Personnel> {
	public List<Personnel>  searchcaregiverByName(String firstName);
	public Personnel getcaregiverByUuid(int uuid);
	public List<Personnel> getcaregiverByUuids(List<Integer> uuids);
	public List<Personnel> getAllPersonnel();
}
