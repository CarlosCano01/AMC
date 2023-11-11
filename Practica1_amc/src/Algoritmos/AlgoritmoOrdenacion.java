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
public class AlgoritmoOrdenacion {


    public static void OrdenaQuickSort(ArrayList<Punto> p) {
        QuickSort(p, 0, p.size()-1);
    }

    private static void QuickSort(ArrayList<Punto> p, int v, int r) {
        if (v < r) {
            int q = Partition(p, v, r);
            QuickSort(p, v, q);
            QuickSort(p, q + 1, r);
        }
    }

    private static int Partition(ArrayList<Punto> p, int v, int r) {
        double piv = p.get(v).getX(); 
        int i = v - 1, j = r + 1;
        do {
            do {
                j = j - 1;
            } while (p.get(j).getX() > piv);
            do {
                i = i + 1;
            } while (p.get(i).getX() < piv);
            if (i < j) {
                cambiar(p,i,j);
            }
        } while (i < j);
        return j;
    }
    
    private static void cambiar(ArrayList<Punto> p, int i, int j) {
        Punto aux = p.get(i);
        p.set(i, p.get(j));
        p.set(j, aux);
    }
;
}
