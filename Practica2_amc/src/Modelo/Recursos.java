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
    public IProceso crearautomata(Vista_Crearfichero vCrear){
        String variable;
        String[] array;
        
        if(vCrear.jComboBox1.equals("AFD")){
            AFD a=new AFD();
             variable=vCrear.jTextField1.getText();
             array=variable.split(" ");
             a.addEstados(array);
             
             variable=vCrear.jTextField2.getText();
             a.setInicial(variable);
             
             variable=vCrear.jTextField3.getText();
             array = variable.split(" ");
             a.addfinales(array);            
             
            

        }else{
            a= new AFND();
        }

        return a;        
        
    }
}
