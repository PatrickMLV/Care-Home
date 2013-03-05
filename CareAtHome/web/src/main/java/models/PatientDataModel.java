package models;

import java.util.List;

import javax.faces.model.ListDataModel;

import mock.beans.Patient;

import org.primefaces.model.SelectableDataModel;

public class PatientDataModel extends ListDataModel<Patient> implements SelectableDataModel<Patient> {

	public PatientDataModel() {  
    }  
  
    public PatientDataModel(List<Patient> data) {  
        super(data);  
    }
    
	@Override
	public Patient getRowData(String key) {
		@SuppressWarnings("unchecked")
		List<Patient> patients = (List<Patient>) getWrappedData();  
        
        for(Patient patient : patients) {  
            if(patient.getUuid() == Integer.parseInt(key)){
            	return patient;
            }
        }  
        return null; 
	}

	@Override
	public Object getRowKey(Patient patient) {
		return patient.getUuid();
	}

}
