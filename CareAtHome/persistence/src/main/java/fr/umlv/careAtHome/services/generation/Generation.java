package fr.umlv.careAtHome.services.generation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.umlv.careAtHome.persistence.beans.Patient;
import fr.umlv.careAtHome.persistence.beans.Personnel;

public class Generation {

    // day : 0 = monday, ...
    public static Map<Personnel, List<Patient>> generate(int day, List<Personnel> staffs, List<Patient> patients) {
        int count = patients.size() / staffs.size();
        if (count == 0) {
            return generate(day, staffs.subList(0, patients.size()), patients);
        }

        HashMap<Personnel, List<Patient>> map = new HashMap<Personnel, List<Patient>>();

        patients = sortPatients(day, patients);

        for (int i = 0; i < patients.size(); i++) {
            Personnel staff = staffs.get(i % staffs.size());
            List<Patient> list = map.get(staff);
            if (list == null) {
                list = new ArrayList<Patient>();
            }
            list.add(patients.get(i));
            map.put(staff, list);
        }

        return map;
    }

    private static List<Patient> sortPatients(int day, List<Patient> patients) {
        ArrayList<Patient> bM = new ArrayList<Patient>();
        ArrayList<Patient> eM = new ArrayList<Patient>();
        ArrayList<Patient> bA = new ArrayList<Patient>();
        ArrayList<Patient> eA = new ArrayList<Patient>();

        for (Patient patient: patients) {
            switch (patient.getDisponibility()[day]) {
                case 0:
                    bM.add(patient);
                    break;
                case 1:
                    eM.add(patient);
                    break;
                case 2:
                    bA.add(patient);
                    break;
                case 3:
                    eA.add(patient);
                    break;
            }
        }

        sortByPriority(bM);
        sortByPriority(eM);
        sortByPriority(bA);
        sortByPriority(eA);


        ArrayList<Patient> ret = new ArrayList<Patient>();
        ret.addAll(bM);
        ret.addAll(eM);
        ret.addAll(bA);
        ret.addAll(eA);

        return  ret;
    }

    private static void sortByPriority(ArrayList<Patient> patients) {
        Collections.sort(patients, new Comparator<Patient>() {
            @Override
            public int compare(Patient o1, Patient o2) {
                return o1.getPriority() - o2.getPriority();
            }
        });
    }
}
