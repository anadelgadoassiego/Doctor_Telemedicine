/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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

    public static String searchPatientByName() {
        System.out.println("Please, enter the following information");
        String name = getStringFromKeyboard("Enter the name of the patient you want to search: ");
        return name;
    }

    public static void searchPatientByName2(List<Patient> patientList) {
        if (!patientList.isEmpty()) {
            for (Patient patient : patientList) {
                System.out.println(patient);
            }
        } else {
            System.out.println("There are no patients with that name.");
        }

    }

    public static String changePassword() {
        String newPassword = getStringFromKeyboard("Introduce your new password: ");
        return newPassword;
    }

}
