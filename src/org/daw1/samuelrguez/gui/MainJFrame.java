/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.daw1.samuelrguez.gui;

import java.awt.Color;
import java.io.File;
import java.nio.file.Path;
import javax.swing.JLabel;
import org.daw1.samuelrguez.motores.IMotor;

/**
 *
 * @author alumno
 */
public class MainJFrame extends javax.swing.JFrame {

    private static final java.awt.Color COLOR_ROJO = new java.awt.Color(204, 0, 0);
    private static final java.awt.Color COLOR_AMARILLO = new java.awt.Color(204, 153, 0);
    private static final java.awt.Color COLOR_VERDE = new java.awt.Color(51, 102, 0);

    private static final int INTENTOS_MAXIMOS = 6;
    private static final int PALABRA_LENGTH = 5;
    private static final String TEXTOVACIO = "";

    private static java.util.Set<String> letrasVerdes = new java.util.TreeSet<>();
    private static java.util.Set<String> letrasAmarillas = new java.util.TreeSet<>();
    private static java.util.Set<String> letrasRojas = new java.util.TreeSet<>();

    private static File FICHERO = new File(Path.of(".") + File.separator + "data" + File.separator + "palabras.txt");

    private final JLabel[][] matrizLabels = new javax.swing.JLabel[INTENTOS_MAXIMOS][PALABRA_LENGTH];

    private static IMotor gestorFichero;

    private static int MAXIMO_INTENTOS_PARTIDA;
    private String palabraRandom;

    /**
     * Creates new form InterfazWordle
     */
    public MainJFrame() {
        initComponents();
        MAXIMO_INTENTOS_PARTIDA = 0;
    }

    private void enviarletrasComprobarYColorear() {
        int contadorAcertadas = 0;
        String s = this.palabrajTextField.getText().toLowerCase();

        if (s.length() == PALABRA_LENGTH) {
            setErrorFalse();
            Color ponerColorPalabra;
            for (int i = 0; i < PALABRA_LENGTH; i++) {
                int printColor = gestorFichero.checkChar(i, palabraRandom, s);
                String insertLetra = s.substring(0 + i, 1 + i).toUpperCase();
                String verde;
                String amarillo;
                String rojo;
                if (printColor == 1) {
                    ponerColorPalabra = COLOR_VERDE;
                    contadorAcertadas++;
                    letrasVerdes.add(insertLetra);

                    if (letrasAmarillas.contains(insertLetra)) {
                        letrasAmarillas.remove(insertLetra);
                        amarillo = cleanLlavesSet(letrasAmarillas.toString());
                        this.existenjLabel.setText(amarillo);
                    }
                    verde = cleanLlavesSet(letrasVerdes.toString());
                    this.bienjLabel.setText(verde);
                } else if (printColor == 0) {
                    ponerColorPalabra = COLOR_AMARILLO;
                    if (!letrasVerdes.contains(insertLetra)) {
                        letrasAmarillas.add(insertLetra);
                    }
                    amarillo = cleanLlavesSet(letrasAmarillas.toString());
                    this.existenjLabel.setText(amarillo);
                } else {
                    ponerColorPalabra = COLOR_ROJO;
                    letrasRojas.add(insertLetra);
                    rojo = cleanLlavesSet(letrasRojas.toString());
                    this.maljLabel.setText(rojo);
                }
                setLetraColor(MAXIMO_INTENTOS_PARTIDA, i, ponerColorPalabra, insertLetra);
            }
            
            MAXIMO_INTENTOS_PARTIDA++;
            if (contadorAcertadas == PALABRA_LENGTH) {
                this.palabrajTextField.setEnabled(false);
                this.finaljLabel.setForeground(COLOR_VERDE);
                this.finaljLabel.setText("Has adivinado la palabra: " + palabraRandom.toUpperCase() + " en \n" + MAXIMO_INTENTOS_PARTIDA + " intentos");

            } else if (MAXIMO_INTENTOS_PARTIDA == 6) {
                this.palabrajTextField.setEnabled(false);
                this.finaljLabel.setForeground(COLOR_ROJO);
                this.finaljLabel.setText("No has acertado la palabra: " + palabraRandom.toUpperCase());
            }
        } else {
            setErrorTrue();
        }
    }

