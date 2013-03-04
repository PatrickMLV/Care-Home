package fr.umlv.careAtHome.persistence.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.umlv.careAtHome.persistence.beans.Responsable;
import fr.umlv.careAtHome.persistence.dao.IResponsableDAO;
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
