/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.daw1.samuelrguez.motores;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author 34609
 */
public class MotorBBDD implements IMotor {

    private static final String URL = "jdbc:sqlite:data/dbwordle.db";

    private Set<String> diccionario = new TreeSet<>();
    private static String lang;

    public MotorBBDD(String lang) {
        this.lang = lang;
    }

    private void setPalabrasFicheroEnDiccionario() {
        try (Connection conn = DriverManager.getConnection(URL);
                PreparedStatement ps = conn.prepareStatement("SELECT palabra FROM palabras WHERE lang = ?")) {
            ps.setString(1, lang);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String s = rs.getString("palabra");
                    diccionario.add(s);
                }
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    @Override
    public boolean isPalabraInDiccionario(String s) {
        setPalabrasFicheroEnDiccionario();
        s = s.toUpperCase().trim();
        return diccionario.contains(s);
    }

    @Override
    public String getPalabraAleatoria() throws SQLException {
        try (Connection conn = DriverManager.getConnection(URL);
                PreparedStatement ps = conn.prepareStatement("SELECT palabra FROM palabras WHERE lang = ? ORDER BY RANDOM() LIMIT 1")) {
            ps.setString(1, lang);
            String random;
            try (ResultSet rs = ps.executeQuery()) {
                random = rs.getString("palabra");
                return random;
            }
        }
    }

    @Override
    public int checkChar(int pos, String random, String insertada) {
        random = random.toUpperCase().trim();
        insertada = insertada.toUpperCase().trim();
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
    public boolean addPalabra(String s) throws IOException, SQLException {
        try (Connection conn = DriverManager.getConnection(URL);
                PreparedStatement ps = conn.prepareStatement("INSERT INTO palabras (palabra, lang) VALUES(?, ?)")) {
            ps.setString(1, s.toUpperCase().trim());
            ps.setString(2, lang);
            int insertadas = ps.executeUpdate();
            return insertadas > 0;
        }
    }

    @Override
    public boolean removePalabra(String s) throws SQLException {
        try (Connection conn = DriverManager.getConnection(URL);
                PreparedStatement ps = conn.prepareStatement("DELETE FROM palabras WHERE palabra = ?")) {
            ps.setString(1, s.toUpperCase().trim());
            int borradas = ps.executeUpdate();
            return borradas > 0;

        }
    }

}
