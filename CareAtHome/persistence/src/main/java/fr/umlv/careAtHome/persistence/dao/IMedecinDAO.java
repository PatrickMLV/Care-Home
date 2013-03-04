package fr.umlv.careAtHome.persistence.dao;

import fr.umlv.careAtHome.persistence.beans.*;
import fr.umlv.m2.jee.dao.hibernate.IHibernateDAO;


public interface IMedecinDAO extends IHibernateDAO<Long, Medecin> {
	public Medecin getMedecinByUuid(int uuid);
}
