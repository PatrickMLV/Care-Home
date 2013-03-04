package beans;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;


@ManagedBean
@RequestScoped
@Named("loginBean")
public class LoginBean {
	
	private String login;
	private String password;
	
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
	
	public String authentificate() {  
        if (login!=null && login.equals("admin") && password!=null && password.equals("admin")){
        	return "success";
        }
        return "error";
    }  
}
