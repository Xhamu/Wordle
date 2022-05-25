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
 * @author alumno
 */
public interface IMotor {
   
    public boolean isPalabraInDiccionario(String s);
    public String getPalabraAleatoria() throws SQLException;
    public int checkChar(int pos, String random, String insertada);
    public boolean addPalabra(String s) throws IOException, SQLException;
    public boolean removePalabra(String s) throws  SQLException;
}
