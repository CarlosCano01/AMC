/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class AFD implements IAutomataFinitoDeterminista {

    private ArrayList<Transacion> transacciones = new ArrayList();
    private ArrayList<String> estados = new ArrayList();
    private ArrayList<String> finales = new ArrayList();
    private String inicial;

    public AFD(ArrayList<Transacion> transacciones, ArrayList<String> estados, ArrayList<String> finales, String inicial) {
        this.inicial = inicial;
        this.transacciones = transacciones;
        this.estados = estados;
        this.finales = finales;
    }

    @Override
    public void load(String filePath) throws Exception {
        // Aquí debería comprobar el fichero (existencia, formato, transiciones, etc.)
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            boolean isReading = false;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                if (line.equals("FIN")) {
                    break;
                } else if (parts[0] == "ESTADOS:") {
                    for (int i = 1; i < parts.length - 1; i++) {
                        estados.add(parts[i]);
                    }
                } else if (parts[0] == "INICIAL:") {
                    inicial = parts[0];
                } else if (parts[0] == "FINALES:") {
                    for (int i = 1; i < parts.length - 1; i++) {
                        finales.add(parts[i]);
                    }
                }

            }
        } catch (IOException e) {
            System.out.println("Error al cargar el fichero.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

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
