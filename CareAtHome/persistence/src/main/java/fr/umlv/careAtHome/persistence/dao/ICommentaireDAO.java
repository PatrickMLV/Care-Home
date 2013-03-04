package fr.umlv.careAtHome.persistence.dao;

import fr.umlv.careAtHome.persistence.beans.*;
import fr.umlv.m2.jee.dao.hibernate.IHibernateDAO;


public interface ICommentaireDAO extends IHibernateDAO<Long, Commentaire> {
	public Commentaire findCommentaireByUuid(int uuid);
}
