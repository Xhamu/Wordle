/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.daw1.samuelrguez.motores;

import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author 34609
 */
public class MotorTester implements IMotor{

    @Override
    public boolean isPalabraInDiccionario(String s) {
        return true;
    }

    @Override
    public String getPalabraAleatoria() {
        return "CICLO";
    }

    @Override
    public int checkChar(int pos, String random, String insertada) {
        char l = insertada.charAt(pos);
        if (random.contains(l + "")) {
            if (insertada.charAt(pos) == l) {
                return 1;
            }
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public boolean addPalabra(String s) throws IOException, SQLException {
        return true;
    }

    @Override
    public boolean removePalabra(String s) throws SQLException {
        return true;
    }
    
}
