package beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import mock.beans.Patient;
import mock.dao.impl.PatientDAO;
import mock.services.PatientService;
import models.PatientDataModel;

@ManagedBean
@RequestScoped
@Named("patientManagerBean")
public class PatientManagerBean {

	private Patient selectedPatient;
	private Patient newPatient = new Patient();
	private PatientDataModel patientDataModel;
	
	private PatientService patientService = new PatientService(new PatientDAO());
	
	public PatientManagerBean(){
	}
	
	public void init(){
		patientDataModel = new PatientDataModel(patientService.getAllPatient());
	}

	public Patient getSelectedPatient() {
		return selectedPatient;
	}

	public void setSelectedPatient(Patient selectedPatient) {
		this.selectedPatient = selectedPatient;
	}

	public Patient getNewPatient() {
		return newPatient;
	}

	public void setNewPatient(Patient newPatient) {
		this.newPatient = newPatient;
	}

	public PatientDataModel getPatientDataModel() {
		return patientDataModel;
	}
	
	public List<Patient> getPatientList(){
		return patientService.getAllPatient();
	}
	
	public void createPatient(){
		patientService.createPatient(newPatient);
		newPatient = new Patient();
	}
	
	public void updatePatient(){
		
		patientService.updatePatient(selectedPatient);
	}
	
	public void deletePatient(){
		patientService.deletePatient(selectedPatient);
		selectedPatient = new Patient();
	}
}
