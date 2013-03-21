package mock.services.generation;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mock.beans.Patient;
import mock.beans.Personnel;

public class Generation {

    public static Map<Personnel, List<Patient>> generateAll(List<Personnel> personnels, List<Patient> patients) {
        int day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        
        System.out.println("GENERATION");
        System.out.println("PERSONNEL");
        for (Personnel personnel : personnels){
        	System.out.println(personnel.getFirstName()+" "+personnel.getLastName());
        }
        System.out.println();
        System.out.println("PATIENT");
        for (Patient patient : patients){
        	System.out.println(patient.getFirstName()+" "+patient.getLastName());
        }
        return generate(day, personnels, patients);
    }

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

        int disp = 5;
        for (Patient patient: patients) {
            switch (day) {
                case Calendar.MONDAY:
                    disp = patient.getMonday();
                    break;
                case Calendar.TUESDAY:
                    disp = patient.getTuesday();
                    break;
                case Calendar.WEDNESDAY:
                    disp = patient.getWednesday();
                    break;
                case Calendar.THURSDAY:
                    disp = patient.getThursday();
                    break;
                case Calendar.FRIDAY:
                    disp = patient.getFriday();
                    break;
                default:
                	throw new UnsupportedOperationException("Saturday and Sunday are not supported.");
            }
            switch (disp) {
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
