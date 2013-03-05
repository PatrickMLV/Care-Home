package mock.dao;

import mock.beans.Laboratory;
import fr.umlv.m2.jee.dao.hibernate.IHibernateDAO;


public interface ILaboratoryDAO extends IHibernateDAO<Long, Laboratory> {
	public Laboratory getLaboratoryByUuid(int uuid);
}
