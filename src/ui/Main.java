/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import pojos.Ecg;
import pojos.Emg;
import pojos.Patient;
import static utils.InputOutput.getFloatFromKeyboard;
import static utils.InputOutput.getIntFromKeyboard;
import static utils.InputOutput.getStringFromKeyboard;

/**
 *
 * @author RAQUEL
 */
public class Main {

    public static void menu() throws Exception {
        System.out.println("Welcome to our database!");

    }

    public static String newUser() throws Exception {
        String response = "";
        System.out.println("Please, enter your full name: ");
        String name = getStringFromKeyboard("Full name: ");
        System.out.println("Please type the new user information: ");
        String username = getStringFromKeyboard("DNI (this will be your username): ");
        String password = getStringFromKeyboard("Password: ");
        Integer roleId = 2;
        response = name + "," + username + "," + password + "," + roleId;

        return response;
    }

    public static String login() throws Exception {
        String response = "";
        System.out.println("Please input your credentials");
        String username = getStringFromKeyboard("Username: ");
        String password = getStringFromKeyboard("Password: ");
        response = username + "," + password;
        return response;
    }

    public static String changeUsername() {
        String newName = getStringFromKeyboard("Introduce your new username: ");
        return newName;
    }

    public static void searchPatientByName(List<Patient> patientList) {
        if (!patientList.isEmpty()) {
            for (Patient patient : patientList) {
                System.out.println(patient);
            }
            String name = getStringFromKeyboard("Enter the name of the patient you want to search: ");
            for (Patient patient : patientList) {
                if (patient.getFull_name().contains(name)) {
                    System.out.println(patient);
                }
            }

        } else {
            System.out.println("There are no patients with that name.");
        }

    }

    public static int deletePatient(List<Patient> patientList) {
        int patient_id = 0;
        if (!patientList.isEmpty()) {
            for (Patient patient : patientList) {
                System.out.println(patient);
            }
            String name = getStringFromKeyboard("Enter the name of the patient you want to search: ");
            for (Patient patient : patientList) {
                if (patient.getFull_name().contains(name)) {
                    System.out.println(patient);
                }
            }
            List<Integer> ids_patients = new ArrayList();
            for (Patient patient : patientList) {
                ids_patients.add(patient.getId());
            }
            do {
                patient_id = Integer.parseInt(getStringFromKeyboard("Enter the id of the patient you want to delete: "));
            } while (!ids_patients.contains(patient_id));

        } else {
            System.out.println("you do not have patients.");
        }
        return patient_id;
    }

    public static int searchEmg(List<Patient> patientList) {
        int patient_id = 0;
        if (!patientList.isEmpty()) {
            for (Patient patient : patientList) {
                System.out.println(patient);
            }
            String name = getStringFromKeyboard("Enter the name of the patient you want to search: ");
            for (Patient patient : patientList) {
                if (patient.getFull_name().contains(name)) {
                    System.out.println(patient);
                }
            }
            List<Integer> ids_patients = new ArrayList();
            for (Patient patient : patientList) {
                ids_patients.add(patient.getId());
            }
            do {
                patient_id = Integer.parseInt(getStringFromKeyboard("Enter the id of the patient you want to see the emg: "));
            } while (!ids_patients.contains(patient_id));

        } else {
            System.out.println("you do not have patients.");
        }
        return patient_id;
    }

    public static int searchEcg(List<Patient> patientList) {
        int patient_id = 0;
        if (!patientList.isEmpty()) {
            for (Patient patient : patientList) {
                System.out.println(patient);
            }
            String name = getStringFromKeyboard("Enter the name of the patient you want to search: ");
            for (Patient patient : patientList) {
                if (patient.getFull_name().contains(name)) {
                    System.out.println(patient);
                }
            }
            List<Integer> ids_patients = new ArrayList();
            for (Patient patient : patientList) {
                ids_patients.add(patient.getId());
            }
            do {
                patient_id = Integer.parseInt(getStringFromKeyboard("Enter the id of the patient you want to see the ecg: "));
            } while (!ids_patients.contains(patient_id));
        } else {
            System.out.println("you do not have patients.");
        }
        return patient_id;
    }

    public static int searchForm(List<Patient> patientList) {
        int patient_id = 0;
        if (!patientList.isEmpty()) {
            for (Patient patient : patientList) {
                System.out.println(patient);
            }
            String name = getStringFromKeyboard("Enter the name of the patient you want to search: ");
            for (Patient patient : patientList) {
                if (patient.getFull_name().contains(name)) {
                    System.out.println(patient);
                }
            }
            List<Integer> ids_patients = new ArrayList();
            for (Patient patient : patientList) {
                ids_patients.add(patient.getId());
            }
            do {
                patient_id = Integer.parseInt(getStringFromKeyboard("Enter the id of the patient you want to see the form: "));
            } while (!ids_patients.contains(patient_id));
        } else {
            System.out.println("You do not have patients.");
        }
        return patient_id;
    }

