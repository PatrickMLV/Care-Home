package fr.umlv.careAtHome.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import fr.umlv.careAtHome.persistence.beans.Personnel;
import fr.umlv.careAtHome.persistence.dao.IPersonnelDAO;
import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

@Repository
public class PersonnelDAO extends AbstractHibernateDAO<Long, Personnel> implements IPersonnelDAO{

}
