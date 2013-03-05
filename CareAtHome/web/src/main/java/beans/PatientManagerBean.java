package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import mock.beans.Patient;
import mock.dao.IPatientDAO;
import mock.dao.impl.PatientDAO;
import mock.services.PatientService;
import models.PatientDataModel;

@ManagedBean
@RequestScoped
@Named("patientManagerBean")
public class PatientManagerBean {

	private Patient selectedPatient;
	private PatientDataModel patientDataModel;
	
	// begin to delete
	private IPatientDAO dao = new PatientDAO();
	private PatientService patientService = new PatientService(dao);
	// end
	
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

	public PatientDataModel getPatientDataModel() {
		return patientDataModel;
	}
	
}
