package beans;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import mock.beans.Actor;
import mock.dao.impl.ActorDAO;
import mock.services.ActorService;


@ManagedBean
@RequestScoped
@Named("loginBean")
public class LoginBean {
	
	private String login;
	private String password;
	private Actor user;
	
	private ActorService actorService = new ActorService(new ActorDAO());
	
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
	public Actor getUser() {
		return user;
	}
	public void setUser(Actor user) {
		this.user = user;
	}
	
	public String authentificate() {  
		user = actorService.login(login, password);
        if (user != null){
        	return "success";
        }
        FacesContext.getCurrentInstance().addMessage(null, 
        		new FacesMessage(FacesMessage.SEVERITY_ERROR, "Wrong login or password","login error message"));  
        return "error";
    }  
}
