package fr.umlv.careAtHome.persistence.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Commentaire {

	@Id
	@GeneratedValue
	@Column(name = "UUID")
	private int uuid;

	@Column(name = "UUID_PERSONNEL")
	private int uuidPersonnel;

	@Column(name = "UUID_PATIENT")
	private int uuidPatient;

	@Column(name = "REMARQUE")
	private String remarque;

	@Column(name = "DATE")
	private Date date;

	public Commentaire() {
	}

	public Commentaire(int uuid, int uuidPersonnel, int uuidPatient,
			String remarque, Date date) {
		super();
		this.uuid = uuid;
		this.uuidPersonnel = uuidPersonnel;
		this.uuidPatient = uuidPatient;
		this.remarque = remarque;
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public String getRemarque() {
		return remarque;
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

	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}

	public void setUuidPatient(int uuidPatient) {
		this.uuidPatient = uuidPatient;
	}

	public void setUuidPersonnel(int uuidPersonnel) {
		this.uuidPersonnel = uuidPersonnel;
	}
}
