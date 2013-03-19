package mock.dao.impl;

import javax.persistence.Query;

import mock.beans.Actor;
import mock.beans.JOB;
import mock.beans.Personnel;
import mock.dao.IActorDAO;

import org.springframework.stereotype.Repository;

import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

@Repository
public class ActorDAO extends AbstractHibernateDAO<Long, Actor> implements IActorDAO{
	
	PersonnelDAO personnelDAO = new PersonnelDAO();

	@Override
	public Actor findActorByUuid(int uuid) {
		Query query = createQuery("SELECT a FROM Actor a where a.uuid =:uuid");
		query.setParameter("uuid", uuid);
		return (Actor) query.getSingleResult();
	}

	@Override
	public Actor login(String login, String password) {
		if (login == null || password == null) return null;
		
		if (login.equals("admin") && password.equals("admin")){
			return new Actor(0, login, password, JOB.PERSONNEL, "Paris", 2);
		}
		for (Personnel personnel : personnelDAO.getAllPersonnel()){
			if (personnel.getLogin().equals(login) && personnel.getPassword().equals(password)){
				return personnel;
			}
		}
		return null;
	}

}
