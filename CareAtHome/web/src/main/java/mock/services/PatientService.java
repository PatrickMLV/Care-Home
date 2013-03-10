package mock.services;

import java.util.Date;
import java.util.List;

import mock.beans.JOB;
import mock.beans.Medecin;
import mock.beans.Patient;
import mock.dao.IPatientDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("PatientService")
public class PatientService {

	@Autowired
	IPatientDAO patientDAO;

	public PatientService(IPatientDAO patientDAO) {
		this.patientDAO = patientDAO;
	}

//	@Transactional()
//	public Patient addPatientFolder(String firstName, String lastName,
//			Date birthday, String ssid, String address, String phone,
//			String priority, Medecin medecin, int uuidLaboratory,
//			int uuidPharmacie) {
//		Patient patient = new Patient();
//		patient.setAddress(address);
//		patient.setBirthday(birthday);
//		patient.setFirstName(firstName);
//		patient.setLastName(lastName);
//		patient.setJob(JOB.PATIENT);
//		patient.setPhone(phone);
//		patient.setPriority(priority);
//		patient.setMedecin(medecin);
//		patient.setUuidLaboratory(uuidLaboratory);
//		patient.setUuidPharmacie(uuidPharmacie);
//		patientDAO.persist(patient);
//
//		return patient;
//	}

//	@Transactional()
//	public Patient modifyPatientFolder(int uuid, String firstName,
//			String lastName, Date birthday, String ssid, String address,
//			String phone, String priority, Medecin medecin, int uuidLaboratory,
//			int uuidPharmacie) {
//		Patient patient = new Patient();
//		patient.setAddress(address);
//		patient.setBirthday(birthday);
//		patient.setFirstName(firstName);
//		patient.setLastName(lastName);
//		patient.setJob(JOB.PATIENT);
//		patient.setPhone(phone);
//		patient.setPriority(priority);
//		patient.setMedecin(medecin);
//		patient.setUuidLaboratory(uuidLaboratory);
//		patient.setUuidPharmacie(uuidPharmacie);
//		patientDAO.merge(patient);
//		return patient;
//	}

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
	
	@Transactional()
	public void createPatient(Patient patient) {
		patientDAO.persist(patient);
	}
	
	@Transactional()
	public void updatePatient(Patient patient) {
		patientDAO.merge(patient);
	}
	
	@Transactional()
	public void deletePatient(Patient patient) {
		patientDAO.remove(patient);
	}
	
}
