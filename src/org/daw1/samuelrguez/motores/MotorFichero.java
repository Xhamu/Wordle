/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.daw1.samuelrguez.motores;

import java.io.BufferedWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Set;

/**
 *
 * @author 34609
 */
public class MotorFichero implements IMotor {

    public static String ruta = Path.of(".") + File.separator + "data" + File.separator + "diccionario.dat";
    public static File FICHERO = new File(ruta);
    private static Set<String> diccionario;

    public MotorFichero() {
        crearFile();
    }
    
    private boolean existsFile() {
        return FICHERO.exists();
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
    
    private boolean addPalabra(String s) {
        if(!existsFile()) {
            crearFile();
        }
        try (BufferedWriter w = new BufferedWriter(new FileWriter (FICHERO, true))) {
            if(!isPalabraInDiccionario(s)) {
                w.append(s.toUpperCase() + "\n");
                return true;
            } else {
                return false;
            }
        } catch (IOException ex) {
            Logger.getLogger(MotorFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean isPalabraInDiccionario(String s) {
        return diccionario.contains(s.toUpperCase());
    }

    @Override
    public String getPalabraAleatoria() {
        int tamano = diccionario.size();
        int random = (int) (Math.random() * tamano);
        String[] array = diccionario.toArray(new String[tamano]);
        return array[random];
    }

    @Override
    public int checkChar(int pos, String palabraRandom, String palabraInsertada) {
        char l = palabraInsertada.charAt(pos);
        if (palabraRandom.contains(l + "")) {
            if (palabraRandom.charAt(pos) == l) {
                return 1;
            }
            return 0;
        } else {
            return -1;
        }
    }

}
