package mock.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import mock.beans.Patient;
import mock.dao.IPatientDAO;

import org.springframework.stereotype.Repository;

import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

@Repository
public class PatientDAO extends AbstractHibernateDAO<Long, Patient> implements IPatientDAO{

	private List<Patient> patients = new ArrayList<Patient>();
	
	public PatientDAO(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			patients.add(new Patient(1, "first1", "last1", sdf.parse("01/02/1990"), "ssid1", "address1", "phone1", "2", 1, 1, 1));
			patients.add(new Patient(2, "first2", "last2", sdf.parse("02/03/1990"), "ssid2", "address2", "phone2", "3", 1, 1, 1));
			patients.add(new Patient(3, "first3", "last3", sdf.parse("03/04/1990"), "ssid3", "address3", "phone3", "4", 1, 1, 1));
			patients.add(new Patient(4, "first4", "last4", sdf.parse("04/05/1990"), "ssid4", "address4", "phone4", "5", 1, 1, 1));
			patients.add(new Patient(5, "first5", "last5", sdf.parse("05/06/1990"), "ssid5", "address5", "phone5", "6", 1, 1, 1));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Patient findPatientByUuid(int uuid) {
//		Query query = createQuery("SELECT a FROM Patient a where a.uuid =:uuid");
//		query.setParameter("uuid", uuid);
//		return (Patient) query.getSingleResult();
		
		for (Patient patient : patients){
			if (patient.getUuid() == uuid){
				return patient;
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Patient>  searchPatientByFirstName(String firstName) {
//		Query query = createQuery("SELECT a FROM Patient a WHERE a.firstname =:firstname");
//		return (List<Patient>) query.getResultList();
		List<Patient> result = new ArrayList<Patient>();
		for (Patient patient : patients){
			if (patient.getFirstName().startsWith(firstName)){
				result.add(patient);
			}
		}
		return result;
	}

	@Override
	public List<Patient> getAllPatient() {
//		Query query = createQuery("SELECT a FROM Patient a");
//		return (List<Patient>) query.getResultList();
		
		return patients;
	}
	
	
}
