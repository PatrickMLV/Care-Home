package fr.umlv.careAtHome.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import fr.umlv.careAtHome.persistence.beans.DayOff;
import fr.umlv.careAtHome.persistence.dao.IDayOffDAO;
import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

@Repository
public class DayOffDAO extends AbstractHibernateDAO<Long, DayOff> implements IDayOffDAO{

}
