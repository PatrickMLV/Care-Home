
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

 
@ManagedBean
@SessionScoped
public class MapBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2315695442414431958L;

	private MapModel simpleModel;

	private Marker marker;
	private String test = "Test d'affichage";

	public String getTest() {
		return test;
	}

	public MapBean() {
		simpleModel = new DefaultMapModel();
		
		//Shared coordinates
		LatLng coord1 = new LatLng(36.879466, 30.667648);
		LatLng coord2 = new LatLng(36.883707, 30.689216);
		LatLng coord3 = new LatLng(36.879703, 30.706707);
		
		//Basic marker
		simpleModel.addOverlay(new Marker(coord1, "Konyaalti"));
		simpleModel.addOverlay(new Marker(coord2, "Ataturk Parki"));
		simpleModel.addOverlay(new Marker(coord3, "Karaalioglu Parki"));
	}
	
	public MapModel getSimpleModel() {
		return simpleModel;
	}
	
	public void onMarkerSelect(OverlaySelectEvent event) {
		marker = (Marker) event.getOverlay();
		
		addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Selected", marker.getTitle()));
	}
	
	public Marker getMarker() {
		return marker;
	}
	
	public void addMessage(FacesMessage message) {
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}
					