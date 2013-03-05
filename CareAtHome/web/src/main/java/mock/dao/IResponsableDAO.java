package mock.dao;

import mock.beans.Responsable;
import fr.umlv.m2.jee.dao.hibernate.IHibernateDAO;


public interface IResponsableDAO extends IHibernateDAO<Long, Responsable> {
	public Responsable getResponsableByUuid(int uuid);
}
