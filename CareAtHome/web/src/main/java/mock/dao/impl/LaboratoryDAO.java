package mock.dao.impl;

import javax.persistence.Query;

import mock.beans.Laboratory;
import mock.dao.ILaboratoryDAO;

import org.springframework.stereotype.Repository;

import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

@Repository
public class LaboratoryDAO extends AbstractHibernateDAO<Long, Laboratory> implements ILaboratoryDAO{

	@Override
	public Laboratory getLaboratoryByUuid(int uuid) {
		Query query = createQuery("SELECT a FROM Laboratory a where a.uuid =:uuid");
		query.setParameter("uuid", uuid);
		return (Laboratory) query.getSingleResult();
	}

}
