package models;

import java.util.List;

import javax.faces.model.ListDataModel;

import mock.beans.DayOff;

import org.primefaces.model.SelectableDataModel;

public class DayOffDataModel extends ListDataModel<DayOff> implements SelectableDataModel<DayOff> {

	public DayOffDataModel() {  
    }  
  
    public DayOffDataModel(List<DayOff> data) {  
        super(data);  
    }
    
	@Override
	public DayOff getRowData(String key) {
		@SuppressWarnings("unchecked")
		List<DayOff> dayOffs = (List<DayOff>) getWrappedData();  
        
        for(DayOff dayOff : dayOffs) {  
            if(dayOff.getUuid() == Integer.parseInt(key)){
            	return dayOff;
            }
        }  
        return null; 
	}

	@Override
	public Object getRowKey(DayOff dayOff) {
		return dayOff.getUuid();
	}

}
