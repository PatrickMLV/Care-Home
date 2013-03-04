package fr.umlv.careAtHome.persistence.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="PATIENT")
public class Patient extends Actor  {

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

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PHONE")
    private String phone;
    
    @Column(name = "PRIORITY")
    private String priority;
    
    @Column(name = "UUID_MEDECIN")
    private int uuidMedecin;
    
    @Column(name = "UUID_LABORATORY")
    private int uuidLaboratory;
    
    @Column(name = "UUID_PHARMACIE")
    private int uuidPharmacie;
	
    public Patient() {
	}

	public Patient(int uuid, String firstName, String lastName, Date birthday,
			String ssid, String address, String phone, String priority,
			int uuidMedecin, int uuidLaboratory, int uuidPharmacie) {
		super();
		this.uuid = uuid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.ssid = ssid;
		this.address = address;
		this.phone = phone;
		this.priority = priority;
		this.uuidMedecin = uuidMedecin;
		this.uuidLaboratory = uuidLaboratory;
		this.uuidPharmacie = uuidPharmacie;
	}

	public int getUuid() {
		return uuid;
	}

	public void setUuid(int uuid) {
		this.uuid = uuid;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public int getUuidMedecin() {
		return uuidMedecin;
	}

	public void setUuidMedecin(int uuidMedecin) {
		this.uuidMedecin = uuidMedecin;
	}

	public int getUuidLaboratory() {
		return uuidLaboratory;
	}

	public void setUuidLaboratory(int uuidLaboratory) {
		this.uuidLaboratory = uuidLaboratory;
	}

	public int getUuidPharmacie() {
		return uuidPharmacie;
	}

	public void setUuidPharmacie(int uuidPharmacie) {
		this.uuidPharmacie = uuidPharmacie;
	}
    
}
