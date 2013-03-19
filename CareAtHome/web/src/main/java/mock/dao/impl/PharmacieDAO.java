package mock.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import mock.beans.Pharmacie;
import mock.dao.IPharmacieDAO;

import org.springframework.stereotype.Repository;

import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

@Repository
public class PharmacieDAO extends AbstractHibernateDAO<Long, Pharmacie> implements IPharmacieDAO{

	@Override
	public Pharmacie getPharmacieByUuid(int uuid) {
		for (Pharmacie Pharmacie : pharmacies){
			if (Pharmacie.getUuid() == uuid){
				return Pharmacie;
			}
		}
		return null;
	}
	
	private List<Pharmacie> pharmacies = new ArrayList<Pharmacie>();

	public PharmacieDAO(){
		pharmacies.add(new Pharmacie(1, "Grande Pharmacie de la Nation", "01 43 73 24 03", "13 Place de la Nation - 75011 Paris"));
		pharmacies.add(new Pharmacie(2, "Pharmacie Monge", "01 43 31 39 44", "74 Rue Monge, 75005 Paris"));
		pharmacies.add(new Pharmacie(3, "City-Pharma", "01 46 33 20 81", "26 Rue du Four, 75006 Paris"));
		pharmacies.add(new Pharmacie(4, "Pharmacie de la Mairie", "01 42 78 53 58", "9 Rue des Archives, 75004 Paris"));
		pharmacies.add(new Pharmacie(5, "Pharmacie Bader", "01 43 26 92 66", "10-12 Boulevard Saint-Michel, 75006 Paris"));
	}

	@Override
	public List<Pharmacie> findAll() {
		Collections.sort(pharmacies, new Comparator<Pharmacie>() {

			@Override
			public int compare(Pharmacie o1, Pharmacie o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		return pharmacies;
	}

	@Override
	public Pharmacie persist(Pharmacie toPersist) {
		toPersist.setUuid(pharmacies.size()+1);
		pharmacies.add(toPersist);
		return toPersist;
	}

	@Override
	public Pharmacie merge(Pharmacie toMerge) {
		for (Pharmacie Pharmacie : pharmacies){
			if (Pharmacie.getUuid() == toMerge.getUuid()){
				pharmacies.remove(Pharmacie);
				break;
			}
		}
		pharmacies.add(toMerge);
		return toMerge;
	}

	@Override
	public void remove(Pharmacie toRemove) {
		for (Pharmacie Pharmacie : pharmacies){
			if (Pharmacie.getUuid() == toRemove.getUuid()){
				pharmacies.remove(Pharmacie);
				break;
			}
		}
	}

}
