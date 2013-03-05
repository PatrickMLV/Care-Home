package mock.dao;

import mock.beans.Pharmacie;
import fr.umlv.m2.jee.dao.hibernate.IHibernateDAO;


public interface IPharmacieDAO extends IHibernateDAO<Long, Pharmacie> {
	public Pharmacie getPharmacieByUuid(int uuid);
}
