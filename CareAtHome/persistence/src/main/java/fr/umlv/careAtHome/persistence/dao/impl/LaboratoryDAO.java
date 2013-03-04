package fr.umlv.careAtHome.persistence.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.umlv.careAtHome.persistence.beans.Laboratory;
import fr.umlv.careAtHome.persistence.dao.ILaboratoryDAO;
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
