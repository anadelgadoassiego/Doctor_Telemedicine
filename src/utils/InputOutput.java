/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputOutput {

    public static String getStringFromKeyboard(String question) {
        BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                
                System.out.println(question);
                String stringLeida = consola.readLine();
                
                while(stringLeida.equals("")||stringLeida.equals("\n")){
                stringLeida = consola.readLine();
                }
                return stringLeida;
            } catch (IOException ioe) {
                System.out.println("There was a problem while reading, please enter it again.");
            }

        }
    }

    public static int getIntFromKeyboard(String question) {
        int intLeido;
        BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.println(question);
                String cadena = consola.readLine();
                intLeido = Integer.parseInt(cadena);
                return intLeido;
            } catch (IOException ioe) {
                System.out.println("There was a problem while reading, please enter it again.");
            } catch (NumberFormatException nfe) {
                System.out.println("You must enter an integer.");
            }

        }

    }

    public static float getFloatFromKeyboard(String question) {
        float floatLeido;
        BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.println(question);
                String cadena = consola.readLine();
                floatLeido = Float.parseFloat(cadena);
                return floatLeido;
            } catch (IOException ioe) {
                System.out.println("There was a problem while reading, please enter it again.");
            } catch (NumberFormatException nfe) {
                System.out.println("You must enter a float.");
            }

        }

    }

}
