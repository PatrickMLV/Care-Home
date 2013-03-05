package mock.dao.impl;

import javax.persistence.Query;

import mock.beans.Cadre;
import mock.dao.ICadreDAO;

import org.springframework.stereotype.Repository;

import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;


@Repository
public class CadreDAO extends AbstractHibernateDAO<Long, Cadre> implements ICadreDAO{

	@Override
	public Cadre getCadreByUuid(int uuid) {
		Query query = createQuery("SELECT a FROM Cadre a where a.uuid =:uuid");
		query.setParameter("uuid", uuid);
		return (Cadre) query.getSingleResult();
	}

}
