/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.IProceso;
import Modelo.LecturaEscirtura;
import Modelo.Recursos;
import Vistas.VistaAñadirTransición;
import Vistas.VistaMensaje;
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

    private VistaPricipal vPrincipal;
    private Vista_Inicial vInicial;
    private Vista_Crearfichero vCrear;
    private VistaMensaje vMensaje;
    private VistaAñadirTransición vATransición;
    private Recursos r;
    private IProceso AutomataCargado;

    public ControladorAplicación() {
        vPrincipal = new VistaPricipal();
        vCrear = new Vista_Crearfichero();
        vInicial = new Vista_Inicial();
        vATransición= new VistaAñadirTransición();
        vMensaje=new VistaMensaje();
        r = new Recursos(vCrear,vATransición);
//       vCrear.setSize(vPrincipal.getSize());
//       vInicial.setSize(vPrincipal.getSize());
        
      
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
        vCrear.jButtonAñadirTransición.addActionListener(this);
        vATransición.jButtonAñadirT.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        switch (e.getActionCommand()) {
            case "Cargar Fichero": {
                try {
                    AutomataCargado=LecturaEscirtura.cargarFichero();
                    System.out.println(AutomataCargado.toString());
                } catch (Exception ex) {
                    vMensaje.Mensaje(vPrincipal, "ERROR", ex.getMessage());
                }
            }
            break;
            case "Crear Fichero": {
                muestraPanel(vCrear);
            }
            break;
            case "EnviarCrear": {
                try {
                    AutomataCargado=r.crearautomata();
                } catch (Exception ex) {
                    Logger.getLogger(ControladorAplicación.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case "Añadir Transición": {
                try {
                    r.muestraNTransacion();
                } catch (Exception ex) {
                    Logger.getLogger(ControladorAplicación.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case "AñadirTransiciónD": {
                try {
                    r.añadirTransición();
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
