import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;

@ManagedBean
@SessionScoped
public class MenuBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MenuModel model;  

	public MenuBean() {  
		model = new DefaultMenuModel();  

		// Patient
		Submenu submenu = new Submenu();  
		submenu.setLabel("Patient");  
		// Manage
		MenuItem item = new MenuItem();  
		item.setValue("Manage");  
		item.setUrl("/patient/manage.xhtml");  
		submenu.getChildren().add(item);  
		// Consult
		item = new MenuItem();  
		item.setValue("Consult");  
		item.setUrl("/patient/consult.xhtml");  
		submenu.getChildren().add(item);

		model.addSubmenu(submenu);  
		// Staff
		submenu = new Submenu();  
		submenu.setLabel("Staff");  
		// Manage
		item = new MenuItem();  
		item.setValue("Manage");  
		item.setUrl("/staff/manage.xhtml");  
		submenu.getChildren().add(item);  
		// Consult
		item = new MenuItem();  
		item.setValue("Consult");  
		item.setUrl("/staff/consult.xhtml");  
		submenu.getChildren().add(item);
		// Circuit
		item = new MenuItem();  
		item.setValue("Circuit");  
		item.setUrl("/staff/circuit.xhtml");  
		submenu.getChildren().add(item);
		// Day Off
		item = new MenuItem();  
		item.setValue("Day Off");  
		item.setUrl("/staff/dayoff.xhtml");  
		submenu.getChildren().add(item);
		// Evaluation
		item = new MenuItem();  
		item.setValue("Evaluation");  
		item.setUrl("/staff/evaluation.xhtml");  
		submenu.getChildren().add(item);

		model.addSubmenu(submenu);  


	}  

	public MenuModel getModel() {  
		return model;  
	}  
}
