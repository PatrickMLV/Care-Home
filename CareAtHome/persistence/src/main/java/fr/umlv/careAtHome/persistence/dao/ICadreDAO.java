package fr.umlv.careAtHome.persistence.dao;

import fr.umlv.careAtHome.persistence.beans.*;
import fr.umlv.m2.jee.dao.hibernate.IHibernateDAO;


public interface ICadreDAO extends IHibernateDAO<Long, Cadre> {
		
	public Cadre getCadreByUuid(int uuid);
}
