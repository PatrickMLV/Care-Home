package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import mock.beans.DayOff;
import mock.dao.impl.DayOffDAO;
import mock.services.DayOffService;
import models.DayOffDataModel;

@ManagedBean
@RequestScoped
@Named("dayOffManagerBean")
public class DayOffManagerBean {

	private DayOff selectedDayOff;
	private DayOffDataModel dayOffDataModel;
	
	// begin to delete
	private DayOffService dayOffService = new DayOffService(new DayOffDAO());
	
	public void init(int userUuid){
		dayOffDataModel = new DayOffDataModel(dayOffService.getAllDayOff(userUuid));
	}

	public DayOff getSelectedDayOff() {
		return selectedDayOff;
	}

	public void setSelectedDayOff(DayOff selectedDayOff) {
		this.selectedDayOff = selectedDayOff;
	}

	public DayOffDataModel getDayOffDataModel() {
		return dayOffDataModel;
	}
	
}
