/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author carlo
 */
public class  LecturaEscirtura {

    public static IProceso ComprobarYCargar(String filePath) throws Exception {
        // Aquí debería comprobar el fichero (existencia, formato, transiciones, etc.)
        IProceso aux=null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
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
                            String estados[] = new String[parts.length-1];
                            for (int i = 1; i < parts.length; i++) {
                                estados[i-1]=parts[i];
                            }
                            automataFD.addEstados(estados);
                        } else if ("INICIAL:".equals(parts[0])) {
                            automataFD.setInicial(parts[1]);
                        } else if ("FINALES:".equals(parts[0])) {
                            String finales[] = new String[parts.length-1];;
                            for (int i = 1; i < parts.length ; i++) {
                                finales[i-1]=parts[i];
                            }
                            automataFD.addfinales(finales);
                        }else if ("TRANSICIONES:".equals(parts[0])) {

                        }else
                            automataFD.addTransicion(parts[0], parts[1].charAt(1), parts[2]);
                        
                    }
                    aux=automataFD;
                    break;
                case "AFND":
                    AFND automataFND=new AFND();
                    while ((line = br.readLine()) != null) {
                        String[] parts = line.split(" ");
                        if (line.equals("FIN")) {
                            break;
                        } else if ("ESTADOS:".equals(parts[0])) {
                            String estados[] = new String[parts.length-1];
                            for (int i = 1; i < parts.length; i++) {
                                estados[i-1]=parts[i];
                            }
                            automataFND.addEstados(estados);
                        } else if ("INICIAL:".equals(parts[0])) {
                            automataFND.setInicial(parts[1]);
                        } else if ("FINALES:".equals(parts[0])) {
                            String finales[] = new String[parts.length-1];;
                            for (int i = 1; i < parts.length ; i++) {
                                finales[i-1]=parts[i];
                            }
                            automataFND.addfinales(finales);
                        }else if ("TRANSICIONES:".equals(parts[0])) {
                            while (!"TRANSICIONES LAMBDA:".equals(line = br.readLine())) {

                                String[] partes = line.split(" ");
                                for (int i = 2; i < partes.length; i++) {
                                    automataFND.addTransicion(partes[0], partes[1].charAt(1), partes[i]);
                                }
                            }
                        }else
                            
                           for (int i = 1; i < parts.length; i++) {
                                automataFND.addtransicionesEpsilon(parts[0], parts[i]);
                        }
                    }
                    aux=automataFND;
                    break;
                default:
                    throw new AssertionError();
            }
        } catch (IOException e) {
            throw new Exception("Error al cargar el fichero.");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        
        return aux;
        
    }

    public static File  cargarFichero() throws Exception {

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
            // Imprime la ruta del archivo seleccionado
            System.out.println("Archivo seleccionado: " + archivoSeleccionado.getAbsolutePath());
        } else {
            throw new Exception("No se ha selecionado ningun fichero");
        }
        
        return archivoSeleccionado;

    }
    
   
}
