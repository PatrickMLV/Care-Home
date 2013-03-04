package fr.umlv.careAtHome.persistence.dao;

import java.util.List;

import fr.umlv.careAtHome.persistence.beans.*;
import fr.umlv.m2.jee.dao.hibernate.IHibernateDAO;


public interface IRDVDAO extends IHibernateDAO<Long, RDV> {
	public List<RDV> getTour(int uuidPersonnel);
}
