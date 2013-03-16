package mock.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import mock.beans.Patient;
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
			personnels.add(new Personnel(1, "personnel", "1", sdf.parse("02/03/1990"), "ssid1", "phone1", "referant1"));
			personnels.add(new Personnel(2, "personnel", "2", sdf.parse("03/04/1990"), "ssid2", "phone2", "referant2"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Personnel> searchcaregiverByName(String firstName) {
		//		Query query = createQuery("SELECT a FROM Personnel a WHERE a.firstname =:firstname");
		//		return (List<Personnel>) query.getResultList();


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
		//		Query query = createQuery("SELECT a FROM Personnel a where a.uuid =:uuid");
		//		query.setParameter("uuid", uuid);
		//		return (Personnel) query.getSingleResult();

		for (Personnel personnel : personnels){
			if (personnel.getUuid() == uuid){
				return personnel;
			}
		}
		return null;
	}

	@Override
	public List<Personnel> getcaregiverByUuids(List<Integer> uuids) {
		//		List<Personnel> personnels = new ArrayList<Personnel>();
		//		Query query = createQuery("SELECT a FROM Personnel a where a.uuid =:uuid");
		//		
		//		for (int uuid : uuids) {
		//			query.setParameter("uuid", uuid);
		//			personnels.add((Personnel) query.getSingleResult());
		//		}
		//		return personnels;

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
		//			// TODO Auto-generated method stub
		//			return super.persist(toPersist);
		toPersist.setUuid(personnels.size()+1);
		personnels.add(toPersist);
		return toPersist;
	}
	
	@Override
	public Personnel merge(Personnel toMerge) {
//		// TODO Auto-generated method stub
//		return super.merge(toMerge);
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
//		// TODO Auto-generated method stub
//		super.remove(toRemove);
		
		for (Personnel personnel : personnels){
			if (personnel.getUuid() == toRemove.getUuid()){
				personnels.remove(personnel);
				break;
			}
		}
	}
	@Override
	public List<Personnel> getAllPersonnel() {
		return personnels;
	}

}
