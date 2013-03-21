package mock.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import mock.beans.Laboratory;
import mock.beans.Medecin;
import mock.beans.Patient;
import mock.beans.Pharmacie;
import mock.dao.IPatientDAO;

import org.springframework.stereotype.Repository;

import fr.umlv.m2.jee.dao.hibernate.AbstractHibernateDAO;

@Repository
public class PatientDAO extends AbstractHibernateDAO<Long, Patient> implements IPatientDAO{

	private List<Patient> patients = new ArrayList<Patient>();

	public PatientDAO(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Medecin> medecins = new MedecinDAO().findAll();
		List<Laboratory> laboratories = new LaboratoryDAO().findAll();
		List<Pharmacie> pharmacies = new PharmacieDAO().findAll();
		try {
			Patient patient1 = new Patient(1, "Redon", "Pierre", sdf.parse("14/02/1984"), "1 84 02 75 538 217 01", "20 Rue Saint-Martin, 75004 Paris", "01 43 57 39 46", 2, medecins.get(0), laboratories.get(0), pharmacies.get(0));
			patient1.setMonday(2);
			patient1.setFriday(3);
			patients.add(patient1);
			
			Patient patient2 = new Patient(2, "Avoine", "Anne-Marie", sdf.parse("28/12/1982"), "2 82 12 75 128 087 16", "8 Avenue Franklin Delano Roosevelt, 75008 Paris", "01 43 19 20 42", 3, medecins.get(1), laboratories.get(1), pharmacies.get(1));
			patient2.setMonday(1);
			patient2.setWednesday(1);
			patients.add(patient2);
			
			Patient patient3 = new Patient(3, "Bernard", "Eric", sdf.parse("11/04/1976"), "1 76 04 75 879 586 13", "12 Boulevard des Capucines, 75009 Paris", "01 43 30 03 56", 4, medecins.get(2), laboratories.get(2), pharmacies.get(2));
			patient3.setTuesday(2);
			patient3.setWednesday(1);
			patient3.setThursday(2);
			patient3.setFriday(1);
			patients.add(patient3);
			
			Patient patient4 = new Patient(4, "Wollf", "Catherine", sdf.parse("22/08/1990"), "2 90 08 75 143 264 97", "7 Rue du Faubourg Montmartre, 75009 Paris", "01 43 99 51 02", 5, medecins.get(3), laboratories.get(3), pharmacies.get(3));
			patient4.setWednesday(1);
			patients.add(patient4);
			
			Patient patient5 = new Patient(5, "Morel", "André", sdf.parse("15/10/1940"), "1 40 10 75 583 159 36", "41 Rue Monsieur le Prince, 75006 Paris", "01 43 36 51 92", 6, medecins.get(4), laboratories.get(4), pharmacies.get(4));
			patient5.setMonday(1);
			patient5.setTuesday(2);
			patient5.setWednesday(1);
			patient5.setThursday(2);
			patient5.setFriday(1);
			patients.add(patient5);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Patient findPatientByUuid(int uuid) {
		for (Patient patient : patients){
			if (patient.getUuid() == uuid){
				return patient;
			}
		}
		return null;
	}

	@Override
	public List<Patient>  searchPatientByFirstName(String firstName) {
		List<Patient> result = new ArrayList<Patient>();
		for (Patient patient : patients){
			if (patient.getFirstName().startsWith(firstName)){
				result.add(patient);
			}
		}
		return result;
	}

	@Override
	public List<Patient> getAllPatient() {
		Collections.sort(patients, new Comparator<Patient>() {

			@Override
			public int compare(Patient o1, Patient o2) {
				return o1.getFirstName().compareTo(o2.getFirstName());
			}
		});
		return patients;
	}

	@Override
	public Patient persist(Patient toPersist) {
		toPersist.setUuid(patients.size()+1);
		patients.add(toPersist);
		return toPersist;
	}

	@Override
	public Patient merge(Patient toMerge) {
		for (Patient patient : patients){
			if (patient.getUuid() == toMerge.getUuid()){
				patients.remove(patient);
				break;
			}
		}
		patients.add(toMerge);
		return toMerge;
	}

	@Override
	public void remove(Patient toRemove) {
		for (Patient patient : patients){
			if (patient.getUuid() == toRemove.getUuid()){
				patients.remove(patient);
				break;
			}
		}
	}

}
