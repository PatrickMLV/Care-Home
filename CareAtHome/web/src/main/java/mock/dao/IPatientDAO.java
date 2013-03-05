package mock.dao;

import java.util.List;

import mock.beans.Patient;
import fr.umlv.m2.jee.dao.hibernate.IHibernateDAO;


public interface IPatientDAO extends IHibernateDAO<Long, Patient> {
	public Patient findPatientByUuid(int uuid);
	public List<Patient>  searchPatientByFirstName(String firstName);
	public List<Patient> getAllPatient();
}
