package mock.dao.impl;

import java.util.List;

import javax.persistence.Query;

import mock.beans.RDV;
import mock.dao.IRDVDAO;

import org.springframework.stereotype.Repository;

import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

@Repository
public class RDVDAO extends AbstractHibernateDAO<Long, RDV> implements IRDVDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<RDV> getTour(int uuidPersonnel) {
		Query query = createQuery("SELECT a FROM RDV a where a.uuidPersonnel =:uuid");
		query.setParameter("uuid", uuidPersonnel);
		return (List<RDV>) query.getResultList();
	}

}
