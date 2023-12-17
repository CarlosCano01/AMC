/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.IProceso;
import Modelo.LecturaEscirtura;
import Modelo.Recursos;
import Vistas.VistaAñadirTransición;
import Vistas.VistaComprobar;
import Vistas.VistaMensaje;
import Vistas.VistaPricipal;
import Vistas.Vista_Crearfichero;
import Vistas.Vista_Inicial;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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
    private VistaComprobar vComp;
    private Recursos r;
    private IProceso AutomataCargado;
    private File archivo;

    public ControladorAplicación() {
        vPrincipal = new VistaPricipal();
        vCrear = new Vista_Crearfichero();
        vInicial = new Vista_Inicial();
        vATransición = new VistaAñadirTransición();
        vMensaje = new VistaMensaje();
        vComp = new VistaComprobar();
        r = new Recursos(vCrear, vATransición, vComp);
//       vCrear.setSize(vPrincipal.getSize());
//       vInicial.setSize(vPrincipal.getSize());

        vPrincipal.getContentPane().setLayout(new CardLayout());
        vPrincipal.add(vCrear);
        vPrincipal.add(vInicial);
        vPrincipal.add(vComp);
        muestraPanel(vInicial);

        addListeners();

        vPrincipal.setLocationRelativeTo(null);
        vPrincipal.setVisible(true);

    }

    private void addListeners() {
        vPrincipal.cargarFichero.addActionListener(this);
        vPrincipal.jMenuItemCrearFichero.addActionListener(this);
        vPrincipal.jMenuItemComprobar.addActionListener(this);
        vCrear.Enviar.addActionListener(this);
        vCrear.jButtonAñadirTransición.addActionListener(this);
        vATransición.jButtonAñadirT.addActionListener(this);
        vComp.jButton1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "Cargar Fichero": {
                try {
           
                    archivo=LecturaEscirtura.cargarFichero();
                    AutomataCargado = LecturaEscirtura.ComprobarYCargar(archivo.getAbsolutePath());
                    System.out.println(AutomataCargado.toString());
                    r.mostrarArchivo(archivo.getName());
                } catch (Exception ex) {
                    vMensaje.Mensaje(vPrincipal, "ERROR", ex.getMessage());
                }
            }
            break;
            case "ComprobarPalabra":  {
                try {
                    if(AutomataCargado==null)
                        throw new Exception("Debes de selecionar un archivo o crear uno");
                    muestraPanel(vComp);
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
                    vMensaje.Mensaje(vPrincipal, "ERROR", ex.getMessage());
                }
            }
            break;
            case "Añadir Transición": {
                try {
                    r.muestraNTransacion();
                } catch (Exception ex) {
                    vMensaje.Mensaje(vPrincipal, "ERROR", ex.getMessage());
                }
            }
            break;
            case "AñadirTransiciónD": {
                try {
                    r.añadirTransición();
                    vATransición.dispose();
                } catch (Exception ex) {
                    vMensaje.Mensaje(vPrincipal, "ERROR", ex.getMessage());
                }
            }
            break;
            case "Comprobar": {
                try {
                    r.mostrarComprobación(AutomataCargado);

                } catch (Exception ex) {
                    vMensaje.Mensaje(vPrincipal, "ERROR", ex.getMessage());
                }
            }
            break;

        }
    }

    private void muestraPanel(JPanel jP) {
        vCrear.setVisible(false);
        vComp.setVisible(false);
        vInicial.setVisible(false);
        jP.setVisible(true);

    }

}
