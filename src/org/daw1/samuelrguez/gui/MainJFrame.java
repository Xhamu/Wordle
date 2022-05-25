/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.daw1.samuelrguez.gui;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.File;
import java.nio.file.Path;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.daw1.samuelrguez.motores.*;

/**
 *
 * @author alumno
 */
public class MainJFrame extends javax.swing.JFrame {

    private static final java.awt.Color COLOR_ROJO = new java.awt.Color(204, 0, 0);
    private static final java.awt.Color COLOR_AMARILLO = new java.awt.Color(204, 153, 0);
    private static final java.awt.Color COLOR_VERDE = new java.awt.Color(51, 102, 0);

    private static final java.util.Set<String> letrasVerdes = new java.util.TreeSet<>();
    private static final java.util.Set<String> letrasAmarillas = new java.util.TreeSet<>();
    private static final java.util.Set<String> letrasRojas = new java.util.TreeSet<>();

    private static final int MAX_INTENTOS = 6;
    protected static final int TAMANO_PALABRA = 5;
    private static final String TEXTOVACIO = "";
    private static int MAXIMO_INTENTOS_PARTIDA;
    private String palabraRandom;
    private final JLabel[][] matriz = new JLabel[MAX_INTENTOS][TAMANO_PALABRA];
    private static IMotor gestorFichero;
    private static File FICHERO = new File(Path.of(".") + File.separator + "data" + File.separator + "diccionario.txt");
    private static File FILE_TEST = new File(Path.of(".") + File.separator + "data" + File.separator + "diccionario.txt");

