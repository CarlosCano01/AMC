/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1_amc;

import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Punto {

    private double x;
    private double y;
    private int numeracion;

    public int getNumeracion() {
        return numeracion;
    }

    public Punto(double x, double y,int num) {
        this.x = x;
        this.y = y;
        this.numeracion = num;
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
    
        public static ArrayList<Punto> rellenarPuntos(int n, boolean mismax) {
        Random rand = new Random();
        ArrayList<Punto> puntos = new ArrayList<>();

        if (mismax) { // PEOR CASO
            for (int i = 0; i < n; i++) {
                double aux1 = rand.nextInt(1000) + 7; // 7 y 1007
                double y = aux1 / ((double) i + 1 + i * 0.100);
                int num = rand.nextInt(3);
                y += ((i % 500) - num * (rand.nextInt(100)));
                double x = 1;
                puntos.add(new Punto(x, y,i+1));
            }
        } else { // CASO MEDIO
            for (int i = 0; i < n; i++) {
                double num = rand.nextInt(4000) + 1;
                double den = rand.nextInt(11) + 7;
                double x = num / (den + 0.37);
                double y = (rand.nextInt(4000) + 1) / (rand.nextInt(11) + 7 + 0.37);
                puntos.add(new Punto(x, y, i+1));
            }
        }
        return puntos;
    }

    @Override
    public String toString() {
        return "("+x+","+y+")";
    }
}
