/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

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

    public void ComprobarYCargar(String filePath) throws Exception {
        // Aquí debería comprobar el fichero (existencia, formato, transiciones, etc.)
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            boolean isReading = false;
            line = br.readLine();
            String[] tipAutomata = line.split(" ");
            switch (tipAutomata[1]) {
                case "AFD":
                    AFD automataFD=new AFD();
                    while ((line = br.readLine()) != null) {
                        String[] parts = line.split(" ");
                        if (line.equals("FIN")) {
                            break;
                        } else if ("ESTADOS:".equals(parts[0])) {
                            for (int i = 1; i < parts.length - 1; i++) {
                                estados.add(parts[i]);
                            }
                        } else if ("INICIAL:".equals(parts[0])) {
                            inicial = parts[0];
                        } else if ("FINALES:".equals(parts[0])) {
                            for (int i = 1; i < parts.length - 1; i++) {
                                finales.add(parts[i]);
                            }
                        }
                    }
                    break;
                case "AFND":
                    
                    break;
                default:
                    throw new AssertionError();
            }
        } catch (IOException e) {
            System.out.println("Error al cargar el fichero.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void cargarFichero() throws Exception {

        JFileChooser fileChooser = new JFileChooser();
        File archivoSeleccionado;
        // Configura el filtro para mostrar solo archivos de texto (opcional)
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto", "txt");
        fileChooser.setFileFilter(filter);

        // Muestra el diálogo de selección de archivos
        int resultado = fileChooser.showOpenDialog(null);

        // Verifica si el usuario seleccionó un archivo
        if (resultado == JFileChooser.APPROVE_OPTION) {
            // Obtiene el archivo seleccionado
            archivoSeleccionado = fileChooser.getSelectedFile();
            ComprobarYCargar(archivoSeleccionado.getAbsolutePath());
            // Imprime la ruta del archivo seleccionado
            System.out.println("Archivo seleccionado: " + archivoSeleccionado.getAbsolutePath());
        } else {
            throw new Exception("No se ha selecionado ningun fichero");
        }

    }
}
