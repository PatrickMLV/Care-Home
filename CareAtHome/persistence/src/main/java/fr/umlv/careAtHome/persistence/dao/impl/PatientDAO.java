package fr.umlv.careAtHome.persistence.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.umlv.careAtHome.persistence.beans.Patient;
import fr.umlv.careAtHome.persistence.dao.IPatientDAO;
import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

@Repository
public class PatientDAO extends AbstractHibernateDAO<Long, Patient> implements IPatientDAO{

	@Override
	public Patient findPatientByUuid(int uuid) {
		Query query = createQuery("SELECT a FROM Patient a where a.uuid =:uuid");
		query.setParameter("uuid", uuid);
		return (Patient) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Patient>  searchPatientByFirstName(String firstName) {
		Query query = createQuery("SELECT a FROM Patient a WHERE a.firstname =:firstname");
		return (List<Patient>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Patient> getAllPatient() {
		Query query = createQuery("SELECT a FROM Patient a");
		return (List<Patient>) query.getResultList();
	}
	
	
}
