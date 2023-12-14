/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.IProceso;
import Modelo.Recursos;
import Vistas.VistaPricipal;
import Vistas.Vista_Crearfichero;
import Vistas.Vista_Inicial;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author carlos
 */
public class ControladorAplicación implements ActionListener {

    private Vistas.VistaPricipal vPrincipal;
    private Vistas.Vista_Inicial vInicial;
    private Vistas.Vista_Crearfichero vCrear;
    private IProceso AutomataCargado;

    public ControladorAplicación() {
        vPrincipal = new VistaPricipal();
        vCrear = new Vista_Crearfichero();
        vInicial = new Vista_Inicial();

        vPrincipal.getContentPane().setLayout(new CardLayout());
        vPrincipal.add(vCrear);
        vPrincipal.add(vInicial);
        muestraPanel(vInicial);

        addListeners();

        vPrincipal.setLocationRelativeTo(null);
        vPrincipal.setVisible(true);

    }

    private void addListeners() {
        vPrincipal.cargarFichero.addActionListener(this);
        vPrincipal.jMenuItemCrearFichero.addActionListener(this);
        vCrear.Enviar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Recursos r = new Recursos();
        switch (e.getActionCommand()) {
            case "Cargar Fichero": {
                try {
                } catch (Exception ex) {
                    Logger.getLogger(ControladorAplicación.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Estoy entrando");
            break;
            case "Crear Fichero": {
                muestraPanel(vCrear);
            }
            break;
            case "EnviarCrear": {
                try {
                    AutomataCargado=r.crearautomata(vCrear);
                } catch (Exception ex) {
                    Logger.getLogger(ControladorAplicación.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;

        }
    }

    private void muestraPanel(JPanel jP) {
        vCrear.setVisible(false);
        jP.setVisible(true);

    }

}
