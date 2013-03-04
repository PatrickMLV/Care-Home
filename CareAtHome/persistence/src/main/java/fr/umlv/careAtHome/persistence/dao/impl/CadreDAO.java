package fr.umlv.careAtHome.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import fr.umlv.careAtHome.persistence.beans.Cadre;
import fr.umlv.careAtHome.persistence.dao.ICadreDAO;
import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;


@Repository
public class CadreDAO extends AbstractHibernateDAO<Long, Cadre> implements ICadreDAO{

}
