package fr.umlv.careAtHome.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import fr.umlv.careAtHome.persistence.beans.Evaluation;
import fr.umlv.careAtHome.persistence.dao.IEvaluationDAO;
import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

@Repository
public class EvaluationDAO extends AbstractHibernateDAO<Long, Evaluation> implements IEvaluationDAO{
	

}
