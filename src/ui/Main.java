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
            patient_id = Integer.parseInt(getStringFromKeyboard("Enter the id of the patient you want to delete: "));

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
            patient_id = Integer.parseInt(getStringFromKeyboard("Enter the id of the patient you want to see the form: "));

        } else {
            System.out.println("You do not have patients.");
        }
        return patient_id;
    }

    public static void printForm(Patient patient) {
        byte[] form = patient.getPatient_form();
        List<String> values = new ArrayList();
        String pasar = "";
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
        //System.out.println(values.toString());
    }

    public static String changePassword() {
        String newPassword = getStringFromKeyboard("Introduce your new password: ");
        return newPassword;
    }

}
