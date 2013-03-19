package mock.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import mock.beans.Medecin;
import mock.dao.IMedecinDAO;

import org.springframework.stereotype.Repository;

import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

@Repository
public class MedecinDAO extends AbstractHibernateDAO<Long, Medecin> implements IMedecinDAO{

	@Override
	public Medecin getMedecinByUuid(int uuid) {
		for (Medecin medecin : medecins){
			if (medecin.getUuid() == uuid){
				return medecin;
			}
		}
		return null;
	}
	
	private List<Medecin> medecins = new ArrayList<Medecin>();
	
	public MedecinDAO(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			medecins.add(new Medecin(1, "Cymes", "Michel", sdf.parse("14/05/1957"), "17920356826", "01 56 09 20 00", "20, rue Leblanc - 75908 Paris"));
			medecins.add(new Medecin(2, "Vernes", "Arthur", sdf.parse("22/05/1959"), "19201251627", "01 44 39 53 00", "36 Rue d'Assas, 75006 Paris"));
			medecins.add(new Medecin(3, "Ktorza", "Thierry ", sdf.parse("30/10/1951"), "25836192720", "01 44 05 13 15", "25 rue Raynouard 75116 Paris"));
			medecins.add(new Medecin(4, "Brachat", "Olivier ", sdf.parse("14/07/1974"), "80372912981", "01 45 49 07 15", "75 Rue de Rennes, 75006 Paris"));
			medecins.add(new Medecin(5, "Denjean", "Dominique ", sdf.parse("21/09/1969"), "42718262917", "01 42 33 46 60", "149 Rue Montmartre, 75002 Paris"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Medecin> findAll() {
		Collections.sort(medecins, new Comparator<Medecin>() {

			@Override
			public int compare(Medecin o1, Medecin o2) {
				return o1.getFirstName().compareTo(o2.getFirstName());
			}
		});
		return medecins;
	}
	
	@Override
	public Medecin persist(Medecin toPersist) {
		toPersist.setUuid(medecins.size()+1);
		medecins.add(toPersist);
		return toPersist;
	}
	
	@Override
	public Medecin merge(Medecin toMerge) {
		for (Medecin medecin : medecins){
			if (medecin.getUuid() == toMerge.getUuid()){
				medecins.remove(medecin);
				break;
			}
		}
		medecins.add(toMerge);
		return toMerge;
	}
	
	@Override
	public void remove(Medecin toRemove) {
		for (Medecin medecin : medecins){
			if (medecin.getUuid() == toRemove.getUuid()){
				medecins.remove(medecin);
				break;
			}
		}
	}

}
