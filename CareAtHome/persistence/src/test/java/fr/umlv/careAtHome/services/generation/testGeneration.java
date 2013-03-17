package fr.umlv.careAtHome.services.generation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import fr.umlv.careAtHome.persistence.beans.Patient;
import fr.umlv.careAtHome.persistence.beans.Personnel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class testGeneration {

    @Test
    public void testGeneration() {
        List<Personnel> staff = new ArrayList<Personnel>();
        staff.add(new Personnel("Prenom1", "Nom1", null, null, null, null));

        List<Patient> expected = new ArrayList<Patient>();
        for (int i = 0; i < 6; i++) {
            expected.add(null);
        }

        List<Patient> patients = new ArrayList<Patient>();
        Patient patient = new Patient(0, "pPrenom1", "pNom1", null, null, "5 Boulevard Descartes, 77420 Champs sur marne", null, 1, 0, 0, 0);
        patient.setDisponibility(new int[]{0, 0, 0, 0, 0, 0, 0});
        expected.remove(0);
        expected.add(0, patient);
        patients.add(patient);
        patient = new Patient(0, "pPrenom2", "pNom2", null, null, "2 Boulevard Blaise Pascal, 93162 Noisy le grand", null, 1, 0, 0, 0);
        patient.setDisponibility(new int[]{1, 0, 0, 0, 0, 0, 0});
        expected.remove(2);
        expected.add(2, patient);
        patients.add(patient);
        patient = new Patient(0, "pPrenom3", "pNom3", null, null, "10 Rue Nelson Mandela, 77420 Champs sur marne", null, 1, 0, 0, 0);
        patient.setDisponibility(new int[]{3, 0, 0, 0, 0, 0, 0});
        expected.remove(5);
        expected.add(5, patient);
        patients.add(patient);
        patient = new Patient(0, "pPrenom4", "pNom4", null, null, "8 Avenue Blaise Pascal, 77420 Champs sur marne", null, 1, 0, 0, 0);
        patient.setDisponibility(new int[]{2, 0, 0, 0, 0, 0, 0});
        expected.remove(3);
        expected.add(3, patient);
        patients.add(patient);
        patient = new Patient(0, "pPrenom5", "pNom5", null, null, "8 Rue Alfred Nobel, 77420 Champs sur marne", null, 1, 0, 0, 0);
        patient.setDisponibility(new int[]{2, 0, 0, 0, 0, 0, 0});
        expected.remove(4);
        expected.add(4, patient);
        patients.add(patient);
        patient = new Patient(0, "pPrenom6", "pNom6", null, null, "Parc de la Butte Verte, 93460 Noisy le Grand", null, 1, 0, 0, 0);
        patient.setDisponibility(new int[]{0, 0, 0, 0, 0, 0, 0});
        expected.remove(1);
        expected.add(1, patient);
        patients.add(patient);

        Map<Personnel,List<Patient>> generated = Generation.generate(0, staff, patients);


        assertEquals(expected, generated.get(staff.get(0)));
    }
}
