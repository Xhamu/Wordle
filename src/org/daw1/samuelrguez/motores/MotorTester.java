/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.daw1.samuelrguez.motores;

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
    public int checkChar(int pos, String palabraRandom, String palabraInsertada) {
        char l = palabraInsertada.charAt(pos);
        if (palabraRandom.contains(l + "")) {
            if (palabraInsertada.charAt(pos) == l) {
                return 1;
            }
            return 0;
        } else {
            return -1;
        }
    }
    
}
