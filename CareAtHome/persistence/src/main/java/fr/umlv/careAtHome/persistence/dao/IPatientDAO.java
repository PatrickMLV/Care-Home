package fr.umlv.careAtHome.persistence.dao;

import java.util.List;

import fr.umlv.careAtHome.persistence.beans.Patient;
import fr.umlv.m2.jee.dao.hibernate.IHibernateDAO;


public interface IPatientDAO extends IHibernateDAO<Long, Patient> {
	public Patient findPatientByUuid(int uuid);
	public List<Patient>  searchPatientByFirstName(String firstName);
	public List<Patient> getAllPatient();
}
