import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import toPutInPersistence.DayOff;

@ManagedBean
@SessionScoped
public class DayOffBean {

	DayOff dayOff;

	public DayOff getDayOff() {
		return dayOff;
	}

	public void setDayOff(DayOff dayOff) {
		this.dayOff = dayOff;
	}
	
	
}
