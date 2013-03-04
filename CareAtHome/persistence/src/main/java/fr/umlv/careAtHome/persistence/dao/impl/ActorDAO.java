package fr.umlv.careAtHome.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import fr.umlv.careAtHome.persistence.beans.Actor;
import fr.umlv.careAtHome.persistence.dao.IActorDAO;
import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

@Repository
public class ActorDAO extends AbstractHibernateDAO<Long, Actor> implements IActorDAO{

}
