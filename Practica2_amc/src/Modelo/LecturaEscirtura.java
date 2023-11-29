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
public class LecturaEscirtura {
    public void lectura(String Fichero) {
//        ArrayList<Punto> PuntoCoordenadas = new ArrayList<>();
//        Punto aux;
        int id = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(Fichero));
            String line;
            boolean isReadingCoordinates = false;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("NODE_COORD_SECTION")) {
                    isReadingCoordinates = true;
                }
                if (isReadingCoordinates) {
                    if (line.equals("EOF")) {
                        // Fin de la seccion de coordenadas
                        break;
                    }
                    String[] parts = line.split(" ");
                    if (parts.length >= 3) {
                        // Asumiendo que el formato es "nodo xCoord yCoord"
//                        aux = new Punto(Double.parseDouble(parts[1]), Double.parseDouble(parts[2]), id++);
//                        PuntoCoordenadas.add(aux);

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        // Ahora tienes las coordenadas x en el array xCoordinates y las coordenadas y en el array yCoordinates
//        for (int i = 0; i < PuntoCoordenadas.size(); i++) {
//            System.out.println("Nodo " + (i + 1) + ": x = " + PuntoCoordenadas.get(i).getX()
//                    + ", y = " + PuntoCoordenadas.get(i).getY());
//        }
//        return PuntoCoordenadas;
    }
}
