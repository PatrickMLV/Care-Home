package mock.dao;

import mock.beans.Cadre;
import fr.umlv.m2.jee.dao.hibernate.IHibernateDAO;


public interface ICadreDAO extends IHibernateDAO<Long, Cadre> {
		
	public Cadre getCadreByUuid(int uuid);
}