    public static void printEmg(List<Emg> emgList) throws Exception {
        boolean found = false;
        String month = getStringFromKeyboard("Introduce the month: ");
        String day = getStringFromKeyboard("Introduce day: ");
        String name_emg = month+day;
        String name_select;
        for (Emg emg : emgList) {
            name_select = emg.getName_emg();
            if (name_select.contains(name_emg)) {
                System.out.println(name_select);
            }
        }

        int position = Integer.parseInt(getStringFromKeyboard("Introduce the number of the emg"));
        name_emg = "EMG_" + month + day + "_" + position + ".txt";
        for (Emg emg : emgList) {
            name_select = emg.getName_emg();
            if (name_select.equals(name_emg)) {
                //print form of emg
                byte[] form = emg.getForm();
                List<String> values_f = new ArrayList();
                String pasar_f = "";
                for (int i = 0; i < (form.length) - 1; i++) {
                    char value_f = (char) form[i];
                    int compare_f = (int) form[i];
                    while (compare_f != 10) {
                        value_f = (char) form[i];
                        compare_f = (int) form[i];
                        if (compare_f != 10) {
                            pasar_f = pasar_f + value_f;
                            i++;
                        }

                    }
                    values_f.add(pasar_f);
                    pasar_f = "";

                }
                for (String value_f : values_f) {
                    System.out.println(value_f);
                }

                //print values of emg
                found = true;
                byte[] emg_values = emg.getPatient_emg();
                List<String> values = new ArrayList();
                List<Integer> values_int = new ArrayList();
                String pasar = "";
                

                for (int i = 0; i < (emg_values.length) - 1; i++) {
                    char value = (char) emg_values[i];
                    int compare = (int) emg_values[i];
                    while (compare != 10) {
                        value = (char) emg_values[i];
                        compare = (int) emg_values[i];
                        if (compare != 10) {
                            pasar = pasar + value;
                            i++;
                        }

                    }
                    values.add(pasar);
                    pasar = "";

                }
                System.out.println(values.toString());
                for (int i = 1; i < (values.size()) - 1; i++) {
                    values_int.add(Integer.parseInt(values.get(i)));
                }
            }
        }
        if (!found) {
            System.out.println("It does not exisist...");
        }

    }

    public static void printEcg(List<Ecg> ecgList) throws Exception {
        boolean found = false;
        String month = getStringFromKeyboard("Introduce the month: ");
        String day = getStringFromKeyboard("Introduce day: ");
        String name_ecg = month + day;
        String name_select;
        for (Ecg ecg : ecgList) {
            name_select = ecg.getName_ecg();
            if (name_select.contains(name_ecg)) {
                System.out.println(name_select);
            }
        }

        int position = Integer.parseInt(getStringFromKeyboard("Introduce the number of the ecg"));
        name_ecg = "ECG_" + month + day + "_" + position + ".txt";
        for (Ecg ecg : ecgList) {
            name_select = ecg.getName_ecg();
            if (name_select.equals(name_ecg)) {
                //print form of ecg
                byte[] form = ecg.getForm();
                List<String> values_f = new ArrayList();
                String pasar_f = "";
                for (int i = 0; i < (form.length) - 1; i++) {
                    char value_f = (char) form[i];
                    int compare_f = (int) form[i];
                    while (compare_f != 10) {
                        value_f = (char) form[i];
                        compare_f = (int) form[i];
                        if (compare_f != 10) {
                            pasar_f = pasar_f + value_f;
                            i++;
                        }

                    }
                    values_f.add(pasar_f);
                    pasar_f = "";

                }
                for (String value_f : values_f) {
                    System.out.println(value_f);
                }
                
                //print values of ecg
                System.out.println(ecg);
                found = true;
                byte[] ecg_values = ecg.getPatient_ecg();
                List<String> values = new ArrayList();
                List<Integer> values_int = new ArrayList();
                String pasar = "";
                for (int i = 0; i < (ecg_values.length) - 1; i++) {
                    char value = (char) ecg_values[i];
                    int compare = (int) ecg_values[i];
                    while (compare != 10) {
                        value = (char) ecg_values[i];
                        compare = (int) ecg_values[i];
                        if (compare != 10) {
                            pasar = pasar + value;
                            i++;
                        }

                    }
                    values.add(pasar);
                    pasar = "";

                }
                System.out.println(values.toString());
                for (int i = 1; i < (values.size()) - 1; i++) {
                    values_int.add(Integer.parseInt(values.get(i)));
                }
            }
        }
        if (!found) {
            System.out.println("It does not exisist...");
        }

    }

    public static void printForm(Patient patient) {
        byte[] form = patient.getPatient_form();
        List<String> values = new ArrayList();
        String pasar = "";
        if(form != null){
        for (int i = 0; i < (form.length) - 1; i++) {
            char value = (char) form[i];
            int compare = (int) form[i];
            while (compare != 10) {
                value = (char) form[i];
                compare = (int) form[i];
                if (compare != 10) {
                    pasar = pasar + value;
                    i++;
                }

            }
            values.add(pasar);
            pasar = "";

        }
        for (String value : values) {
            System.out.println(value);
        }
        }
        //System.out.println(values.toString());
    }

    public static String changePassword() {
        String newPassword = getStringFromKeyboard("Introduce your new password: ");
        return newPassword;
    }

}
