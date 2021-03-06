/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.Ecg;
import pojos.Emg;
import pojos.Patient;
import static utils.InputOutput.getStringFromKeyboard;

/**
 *
 * @author RAQUEL
 */
public class ClientSendCharactersViaNetwork {
    private static Socket socket;
    
    public static void main(String args[]) throws IOException, Exception {
        int byteRead;

        socket = new Socket(InetAddress.getLocalHost(), 9000);
        InputStream console;
        InputStream inputStream;
        OutputStream outputStream;
        DataInputStream dint;
        DataOutputStream dout;
        
        
        //Redirect the console
        
        try{
            console = (System.in);
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            dint= new DataInputStream(inputStream);
            dout = new DataOutputStream(outputStream);
         while (true) {

                System.out.println("What do you want to do?");
                System.out.println("1. Create a new user");
                System.out.println("2. Login");
                System.out.println("0. Exit");
                Integer choice = new Integer(0);

                boolean wrongtext = false;
                do {
                    System.out.println("Introduce the number of the option you would like to choose: ");
                    try {
                        choice = Character.getNumericValue(console.read());
                        wrongtext = false;
                    } catch (NumberFormatException ex) {
                        wrongtext = true;
                        System.out.println("It's not an int, please enter an int");
                    }
                } while (choice < 0 || choice > 2 || wrongtext);
                dout.writeInt(choice);
                switch (choice) {
                    case 1:
                        int roleId = 2;
                        String response = ui.Main.newUser();
                        dout.writeInt(roleId);
                        dout.writeUTF(response);
                        break;
                    case 2:
                        String response_login = ui.Main.login();
                        dout.writeUTF(response_login);
                        String okay = dint.readUTF();
                        if (okay.equals("Welcome doctor !")) {
                            System.out.println(okay);
                            menuDoctor();
                        }else if(okay.equals("Welcome patient !")){
                             System.out.println("Wrong credentials, please try again");
                        }else{
                             System.out.println(okay);
                        }
                        
                        break;
                        
                        
                    case 0:
                        System.out.println("Finish");
                        releaseResources(outputStream,console, inputStream, console,dint,dout, socket);
                        System.exit(0);
                        return;
                    default:
                        return;
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(ClientSendCharactersViaNetwork.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        private static void menuDoctor() throws Exception {
        
        InputStream console2;
        InputStream inputStream2;
        OutputStream outputStream2;
        DataInputStream dint2;
        DataOutputStream dout2;
        ObjectInputStream objectInputStream = null;
        
       
        try {
            console2 = (System.in);
            inputStream2 = socket.getInputStream();
            outputStream2 = socket.getOutputStream();
            dint2 = new DataInputStream(inputStream2);
            dout2 = new DataOutputStream(outputStream2);
            objectInputStream = new ObjectInputStream(inputStream2);
            
            while (true) {
            System.out.println("What would you like to do?");
            System.out.println("1. Search patient by name");
            System.out.println("2. Search EMG by name");
            System.out.println("3. Search ECG by name");
            System.out.println("4. Search Form by name");
            System.out.println("5. Delete patient");
            System.out.println("6. Change your userName");
            System.out.println("7. Change your password");
            System.out.println("8. Go back");
                Integer choice = new Integer(0);
                boolean wrongtext = false;
                do {
                    System.out.println("Introduce the number of the option you would like to choose: ");
                    try {
                        choice = Character.getNumericValue(console2.read());
                        wrongtext = false;
                    } catch (NumberFormatException ex) {
                        wrongtext = true;
                        System.out.println("It's not an int, please enter an int");
                    }
                } while (choice < 1 || choice > 8 || wrongtext);
                dout2.writeInt(choice);
                switch (choice) {
                    case 1:
                        List<Patient> patientList = new ArrayList <Patient>();
                        Object tmp;
                        while ((tmp = objectInputStream.readObject()) != null) {
                            Patient patient = (Patient) tmp;
                            patientList.add(patient);
                        }
                        ui.Main.searchPatientByName(patientList);
                        break;
                    case 2:
                        List<Patient> patientList_emg = new ArrayList <Patient>();
                        Object tmp_emg;
                        while ((tmp_emg = objectInputStream.readObject()) != null) {
                            Patient patient = (Patient) tmp_emg;
                            patientList_emg.add(patient);
                        }
                        int patientId_emg = ui.Main.searchEmg(patientList_emg);
                        dout2.writeInt(patientId_emg);
                        List<Emg> emgList = new ArrayList <Emg>();
                        Object tmp_emgList;
                        while ((tmp_emgList = objectInputStream.readObject()) != null) {
                            
                            Emg emg = (Emg) tmp_emgList;
                            emgList.add(emg);
                        }
                        ui.Main.printEmg(emgList);
                        
                        break;
                    case 3:
                        List<Patient> patientList_ecg = new ArrayList <Patient>();
                        Object tmp_ecg;
                        while ((tmp_ecg = objectInputStream.readObject()) != null) {
                            Patient patient = (Patient) tmp_ecg;
                            patientList_ecg.add(patient);
                        }
                        int patientId_ecg = ui.Main.searchEcg(patientList_ecg);
                        dout2.writeInt(patientId_ecg);
                        List<Ecg> ecgList = new ArrayList <Ecg>();
                        Object tmp_ecgList;
                        while ((tmp_ecgList = objectInputStream.readObject()) != null) {
                            Ecg ecg = (Ecg) tmp_ecgList;
                            ecgList.add(ecg);
                        }
                        ui.Main.printEcg(ecgList);
                        break;
                    case 4:
                        List<Patient> patientList_form = new ArrayList <Patient>();
                        Object tmp_form;
                        while ((tmp_form = objectInputStream.readObject()) != null) {
                            Patient patient = (Patient) tmp_form;
                            patientList_form.add(patient);
                        }
                        int patientId_form = ui.Main.searchForm(patientList_form);
                        dout2.writeInt(patientId_form);
                        Patient patient_form = (Patient) objectInputStream.readObject();
                        ui.Main.printForm(patient_form);
                        break;
                    case 5:
                        List<Patient> patientList_delete = new ArrayList <Patient>();
                        Object tmp_delete;
                        while ((tmp_delete = objectInputStream.readObject()) != null) {
                            Patient patient = (Patient) tmp_delete;
                            patientList_delete.add(patient);
                        }
                        int patientId_delete = ui.Main.deletePatient(patientList_delete);
                        dout2.writeInt(patientId_delete);
                        break;
                    case 6:
                        String response_newUser = ui.Main.changeUsername();
                        dout2.writeUTF(response_newUser);
                        String okay = dint2.readUTF();
                        System.out.println(okay);
                        break;
                    case 7:
                        String response_newPassword = ui.Main.changePassword();
                        dout2.writeUTF(response_newPassword);
                        okay = dint2.readUTF();
                        System.out.println(okay);
                        break;

                    case 8:
                        //releaseResources2(outputStream2, console2, inputStream2, dint2, dout2);
                        return;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ClientSendCharactersViaNetwork.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
     private static void releaseResources(OutputStream outputStream, InputStream console, InputStream inputStream, InputStream console2, DataInputStream dint, DataOutputStream dout, Socket socket) {
        try {
            try {
                dout.close();
            } catch (IOException ex) {
                Logger.getLogger(ClientSendCharactersViaNetwork.class.getName()).log(Level.SEVERE, null, ex);

            }
            try {
                dint.close();
            } catch (IOException ex) {
                Logger.getLogger(ClientSendCharactersViaNetwork.class.getName()).log(Level.SEVERE, null, ex);

            }
            try {
                outputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(ClientSendCharactersViaNetwork.class.getName()).log(Level.SEVERE, null, ex);

            }

            try {
                inputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(ClientSendCharactersViaNetwork.class.getName()).log(Level.SEVERE, null, ex);

            }
            try {
                console.close();
            } catch (IOException ex) {
                Logger.getLogger(ClientSendCharactersViaNetwork.class.getName()).log(Level.SEVERE, null, ex);

            }

            socket.close();

        } catch (IOException ex) {
            Logger.getLogger(ClientSendCharactersViaNetwork.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private static void releaseResources2(OutputStream outputStream2,InputStream console2, InputStream inputStream2, DataInputStream dint2, DataOutputStream dout2) {
        try {
            dout2.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientSendCharactersViaNetwork.class.getName()).log(Level.SEVERE, null, ex);

        }
        
        try {
            dint2.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientSendCharactersViaNetwork.class.getName()).log(Level.SEVERE, null, ex);

        }
        try {
            inputStream2.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientSendCharactersViaNetwork.class.getName()).log(Level.SEVERE, null, ex);

        }
         try {
            outputStream2.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientSendCharactersViaNetwork.class.getName()).log(Level.SEVERE, null, ex);

        }
        try {
            console2.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientSendCharactersViaNetwork.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

   

}
