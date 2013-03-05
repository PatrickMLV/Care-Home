package mock.services;

import java.util.Date;
import java.util.List;

import mock.beans.DayOff;
import mock.dao.IDayOffDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("DayOffService")
public class DayOffService {

	@Autowired
	IDayOffDAO dayOffDAO;

	public DayOffService(IDayOffDAO dayOffDAO) {
		this.dayOffDAO = dayOffDAO;
	}

	@Transactional()
	public DayOff setDayOffDemand(int actorUuid, Date beginDate, Date endDate) {
		DayOff dayOff = new DayOff();
		dayOff.setActorUuid(actorUuid);
		dayOff.setBeginDate(beginDate);
		dayOff.setEndDate(endDate);
		dayOffDAO.persist(dayOff);
		return dayOff;
	}
	
	@Transactional()
	public List<DayOff> getAllDayOff(int actorUuid) {
		return dayOffDAO.getAllDayOff(actorUuid);
	}

}
