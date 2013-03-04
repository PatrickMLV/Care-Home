package fr.umlv.careAtHome.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import fr.umlv.careAtHome.persistence.beans.Commentaire;
import fr.umlv.careAtHome.persistence.dao.ICommentaireDAO;
import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

@Repository
public class CommentaireDAO extends AbstractHibernateDAO<Long, Commentaire> implements ICommentaireDAO{

}
