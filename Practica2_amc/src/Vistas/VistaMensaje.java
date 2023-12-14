/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vistas;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author carlo
 */
public class VistaMensaje {
    public void Mensaje(Component c,String tipo,String mensaje){
    
        switch (tipo) {
            case "INFO":
                    JOptionPane.showMessageDialog(c, mensaje,"INFORMACION",JOptionPane.INFORMATION_MESSAGE);
                break;
            case "ERROR":
                    JOptionPane.showMessageDialog(c, mensaje,"ERROR",JOptionPane.ERROR_MESSAGE);
                break;
            default:
                throw new AssertionError();
        }
    }
}
