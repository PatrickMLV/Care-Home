package mock.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import mock.beans.Medecin;
import mock.dao.IMedecinDAO;

import org.springframework.stereotype.Repository;

import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

@Repository
public class MedecinDAO extends AbstractHibernateDAO<Long, Medecin> implements IMedecinDAO{

	@Override
	public Medecin getMedecinByUuid(int uuid) {
//		Query query = createQuery("SELECT a FROM Medecin a where a.uuid =:uuid");
//		query.setParameter("uuid", uuid);
//		return (Medecin) query.getSingleResult();
		for (Medecin medecin : medecins){
			if (medecin.getUuid() == uuid){
				System.out.println("GET MEDECIN "+uuid);
				return medecin;
			}
		}
		return null;
	}
	
	private List<Medecin> medecins = new ArrayList<Medecin>();
	
	public MedecinDAO(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			medecins.add(new Medecin(1, "Doc1", "Tor1", sdf.parse("10/01/1970"), "ssid-medecin-1", "phone-medecin-1", "add-medecin-1"));
			medecins.add(new Medecin(2, "Doc2", "Tor2", sdf.parse("20/02/1970"), "ssid-medecin-2", "phone-medecin-2", "add-medecin-2"));
			medecins.add(new Medecin(3, "Doc3", "Tor3", sdf.parse("30/03/1970"), "ssid-medecin-3", "phone-medecin-3", "add-medecin-3"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Medecin> findAll() {
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
