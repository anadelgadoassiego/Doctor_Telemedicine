/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
        System.out.println("Please, enter the following information: ");
      
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

}
