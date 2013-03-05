package mock.dao.impl;

import javax.persistence.Query;

import mock.beans.Actor;
import mock.beans.JOB;
import mock.dao.IActorDAO;

import org.springframework.stereotype.Repository;

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
//		try {
//			Query query = createQuery("SELECT a FROM Actor a where a.login=:login AND a.password=:password");
//			query.setParameter("login", login);
//			query.setParameter("password", password);
//			return (Actor) query.getSingleResult();
//		} catch (Exception e) {
//			return null;
//		}
		
		if (login != null && login.equals("admin") && password!=null && password.equals("admin")){
			return new Actor(1, login, password, JOB.PERSONNEL, "sector", 2);
		}
		return null;
	}

}
