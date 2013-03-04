package fr.umlv.careAtHome.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class RDV {

	@Id
	@GeneratedValue
	@Column(name = "UUID")
	private int uuid;
	
	@Column(name = "UUID_PERSONNEL")
	private int uuidPersonnel;
	
	@Column(name = "UUID_PATIENT")
	private int uuidPatient;

	@Column(name = "PRIORITY")
	private int priotiry;

	@Column(name = "DATE")
	private Date date;

	public RDV() {
	}

	public RDV(int uuid, int uuidPersonnel, int uuidPatient, int priotiry, Date date) {
		super();
		this.uuid = uuid;
		this.uuidPersonnel = uuidPersonnel;
		this.uuidPatient = uuidPatient;
		this.priotiry = priotiry;
		this.date = date;
	}

	public Date getDate() {
		return date;
	}


	public int getPriotiry() {
		return priotiry;
	}

	public int getUuid() {
		return uuid;
	}

	public int getUuidPatient() {
		return uuidPatient;
	}
	public int getUuidPersonnel() {
		return uuidPersonnel;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setUuid(int uuid) {
		this.uuid = uuid;
	}

	public void setPriotiry(int priotiry) {
		this.priotiry = priotiry;
	}

	public void setUuidPatient(int uuidPatient) {
		this.uuidPatient = uuidPatient;
	}

	public void setUuidPersonnel(int uuidPersonnel) {
		this.uuidPersonnel = uuidPersonnel;
	}
}
