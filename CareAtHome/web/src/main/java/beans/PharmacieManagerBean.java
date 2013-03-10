package beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import mock.beans.Pharmacie;
import mock.dao.impl.PharmacieDAO;
import mock.services.PharmacieService;

@ManagedBean
@ViewScoped
@Named("pharmacieManagerBean")
public class PharmacieManagerBean {

	private Pharmacie selectedPharmacie;
	private Pharmacie newPharmacie = new Pharmacie();
	
	public static final PharmacieService pharmacieService = new PharmacieService(new PharmacieDAO());
	
	public PharmacieManagerBean(){
	}

	public Pharmacie getSelectedPharmacie() {
		return selectedPharmacie;
	}

	public void setSelectedPharmacie(Pharmacie selectedPharmacie) {
		this.selectedPharmacie = selectedPharmacie;
	}

	public Pharmacie getNewPharmacie() {
		return newPharmacie;
	}

	public void setNewPharmacie(Pharmacie newPharmacie) {
		this.newPharmacie = newPharmacie;
	}

	public List<Pharmacie> getPharmacieList(){
		return pharmacieService.getAllPharmacie();
	}
	
	public void createPharmacie(){
		pharmacieService.createPharmacie(newPharmacie);
		newPharmacie = new Pharmacie();
	}
	
	public void updatePharmacie(){
		pharmacieService.updatePharmacie(selectedPharmacie);
	}
	
	public void deletePharmacie(){
		pharmacieService.deletePharmacie(selectedPharmacie);
		selectedPharmacie = new Pharmacie();
	}
	
}
