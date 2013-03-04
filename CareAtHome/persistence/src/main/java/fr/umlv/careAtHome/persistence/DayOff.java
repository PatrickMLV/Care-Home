package fr.umlv.careAtHome.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class DayOff {

	@Id
	@GeneratedValue
	@Column(name = "UUID")
	private int uuid;

	@Column(name = "FIRSTNAME")
	private String actorUuid;

	@Column(name = "BEGINDATE")
	private Date beginDate;

	@Column(name = "ENDDATE")
	private Date endDAte;

	public DayOff() {
	}

	public DayOff(int uuid, String actorUuid, Date beginDate, Date endDAte) {
		super();
		this.uuid = uuid;
		this.actorUuid = actorUuid;
		this.beginDate = beginDate;
		this.endDAte = endDAte;
	}

	public String getActorUuid() {
		return actorUuid;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public Date getEndDAte() {
		return endDAte;
	}

	public int getUuid() {
		return uuid;
	}

	public void setActorUuid(String actorUuid) {
		this.actorUuid = actorUuid;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public void setEndDAte(Date endDAte) {
		this.endDAte = endDAte;
	}

	public void setUuid(int uuid) {
		this.uuid = uuid;
	}
}
