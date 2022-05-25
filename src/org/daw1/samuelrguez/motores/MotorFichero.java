/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.daw1.samuelrguez.motores;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.Random;

/**
 *
 * @author 34609
 */
public class MotorFichero implements IMotor {

    public static File FICHERO;
    private static Set<String> diccionario = new TreeSet<>();

    public MotorFichero(File f) {
        FICHERO = f;
        setPalabrasFicheroEnDiccionario();
    }

    private boolean existsFile() {
        return FICHERO.exists();
    }

    private boolean setPalabrasFicheroEnDiccionario() {
        try (BufferedReader br = new BufferedReader(new FileReader(FICHERO))) {
            String line = br.readLine();
            while (line != null) {
                diccionario.add(line);
                line = br.readLine();
            }
            return true;
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
        return false;
    }

    private boolean setPalabraDiccionarioEnFichero() {
        if (!existsFile()) {
            crearFile();
        }
        try (Writer wr = new BufferedWriter(new FileWriter(FICHERO))) {
            wr.write("");
        } catch (IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
        try (Writer wr = new BufferedWriter(new FileWriter(FICHERO, true))) {
            StringBuilder sb = new StringBuilder();
            for (String s : diccionario) {
                sb.append(s).append("\n");
            }
            wr.write(sb.toString());
            return true;
        } catch (IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
        return false;
    }

    private void crearFile() {
        if (!existsFile()) {
            FICHERO.getParentFile().mkdirs();
            try {
                FICHERO.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(MotorFichero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private boolean checkPalabra(String s) {
        s = s.toLowerCase().trim();
        return !s.matches("[^a-z]{5}");
    }

    @Override
    public boolean isPalabraInDiccionario(String s) {
        setPalabrasFicheroEnDiccionario();
        s = s.toLowerCase().trim();
        return diccionario.contains(s.toUpperCase());
    }

    @Override
    public String getPalabraAleatoria() throws SQLException {
        if (!existsFile()) {
            crearFile();
        }
        String random = "";
        int cont = 0;
        Random numeroRandom = new Random();
        int numeroRandomPalabra = numeroRandom.nextInt(diccionario.size());
        Iterator it = diccionario.iterator();
        while (cont <= numeroRandomPalabra) {
            random = (String) it.next();
            cont++;
        }
        return random;
    }

    @Override
    public int checkChar(int pos, String random, String insertada) {
        random = random.toLowerCase().trim();
        insertada = insertada.toLowerCase().trim();
        char l = insertada.charAt(pos);
        if (random.contains(l + "")) {
            if (random.charAt(pos) == l) {
                return 1;
            }
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public boolean addPalabra(String s) throws IOException {
        s = s.toLowerCase().trim();
        if (checkPalabra(s)) {
            if (!existsFile()) {
                crearFile();
            }
            try (Writer wr = new BufferedWriter(new FileWriter(FICHERO, true))) {
                wr.write(s + "\n");
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removePalabra(String s) throws SQLException {
        s = s.toLowerCase().trim();
        if (checkPalabra(s)) {
            if (!existsFile()) {
                crearFile();
            }
            setPalabrasFicheroEnDiccionario();
            if (diccionario.contains(s)) {
                if (diccionario.remove(s)) {
                    setPalabraDiccionarioEnFichero();
                    return true;
                }
            }
        }
        return false;
    }
}
