/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.daw1.samuelrguez.motores;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
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
        if (!FICHERO.exists()) {
            FICHERO.getParentFile().mkdirs();
            try {
                FICHERO.createNewFile();
            } catch (IOException iOException) {
            }
        }
    }

    @Override
    public boolean isPalabraInDiccionario(String s) {
        return diccionario.contains(s.toUpperCase());
    }

    @Override
    public String getPalabraAleatoria() {
        String[] array = diccionario.toArray(new String[diccionario.size()]);
        return array[(int) (Math.random() * diccionario.size())];
    }

}
