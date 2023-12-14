/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.IOException;

/**
 *
 * @author carlo
 */
public class AFND   {

    public void load(String filePath) throws Exception {
        // Aquí debería comprobar el fichero (existencia, formato, transiciones, etc.)
        throw new IOException("");
    }


    public boolean esFinal(int estado) {
        return false;
    }


    public boolean reconocer(String cadena) {
        return false;
    }

    @Override
    public String toString() {
        return " ";
    }
}
