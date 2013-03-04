package fr.umlv.careAtHome.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import fr.umlv.careAtHome.persistence.beans.Medecin;
import fr.umlv.careAtHome.persistence.dao.IMedecinDAO;
import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

@Repository
public class MededcinDAO extends AbstractHibernateDAO<Long, Medecin> implements IMedecinDAO{

}
