/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import pojos.Patient;
import static utils.InputOutput.getStringFromKeyboard;

/**
 *
 * @author gustavo
 */
public class DoctorMenu2 extends javax.swing.JFrame {
    public static String response = new String("");
    private static InputStream inputStream2 = CreateLoginInterface.inputStream;
    private static OutputStream outputStream2 = CreateLoginInterface.outputStream;
    private static DataInputStream dint2= new DataInputStream(inputStream2);
    private static DataOutputStream dout2 = new DataOutputStream(outputStream2);
    public static Socket socket2 = CreateLoginInterface.socket;
    public static ObjectInputStream objectInputStream; // =  new ObjectInputStream(inputStream2);
    
    public static int id = 0;
    public static List<Patient> patientList = new ArrayList <Patient>();
    /**
     * Creates new form DoctorMenu
     */
    public DoctorMenu2() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        patbyname = new javax.swing.JButton();
        emg = new javax.swing.JButton();
        ecg = new javax.swing.JButton();
        form = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        username = new javax.swing.JButton();
        password = new javax.swing.JButton();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Hi Doc! What would you like to do?");

        patbyname.setText("Search patient by name");
        patbyname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patbynameActionPerformed(evt);
            }
        });

        emg.setText("Search EMG by name");

        ecg.setText("Search ECG by name");
        ecg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ecgActionPerformed(evt);
            }
        });

        form.setText("Search Form by name");
        form.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formActionPerformed(evt);
            }
        });

        delete.setText("Delete patient");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        username.setText("Change username");
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        password.setText("Change password");
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });

        back.setText("Go back");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(delete)
                            .addComponent(form)
                            .addComponent(username)
                            .addComponent(password)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(patbyname)
                            .addComponent(jLabel1)
                            .addComponent(emg)
                            .addComponent(ecg))))
                .addContainerGap(136, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(back)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(patbyname)
                .addGap(18, 18, 18)
                .addComponent(emg)
                .addGap(18, 18, 18)
                .addComponent(ecg)
                .addGap(18, 18, 18)
                .addComponent(form)
                .addGap(18, 18, 18)
                .addComponent(delete)
                .addGap(18, 18, 18)
                .addComponent(username)
                .addGap(18, 18, 18)
                .addComponent(password)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(back)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ecgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ecgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ecgActionPerformed

    private void patbynameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patbynameActionPerformed
        try {
            // TODO add your handling code here:
            outputStream2 = socket2.getOutputStream();
            dout2 = new DataOutputStream(outputStream2);
            inputStream2 = socket2.getInputStream();
            dint2 = new DataInputStream(inputStream2);
            int entero = 1;
            dout2.writeInt(entero);
            objectInputStream = new ObjectInputStream(inputStream2);
            Object tmp;
            while ((tmp = objectInputStream.readObject()) != null) {
                Patient patient = (Patient) tmp;
                patientList.add(patient);
            }
            if (!patientList.isEmpty()) {
            for (Patient patient : patientList) {
                
                DoctorMenu2 p = new DoctorMenu2();
                JOptionPane.showMessageDialog(p, patient);
            }
            String name = JOptionPane.showInputDialog("Enter the name of the patient you want to search: ");
            for (Patient patient : patientList) {
                if (patient.getFull_name().contains(name)) {
                    DoctorMenu2 p = new DoctorMenu2();
                    JOptionPane.showMessageDialog(p, patient);
                }
            }

            } else {
            DoctorMenu2 p = new DoctorMenu2();
            JOptionPane.showMessageDialog(p, "There are no patients with that name.");

        }
            
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(DoctorMenu2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoctorMenu2.class.getName()).log(Level.SEVERE, null, ex);
        }
        DoctorMenu2 p = new DoctorMenu2();
        p.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_patbynameActionPerformed

    private void formActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formActionPerformed
        try {
            // TODO add your handling code here:
            outputStream2 = socket2.getOutputStream();
            dout2 = new DataOutputStream(outputStream2);
            inputStream2 = socket2.getInputStream();
            dint2 = new DataInputStream(inputStream2);
            int entero = 4;
            dout2.writeInt(entero);
            objectInputStream = new ObjectInputStream(inputStream2);
            Object tmp;
            
            while ((tmp = objectInputStream.readObject()) != null) {
                Patient patient = (Patient) tmp;
                patientList.add(patient);
                
                
            int patient_id = 0;
            if (!patientList.isEmpty()) {
                for (Patient patient2 : patientList) {
                    DoctorMenu2 p = new DoctorMenu2();
                    JOptionPane.showMessageDialog(p, patient2);
                }
                String name = JOptionPane.showInputDialog("Enter the name of the patient you want to search: ");
                for (Patient patient2 : patientList) {
                    if (patient.getFull_name().contains(name)) {
                        DoctorMenu2 p = new DoctorMenu2();
                        JOptionPane.showMessageDialog(p, patient2);
                    }
                }
                patient_id = Integer.parseInt(JOptionPane.showInputDialog("Enter the id of the patient you want to search the form: "));

            } else {
                DoctorMenu2 p = new DoctorMenu2();
                JOptionPane.showMessageDialog(p, "You do not have patients");
            }
            
            dout2.writeInt(patient_id);
            Patient patient_form = (Patient) objectInputStream.readObject();
            byte[] form = patient_form.getPatient_form();
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
                DoctorMenu2 p = new DoctorMenu2();
                JOptionPane.showMessageDialog(p, value);
            }
                
            }
        } catch (IOException ex) {
            Logger.getLogger(DoctorMenu2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoctorMenu2.class.getName()).log(Level.SEVERE, null, ex);
        }
        DoctorMenu2 p = new DoctorMenu2();
        p.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_formActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
        try{
        outputStream2 = socket2.getOutputStream();
        dout2 = new DataOutputStream(outputStream2);
        inputStream2 = socket2.getInputStream();
        dint2 = new DataInputStream(inputStream2);
        int entero = 7;
        dout2.writeInt(entero);
        String okay;
        String password = JOptionPane.showInputDialog("Introduce your new Password");
        dout2.writeUTF(password);
        okay = dint2.readUTF();
        if (okay.equals("Action Completed")){
            DoctorMenu2 p = new DoctorMenu2();
            JOptionPane.showMessageDialog(p, "Action completed!");
        } else {
            DoctorMenu2 p = new DoctorMenu2();
            JOptionPane.showMessageDialog(p, "Can not be completed!");
        }
        } catch (IOException ex) {
            Logger.getLogger(DoctorMenu2.class.getName()).log(Level.SEVERE, null, ex);
        }
        DoctorMenu2 p = new DoctorMenu2();
        p.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_passwordActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
        try{
        outputStream2 = socket2.getOutputStream();
        dout2 = new DataOutputStream(outputStream2);
        inputStream2 = socket2.getInputStream();
        dint2 = new DataInputStream(inputStream2);
        int entero = 6;
        dout2.writeInt(entero);
        String okay;
        String password = JOptionPane.showInputDialog("Introduce your new UserName");
        dout2.writeUTF(password);
        okay = dint2.readUTF();
        if (okay.equals("Action Completed")){
            DoctorMenu2 p = new DoctorMenu2();
            JOptionPane.showMessageDialog(p, "Action completed!");
        } else {
            DoctorMenu2 p = new DoctorMenu2();
            JOptionPane.showMessageDialog(p, "Can not be completed!");
        }
        } catch (IOException ex) {
            Logger.getLogger(DoctorMenu2.class.getName()).log(Level.SEVERE, null, ex);
        }
        DoctorMenu2 p = new DoctorMenu2();
        p.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_usernameActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        try {
            // TODO add your handling code here:
            outputStream2 = socket2.getOutputStream();
            dout2 = new DataOutputStream(outputStream2);
            inputStream2 = socket2.getInputStream();
            dint2 = new DataInputStream(inputStream2);
            int entero = 5;
            dout2.writeInt(entero);
            objectInputStream = new ObjectInputStream(inputStream2);
            Object tmp;
            while ((tmp = objectInputStream.readObject()) != null) {
                Patient patient = (Patient) tmp;
                patientList.add(patient);
            }
            int patient_id = 0;
            if (!patientList.isEmpty()) {
                for (Patient patient : patientList) {
                    DoctorMenu2 p = new DoctorMenu2();
                    JOptionPane.showMessageDialog(p, patient);
                }
                String name = JOptionPane.showInputDialog("Enter the name of the patient you want to search: ");
                for (Patient patient : patientList) {
                    if (patient.getFull_name().contains(name)) {
                        DoctorMenu2 p = new DoctorMenu2();
                        JOptionPane.showMessageDialog(p, patient);
                    }
                }
            patient_id = Integer.parseInt(JOptionPane.showInputDialog("Enter the id of the patient you want to delete: "));

            } else {
                DoctorMenu2 p = new DoctorMenu2();
                JOptionPane.showMessageDialog(p, "You do not have this patient");
            }
        } catch (IOException ex) {
            Logger.getLogger(DoctorMenu2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoctorMenu2.class.getName()).log(Level.SEVERE, null, ex);
        }
        DoctorMenu2 p = new DoctorMenu2();
        p.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_deleteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DoctorMenu2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoctorMenu2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoctorMenu2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoctorMenu2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoctorMenu2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton delete;
    private javax.swing.JButton ecg;
    private javax.swing.JButton emg;
    private javax.swing.JButton form;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton password;
    private javax.swing.JButton patbyname;
    private javax.swing.JButton username;
    // End of variables declaration//GEN-END:variables
}