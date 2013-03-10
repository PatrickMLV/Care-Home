package mock.dao.impl;

import java.util.ArrayList;
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
		pharmacies.add(new Pharmacie(1, "Pharmacie 1", "phone-pharma-1", "address-pharma-1"));
	}

	@Override
	public List<Pharmacie> findAll() {
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
