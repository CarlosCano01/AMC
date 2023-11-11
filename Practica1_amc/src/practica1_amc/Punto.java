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

    public ArrayList<Punto> rellenarPuntos(ArrayList<Punto> p, int n, boolean mismax) {
        int num, den;
        double x, y, aux1;

        Random random = new Random();
        if (mismax) { //PEOR CASO
            for (int i = 0; i < n; i++) {
                aux1 = random.nextDouble() % 1000 + 7; //7 y 1007
                y = (double) (aux1 / ((double) i + 1 + i * 0.100)); //aux2; //+(i/3.0);
                num = (int)random.nextDouble() % 3;
                y += ((i % 500) - num * (random.nextDouble() % 100));
                x = 1;
                p.add(new Punto(x, y));
            }
        } else { //CASO MEDIO
            for (int i = 0; i < n; i++) {
                /*num = rand() % 4000 + 1; //genera un número aleatorio entre 1 y 4000
                den = rand() % 11 + 7; //genera un aleatorio entre 7 y 17
                x = num / ((double) den + 0.37); //division con decimales
                y = (rand() % 4000 + 1) / ((double) (rand() % 11 + 7) + 0.37);
                p[i] = Punto(x, y, i + 1);*/
            }
        }
        return p;
    }

}
