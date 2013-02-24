import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import toPutInPersistence.Patient;

@ManagedBean
@SessionScoped
public class PatientBean {

	private Patient patient;
	
	public void setNewPatient(){
		System.out.println("NEW PATIENT");
		patient = new Patient();
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	
}
