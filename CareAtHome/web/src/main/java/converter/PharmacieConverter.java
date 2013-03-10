package converter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import mock.services.PharmacieService;
import beans.PharmacieManagerBean;

@FacesConverter("pharmacieConverter")
public class PharmacieConverter implements Converter{
	
	private PharmacieService pharmacieService = PharmacieManagerBean.pharmacieService;
	private final Pattern uuidPattern = Pattern.compile("\\(.+\\)");

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		Matcher matcher = uuidPattern.matcher(arg2);
		if (matcher.find()){
			String uuidStr = matcher.group(0).replace("(", "").replace(")", "");
			int uuid = Integer.parseInt(uuidStr);
			return pharmacieService.getPharmacieByUuid(uuid);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return arg2.toString(); 
	}

}
