package fr.umlv.careAtHome.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.umlv.careAtHome.persistence.beans.Personnel;
import fr.umlv.careAtHome.persistence.dao.IPersonnelDAO;
import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

@Repository
public class PersonnelDAO extends AbstractHibernateDAO<Long, Personnel> implements IPersonnelDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<Personnel> searchcaregiverByName(String firstName) {
		Query query = createQuery("SELECT a FROM Personnel a WHERE a.firstname =:firstname");
		return (List<Personnel>) query.getResultList();
	}

	@Override
	public Personnel getcaregiverByUuid(int uuid) {
		Query query = createQuery("SELECT a FROM Personnel a where a.uuid =:uuid");
		query.setParameter("uuid", uuid);
		return (Personnel) query.getSingleResult();
	}

	@Override
	public List<Personnel> getcaregiverByUuids(List<Integer> uuids) {
		List<Personnel> personnels = new ArrayList<Personnel>();
		Query query = createQuery("SELECT a FROM Personnel a where a.uuid =:uuid");
		
		for (int uuid : uuids) {
			query.setParameter("uuid", uuid);
			personnels.add((Personnel) query.getSingleResult());
		}
		return personnels;
	}

}
