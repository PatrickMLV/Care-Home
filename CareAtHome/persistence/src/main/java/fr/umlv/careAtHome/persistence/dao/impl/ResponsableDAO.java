package fr.umlv.careAtHome.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import fr.umlv.careAtHome.persistence.beans.Responsable;
import fr.umlv.careAtHome.persistence.dao.IResponsableDAO;
import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

@Repository
public class ResponsableDAO extends AbstractHibernateDAO<Long, Responsable> implements IResponsableDAO{

}
