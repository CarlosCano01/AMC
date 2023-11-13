package Algoritmos;

import java.util.ArrayList;
import java.util.Collections;
import practica1_amc.LecturaEscritura;
import practica1_amc.Punto;
import practica1_amc.Resultado;

public class AlgoritmosVoraces {

    public static Resultado Unidireccional(ArrayList<Punto> nodos, String archivo) {
        ArrayList<Punto> nodoNoVisitados = new ArrayList<>(nodos);
        ArrayList<Punto> ruta = new ArrayList<>();

        Punto puntoActual = nodoNoVisitados.get(0);
        ruta.add(puntoActual);
        nodoNoVisitados.remove(0);

        while (!nodoNoVisitados.isEmpty()) {
            Punto nodoMasCercano = null;
            double distanciaMinima = Double.MAX_VALUE;

            for (Punto nodo : nodoNoVisitados) {
                double distancia = puntoActual.distancia(nodo);
                if (distancia < distanciaMinima) {                  //Esto se puede mejorar haciendo poda
                    distanciaMinima = distancia;
                    nodoMasCercano = nodo;
                }
            }

            ruta.add(nodoMasCercano);
            nodoNoVisitados.remove(nodoMasCercano);
            puntoActual = nodoMasCercano;
        }

        double distancia = 0;
        for (int i = 0; i < ruta.size() - 1; i++) {
            distancia += ruta.get(i).distancia(ruta.get(i + 1));
        }
        distancia += ruta.get(ruta.size() - 1).distancia(ruta.get(0));

        Resultado resultados = new Resultado(distancia, ruta);

        if (archivo != null && archivo != "Test") {
            LecturaEscritura.crearArchivoTSPvoraz(ruta, resultados.getDistancia(), "uni_" + archivo + ".tour");
        }

        return resultados;
    }

    public static Resultado Bidireccional(ArrayList<Punto> nodos, String archivo) {
        ArrayList<Punto> nodosNoVisitados = new ArrayList<>(nodos);
        ArrayList<Punto> ladoIzquierdo = new ArrayList<>();
        ArrayList<Punto> ladoDerecho = new ArrayList<>();

        Punto puntoIzquierdo = nodosNoVisitados.get(0);
        ladoIzquierdo.add(puntoIzquierdo);
        nodosNoVisitados.remove(0);

        Punto puntoDerecho = nodosNoVisitados.get(0);
        ladoDerecho.add(puntoDerecho);
        nodosNoVisitados.remove(0);

        while (!nodosNoVisitados.isEmpty()) {

            Punto puntoMasCercanoIzquierdo = null;
            double distanciaMinimaIzquierda = Double.MAX_VALUE;

            Punto puntoMasCercanoDerecho = null;
            double distanciaMinimaDerecha = Double.MAX_VALUE;

            for (Punto nodo : nodosNoVisitados) {
                double distanciaIzquierda = puntoIzquierdo.distancia(nodo);
                if (distanciaIzquierda < distanciaMinimaIzquierda) {
                    distanciaMinimaIzquierda = distanciaIzquierda;
                    puntoMasCercanoIzquierdo = nodo;
                }

                double distanciaDerecha = puntoDerecho.distancia(nodo);
                if (distanciaDerecha < distanciaMinimaDerecha) {
                    distanciaMinimaDerecha = distanciaDerecha;
                    puntoMasCercanoDerecho = nodo;
                }
            }

            if (distanciaMinimaIzquierda <= distanciaMinimaDerecha) {
                ladoIzquierdo.add(puntoMasCercanoIzquierdo);
                nodosNoVisitados.remove(puntoMasCercanoIzquierdo);
                puntoIzquierdo = puntoMasCercanoIzquierdo;
            } else {
                ladoDerecho.add(puntoMasCercanoDerecho);
                nodosNoVisitados.remove(puntoMasCercanoDerecho);
                puntoDerecho = puntoMasCercanoDerecho;
            }
        }

        ArrayList<Punto> rutaBidireccional = new ArrayList<>(ladoIzquierdo);
        Collections.reverse(ladoDerecho);
        rutaBidireccional.addAll(ladoDerecho);

        double distanciaRecorrida = 0;
        for (int i = 0; i < rutaBidireccional.size() - 1; i++) {
            distanciaRecorrida += rutaBidireccional.get(i).distancia(rutaBidireccional.get(i + 1));
        }
        distanciaRecorrida += rutaBidireccional.get(rutaBidireccional.size() - 1).distancia(rutaBidireccional.get(0));

        Resultado resultados = new Resultado(distanciaRecorrida, rutaBidireccional);

        if (archivo != null && archivo != "Test") {
            LecturaEscritura.crearArchivoTSPvoraz(rutaBidireccional, resultados.getDistancia(), "bi_" + archivo + ".tour");
        }

        return resultados;
    }
}
