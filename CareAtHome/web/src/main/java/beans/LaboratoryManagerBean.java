package beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import mock.beans.Laboratory;
import mock.dao.impl.LaboratoryDAO;
import mock.services.LaboratoryService;

@ManagedBean
@ViewScoped
@Named("laboratoryManagerBean")
public class LaboratoryManagerBean {

	private Laboratory selectedLaboratory;
	private Laboratory newLaboratory = new Laboratory();
	
	public static final LaboratoryService laboratoryService = new LaboratoryService(new LaboratoryDAO());
	
	public LaboratoryManagerBean(){
	}

	public Laboratory getSelectedLaboratory() {
		return selectedLaboratory;
	}

	public void setSelectedLaboratory(Laboratory selectedLaboratory) {
		this.selectedLaboratory = selectedLaboratory;
	}

	public Laboratory getNewLaboratory() {
		return newLaboratory;
	}

	public void setNewLaboratory(Laboratory newLaboratory) {
		this.newLaboratory = newLaboratory;
	}

	public List<Laboratory> getLaboratoryList(){
		return laboratoryService.getAllLaboratory();
	}
	
	public void createLaboratory(){
		laboratoryService.createLaboratory(newLaboratory);
		newLaboratory = new Laboratory();
	}
	
	public void updateLaboratory(){
		laboratoryService.updateLaboratory(selectedLaboratory);
	}
	
	public void deleteLaboratory(){
		laboratoryService.deleteLaboratory(selectedLaboratory);
		selectedLaboratory = new Laboratory();
	}
	
}
