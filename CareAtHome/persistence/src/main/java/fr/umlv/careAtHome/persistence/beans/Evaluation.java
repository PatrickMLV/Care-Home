package fr.umlv.careAtHome.persistence.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Evaluation {

	@Id
	@GeneratedValue
	@Column(name = "UUID")
	private int uuid;
	
	@Column(name = "UUID_EVALUATOR")
	private int uuidEvalusator;
	
	@Column(name = "UUID_ACTOR")
	private int uuidActor;

	@Column(name = "EVALUATION")
	private String evaluation;

	@Column(name = "DATE")
	private Date date;

	public Evaluation() {
	}

	public Evaluation(int uuid, int uuidEvalusator, int uuidActor,
			String evaluation, Date date) {
		super();
		this.uuid = uuid;
		this.uuidEvalusator = uuidEvalusator;
		this.uuidActor = uuidActor;
		this.evaluation = evaluation;
		this.date = date;
	}

	public int getUuid() {
		return uuid;
	}

	public void setUuid(int uuid) {
		this.uuid = uuid;
	}

	public int getUuidEvalusator() {
		return uuidEvalusator;
	}

	public void setUuidEvalusator(int uuidEvalusator) {
		this.uuidEvalusator = uuidEvalusator;
	}

	public int getUuidActor() {
		return uuidActor;
	}

	public void setUuidActor(int uuidActor) {
		this.uuidActor = uuidActor;
	}

	public String getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
