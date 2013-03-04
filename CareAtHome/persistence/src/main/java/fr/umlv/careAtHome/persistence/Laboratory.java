package fr.umlv.careAtHome.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Laboratory {

	@Id
	@GeneratedValue
	@Column(name = "UUID")
	private int uuid;

	@Column(name = "NAME")
	private String name;

	@Column(name = "PHONE")
	private String phone;

	@Column(name = "ADRESS")
	private String adress;

	public Laboratory() {
	}

	public Laboratory(int uuid, String name, String phone, String adress) {
		super();
		this.uuid = uuid;
		this.name = name;
		this.phone = phone;
		this.adress = adress;
	}

	public String getAdress() {
		return adress;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public int getUuid() {
		return uuid;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setUuid(int uuid) {
		this.uuid = uuid;
	}
}
