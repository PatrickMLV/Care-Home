package mock.dao;

import java.util.List;

import mock.beans.DayOff;
import fr.umlv.m2.jee.dao.hibernate.IHibernateDAO;


public interface IDayOffDAO extends IHibernateDAO<Long, DayOff> {
	public List<DayOff> getAllDayOff(int actorUuid);
}
