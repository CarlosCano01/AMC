package Algoritmos;

import java.util.ArrayList;
import java.util.Collections;
import practica1_amc.LecturaEscritura;
import practica1_amc.Punto;
import practica1_amc.Resultado;

public class AlgoritmosVoraces {

    public static Resultado Unidireccional(ArrayList<Punto> nodos, String nombreFichero) {
        ArrayList<Punto> nodoNoVisitados = new ArrayList<>(nodos);
        ArrayList<Punto> ruta = new ArrayList<>();
        
        //Seleccionamos la primera nodo
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

        // Calcular la distancia total del recorrido
        double distancia = 0;
        for (int i = 0; i < ruta.size() - 1; i++) {
            distancia += ruta.get(i).distancia(ruta.get(i + 1));
        }
        distancia += ruta.get(ruta.size() - 1).distancia(ruta.get(0)); // Volver al punto de inicio

        Resultado resultados = new Resultado(distancia,ruta);

        
        // Generar el archivo de solución
        if (nombreFichero != null) {
            LecturaEscritura.crearArchivoTSPuni(ruta, resultados.getDistancia(), nombreFichero + ".tour");
        }
    
        
        return resultados;
    }

        public Resultado busquedaVorazBidireccional(ArrayList<Punto> ciudades, String nombreFichero) {
        ArrayList<Punto> ciudadesNoVisitadas = new ArrayList<>(ciudades);
        ArrayList<Punto> caminoIzquierdo = new ArrayList<>();
        ArrayList<Punto> caminoDerecho = new ArrayList<>();

        // Punto de partida en el extremo izquierdo
        Punto puntoIzquierdo = ciudadesNoVisitadas.get(0);
        caminoIzquierdo.add(puntoIzquierdo);
        ciudadesNoVisitadas.remove(0);

        // Punto de partida en el extremo derecho
        Punto puntoDerecho = ciudadesNoVisitadas.get(0);
        caminoDerecho.add(puntoDerecho);
        ciudadesNoVisitadas.remove(0);

        while (!ciudadesNoVisitadas.isEmpty()) {
            // Extremo izquierdo
            Punto puntoMasCercanoIzquierdo = null;
            double distanciaMinimaIzquierda = Double.MAX_VALUE;

            // Extremo derecho
            Punto puntoMasCercanoDerecho = null;
            double distanciaMinimaDerecha = Double.MAX_VALUE;

            for (Punto ciudad : ciudadesNoVisitadas) {
                double distanciaIzquierda = puntoIzquierdo.distancia(ciudad);
                if (distanciaIzquierda < distanciaMinimaIzquierda) {
                    distanciaMinimaIzquierda = distanciaIzquierda;
                    puntoMasCercanoIzquierdo = ciudad;
                }

                double distanciaDerecha = puntoDerecho.distancia(ciudad);
                if (distanciaDerecha < distanciaMinimaDerecha) {
                    distanciaMinimaDerecha = distanciaDerecha;
                    puntoMasCercanoDerecho = ciudad;
                }
            }

            if (distanciaMinimaIzquierda <= distanciaMinimaDerecha) {
                caminoIzquierdo.add(puntoMasCercanoIzquierdo);
                ciudadesNoVisitadas.remove(puntoMasCercanoIzquierdo);
                puntoIzquierdo = puntoMasCercanoIzquierdo;
            } else {
                caminoDerecho.add(puntoMasCercanoDerecho);
                ciudadesNoVisitadas.remove(puntoMasCercanoDerecho);
                puntoDerecho = puntoMasCercanoDerecho;
            }
        }

        // Fusionar los caminos izquierdo y derecho en un camino bidireccional
        ArrayList<Punto> caminoBidireccional = new ArrayList<>(caminoIzquierdo);
        Collections.reverse(caminoDerecho);
        caminoBidireccional.addAll(caminoDerecho);

        // Calcular la distancia total del recorrido
        double distanciaRecorrida = 0;
        for (int i = 0; i < caminoBidireccional.size() - 1; i++) {
            distanciaRecorrida += caminoBidireccional.get(i).distancia(caminoBidireccional.get(i + 1));
        }
        distanciaRecorrida += caminoBidireccional.get(caminoBidireccional.size() - 1).distancia(caminoBidireccional.get(0)); // Volver al punto de inicio

        Resultado resultados = new Resultado(distanciaRecorrida,caminoBidireccional);

        // Generar el archivo de solución
        if (nombreFichero != null) {
            LecturaEscritura.crearArchivoTSPbi(caminoBidireccional, resultados.getDistancia(), nombreFichero + ".tour");
        }
        

        return resultados;
    }
}
