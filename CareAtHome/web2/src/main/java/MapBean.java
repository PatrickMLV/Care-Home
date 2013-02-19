
import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderResult;

 
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
	private double lat;
	private double lon;

	public String getTest() {
		return test;
	}
	public double getLat() {
		return lat;
	}public double getLon() {
		return lon;
	}

	public MapBean() {
		simpleModel = new DefaultMapModel();
		
		//Shared coordinates
		/*LatLng coord1 = new LatLng(36.879466, 30.667648);
		LatLng coord2 = new LatLng(36.883707, 30.689216);
		LatLng coord3 = new LatLng(36.879703, 30.706707);*/
		LatLng coord4 = null;
		LatLng coord5 = null;
		
		final Geocoder geocoder = new Geocoder();
		GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress("5 Boulevard Descartes, 77454 Champs-sur-Marne").setLanguage("en").getGeocoderRequest();
		GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
		List<GeocoderResult> results = geocoderResponse.getResults();
		for (GeocoderResult geocoderResult : results) {
			lat = geocoderResult.getGeometry().getLocation().getLat().doubleValue();
			lon = geocoderResult.getGeometry().getLocation().getLng().doubleValue();
			coord4 = new LatLng(lat, lon);
		}
		
		
		geocoderRequest = new GeocoderRequestBuilder().setAddress("Aérodrome de Lognes-Emerainville, Darse B, Boulevard de Courcerin Lognes").setLanguage("en").getGeocoderRequest();
		geocoderResponse = geocoder.geocode(geocoderRequest);
		results = geocoderResponse.getResults();
		for (GeocoderResult geocoderResult : results) {
			coord5 = new LatLng(geocoderResult.getGeometry().getLocation().getLat().doubleValue(), geocoderResult.getGeometry().getLocation().getLng().doubleValue());
		}
		
		//Basic marker
		/*simpleModel.addOverlay(new Marker(coord1, "Konyaalti"));
		simpleModel.addOverlay(new Marker(coord2, "Ataturk Parki"));
		simpleModel.addOverlay(new Marker(coord3, "Karaalioglu Parki"));*/
		simpleModel.addOverlay(new Marker(coord4, "Test Fac"));
		simpleModel.addOverlay(new Marker(coord5, "Test Aerodrome"));
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
					