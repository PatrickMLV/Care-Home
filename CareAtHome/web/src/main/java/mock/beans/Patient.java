package mock.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    
    @ManyToOne(optional=true) 
    @JoinColumn(name="UUID_MEDECIN")
    private Medecin medecin;
    
    @ManyToOne(optional=true) 
    @JoinColumn(name="UUID_LABORATORY")
    private Laboratory laboratory;
    
    @ManyToOne(optional=true) 
    @JoinColumn(name="UUID_PHARMACIE")
    private Pharmacie pharmacie;
	
    public Patient() {
	}

	public Patient(int uuid, String firstName, String lastName, Date birthday,
			String ssid, String address, String phone, String priority,
			Medecin medecin, Laboratory laboratory, Pharmacie pharmacie) {
		super();
		this.uuid = uuid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.ssid = ssid;
		this.address = address;
		this.phone = phone;
		this.priority = priority;
		this.medecin = medecin;
		this.laboratory = laboratory;
		this.pharmacie = pharmacie;
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

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public Laboratory getLaboratory() {
		return laboratory;
	}

	public void setLaboratory(Laboratory laboratory) {
		this.laboratory = laboratory;
	}

	public Pharmacie getPharmacie() {
		return pharmacie;
	}

	public void setPharmacie(Pharmacie pharmacie) {
		this.pharmacie = pharmacie;
	}
    
}
