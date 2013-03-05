package mock.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="ACTOR")
public class Actor {

	@Id
	@GeneratedValue
	@Column(name = "UUID")
	private int uuid;

	@Column(name = "LOGIN")
	private String login;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "JOB")
	private JOB job;

	@Column(name = "SECTOR")
	private String sector;

	@Column(name = "REFERANT")
	private int uuidReference;

	public Actor() {
	}

	public Actor(int uuid, String login, String password, JOB job,
			String sector, int uuidReference) {
		super();
		this.uuid = uuid;
		this.login = login;
		this.password = password;
		this.job = job;
		this.sector = sector;
		this.uuidReference = uuidReference;
	}

	public int getUuid() {
		return uuid;
	}

	public void setUuid(int uuid) {
		this.uuid = uuid;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public JOB getJob() {
		return job;
	}

	public void setJob(JOB job) {
		this.job = job;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public int getUuidReference() {
		return uuidReference;
	}

	public void setUuidReference(int uuidReference) {
		this.uuidReference = uuidReference;
	}

}
