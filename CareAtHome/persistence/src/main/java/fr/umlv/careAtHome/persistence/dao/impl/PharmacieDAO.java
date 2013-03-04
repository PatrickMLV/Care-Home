package fr.umlv.careAtHome.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import fr.umlv.careAtHome.persistence.beans.Pharmacie;
import fr.umlv.careAtHome.persistence.dao.IPharmacieDAO;
import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

@Repository
public class PharmacieDAO extends AbstractHibernateDAO<Long, Pharmacie> implements IPharmacieDAO{

}
