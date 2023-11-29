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
public class AFD implements IAutomataFinitoDeterminista {
    @Override
    public void load(String filePath) throws Exception {
        // Aquí debería comprobar el fichero (existencia, formato, transiciones, etc.)
        throw new IOException(" ");
    }

    @Override
    public boolean reconocer(String cadena) {
        return false;
    }

    @Override
    public String toString() {
        return "  ";
    }

    @Override
    public boolean esFinal(int estado) {
       return false;
    }
}
