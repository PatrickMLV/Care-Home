package fr.umlv.careAtHome.persistence.dao;

import fr.umlv.careAtHome.persistence.beans.*;
import fr.umlv.m2.jee.dao.hibernate.IHibernateDAO;


public interface IActorDAO extends IHibernateDAO<Long, Actor> {
	
	public Actor findActorByUuid(int uuid);
	public Actor login(String login, String password);

}
