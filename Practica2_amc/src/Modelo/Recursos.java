/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vistas.VistaAñadirTransición;
import Vistas.VistaComprobar;
import Vistas.Vista_Crearfichero;
import java.awt.Dialog;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author carlo
 */
public class Recursos {
    
    private Vista_Crearfichero vCrear;
    private VistaAñadirTransición vAt;
    private VistaComprobar vComprobar;
    
    public Recursos(Vista_Crearfichero vCrear,VistaAñadirTransición vATransicion,VistaComprobar vComprobar){
        this.vCrear=vCrear;
        this.vAt=vATransicion;
        this.vComprobar=vComprobar;
    }
    
    
    public IProceso crearautomata() {
        String variable;
        String[] array;
        IProceso b = null;
        
        if (vCrear.jComboBox1.equals("AFD")) {
            AFD a = new AFD();
            //inicial
            variable = vCrear.jTextField1.getText();
            array = variable.split(" ");
            a.addEstados(array);
            //todos los estados
            variable = vCrear.jTextField2.getText();
            a.setInicial(variable);
            //transiciones
//            variable = vCrear.jTextField3.getText();
//            array = variable.split(" ");
//            a.addfinales(array);
//            b = a;
           

        } else {
            AFND a = new AFND();
            //inicial
            variable = vCrear.jTextField1.getText();
            array = variable.split(" ");
            a.addEstados(array);
            //todos los estados
            variable = vCrear.jTextField2.getText();
            a.setInicial(variable);
            //transiciones
//            variable = vCrear.jTextField3.getText();
//            array = variable.split(" ");
//            a.addfinales(array);
//            b = a;
        }
         

        return b;

    }
    public void añadirTransición(){
        System.out.println("pata");
        Object[] fila = new Object[3];
        System.out.println("estoy funcionando");    
            fila[0] = vAt.jTextFieldInicial.getText();
            fila[1] = vAt.jTextFieldCaract.getText();
            fila[2] = vAt.jTextFieldFinal.getText();
            vCrear.modeloTablaTransiciones.addRow(fila);
        vAt.dispose();
    }

    public void muestraNTransacion(){
        vAt.setLocationRelativeTo(null);
        vAt.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        vAt.setVisible(true);
    }
    public boolean ComprobarP(){
       // vComp
    }
    
}
