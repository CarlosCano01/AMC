/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vistas.Vista_Crearfichero;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author carlo
 */
public class Recursos {

    public IProceso crearautomata(Vista_Crearfichero vCrear) {
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
            variable = vCrear.jTextField3.getText();
            array = variable.split(" ");
            a.addfinales(array);
            b = a;
           

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
            variable = vCrear.jTextField3.getText();
            array = variable.split(" ");
            a.addfinales(array);
            b = a;
        }
         

        return b;

    }
}
