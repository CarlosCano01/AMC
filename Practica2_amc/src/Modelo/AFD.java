/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author carlo
 */
public class AFD implements IProceso {

    private Set<String> estados, finales;
    private Set<Character> simbolos;
    private String inicial;
    private Map<String, String> transiciones;
    private String pasoapaso="";

    /**
     * Constructor de la clase {@code AFD}.
     * Inicializa los conjuntos y mapas necesarios para representar un AFD.
     */
    
    public AFD() {
        this.inicial = null;
        this.transiciones = new HashMap<>();
        this.estados = new HashSet<>();
        this.finales = new HashSet<>();
        this.simbolos = new HashSet<>();

    }

    public void setInicial(String inicial) {
        this.inicial = inicial;
    }

    public Set<String> getEstados() {
        return estados;
    }

    public Set<String> getFinales() {
        return finales;
    }

    public Set<Character> getSimbolos() {
        return simbolos;
    }

    public String getInicial() {
        return inicial;
    }

    /**
     * Agrega un conjunto de estados al autómata.
     *
     * @param estados Conjunto de estados a agregar.
     */
    public void addEstados(String[] estados) {
        this.estados.addAll(Arrays.asList(estados));
    }

    /**
     * Agrega un conjunto de estados finales al autómata.
     *
     * @param estados Conjunto de estados finales a agregar.
     */
    public void addfinales(String[] estados) {
        finales.addAll(Arrays.asList(estados));
    }

    /**
     * Agrega una transición al autómata.
     *
     * @param partida Estado de partida de la transición.
     * @param simbolo Símbolo de transición.
     * @param resultado Estado resultado de la transición.
     */
    public void addTransicion(String partida, char simbolo, String resultado) {
        transiciones.put(formarCondicion(partida, simbolo), resultado);
        if (!simbolos.contains(simbolo)) {
            simbolos.add(simbolo);
        }
    }

    /**
     * Método que valida la estructura del autómata, verificando que esté
     * correctamente definido.
     *
     * @throws Exception Si el autómata no está correctamente definido.
     */
    public void validar() throws Exception {
        if (estados.isEmpty()) {
            throw new Exception("No se han definido estados");
        }
        if (inicial == null) {
            throw new Exception("Estado inicial no definido");
        }
        if (!estados.contains(inicial)) {
            throw new Exception("El estado inicial no está incluido en la lista de estados");
        }
        if (finales.isEmpty()) {
            throw new Exception("No se han definido estados finales");
        }
        if (!estados.containsAll(finales)) {
            throw new Exception("Los estaos finales no está incluido en la lista de estados");
        }
        if (simbolos.isEmpty()) {
            throw new Exception("No se han definido simbolos");
        }
        for (Map.Entry<String, String> transicion : transiciones.entrySet()) {
            String[] key = transicion.getKey().split("-");
            String value = transicion.getValue();
            if (!estados.contains(key[0])) {
                throw new Exception("Estado de partida de transicción no está incluido en la lista de estados");
            }
            if (key[1].length() != 1) {
                throw new Exception("Simbolo no es un solo caracter");
            } else if (!simbolos.contains(key[1].charAt(0))) {
                throw new Exception("Simbolo de transicción no está incluido en la lista de simbolos");
            }
            if (!estados.contains(value)) {
                throw new Exception("Estado resultado de transicción no está incluido en la lista de estados");
            }
        }
    }

    /**
     *
     * @param cadena
     * @return
     * @throws Exception
     */
    @Override
    public boolean reconocer(String cadena) throws Exception {
        char[] simbol = cadena.toCharArray();
        String estado = inicial;
        pasoapaso="";
        introducirNuevoPaso("Estado Inicial    Simbolo       Estado Final");
        for (char simbolo : simbol) {
            if (!this.simbolos.contains(simbolo)) {
                throw new Exception("Simbolo en cadena no reconocido");
            }
            String principio=estado;
            estado = this.transiciones.get(formarCondicion(estado, simbolo));
            if (estado == null) {
                introducirNuevoPaso("\n"+principio+"\t"+ simbolo +"\testado muerto");
                return false;
                
            }
            introducirNuevoPaso("\n"+principio+"\t"+ simbolo +"\t"+ estado);
            

        }

        return finales.contains(estado);
    }
    
    private void introducirNuevoPaso(String NuevoPaso){
        pasoapaso+=NuevoPaso;
    }
    @Override
    public String PasoaPaso(){
        return pasoapaso;
    }
    /**
     * Representación en cadena del autómata.
     *
     * @return Una representación en cadena del autómata.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ESTADOS: ").append(estados.toString()).append("\n")
                .append("INICIAL: ").append(inicial).append("\n")
                .append("FINALES: ").append(finales).append("\n")
                .append("TRANSICIONES: ").append("\n");
        for (Map.Entry<String, String> transicion : transiciones.entrySet()) {
            String[] key = transicion.getKey().split("-");
            String value = transicion.getValue();
            sb.append("\t").append(key[0]).append(" '").append(key[1]).append("' ").append(value).append("\n");
        }
        sb.append("FIN");
        return sb.toString();
    }

    /**
     * Forma la condición de transición combinando el estado de partida y el
     * símbolo.
     *
     * @param partida Estado de partida de la transición.
     * @param simbolo Símbolo de transición.
     * @return Condición de transición formada.
     */
    public static String formarCondicion(String partida, char simbolo) {
        return new StringBuilder().append(partida).append('-').append(simbolo).toString();
    }

    @Override
    public boolean esFinal(int estado) {
        return finales.contains(estado);
    }
}
