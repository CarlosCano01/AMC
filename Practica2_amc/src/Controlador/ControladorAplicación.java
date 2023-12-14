/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.IProceso;
import Modelo.Recursos;
import Vistas.VistaPricipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlos
 */
public class ControladorAplicación implements ActionListener{
    
    private Vistas.VistaPricipal vPrincipal;
    private IProceso AutomataCargado;
    public ControladorAplicación() {
        vPrincipal = new VistaPricipal();

        addListeners();

        vPrincipal.setLocationRelativeTo(null);
        vPrincipal.setVisible(true);
    }
    
    private void addListeners() {
        vPrincipal.cargarFichero.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Cargar Fichero":
                Recursos r=new Recursos();
            {
                try {
                    r.cargarFichero();
                } catch (Exception ex) {
                    Logger.getLogger(ControladorAplicación.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                System.out.println("Estoy entrando");
                break;

        }
    }
}
