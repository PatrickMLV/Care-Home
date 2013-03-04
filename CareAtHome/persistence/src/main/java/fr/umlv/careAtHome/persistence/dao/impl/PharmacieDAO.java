package fr.umlv.careAtHome.persistence.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.umlv.careAtHome.persistence.beans.Pharmacie;
import fr.umlv.careAtHome.persistence.dao.IPharmacieDAO;
import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

@Repository
public class PharmacieDAO extends AbstractHibernateDAO<Long, Pharmacie> implements IPharmacieDAO{

	@Override
	public Pharmacie getPharmacieByUuid(int uuid) {
		Query query = createQuery("SELECT a FROM Pharmacie a where a.uuid =:uuid");
		query.setParameter("uuid", uuid);
		return (Pharmacie) query.getSingleResult();
	}

}
