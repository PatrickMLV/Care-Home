package fr.umlv.careAtHome.persistence.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.umlv.careAtHome.persistence.beans.JOB;
import fr.umlv.careAtHome.persistence.beans.Patient;
import fr.umlv.careAtHome.persistence.dao.IPatientDAO;

@Transactional
@Service("PatientService")
public class PatientService {

	@Autowired
	IPatientDAO patientDAO;

	public PatientService(IPatientDAO patientDAO) {
		this.patientDAO = patientDAO;
	}

	@Transactional()
	public Patient addPatientFolder(String firstName, String lastName,
			Date birthday, String ssid, String address, String phone,
			String priority, int uuidMedecin, int uuidLaboratory,
			int uuidPharmacie) {
		Patient patient = new Patient();
		patient.setAddress(address);
		patient.setBirthday(birthday);
		patient.setFirstName(firstName);
		patient.setLastName(lastName);
		patient.setJob(JOB.PATIENT);
		patient.setPhone(phone);
		patient.setPriority(priority);
		patient.setUuidMedecin(uuidMedecin);
		patient.setUuidLaboratory(uuidLaboratory);
		patient.setUuidPharmacie(uuidPharmacie);
		patientDAO.persist(patient);

		return patient;
	}

	@Transactional()
	public Patient modifyPatientFolder(int uuid, String firstName,
			String lastName, Date birthday, String ssid, String address,
			String phone, String priority, int uuidMedecin, int uuidLaboratory,
			int uuidPharmacie) {
		Patient patient = new Patient();
		patient.setAddress(address);
		patient.setBirthday(birthday);
		patient.setFirstName(firstName);
		patient.setLastName(lastName);
		patient.setJob(JOB.PATIENT);
		patient.setPhone(phone);
		patient.setPriority(priority);
		patient.setUuidMedecin(uuidMedecin);
		patient.setUuidLaboratory(uuidLaboratory);
		patient.setUuidPharmacie(uuidPharmacie);
		patientDAO.merge(patient);
		return patient;
	}

	@Transactional()
	public boolean removePatientFolder(int uuid) {
		Patient patient = patientDAO.findPatientByUuid(uuid);
		if (patient == null) {
			return false;
		}
		patientDAO.remove(patient);
		return true;
	}

	@Transactional()
	public List<Patient> getAllPatient() {
		return patientDAO.getAllPatient();
	}

	@Transactional()
	public List<Patient> searchPatientByFirstName(String firstName) {
		return patientDAO.searchPatientByFirstName(firstName);
	}

	@Transactional()
	public Patient findPatientByUuid(int uuid) {
		return patientDAO.findPatientByUuid(uuid);
	}
}
