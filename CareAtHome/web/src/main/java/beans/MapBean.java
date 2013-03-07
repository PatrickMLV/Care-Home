package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import mock.beans.Patient;

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
@Named("mapBean")
public class MapBean implements Serializable {

	private static final long serialVersionUID = -2315695442414431958L;

	private MapModel simpleModel;

	private Marker marker;
	private double lat = 0;
	private double lon = 0;
	private double minLat = 9999;
	private double minLon = 9999;
	private double maxLat = 0;
	private double maxLon = 0;
	private double zoom = 13;
	private List<Patient> users = new ArrayList<Patient>();

	public List<Patient> getUsers() {
		return users;
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
		users.add(new Patient(15, "Fac", "MLV", new Date(), "alalala",
				"Copernic 5 Boulevard Descartes, 77454 Champs-sur-Marne",
				 "0606060606","1AP", 200, 300, 400));
		users.add(new Patient(
				16,
				"Aerodrome",
				"Lognes",
				new Date(),
				"alalala",
				"Aerodrome de Lognes-Emerainville, Boulevard de Courcerin Lognes",
				 "0707070707","1AP", 200, 300, 400));
		users.add(new Patient(17, "Ecole", "Esiee", new Date(), "alalala",
				"2 Boulevard Blaise Pascal 93162 Noisy-le-Grand Esiee", 
				"0808080808","1AP", 200, 300, 400));

		simpleModel = new DefaultMapModel();

		final Geocoder geocoder = new Geocoder();
		GeocoderRequest geocoderRequest = null;
		GeocodeResponse geocodeResponse = null;
		List<GeocoderResult> results = new ArrayList<GeocoderResult>();
		LatLng coord = null;

		for (Patient user : users) {
			geocoderRequest = new GeocoderRequestBuilder()
			.setAddress(user.getAddress()).setLanguage("fr")
			.getGeocoderRequest();
			geocodeResponse = geocoder.geocode(geocoderRequest);
			results = geocodeResponse.getResults();
			for (GeocoderResult geocoderResult : results) {
				lat = geocoderResult.getGeometry().getLocation().getLat()
						.doubleValue();
				lon = geocoderResult.getGeometry().getLocation().getLng()
						.doubleValue();

				if (lat < minLat) {
					minLat = lat;
				}
				if (lat > maxLat) {
					maxLat = lat;
				}
				if (lon < minLon) {
					minLon = lon;
				}
				if (lon > maxLon) {
					maxLon = lon;
				}
				coord = new LatLng(lat, lon);

				simpleModel.addOverlay(new Marker(coord, user.getAddress()));
			}
		}

		zoomDefinition(minLat, minLon, maxLat, maxLon, users.size());

		/**
		 * Calcul du centrage de la map pour voir tous les points
		 */
		lat = (minLat + maxLat) / 2;
		lon = (minLon + maxLon) / 2;

	}

	public void zoomDefinition(double minLat, double minLon, double maxLat,
			double maxLon, int marquerNumber) {
		/**
		 * Si on a qu'un marqueur on met par defaut le zoom a 13
		 */
		if (marquerNumber == 1 || ((minLat == maxLat) && (minLat == maxLat))) {
			zoom = 13;
		} else {

			int mapdisplay = 322;
			double dist = (6371 * Math
					.acos(Math.sin(minLat / 57.2958)
							* Math.sin(maxLat / 57.2958)
							+ (Math.cos(minLat / 57.2958)
									* Math.cos(maxLat / 57.2958) * Math
									.cos((maxLon / 57.2958)
											- (minLon / 57.2958)))));
			zoom = Math.floor(7
					- Math.log(1.6446 * dist
							/ Math.sqrt(2 * (mapdisplay * mapdisplay)))
							/ Math.log(2));
		}
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
