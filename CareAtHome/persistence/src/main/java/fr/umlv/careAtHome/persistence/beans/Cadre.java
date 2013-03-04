package fr.umlv.careAtHome.persistence.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="CADRE")
public class Cadre extends Actor  {

	@Id
	@GeneratedValue
	@Column(name = "UUID")
	private int uuid;

	@Column(name = "FIRSTNAME")
	private String firstName;

	@Column(name = "LASTNAME")
	private String lastName;

	@Column(name = "BIRTHDAY")
	private Date birthday;

	@Column(name = "SSID")
	private String ssid;

	@Column(name = "PHONE")
	private String phone;

	@Column(name = "REFERANT")
	private String referant;

	public Cadre(String firstName, String lastName, Date birthday,
			String ssid, String phone, String referant) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.ssid = ssid;
		this.referant = referant;
		this.phone = phone;
	}

	public Cadre() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSsid() {
		return ssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	public String getReferant() {
		return referant;
	}

	public void setReferant(String referant) {
		this.referant = referant;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
