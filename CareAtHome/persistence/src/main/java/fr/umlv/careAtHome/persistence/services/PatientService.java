package fr.umlv.careAtHome.persistence.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.umlv.careAtHome.persistence.beans.Patient;
import fr.umlv.careAtHome.persistence.dao.IPatientDAO;

public class PatientService {
	
	@Autowired
	IPatientDAO patientDAO;
	
	public PatientService() {
	}
	
	
	public boolean addPatientFolder(String firstName, String lastName, Date birthday,
			String ssid, String address, String phone, String priority,
			int uuidMedecin, int uuidLaboratory, int uuidPharmacie){
		
		return false;
	}
	
	public boolean modifyPatientFolder(int uuid, String firstName, String lastName, Date birthday,
			String ssid, String address, String phone, String priority,
			int uuidMedecin, int uuidLaboratory, int uuidPharmacie){
		
		return false;
	}
	
	
	public boolean removePatientFolder(int uuid){
		return false;
	}
	
	public List<Patient> getAllPatient(){
		return null;
	}
	
	public List<Patient> searchPatientByCriteria(String firstName, String lastName, String ssid, Date birthdayDate){
		return null;
	}
}
