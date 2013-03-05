package mock.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import mock.beans.DayOff;
import mock.dao.IDayOffDAO;

import org.springframework.stereotype.Repository;

import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

@Repository
public class DayOffDAO extends AbstractHibernateDAO<Long, DayOff> implements IDayOffDAO{

	private List<DayOff> dayOffs = new ArrayList<DayOff>();
	
	public DayOffDAO(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			dayOffs.add(new DayOff(1, 1, sdf.parse("06/06/2012"), sdf.parse("07/06/2012")));
			dayOffs.add(new DayOff(2, 1, sdf.parse("06/07/2012"), sdf.parse("07/07/2012")));
			dayOffs.add(new DayOff(3, 2, sdf.parse("06/06/2012"), sdf.parse("07/06/2012")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public DayOff persist(DayOff toPersist) {
		dayOffs.add(toPersist);
		return toPersist;
	}

	@Override
	public List<DayOff> getAllDayOff(int actorUuid) {
		List<DayOff> result = new ArrayList<DayOff>();
		for (DayOff dayOff : dayOffs){
			if (dayOff.getActorUuid()==actorUuid){
				result.add(dayOff);
			}
		}
		return result;
	}
}
