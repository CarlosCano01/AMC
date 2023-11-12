/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1_amc;

import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.Random;


public class Punto {

    private double x;
    private double y;
    private int numeracion;

    Punto(double parseDouble, double parseDouble0, int i) {
        this.x = x;
        this.y = y;
        this.numeracion=i;
    }

    public int getNumeracion() {
        return numeracion;
    }

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distancia(Punto p) {
        double x1 = p.getX();
        double y1 = p.getY();
        return (double) (sqrt((Math.pow(x1 - this.x, 2)) + Math.pow(y1 - this.y, 2)));
    }

}
