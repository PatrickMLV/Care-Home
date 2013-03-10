package mock.dao.impl;

import java.util.ArrayList;
import java.util.List;

import mock.beans.Laboratory;
import mock.dao.ILaboratoryDAO;

import org.springframework.stereotype.Repository;

import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

@Repository
public class LaboratoryDAO extends AbstractHibernateDAO<Long, Laboratory> implements ILaboratoryDAO{

	@Override
	public Laboratory getLaboratoryByUuid(int uuid) {
		//		Query query = createQuery("SELECT a FROM Laboratory a where a.uuid =:uuid");
		//		query.setParameter("uuid", uuid);
		//		return (Laboratory) query.getSingleResult();
		for (Laboratory Laboratory : laboratories){
			if (Laboratory.getUuid() == uuid){
				return Laboratory;
			}
		}
		return null;
	}

	private List<Laboratory> laboratories = new ArrayList<Laboratory>();

	public LaboratoryDAO(){
		laboratories.add(new Laboratory(1, "Laboratory 1", "phone-labo-1", "address-labo-1"));
	}

	@Override
	public List<Laboratory> findAll() {
		return laboratories;
	}

	@Override
	public Laboratory persist(Laboratory toPersist) {
		toPersist.setUuid(laboratories.size()+1);
		laboratories.add(toPersist);
		return toPersist;
	}

	@Override
	public Laboratory merge(Laboratory toMerge) {
		for (Laboratory Laboratory : laboratories){
			if (Laboratory.getUuid() == toMerge.getUuid()){
				laboratories.remove(Laboratory);
				break;
			}
		}
		laboratories.add(toMerge);
		return toMerge;
	}

	@Override
	public void remove(Laboratory toRemove) {
		for (Laboratory Laboratory : laboratories){
			if (Laboratory.getUuid() == toRemove.getUuid()){
				laboratories.remove(Laboratory);
				break;
			}
		}
	}

}
