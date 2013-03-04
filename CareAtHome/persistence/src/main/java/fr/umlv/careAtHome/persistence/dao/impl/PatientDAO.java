package fr.umlv.careAtHome.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import fr.umlv.careAtHome.persistence.beans.Patient;
import fr.umlv.careAtHome.persistence.dao.IPatientDAO;
import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

@Repository
public class PatientDAO extends AbstractHibernateDAO<Long, Patient> implements IPatientDAO{

}
