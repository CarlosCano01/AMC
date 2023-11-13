/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1_amc;

import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class Resultado {
    private Punto punto1, punto2;
    private double distancia;
    private ArrayList<Punto> ruta; // Campo para almacenar el ruta completo

    public Resultado(Punto punto1, Punto punto2, double distancia) {
        this.punto1 = punto1;
        this.punto2 = punto2;
        this.distancia = distancia;
    }

    public Resultado(double distancia, ArrayList<Punto> ruta) {
        this.distancia = distancia;
        this.ruta = ruta;
    }
    
    public Punto getPunto1() {
        return punto1;
    }

    public void setPunto1(Punto punto1) {
        this.punto1 = punto1;
    }

    public Punto getPunto2() {
        return punto2;
    }

    public void setPunto2(Punto punto2) {
        this.punto2 = punto2;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public ArrayList<Punto> getRuta() {
        return ruta;
    }

    public void setRuta(ArrayList<Punto> ruta) {
        this.ruta = ruta;
    }
    
    @Override
    public String toString() {
        return "EL punto1 es : " + punto1+
                "\nEl punto2 es : "+ punto2+
                "\nLa distancia es: "+distancia;
    }
}
