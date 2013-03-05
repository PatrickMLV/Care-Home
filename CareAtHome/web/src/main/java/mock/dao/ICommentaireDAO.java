package mock.dao;

import mock.beans.Commentaire;
import fr.umlv.m2.jee.dao.hibernate.IHibernateDAO;


public interface ICommentaireDAO extends IHibernateDAO<Long, Commentaire> {
	public Commentaire findCommentaireByUuid(int uuid);
}
