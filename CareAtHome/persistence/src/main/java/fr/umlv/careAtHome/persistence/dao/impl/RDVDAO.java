package fr.umlv.careAtHome.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import fr.umlv.careAtHome.persistence.beans.RDV;
import fr.umlv.careAtHome.persistence.dao.IRDVDAO;
import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

@Repository
public class RDVDAO extends AbstractHibernateDAO<Long, RDV> implements IRDVDAO{

}
