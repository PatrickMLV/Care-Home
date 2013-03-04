package fr.umlv.careAtHome.persistence.dao;

import fr.umlv.careAtHome.persistence.beans.*;
import fr.umlv.m2.jee.dao.hibernate.IHibernateDAO;


public interface ILaboratoryDAO extends IHibernateDAO<Long, Laboratory> {
	public Laboratory getLaboratoryByUuid(int uuid);
}
