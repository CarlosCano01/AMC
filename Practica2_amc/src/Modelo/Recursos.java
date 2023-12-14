/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author carlo
 */
public class Recursos {
    public void cargarFichero() throws Exception{

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

    }
}
