package beans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
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
		if (newPatient.getFirstName().isEmpty()){
			FacesContext.getCurrentInstance().addMessage(null, 
		        		new FacesMessage(FacesMessage.SEVERITY_ERROR, "The first name musn't be null","adding patient error message"));  
		    return ;    
		}
		if (newPatient.getLastName().isEmpty()){
			FacesContext.getCurrentInstance().addMessage(null, 
		        		new FacesMessage(FacesMessage.SEVERITY_ERROR, "The last name musn't be null","adding patient error message"));  
		    return ;    
		}
		if (newPatient.getPhone().isEmpty()){
			FacesContext.getCurrentInstance().addMessage(null, 
		        		new FacesMessage(FacesMessage.SEVERITY_ERROR, "The phone number musn't be null","adding patient error message"));  
		    return ;    
		}
		if (newPatient.getAddress().isEmpty()){
			FacesContext.getCurrentInstance().addMessage(null, 
		        		new FacesMessage(FacesMessage.SEVERITY_ERROR, "The address musn't be null","adding patient error message"));  
		    return ;    
		}
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
