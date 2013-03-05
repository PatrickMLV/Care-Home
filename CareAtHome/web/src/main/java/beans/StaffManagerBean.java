package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import mock.beans.Personnel;
import mock.dao.IPersonnelDAO;
import mock.dao.impl.PersonnelDAO;
import mock.services.PersonnelService;
import models.StaffDataModel;

@ManagedBean
@RequestScoped
@Named("staffManagerBean")
public class StaffManagerBean {

	private Personnel selectedStaff;
	private StaffDataModel staffDataModel;
	
	// begin to delete
	private IPersonnelDAO dao = new PersonnelDAO();
	private PersonnelService personnelService = new PersonnelService(dao);
	// end
	
	public StaffManagerBean(){
	}
	
	public void init(){
		staffDataModel = new StaffDataModel(personnelService.getAllPersonnel());
	}

	public Personnel getSelectedStaff() {
		return selectedStaff;
	}

	public void setSelectedStaff(Personnel selectedStaff) {
		this.selectedStaff = selectedStaff;
	}

	public StaffDataModel getStaffDataModel() {
		return staffDataModel;
	}
	
}
