package fr.umlv.careAtHome.persistence.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.umlv.careAtHome.persistence.beans.Actor;
import fr.umlv.careAtHome.persistence.dao.IActorDAO;
import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

@Repository
public class ActorDAO extends AbstractHibernateDAO<Long, Actor> implements IActorDAO{

	@Override
	public Actor findActorByUuid(int uuid) {
		Query query = createQuery("SELECT a FROM Actor a where a.uuid =:uuid");
		query.setParameter("uuid", uuid);
		return (Actor) query.getSingleResult();
	}

	@Override
	public Actor login(String login, String password) {
		try {
			Query query = createQuery("SELECT a FROM Actor a where a.login=:login AND a.password=:password");
			query.setParameter("login", login);
			query.setParameter("password", password);
			return (Actor) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

}
