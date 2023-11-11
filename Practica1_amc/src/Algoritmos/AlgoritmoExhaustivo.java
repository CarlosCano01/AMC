/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algoritmos;

import java.util.ArrayList;
import practica1_amc.Punto;

/**
 *
 * @author tomas
 */
public class AlgoritmoExhaustivo {

    
    public static double BusquedaExhauxtiva(ArrayList<Punto> p){
        Punto p1=null;
        Punto p2=null;
        double distanciaMin = Double.MAX_VALUE;
        for(int i=0;i<p.size()-1;i++){
            for(int j=i+1;j<p.size();j++){
                double distancia=p.get(i).distancia(p.get(j));
                if(distancia<distanciaMin){
                    distanciaMin=distancia;
                    p1=p.get(i);
                    p2=p.get(j);
                }
            }
        }
        System.out.println("Punto más cercano 1: (" + p1.getX() + ", " + p1.getY() + ")");
        System.out.println("Punto más cercano 2: (" + p2.getX()+ ", " + p2.getY() + ")");
        System.out.println("Distancia mínima: " + distanciaMin);
        
        return distanciaMin;
    }
    
    public static void BusquedaExhauxtivaPoda(ArrayList<Punto> p){
        AlgoritmoOrdenacion.OrdenaQuickSort(p);
        double distanciaMin = Double.MAX_VALUE;
        Punto p1=null;
        Punto p2=null;
        for (int i = 0; i < p.size()-2;i++) {
            int j = i + 1;
            while (j < p.size()) {
                if ((p.get(j).getX() - p.get(i).getX()) >= distanciaMin) {
                    j = p.size(); 
                } else {
                    double distancia = p.get(i).distancia(p.get(j));
                    if (distancia < distanciaMin) {
                        distanciaMin = distancia;
                        p1 = p.get(i);
                        p2 = p.get(j);
                    }
                    j++;
                }
            }
        }

        
        System.out.println("Punto más cercano 1: (" + p1.getX() + ", " + p1.getY() + ")");
        System.out.println("Punto más cercano 2: (" + p2.getX()+ ", " + p2.getY() + ")");
        System.out.println("Distancia mínima: " + distanciaMin);
    }
}
