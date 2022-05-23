/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.daw1.samuelrguez.motores;

/**
 *
 * @author alumno
 */
public interface IMotor {
    
    public boolean isPalabraInDiccionario(String s);
    public String getPalabraAleatoria();
    public int comprobarCaracter(int pos, String palabraRandom, String palabraInsertada);
    
}
