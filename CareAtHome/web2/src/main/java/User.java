import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class User {
	private String name;
	private String surname;
	private String adress;
	private String phoneNumber;

	public User(String name, String surname, String adresse, String phoneNumber) {
		super();
		this.name = name;
		this.surname = surname;
		this.adress = adresse;
		this.phoneNumber = phoneNumber;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getAdress() {
		return adress;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getSurname() {
		return surname;
	}

}
