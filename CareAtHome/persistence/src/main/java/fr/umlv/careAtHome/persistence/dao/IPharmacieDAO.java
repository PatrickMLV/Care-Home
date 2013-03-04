package fr.umlv.careAtHome.persistence.dao;

import fr.umlv.careAtHome.persistence.beans.*;
import fr.umlv.m2.jee.dao.hibernate.IHibernateDAO;


public interface IPharmacieDAO extends IHibernateDAO<Long, Pharmacie> {
	public Pharmacie getPharmacieByUuid(int uuid);
}