    private void setErrorFalse() {
        this.errorjPanel.setVisible(false);
        this.errorjLabel.setVisible(false);
        this.errorjLabel.setText(TEXTOVACIO);
        this.palabrajTextField.setText(TEXTOVACIO);
    }

    public void setLetraColor(int f, int pos, Color c, String letra) {
        JLabel[] filaDeLabels = matrizLabels[f];
        JLabel jLabel = filaDeLabels[pos];
        jLabel.setForeground(c);
        jLabel.setText(letra);
        jLabel.setVisible(true);
    }

    private void setErrorTrue() {
        this.errorjPanel.setVisible(true);
        this.errorjLabel.setVisible(true);
        this.errorjLabel.setText("No se admiten palabras con longitud diferente a 5 letras.");
        this.palabrajTextField.setText(TEXTOVACIO);
    }

    private String cleanLlavesSet(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb = sb.delete(0, 1);
        sb = sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel2 = new javax.swing.JLabel();
        mainjPanel = new javax.swing.JPanel();
        letrasjPanel = new javax.swing.JPanel();
        jLabel1_1 = new javax.swing.JLabel();
        jLabel1_2 = new javax.swing.JLabel();
        jLabel1_3 = new javax.swing.JLabel();
        jLabel1_4 = new javax.swing.JLabel();
        jLabel1_5 = new javax.swing.JLabel();
        jLabel2_1 = new javax.swing.JLabel();
        jLabel2_2 = new javax.swing.JLabel();
        jLabel2_3 = new javax.swing.JLabel();
        jLabel2_4 = new javax.swing.JLabel();
        jLabel2_5 = new javax.swing.JLabel();
        jLabel3_1 = new javax.swing.JLabel();
        jLabel3_2 = new javax.swing.JLabel();
        jLabel3_3 = new javax.swing.JLabel();
        jLabel3_4 = new javax.swing.JLabel();
        jLabel3_5 = new javax.swing.JLabel();
        jLabel4_1 = new javax.swing.JLabel();
        jLabel4_2 = new javax.swing.JLabel();
        jLabel4_3 = new javax.swing.JLabel();
        jLabel4_4 = new javax.swing.JLabel();
        jLabel4_5 = new javax.swing.JLabel();
        jLabel5_1 = new javax.swing.JLabel();
        jLabel5_2 = new javax.swing.JLabel();
        jLabel5_3 = new javax.swing.JLabel();
        jLabel5_4 = new javax.swing.JLabel();
        jLabel5_5 = new javax.swing.JLabel();
        jLabel6_1 = new javax.swing.JLabel();
        jLabel6_2 = new javax.swing.JLabel();
        jLabel6_3 = new javax.swing.JLabel();
        jLabel6_4 = new javax.swing.JLabel();
        jLabel6_5 = new javax.swing.JLabel();
        bottomjPanel1 = new javax.swing.JPanel();
        estadojPanel = new javax.swing.JPanel();
        maljPanel = new javax.swing.JPanel();
        maljLabel = new javax.swing.JLabel();
        existenjPanel = new javax.swing.JPanel();
        existenjLabel = new javax.swing.JLabel();
        bienjPanel = new javax.swing.JPanel();
        bienjLabel = new javax.swing.JLabel();
        inputjPanel = new javax.swing.JPanel();
        palabrajTextField = new javax.swing.JTextField();
        enviarjButton = new javax.swing.JButton();
        exitojPanel = new javax.swing.JPanel();
        finaljLabel = new javax.swing.JLabel();
        errorjPanel = new javax.swing.JPanel();
        errorjLabel = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DAW1 Wordle SamuelR");

        mainjPanel.setMinimumSize(new java.awt.Dimension(415, 450));
        mainjPanel.setPreferredSize(new java.awt.Dimension(415, 450));
        mainjPanel.setLayout(new java.awt.BorderLayout());

        letrasjPanel.setLayout(new java.awt.GridLayout(6, 5));

        jLabel1_1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel1_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1_1.setText("A");
        letrasjPanel.add(jLabel1_1);

        jLabel1_2.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel1_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1_2.setText("A");
        letrasjPanel.add(jLabel1_2);

        jLabel1_3.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel1_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1_3.setText("A");
        letrasjPanel.add(jLabel1_3);

        jLabel1_4.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel1_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1_4.setText("A");
        letrasjPanel.add(jLabel1_4);

        jLabel1_5.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel1_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1_5.setText("A");
        letrasjPanel.add(jLabel1_5);

        jLabel2_1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel2_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2_1.setText("A");
        letrasjPanel.add(jLabel2_1);

        jLabel2_2.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel2_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2_2.setText("A");
        letrasjPanel.add(jLabel2_2);

        jLabel2_3.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel2_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2_3.setText("A");
        letrasjPanel.add(jLabel2_3);

        jLabel2_4.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel2_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2_4.setText("A");
        letrasjPanel.add(jLabel2_4);

        jLabel2_5.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel2_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2_5.setText("A");
        letrasjPanel.add(jLabel2_5);

        jLabel3_1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel3_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3_1.setText("A");
        letrasjPanel.add(jLabel3_1);

        jLabel3_2.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel3_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3_2.setText("A");
        letrasjPanel.add(jLabel3_2);

        jLabel3_3.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel3_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3_3.setText("A");
        letrasjPanel.add(jLabel3_3);

        jLabel3_4.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel3_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3_4.setText("A");
        letrasjPanel.add(jLabel3_4);

        jLabel3_5.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel3_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3_5.setText("A");
        letrasjPanel.add(jLabel3_5);

        jLabel4_1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel4_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4_1.setText("A");
        letrasjPanel.add(jLabel4_1);

        jLabel4_2.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel4_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4_2.setText("A");
        letrasjPanel.add(jLabel4_2);

        jLabel4_3.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel4_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4_3.setText("A");
        letrasjPanel.add(jLabel4_3);

        jLabel4_4.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel4_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4_4.setText("A");
        letrasjPanel.add(jLabel4_4);

        jLabel4_5.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel4_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4_5.setText("A");
        letrasjPanel.add(jLabel4_5);

        jLabel5_1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel5_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5_1.setText("A");
        letrasjPanel.add(jLabel5_1);

        jLabel5_2.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel5_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5_2.setText("A");
        letrasjPanel.add(jLabel5_2);

        jLabel5_3.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel5_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5_3.setText("A");
        letrasjPanel.add(jLabel5_3);

        jLabel5_4.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel5_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5_4.setText("A");
        letrasjPanel.add(jLabel5_4);

        jLabel5_5.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel5_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5_5.setText("A");
        letrasjPanel.add(jLabel5_5);

        jLabel6_1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel6_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6_1.setText("A");
        letrasjPanel.add(jLabel6_1);

        jLabel6_2.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel6_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6_2.setText("A");
        letrasjPanel.add(jLabel6_2);

        jLabel6_3.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel6_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6_3.setText("A");
        letrasjPanel.add(jLabel6_3);

        jLabel6_4.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel6_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6_4.setText("A");
        letrasjPanel.add(jLabel6_4);

        jLabel6_5.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel6_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6_5.setText("A");
        letrasjPanel.add(jLabel6_5);

        mainjPanel.add(letrasjPanel, java.awt.BorderLayout.CENTER);

        bottomjPanel1.setPreferredSize(new java.awt.Dimension(200, 100));
        bottomjPanel1.setLayout(new java.awt.GridLayout(2, 2));

        estadojPanel.setLayout(new java.awt.GridLayout(3, 1));

        maljPanel.setLayout(new java.awt.GridLayout(1, 0));

        maljLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        maljLabel.setForeground(new java.awt.Color(204, 0, 0));
        maljLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        maljPanel.add(maljLabel);

        estadojPanel.add(maljPanel);

        existenjPanel.setLayout(new java.awt.GridLayout(1, 0));

        existenjLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        existenjLabel.setForeground(new java.awt.Color(204, 153, 0));
        existenjPanel.add(existenjLabel);

        estadojPanel.add(existenjPanel);

        bienjPanel.setLayout(new java.awt.GridLayout(1, 0));

        bienjLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bienjLabel.setForeground(new java.awt.Color(51, 102, 0));
        bienjPanel.add(bienjLabel);

        estadojPanel.add(bienjPanel);

        bottomjPanel1.add(estadojPanel);

        palabrajTextField.setPreferredSize(new java.awt.Dimension(120, 22));
        palabrajTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                palabrajTextFieldActionPerformed(evt);
            }
        });
        inputjPanel.add(palabrajTextField);

        enviarjButton.setText("Enviar");
        enviarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarjButtonActionPerformed(evt);
            }
        });
        inputjPanel.add(enviarjButton);

        bottomjPanel1.add(inputjPanel);

        exitojPanel.setLayout(new java.awt.GridBagLayout());

        finaljLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        finaljLabel.setForeground(new java.awt.Color(51, 102, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 94, 17, 95);
        exitojPanel.add(finaljLabel, gridBagConstraints);

        bottomjPanel1.add(exitojPanel);

        errorjPanel.setLayout(new java.awt.GridBagLayout());

        errorjLabel.setForeground(new java.awt.Color(204, 0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 101, 17, 101);
        errorjPanel.add(errorjLabel, gridBagConstraints);

        bottomjPanel1.add(errorjPanel);

        mainjPanel.add(bottomjPanel1, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainjPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainjPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enviarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarjButtonActionPerformed
        enviarletrasComprobarYColorear();
    }//GEN-LAST:event_enviarjButtonActionPerformed

    private void palabrajTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_palabrajTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_palabrajTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bienjLabel;
    private javax.swing.JPanel bienjPanel;
    private javax.swing.JPanel bottomjPanel1;
    private javax.swing.JButton enviarjButton;
    private javax.swing.JLabel errorjLabel;
    private javax.swing.JPanel errorjPanel;
    private javax.swing.JPanel estadojPanel;
    private javax.swing.JLabel existenjLabel;
    private javax.swing.JPanel existenjPanel;
    private javax.swing.JPanel exitojPanel;
    private javax.swing.JLabel finaljLabel;
    private javax.swing.JPanel inputjPanel;
    private javax.swing.JLabel jLabel1_1;
    private javax.swing.JLabel jLabel1_2;
    private javax.swing.JLabel jLabel1_3;
    private javax.swing.JLabel jLabel1_4;
    private javax.swing.JLabel jLabel1_5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel2_1;
    private javax.swing.JLabel jLabel2_2;
    private javax.swing.JLabel jLabel2_3;
    private javax.swing.JLabel jLabel2_4;
    private javax.swing.JLabel jLabel2_5;
    private javax.swing.JLabel jLabel3_1;
    private javax.swing.JLabel jLabel3_2;
    private javax.swing.JLabel jLabel3_3;
    private javax.swing.JLabel jLabel3_4;
    private javax.swing.JLabel jLabel3_5;
    private javax.swing.JLabel jLabel4_1;
    private javax.swing.JLabel jLabel4_2;
    private javax.swing.JLabel jLabel4_3;
    private javax.swing.JLabel jLabel4_4;
    private javax.swing.JLabel jLabel4_5;
    private javax.swing.JLabel jLabel5_1;
    private javax.swing.JLabel jLabel5_2;
    private javax.swing.JLabel jLabel5_3;
    private javax.swing.JLabel jLabel5_4;
    private javax.swing.JLabel jLabel5_5;
    private javax.swing.JLabel jLabel6_1;
    private javax.swing.JLabel jLabel6_2;
    private javax.swing.JLabel jLabel6_3;
    private javax.swing.JLabel jLabel6_4;
    private javax.swing.JLabel jLabel6_5;
    private javax.swing.JPanel letrasjPanel;
    private javax.swing.JPanel mainjPanel;
    private javax.swing.JLabel maljLabel;
    private javax.swing.JPanel maljPanel;
    private javax.swing.JTextField palabrajTextField;
    // End of variables declaration//GEN-END:variables
}
