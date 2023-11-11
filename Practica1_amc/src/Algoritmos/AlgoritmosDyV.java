/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algoritmos;

import java.util.ArrayList;
import practica1_amc.Punto;

/**
 *
 * @author carlo
 */
public class AlgoritmosDyV {

    public static double DyV(ArrayList<Punto> p) {
        AlgoritmoOrdenacion.OrdenaQuickSort(p);
        for (int i = 0; i < p.size(); i++) {
            System.out.println("Nodo " + (i + 1) + ": x = " + p.get(i).getX()
                    + ", y = " + p.get(i).getY());
        }
        return ParesCercanosX(p, 0, p.size()-1);
    }

    private static double ParesCercanosX(ArrayList<Punto> p, int izq, int dcha) {
        
        if (dcha - izq <= 3) {
            ArrayList<Punto> Pcercanos = new ArrayList<>();
            for (int i = izq; i < dcha+1 ; i++) {
                Pcercanos.add(p.get(i));
            }
            return AlgoritmoExhaustivo.BusquedaExhauxtiva(Pcercanos);
        }

        int mid = (izq + dcha) / 2;
        Punto medio = p.get(mid);

        double dIzq = ParesCercanosX(p, izq, mid);
        double dDcha = ParesCercanosX(p, mid + 1, dcha);
        double minDist = Math.min(dIzq, dDcha);

        double stripMin = stripClosestX(p, izq, dcha, medio, minDist);

        //System.out.println(Math.min(minDist, stripMin));
        
        return Math.min(minDist, stripMin);
    }

    private static double stripClosestX(ArrayList<Punto> p, int izq, int dcha, Punto medio, double minDist) {
        double min = minDist;
        for (int i = izq; i <= dcha; i++) {
            if (Math.abs(p.get(i).getX() - medio.getX()) < min) {
                for (int j = i + 1; j <= dcha; j++) {
                    if (p.get(j).getY() - p.get(i).getY() >= min) {
                        break;
                    }
                    double dist = p.get(i).distancia(p.get(j));
                    if (dist < min) {
                        min = dist;
                    }
                }
            }
        }
        return min;
    }
}
