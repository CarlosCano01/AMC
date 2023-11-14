/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Algoritmos;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import practica1_amc.Punto;
import practica1_amc.Resultado;

/**
 *
 * @author carlo
 */
public class AlgoritmoSolucionOptima {

    public static Resultado recorrerConPermutaciones(ArrayList<Punto> arrayList) {
        Resultado Rfinal = new Resultado(Double.MAX_VALUE, arrayList);
        return recorrerConPermutacionesI(arrayList, 0, Rfinal);
    }

    public static Resultado recorrerConPermutacionesI(ArrayList<Punto> arrayList, int indice, Resultado Rfinal) {
        try {
            if (arrayList.size() < 11) {
                if (indice == arrayList.size() - 1) {
                    double distancia = 0;
                    for (int i = 0; i < arrayList.size() - 2; i++) {
                        distancia += arrayList.get(i).distancia(arrayList.get(i + 1));
                    }
                    if (Rfinal.getDistancia() > distancia) {
                        Rfinal = new Resultado(distancia, arrayList);
                    }
                } else {
                    for (int i = indice; i < arrayList.size(); i++) {
                        intercambiarElementos(arrayList, indice, i);
                        Rfinal = recorrerConPermutacionesI(arrayList, indice + 1, Rfinal);
                        intercambiarElementos(arrayList, indice, i); 
                    }
                }
                
            } else {
                throw new Exception();
            }
        } catch (Exception ex) {
            System.out.println("Introduce un archivo que contenga 10 puntos o menos");
        }
        return Rfinal;
    }

    private static void intercambiarElementos(ArrayList<Punto> arrayList, int i, int j) {
        Punto temp = arrayList.get(i);
        arrayList.set(i, arrayList.get(j));
        arrayList.set(j, temp);
    }

}