    /**
     * Creates new form InterfazWordle
     */
    public MainJFrame() {
        initComponents();
        ponerLabelsEnMatriz();
        setInvisibleLabels();
        gestorFichero = new MotorTester();
        MAXIMO_INTENTOS_PARTIDA = 0;
        try {
            palabraRandom = gestorFichero.getPalabraAleatoria();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "ERROR: " + ex.getMessage());
        }
    }

    public void setLetraColor(int fila, int pos, Color c, String letra) {
        JLabel[] filaDeLabels = matriz[fila];
        JLabel jLabel = filaDeLabels[pos];
        jLabel.setForeground(c);
        jLabel.setText(letra);
        jLabel.setVisible(true);
    }

    private void setInvisibleLabels() {
        for (JLabel[] filaDeLabels : matriz) {
            for (JLabel label : filaDeLabels) {
                label.setVisible(false);
            }
        }
    }

    private void setLabelsBlank() {
        for (JLabel[] filaDeLabels : matriz) {
            for (JLabel label : filaDeLabels) {
                label.setText(TEXTOVACIO);
                label.setVisible(false);
            }
        }
    }

    public final void ponerLabelsEnMatriz() {
        for (int i = 1; i <= MAX_INTENTOS; i++) {
            for (int j = 1; j <= TAMANO_PALABRA; j++) {
                try {
                    String s = "jLabel" + i + "_" + j;
                    JLabel label = (javax.swing.JLabel) this.getClass().getDeclaredField(s).get(this);
                    matriz[i - 1][j - 1] = label;
                } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
                    Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
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
        jMenuBar1 = new javax.swing.JMenuBar();
        archivojMenu = new javax.swing.JMenu();
        nuevaPartidajCheckBoxMenuItem = new javax.swing.JCheckBoxMenuItem();
        motoresjMenu = new javax.swing.JMenu();
        testjRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        filejRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        esBBDDjRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        glBBDDjRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        gestionMotorjMenuItem = new javax.swing.JMenuItem();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DAW1 Wordle SamuelR");
        setResizable(false);

        mainjPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainjPanel.setMinimumSize(new java.awt.Dimension(415, 450));
        mainjPanel.setPreferredSize(new java.awt.Dimension(415, 450));
        mainjPanel.setLayout(new java.awt.BorderLayout());

        letrasjPanel.setBackground(new java.awt.Color(255, 255, 255));
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

        bottomjPanel1.setBackground(new java.awt.Color(255, 255, 255));
        bottomjPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        bottomjPanel1.setPreferredSize(new java.awt.Dimension(200, 100));
        bottomjPanel1.setLayout(new java.awt.GridLayout(2, 2));

        estadojPanel.setBackground(new java.awt.Color(255, 255, 255));
        estadojPanel.setLayout(new java.awt.GridLayout(3, 1));

        maljPanel.setBackground(new java.awt.Color(255, 255, 255));
        maljPanel.setLayout(new java.awt.GridLayout(1, 0));

        maljLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        maljLabel.setForeground(new java.awt.Color(204, 0, 0));
        maljLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        maljLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        maljPanel.add(maljLabel);

        estadojPanel.add(maljPanel);

        existenjPanel.setBackground(new java.awt.Color(255, 255, 255));
        existenjPanel.setLayout(new java.awt.GridLayout(1, 0));

        existenjLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        existenjLabel.setForeground(new java.awt.Color(204, 153, 0));
        existenjLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        existenjPanel.add(existenjLabel);

        estadojPanel.add(existenjPanel);

        bienjPanel.setBackground(new java.awt.Color(255, 255, 255));
        bienjPanel.setLayout(new java.awt.GridLayout(1, 0));

        bienjLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bienjLabel.setForeground(new java.awt.Color(51, 102, 0));
        bienjLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bienjPanel.add(bienjLabel);

        estadojPanel.add(bienjPanel);

        bottomjPanel1.add(estadojPanel);

        inputjPanel.setBackground(new java.awt.Color(255, 255, 255));

        palabrajTextField.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        palabrajTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        palabrajTextField.setPreferredSize(new java.awt.Dimension(120, 22));
        palabrajTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                palabrajTextFieldActionPerformed(evt);
            }
        });
        palabrajTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                palabrajTextFieldKeyReleased(evt);
            }
        });
        inputjPanel.add(palabrajTextField);

        enviarjButton.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        enviarjButton.setText("Enviar");
        enviarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarjButtonActionPerformed(evt);
            }
        });
        inputjPanel.add(enviarjButton);

        bottomjPanel1.add(inputjPanel);

        exitojPanel.setBackground(new java.awt.Color(255, 255, 255));
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

        errorjPanel.setBackground(new java.awt.Color(255, 255, 255));
        errorjPanel.setLayout(new java.awt.GridBagLayout());

        errorjLabel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        errorjLabel.setForeground(new java.awt.Color(204, 0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 101, 17, 101);
        errorjPanel.add(errorjLabel, gridBagConstraints);

        bottomjPanel1.add(errorjPanel);

        mainjPanel.add(bottomjPanel1, java.awt.BorderLayout.PAGE_END);

        archivojMenu.setText("Archivo");
        archivojMenu.setFocusable(false);
        archivojMenu.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        nuevaPartidajCheckBoxMenuItem.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        nuevaPartidajCheckBoxMenuItem.setText("Nueva partida");
        nuevaPartidajCheckBoxMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevaPartidajCheckBoxMenuItemActionPerformed(evt);
            }
        });
        archivojMenu.add(nuevaPartidajCheckBoxMenuItem);

        jMenuBar1.add(archivojMenu);

        motoresjMenu.setText("Motores");
        motoresjMenu.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N

        testjRadioButtonMenuItem.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        testjRadioButtonMenuItem.setSelected(true);
        testjRadioButtonMenuItem.setText("Motor de test");
        testjRadioButtonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testjRadioButtonMenuItemActionPerformed(evt);
            }
        });
        motoresjMenu.add(testjRadioButtonMenuItem);

        filejRadioButtonMenuItem.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        filejRadioButtonMenuItem.setText("Motor de fichero");
        filejRadioButtonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filejRadioButtonMenuItemActionPerformed(evt);
            }
        });
        motoresjMenu.add(filejRadioButtonMenuItem);

        esBBDDjRadioButtonMenuItem.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        esBBDDjRadioButtonMenuItem.setText("Motor de BBDD (Español)");
        esBBDDjRadioButtonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                esBBDDjRadioButtonMenuItemActionPerformed(evt);
            }
        });
        motoresjMenu.add(esBBDDjRadioButtonMenuItem);

        glBBDDjRadioButtonMenuItem.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        glBBDDjRadioButtonMenuItem.setText("Motor de BBDD (Gallego)");
        glBBDDjRadioButtonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                glBBDDjRadioButtonMenuItemActionPerformed(evt);
            }
        });
        motoresjMenu.add(glBBDDjRadioButtonMenuItem);
        motoresjMenu.add(jSeparator1);

        gestionMotorjMenuItem.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        gestionMotorjMenuItem.setText("Administrar motor");
        gestionMotorjMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionMotorjMenuItemActionPerformed(evt);
            }
        });
        motoresjMenu.add(gestionMotorjMenuItem);

        jMenuBar1.add(motoresjMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainjPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainjPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enviarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarjButtonActionPerformed
        enviarletrasComprobarYColorear();
    }//GEN-LAST:event_enviarjButtonActionPerformed

    private void palabrajTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_palabrajTextFieldActionPerformed

    }//GEN-LAST:event_palabrajTextFieldActionPerformed

    private void testjRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testjRadioButtonMenuItemActionPerformed
        selectMotor();
        setNuevaPartida();
    }//GEN-LAST:event_testjRadioButtonMenuItemActionPerformed

    private void palabrajTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_palabrajTextFieldKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            enviarletrasComprobarYColorear();
        }
    }//GEN-LAST:event_palabrajTextFieldKeyReleased

    private void filejRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filejRadioButtonMenuItemActionPerformed
        selectMotor();
        setNuevaPartida();
    }//GEN-LAST:event_filejRadioButtonMenuItemActionPerformed

    private void esBBDDjRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_esBBDDjRadioButtonMenuItemActionPerformed
        selectMotor();
        setNuevaPartida();
    }//GEN-LAST:event_esBBDDjRadioButtonMenuItemActionPerformed

    private void glBBDDjRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_glBBDDjRadioButtonMenuItemActionPerformed
        selectMotor();
        setNuevaPartida();
    }//GEN-LAST:event_glBBDDjRadioButtonMenuItemActionPerformed

    private void nuevaPartidajCheckBoxMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevaPartidajCheckBoxMenuItemActionPerformed
        setNuevaPartida();
    }//GEN-LAST:event_nuevaPartidajCheckBoxMenuItemActionPerformed

    private void gestionMotorjMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionMotorjMenuItemActionPerformed
        GestionMotorJDialog gestionMotor = new GestionMotorJDialog(this, true, gestorFichero);
        gestionMotor.setVisible(true);
    }//GEN-LAST:event_gestionMotorjMenuItemActionPerformed

    private void selectMotor() {
        if (this.testjRadioButtonMenuItem.isSelected()) {
            gestorFichero = new MotorTester();
        } else if (this.filejRadioButtonMenuItem.isSelected()) {
            FICHERO = FILE_TEST;
            gestorFichero = new MotorFichero(FICHERO);
        } else if (this.esBBDDjRadioButtonMenuItem.isSelected()) {
            gestorFichero = new MotorBBDD("es");
        } else if (this.glBBDDjRadioButtonMenuItem.isSelected()) {
            gestorFichero = new MotorBBDD("gl");
        }
    }

    private void setNuevaPartida() {
        setLabelsBlank();
        MAXIMO_INTENTOS_PARTIDA = 0;
        try {
            palabraRandom = gestorFichero.getPalabraAleatoria();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "ERROR: " + ex.getMessage());
        }
        this.palabrajTextField.setEnabled(true);
        this.finaljLabel.setText(TEXTOVACIO);
        letrasVerdes.clear();
        this.bienjLabel.setText(TEXTOVACIO);
        letrasAmarillas.clear();
        this.existenjLabel.setText(TEXTOVACIO);
        letrasRojas.clear();
        this.maljLabel.setText(TEXTOVACIO);
    }

    private void enviarletrasComprobarYColorear() {
        int contadorAcertadas = 0;
        Color ponerColorPalabra;
        String s = this.palabrajTextField.getText().toLowerCase();
        if (s.length() == TAMANO_PALABRA) {
            setErrorFalse();
            for (int i = 0; i < TAMANO_PALABRA; i++) {
                int insertColor = gestorFichero.checkChar(i, palabraRandom, s);
                String insertLetra = s.substring(0 + i, 1 + i).toUpperCase();
                String rojo;
                String amarillo;
                String verde;
                switch (insertColor) {
                    case 1:
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
                        break;
                    case 0:
                        ponerColorPalabra = COLOR_AMARILLO;
                        if (!letrasVerdes.contains(insertLetra)) {
                            letrasAmarillas.add(insertLetra);
                        }
                        amarillo = cleanLlavesSet(letrasAmarillas.toString());
                        this.existenjLabel.setText(amarillo);
                        break;
                    default:
                        ponerColorPalabra = COLOR_ROJO;
                        letrasRojas.add(insertLetra);
                        rojo = cleanLlavesSet(letrasRojas.toString());
                        this.maljLabel.setText(rojo);
                        break;
                }
                setLetraColor(MAXIMO_INTENTOS_PARTIDA, i, ponerColorPalabra, insertLetra);
            }
            MAXIMO_INTENTOS_PARTIDA++;
            if (contadorAcertadas == TAMANO_PALABRA) {
                this.palabrajTextField.setEnabled(false);
                this.finaljLabel.setForeground(COLOR_VERDE);
                this.finaljLabel.setText("Has adivinado la palabra: " + palabraRandom.toUpperCase() + " en " + MAXIMO_INTENTOS_PARTIDA + " intentos");
            } else if (MAXIMO_INTENTOS_PARTIDA == 6) {
                this.palabrajTextField.setEnabled(false);
                this.finaljLabel.setForeground(COLOR_ROJO);
                this.finaljLabel.setText("No has acertado la palabra: " + palabraRandom.toUpperCase());
            }
        } else {
            setErrorTrue();
        }
    }

    public void setErrorFalse() {
        this.errorjPanel.setVisible(false);
        this.errorjLabel.setVisible(false);
        this.errorjLabel.setText(TEXTOVACIO);
        this.palabrajTextField.setText(TEXTOVACIO);
    }

    public void setErrorTrue() {
        this.errorjPanel.setVisible(true);
        this.errorjLabel.setVisible(true);
        this.errorjLabel.setText("Las palabras deben estar formadas por 5 letras.");
        this.palabrajTextField.setText(TEXTOVACIO);
    }

    public String cleanLlavesSet(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb = sb.delete(0, 1);
        sb = sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

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
    private javax.swing.JMenu archivojMenu;
    private javax.swing.JLabel bienjLabel;
    private javax.swing.JPanel bienjPanel;
    private javax.swing.JPanel bottomjPanel1;
    private javax.swing.JButton enviarjButton;
    private javax.swing.JLabel errorjLabel;
    private javax.swing.JPanel errorjPanel;
    private javax.swing.JRadioButtonMenuItem esBBDDjRadioButtonMenuItem;
    private javax.swing.JPanel estadojPanel;
    private javax.swing.JLabel existenjLabel;
    private javax.swing.JPanel existenjPanel;
    private javax.swing.JPanel exitojPanel;
    private javax.swing.JRadioButtonMenuItem filejRadioButtonMenuItem;
    private javax.swing.JLabel finaljLabel;
    private javax.swing.JMenuItem gestionMotorjMenuItem;
    private javax.swing.JRadioButtonMenuItem glBBDDjRadioButtonMenuItem;
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
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPanel letrasjPanel;
    private javax.swing.JPanel mainjPanel;
    private javax.swing.JLabel maljLabel;
    private javax.swing.JPanel maljPanel;
    private javax.swing.JMenu motoresjMenu;
    private javax.swing.JCheckBoxMenuItem nuevaPartidajCheckBoxMenuItem;
    private javax.swing.JTextField palabrajTextField;
    private javax.swing.JRadioButtonMenuItem testjRadioButtonMenuItem;
    // End of variables declaration//GEN-END:variables
}
