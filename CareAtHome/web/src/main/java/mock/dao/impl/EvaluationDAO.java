package mock.dao.impl;

import mock.beans.Evaluation;
import mock.dao.IEvaluationDAO;

import org.springframework.stereotype.Repository;

import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

@Repository
public class EvaluationDAO extends AbstractHibernateDAO<Long, Evaluation> implements IEvaluationDAO{
	

}
