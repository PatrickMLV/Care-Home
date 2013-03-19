package mock.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import mock.beans.Laboratory;
import mock.dao.ILaboratoryDAO;

import org.springframework.stereotype.Repository;

import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

@Repository
public class LaboratoryDAO extends AbstractHibernateDAO<Long, Laboratory> implements ILaboratoryDAO{

	@Override
	public Laboratory getLaboratoryByUuid(int uuid) {
		for (Laboratory Laboratory : laboratories){
			if (Laboratory.getUuid() == uuid){
				return Laboratory;
			}
		}
		return null;
	}

	private List<Laboratory> laboratories = new ArrayList<Laboratory>();

	public LaboratoryDAO(){
		laboratories.add(new Laboratory(1, "Laboratoire d'Analyse Médicale Richelieu", "01 42 60 61 30", "55 Rue de Richelieu, 75002 Paris"));
		laboratories.add(new Laboratory(2, "Laboratoires Notre Dame des Champs", "01 42 22 37 63", "9 Rue Stanislas, 75006 Paris"));
		laboratories.add(new Laboratory(3, "Institut Alfred Fournier", "01 40 78 26 00", "25 Boulevard Saint-Jacques, 75014 Paris"));
		laboratories.add(new Laboratory(4, "Laboratoire Saint Sébastien", "01 47 00 08 99", "2 Boulevard des Filles du Calvaire, 75011 Paris"));
		laboratories.add(new Laboratory(5, "Laboratoire d'Eylau-Saint Didier", "01 41 43 96 00", "55 Rue Saint-Didier, 75116 Paris"));
	}

	@Override
	public List<Laboratory> findAll() {
		Collections.sort(laboratories, new Comparator<Laboratory>() {

			@Override
			public int compare(Laboratory o1, Laboratory o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
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
