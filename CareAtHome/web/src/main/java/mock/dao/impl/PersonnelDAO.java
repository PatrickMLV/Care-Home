package mock.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import mock.beans.Personnel;
import mock.dao.IPersonnelDAO;

import org.springframework.stereotype.Repository;

import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

@Repository
public class PersonnelDAO extends AbstractHibernateDAO<Long, Personnel> implements IPersonnelDAO{

	private List<Personnel> personnels = new ArrayList<Personnel>();

	public PersonnelDAO(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			personnels.add(new Personnel(1, "Angely", "Catherine", sdf.parse("22/10/1986"), "2 86 10 75 068 579 10", "06 43 52 39 46", "Heaume Chantal", "acatherine", "acatherine"));
			personnels.add(new Personnel(2, "Dahan", "Georges", sdf.parse("16/04/1981"), "1 81 04 75 142 442 75", "06 28 68 92 01", "Maes Yunsan", "dgeorges", "dgeorges"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<Personnel> searchcaregiverByName(String firstName) {
		List<Personnel> result = new ArrayList<Personnel>();
		for (Personnel personnel : personnels){
			if (personnel.getFirstName().startsWith(firstName)){
				result.add(personnel);
			}
		}
		return result;
	}

	@Override
	public Personnel getcaregiverByUuid(int uuid) {
		for (Personnel personnel : personnels){
			if (personnel.getUuid() == uuid){
				return personnel;
			}
		}
		return null;
	}

	@Override
	public List<Personnel> getcaregiverByUuids(List<Integer> uuids) {
		List<Personnel> result = new ArrayList<Personnel>();
		for (Personnel personnel : personnels){
			if (uuids.contains(personnel.getUuid())){
				result.add(personnel);
			}
		}
		return result;
	}

	@Override
	public Personnel persist(Personnel toPersist) {
		toPersist.setUuid(personnels.size()+1);
		personnels.add(toPersist);
		return toPersist;
	}
	
	@Override
	public Personnel merge(Personnel toMerge) {
		for (Personnel personnel : personnels){
			if (personnel.getUuid() == toMerge.getUuid()){
				personnels.remove(personnel);
				break;
			}
		}
		personnels.add(toMerge);
		return toMerge;
	}
	
	@Override
	public void remove(Personnel toRemove) {
		for (Personnel personnel : personnels){
			if (personnel.getUuid() == toRemove.getUuid()){
				personnels.remove(personnel);
				break;
			}
		}
	}
	@Override
	public List<Personnel> getAllPersonnel() {
		Collections.sort(personnels, new Comparator<Personnel>() {

			@Override
			public int compare(Personnel o1, Personnel o2) {
				return o1.getFirstName().compareTo(o2.getFirstName());
			}
		});
		return personnels;
	}

}
