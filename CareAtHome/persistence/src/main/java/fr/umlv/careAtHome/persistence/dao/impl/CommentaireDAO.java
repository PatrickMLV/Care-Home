package fr.umlv.careAtHome.persistence.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.umlv.careAtHome.persistence.beans.Commentaire;
import fr.umlv.careAtHome.persistence.dao.ICommentaireDAO;
import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

@Repository
public class CommentaireDAO extends AbstractHibernateDAO<Long, Commentaire> implements ICommentaireDAO{

	@Override
	public Commentaire findCommentaireByUuid(int uuid) {
		Query query = createQuery("SELECT a FROM Commentaire a where a.uuid =:uuid");
		query.setParameter("uuid", uuid);
		return (Commentaire) query.getSingleResult();
	}

}
