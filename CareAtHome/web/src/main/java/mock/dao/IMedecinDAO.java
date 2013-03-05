package mock.dao;

import mock.beans.Medecin;
import fr.umlv.m2.jee.dao.hibernate.IHibernateDAO;


public interface IMedecinDAO extends IHibernateDAO<Long, Medecin> {
	public Medecin getMedecinByUuid(int uuid);
}
