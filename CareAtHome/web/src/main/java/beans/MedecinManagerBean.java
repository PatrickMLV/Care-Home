package beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import mock.beans.Medecin;
import mock.dao.impl.MedecinDAO;
import mock.services.MedecinService;

@ManagedBean
@ViewScoped
@Named("medecinManagerBean")
public class MedecinManagerBean {

	private Medecin selectedMedecin;
	private Medecin newMedecin = new Medecin();
	
	public static final MedecinService medecinService = new MedecinService(new MedecinDAO());
	
	public MedecinManagerBean(){
	}

	public Medecin getSelectedMedecin() {
		return selectedMedecin;
	}

	public void setSelectedMedecin(Medecin selectedMedecin) {
		this.selectedMedecin = selectedMedecin;
	}

	public Medecin getNewMedecin() {
		return newMedecin;
	}

	public void setNewMedecin(Medecin newMedecin) {
		this.newMedecin = newMedecin;
	}

	public List<Medecin> getMedecinList(){
		return medecinService.getAllMedecin();
	}
	
	public void createMedecin(){
		medecinService.createMedecin(newMedecin);
		newMedecin = new Medecin();
	}
	
	public void updateMedecin(){
		medecinService.updateMedecin(selectedMedecin);
	}
	
	public void deleteMedecin(){
		medecinService.deleteMedecin(selectedMedecin);
		selectedMedecin = new Medecin();
	}
	
}
