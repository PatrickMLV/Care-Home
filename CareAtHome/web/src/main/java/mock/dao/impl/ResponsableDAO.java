package mock.dao.impl;

import javax.persistence.Query;

import mock.beans.Responsable;
import mock.dao.IResponsableDAO;

import org.springframework.stereotype.Repository;

import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

@Repository
public class ResponsableDAO extends AbstractHibernateDAO<Long, Responsable> implements IResponsableDAO{

	@Override
	public Responsable getResponsableByUuid(int uuid) {
		Query query = createQuery("SELECT a FROM Responsable a where a.uuid =:uuid");
		query.setParameter("uuid", uuid);
		return (Responsable) query.getSingleResult();
	}
}
