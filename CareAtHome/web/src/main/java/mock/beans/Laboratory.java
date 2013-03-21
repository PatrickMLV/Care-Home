package mock.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="LABORATORY")
public class Laboratory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	
	@Override
	public String toString() {
		return name+" ("+uuid+")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adress == null) ? 0 : adress.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + uuid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Laboratory other = (Laboratory) obj;
		if (adress == null) {
			if (other.adress != null)
				return false;
		} else if (!adress.equals(other.adress))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (uuid != other.uuid)
			return false;
		return true;
	}
	
	
}
