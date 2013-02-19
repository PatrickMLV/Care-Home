import java.io.Serializable;
import java.util.ArrayList;
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
import com.google.code.geocoder.model.LatLngBounds;

@ManagedBean
@SessionScoped
public class MapBean implements Serializable {

	private static final long serialVersionUID = -2315695442414431958L;

	private MapModel simpleModel;

	private Marker marker;
	private String test = "Test d'affichage";
	private double lat = 0;
	private double lon = 0;
	private double minLat = 9999;
	private double minLon = 9999;
	private double maxLat = 0;
	private double maxLon = 0;	
	private double zoom = 13;
	
	public String getTest() {
		return test;
	}

	public double getLat() {
		return lat;
	}

	public double getLon() {
		return lon;
	}

	public double getZoom() {
		return zoom;
	}
	
	public MapBean() {
		simpleModel = new DefaultMapModel();
		String[] AdressList = {
				"Copernic 5 Boulevard Descartes, 77454 Champs-sur-Marne",
				"Aérodrome de Lognes-Emerainville, Boulevard de Courcerin Lognes",
				"2 Boulevard Blaise Pascal 93162 Noisy-le-Grand Esiee" };
		
		final Geocoder geocoder = new Geocoder();
		GeocoderRequest geocoderRequest = null;
		GeocodeResponse geocodeResponse = null;
		List<GeocoderResult> results = new ArrayList<GeocoderResult>();
		LatLng coord = null;
		
		for (String string : AdressList) {
			geocoderRequest = new GeocoderRequestBuilder().setAddress(string).setLanguage("fr").getGeocoderRequest();
			geocodeResponse = geocoder.geocode(geocoderRequest);
			results = geocodeResponse.getResults();
			for (GeocoderResult geocoderResult : results) {
				lat = geocoderResult.getGeometry().getLocation().getLat()
						.doubleValue();
				lon = geocoderResult.getGeometry().getLocation().getLng()
						.doubleValue();
				
				if(lat < minLat){
					minLat = lat;
				}
				if(lat > maxLat){
					maxLat = lat;
				}
				if(lon < minLon){
					minLon = lon;
				}
				if(lon > maxLon){
					maxLon = lon;
				}
				coord = new LatLng(lat, lon);
				
				simpleModel.addOverlay(new Marker(coord, string));
		 	}
		}
		
		
		/**
		 * Calcul du centrage de la map pour voir tous les points
		 */
		lat = (minLat + maxLat)/2;
		lon = (minLon + maxLon)/2;

	}

	public MapModel getSimpleModel() {
		return simpleModel;
	}

	public void onMarkerSelect(OverlaySelectEvent event) {
		marker = (Marker) event.getOverlay();

		addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Marker Selected", marker.getTitle()));
	}

	public Marker getMarker() {
		return marker;
	}

	public void addMessage(FacesMessage message) {
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}
