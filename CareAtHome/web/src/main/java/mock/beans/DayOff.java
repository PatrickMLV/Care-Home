package mock.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="DAYOFF")
public class DayOff {

	@Id
	@GeneratedValue
	@Column(name = "UUID")
	private int uuid;

	@Column(name = "FIRSTNAME")
	private int actorUuid;

	@Column(name = "BEGINDATE")
	private Date beginDate;

	@Column(name = "ENDDATE")
	private Date endDate;

	public DayOff() {
	}

	public DayOff(int uuid, int actorUuid, Date beginDate, Date endDate) {
		super();
		this.uuid = uuid;
		this.actorUuid = actorUuid;
		this.beginDate = beginDate;
		this.endDate = endDate;
	}

	public int getActorUuid() {
		return actorUuid;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public int getUuid() {
		return uuid;
	}

	public void setActorUuid(int actorUuid) {
		this.actorUuid = actorUuid;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setUuid(int uuid) {
		this.uuid = uuid;
	}
}
