/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1_amc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

/**
 *
 * @author tomas
 */
public class LecturaEscritura {

    public ArrayList<Punto> lectura(String Fichero) {
        ArrayList<Punto> PuntoCoordenadas = new ArrayList<>();
        Punto aux;

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
                        // Fin de la sección de coordenadas
                        break;
                    }
                    String[] parts = line.split(" ");
                    if (parts.length >= 3) {
                        // Asumiendo que el formato es "nodo xCoord yCoord"
                        aux = new Punto(Double.parseDouble(parts[1]), Double.parseDouble(parts[2]));
                        PuntoCoordenadas.add(aux);

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Ahora tienes las coordenadas x en el array xCoordinates y las coordenadas y en el array yCoordinates
        for (int i = 0; i < PuntoCoordenadas.size(); i++) {
            System.out.println("Nodo " + (i + 1) + ": x = " + PuntoCoordenadas.get(i).getX()
                    + ", y = " + PuntoCoordenadas.get(i).getY());
        }
        return PuntoCoordenadas;
    }

    public static void crearArchivoTSP(String nombre, int n) {
        try {
            Locale.setDefault(Locale.US);
            String carpeta = "dataset";
            String rutacompleta = carpeta + "/" + nombre + n + ".tsp";
            BufferedWriter writer = new BufferedWriter(new FileWriter(rutacompleta));

            writer.write("NAME: dataset" + n);
            writer.newLine();
            writer.write("TYPE: TSP");
            writer.newLine();
            writer.write("COMMENT: " + n + "-Staedte in dataset" + n + " (Zaw Win)");
            writer.newLine();
            writer.write("DIMENSION: " + n);
            writer.newLine();
            writer.write("EDGE_WEIGHT_TYPE: GEO");
            writer.newLine();
            writer.write("EDGE_WEIGHT_FORMAT: FUNCTION");
            writer.newLine();
            writer.write("DISPLAY_DATA_TYPE: COORD_DISPLAY");
            writer.newLine();
            writer.write("NODE_COORD_SECTION");
            writer.newLine();

            Random random = new Random();

            for (int i = 1; i <= n; i++) {
                double alto = 16 + random.nextDouble() * 10;
                double ancho = 92 + random.nextDouble() * 10;
                writer.write(i + " " + String.format("%.2f", alto) + " " + String.format("%.2f", ancho));
                writer.newLine();
            }
//hola
            writer.write("EOF");
            writer.close();
            System.out.println("Archivo " + nombre + n + " creado con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
