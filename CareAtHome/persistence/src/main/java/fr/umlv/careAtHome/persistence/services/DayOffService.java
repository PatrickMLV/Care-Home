package fr.umlv.careAtHome.persistence.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.umlv.careAtHome.persistence.beans.DayOff;
import fr.umlv.careAtHome.persistence.dao.IDayOffDAO;

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
		dayOff.setEndDAte(endDate);
		dayOffDAO.persist(dayOff);
		return dayOff;
	}

}
