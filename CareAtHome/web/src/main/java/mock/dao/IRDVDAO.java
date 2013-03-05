package mock.dao;

import java.util.List;

import mock.beans.RDV;

import fr.umlv.m2.jee.dao.hibernate.IHibernateDAO;


public interface IRDVDAO extends IHibernateDAO<Long, RDV> {
	public List<RDV> getTour(int uuidPersonnel);
}
