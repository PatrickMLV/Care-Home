package models;

import java.util.List;

import javax.faces.model.ListDataModel;

import mock.beans.Personnel;

import org.primefaces.model.SelectableDataModel;

public class StaffDataModel extends ListDataModel<Personnel> implements SelectableDataModel<Personnel> {

	public StaffDataModel() {  
    }  
  
    public StaffDataModel(List<Personnel> data) {  
        super(data);  
    }
    
	@Override
	public Personnel getRowData(String key) {
		@SuppressWarnings("unchecked")
		List<Personnel> staffs = (List<Personnel>) getWrappedData();  
        
        for(Personnel staff : staffs) {  
            if(staff.getUuid() == Integer.parseInt(key)){
            	return staff;
            }
        }  
        return null; 
	}

	@Override
	public Object getRowKey(Personnel staff) {
		System.out.println(staff.getUuid()+" "+staff.getBirthday());
		return staff.getUuid();
	}

}
