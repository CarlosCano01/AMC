/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algoritmos;

import java.util.ArrayList;
import practica1_amc.Punto;


public class AlgoritmoOrdenacion {


    public static void OrdenaQuickSortX(ArrayList<Punto> p) {
        QuickSortX(p, 0, p.size()-1);
    }

    private static void QuickSortX(ArrayList<Punto> p, int v, int r) {
        if (v < r) {
            int q = PartitionX(p, v, r);
            QuickSortX(p, v, q);
            QuickSortX(p, q + 1, r);
        }
    }

    private static int PartitionX(ArrayList<Punto> p, int v, int r) {
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
       public static void OrdenaQuickSortY(ArrayList<Punto> p) {
        QuickSortX(p, 0, p.size()-1);
    }

    private static void QuickSortY(ArrayList<Punto> p, int v, int r) {
        if (v < r) {
            int q = PartitionY(p, v, r);
            QuickSortY(p, v, q);
            QuickSortY(p, q + 1, r);
        }
    }

    private static int PartitionY(ArrayList<Punto> p, int v, int r) {
        double piv = p.get(v).getY(); 
        int i = v - 1, j = r + 1;
        do {
            do {
                j = j - 1;
            } while (p.get(j).getY() > piv);
            do {
                i = i + 1;
            } while (p.get(i).getY() < piv);
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
