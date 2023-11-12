/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algoritmos;

import java.util.ArrayList;
import practica1_amc.Punto;
import practica1_amc.Resultado;


public class AlgoritmosDyV {

    public static Resultado DyV(ArrayList<Punto> p) {
        ArrayList<Punto> clonP=p;
        AlgoritmoOrdenacion.OrdenaQuickSortX(clonP);
        return ParesCercanosX(clonP, 0, p.size()-1);
    }
     
    public static Resultado DyVMejorado(ArrayList<Punto> p) {
        ArrayList<Punto> clonP=p;
        AlgoritmoOrdenacion.OrdenaQuickSortY(clonP);
        return ParesCercanosY(clonP, 0, p.size()-1);
    }

    private static Resultado ParesCercanosX(ArrayList<Punto> p, int izq, int dcha) {
        double minDist;
        Resultado rfinal;
        if (dcha - izq <= 3) {
            ArrayList<Punto> Pcercanos = new ArrayList<>();
            for (int i = izq; i < dcha+1 ; i++) {
                Pcercanos.add(p.get(i));
            }
            return AlgoritmoExhaustivo.BusquedaExhauxtiva(Pcercanos);
        }

        int mid = (izq + dcha) / 2;
        Punto medio = p.get(mid);

        Resultado dIzq = ParesCercanosX(p, izq, mid);
        Resultado dDcha = ParesCercanosX(p, mid + 1, dcha);
        if(dIzq.getDistancia()<dDcha.getDistancia()){
            minDist=dIzq.getDistancia();
            rfinal=dIzq;
        }else{
            minDist=dDcha.getDistancia();
            rfinal=dDcha;
        }
        
        Resultado rPosible = stripClosestY(p, izq, dcha, medio, rfinal);
        
        if(rPosible.getDistancia()<rfinal.getDistancia()){
            rfinal=rPosible;
        }
        
        return rfinal;
    }
    
        public static Resultado ParesCercanosY(ArrayList<Punto> p, int izq, int dcha) {
        double minDist;
        Resultado rfinal;
        if (dcha - izq <= 12) {
            ArrayList<Punto> Pcercanos = new ArrayList<>();
            for (int i = izq; i < dcha+1 ; i++) {
                Pcercanos.add(p.get(i));
            }
            return AlgoritmoExhaustivo.BusquedaExhauxtiva(Pcercanos);
        }

        int mid = (izq + dcha) / 2;
        Punto medio = p.get(mid);

        Resultado dIzq = ParesCercanosY(p, izq, mid);
        Resultado dDcha = ParesCercanosY(p, mid + 1, dcha);
        
        if(dIzq.getDistancia()<dDcha.getDistancia()){
            minDist=dIzq.getDistancia();
            rfinal=dIzq;
        }else{
            minDist=dDcha.getDistancia();
            rfinal=dDcha;
        }
        
        Resultado rPosible = stripClosestY(p, izq, dcha, medio, rfinal);
        
        if(rPosible.getDistancia()<rfinal.getDistancia()){
            rfinal=rPosible;
        }
        
        return rfinal;
    }

    private static Resultado stripClosestX(ArrayList<Punto> p, int izq, int dcha, Punto medio, Resultado rfinal) {
        double min = rfinal.getDistancia();
        Resultado rPosible=rfinal;
        for (int i = izq; i <= dcha; i++) {
            if (Math.abs(p.get(i).getX() - medio.getX()) < min) {
                for (int j = i + 1; j <= dcha; j++) {
                    if (p.get(j).getY() - p.get(i).getY() >= min) {
                        break;
                    }
                    double dist = p.get(i).distancia(p.get(j));
                    if (dist < min) {
                        rPosible = new Resultado(p.get(i), p.get(j), dist);
                    }
                }
            }
        }
        return rPosible;
    }
    private static Resultado stripClosestY(ArrayList<Punto> p, int izq, int dcha, Punto medio, Resultado rfinal) {
        double min = rfinal.getDistancia();
        Resultado rPosible=rfinal;
        for (int i = izq; i <= dcha; i++) {
            if (Math.abs(p.get(i).getY()- medio.getY()) < min) {
                for (int j = i + 1; j <= dcha; j++) {
                    double dist = p.get(i).distancia(p.get(j));
                    if (dist < min) {
                        rPosible = new Resultado(p.get(i), p.get(j), dist);
                    }
                }
            }
        }
        return rPosible;
    }
}
