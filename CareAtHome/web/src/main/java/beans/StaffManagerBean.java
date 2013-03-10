package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import java.util.List;

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
	private Personnel newStaff = new Personnel();
	private StaffDataModel staffDataModel;
	
	private IPersonnelDAO dao = new PersonnelDAO();
	private PersonnelService personnelService = new PersonnelService(dao);
	
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

	public Personnel getNewStaff() {
		return newStaff;
	}

	public void setNewStaff(Personnel newStaff) {
		this.newStaff = newStaff;
	}

	public StaffDataModel getStaffDataModel() {
		return staffDataModel;
	}
	
	public List<Personnel> getStaffList(){
		return personnelService.getAllPersonnel();
	}
	
	public void createStaff(){
		personnelService.create(newStaff);
		newStaff = new Personnel();
	}
	
	public void updateStaff(){
		personnelService.update(selectedStaff);
	}
	
	public void deleteStaff(){
		personnelService.delete(selectedStaff);
		selectedStaff = new Personnel();
	}
	
}
