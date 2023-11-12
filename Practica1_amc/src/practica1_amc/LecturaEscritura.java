/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1_amc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class LecturaEscritura {

    public ArrayList<Punto> lectura(String Fichero) {
        ArrayList<Punto> PuntoCoordenadas = new ArrayList<>();
        Punto aux;
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
                        aux = new Punto(Double.parseDouble(parts[1]), Double.parseDouble(parts[2]), id++);
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

    public static void crearArchivoTSP(String nombre, int n, boolean caso) {
        try {
            Locale.setDefault(Locale.US);
            String carpeta = "archivos";
            String rutacompleta = carpeta + "/" + nombre + n + ".tsp";
            BufferedWriter writer = new BufferedWriter(new FileWriter(rutacompleta));

            writer.write("NAME: archivos" + n);
            writer.newLine();
            writer.write("TYPE: TSP");
            writer.newLine();
            writer.write("COMMENT: " + n + "-Staedte in archivos" + n + " (Zaw Win)");
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
            int num, den;
            double y, x, aux1;
            for (int i = 1; i <= n; i++) {
                if (!caso) {
                    aux1 = random.nextInt(1000) + 7; //7 y 1007
                    y = (int) (aux1 / ((double) i + 1 + i * 0.100)); //aux2; //+(i/3.0)
                    x = 1;
                } else {
                    num = random.nextInt(4000) + 1; //genera un número aleatorio entre 1 y 4000
                    den = random.nextInt(11) + 7; //genera un aleatorio entre 7 y 17
                    x = num / ((double) den + 0.37); //division con decimales
                    y = (random.nextInt(4000) + 1) / ((double) (random.nextInt(11) + 7) + 0.37);
                }

                double alto = (double) x;
                double ancho = (double) y;
                writer.write(i + " " + String.format("%.2f", alto) + " " + String.format("%.2f", ancho));
                writer.newLine();
            }

            writer.write("EOF");
            writer.close();
            System.out.println("Archivo " + nombre + n + " creado con Exito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void crearArchivoTSPuni(ArrayList<Punto> ruta, double distancia, String archivo) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));
            writer.write("NAME : " + archivo);
            writer.newLine();
            writer.write("TYPE : TOUR");
            writer.newLine();
            writer.write("DIMENSION : " + ruta.size());
            writer.newLine();
            writer.write("SOLUTION: " + distancia);
            writer.newLine();
            writer.write("TOUR_SECTION");
            writer.newLine();

            //para tener una cadena del orden de los nodos 
            StringBuilder sequence = new StringBuilder();

            for (int i = 0; i < ruta.size(); i++) {
                sequence.append(ruta.get(i).getNumeracion()); // obtener el numero del nodo

                if (i < ruta.size() - 1) {
                    sequence.append(", ");
                }
            }

            // Repetir el primer número para cerrar el ciclo
            sequence.append(", " + ruta.get(0).getNumeracion());
            writer.write(sequence.toString());
            writer.newLine();

            for (int i = 0; i < ruta.size(); i++) {
                Punto nodoActual = ruta.get(i);
                Punto nodoSiguiente = ruta.get((i + 1) % ruta.size());

                double dis = nodoActual.distancia(nodoSiguiente);
                writer.write(dis + " - " + nodoActual.getNumeracion() + "," + nodoSiguiente.getNumeracion());
                writer.newLine();
            }

            writer.write("EOF");
            writer.close();
            System.out.println("Archivo " + archivo + " creado con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void crearArchivoTSPbi(ArrayList<Punto> ruta, String archivo, double coste) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));

            writer.write("NAME : " + archivo);
            writer.newLine();
            writer.write("TYPE : TOUR");
            writer.newLine();
            writer.write("DIMENSION : " + ruta.size());
            writer.newLine();
            writer.write("SOLUTION: " + coste);
            writer.newLine();
            writer.write("TOUR_SECTION");
            writer.newLine();

            //mostramos el orden de los nodos
            for (int i = 0; i < ruta.size(); i++) {
                writer.write(Integer.toString(ruta.get(i).getNumeracion()));
                writer.write(", ");
            }

            writer.write(Integer.toString(ruta.get(0).getNumeracion()));//este es el primero

            // y las distancia entre los nodos
            writer.newLine();
            for (int i = 0; i < ruta.size(); i++) {
                Punto nodoActual = ruta.get(i);
                Punto nodoSiguiente = ruta.get((i + 1) % ruta.size());

                double distancia = nodoActual.distancia(nodoSiguiente);
                writer.write(distancia + " - " + nodoActual.getNumeracion() + "," + nodoSiguiente.getNumeracion());
                writer.newLine();
            }

            writer.write("EOF");
            writer.close();
            System.out.println("Resultado de estrategia bidireccional guardado en " + archivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> getNombreFicheros() {
        File carpeta = new File("archivos");
        ArrayList<String> listaArchivos = new ArrayList<>();
        for (File archivo : carpeta.listFiles()) {
            listaArchivos.add(archivo.getName());
        }
        return listaArchivos;
    }
}
