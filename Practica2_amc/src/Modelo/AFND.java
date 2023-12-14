/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

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
public class AFND {

    private Set<String> estados, finales, iniciales;
    private Set<Character> simbolos;
    private Map<String, String[]> transiciones;

    public AFND() {
        estados = new HashSet<>();
        finales = new HashSet<>();
        simbolos = new HashSet<>();
        iniciales = new HashSet<>();
        transiciones = new HashMap<>();
    }

    public void setiniciales(Set<String> iniciales) {
        this.iniciales = iniciales;
    }

    public Set<String> getEstados() {
        return estados;
    }

    public Set<String> getfinales() {
        return finales;
    }

    public Set<String> getiniciales() {
        return iniciales;
    }

    public Set<Character> getSimbolos() {
        return simbolos;
    }

    public Map<String, String[]> getTransiciones() {
        return transiciones;
    }

    public boolean esFinal(int estado) {
        return false;
    }

    public void lambdaClausura(String estado, Set<String> nuevos) {
        String[] resultados = transiciones.get(estado);
        if (resultados != null) {
            for (String resultado : resultados) {
                if (!nuevos.contains(resultado)) {
                    nuevos.add(resultado);
                    lambdaClausura(resultado, nuevos);
                }
            }
        }
    }

    public static String formarCondicion(String partida, Character simbolo) {
        return simbolo == null ? partida : new StringBuilder().append(partida).append('-').append(simbolo).toString();
    }

    public boolean reconocer(String cadena) throws Exception {
        char[] simbol = cadena.toCharArray();
        if (estados.isEmpty()) {
            throw new Exception("No se han definido estados");
        }
        if (iniciales.isEmpty()) {
            throw new Exception("Estados iniciales no definido");
        }
        if (!estados.containsAll(iniciales)) {
            throw new Exception("Los estados iniciales no está incluido en la lista de estados");
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
        for (Map.Entry<String, String[]> transicion : transiciones.entrySet()) {
            String[] value = transicion.getValue();
            if (!estados.containsAll(Arrays.asList(value))) {
                throw new Exception("Estados resultado de transicción no está incluido en la lista de estados");
            }
            if (transicion.getKey().contains("-")) {
                String[] key = transicion.getKey().split("-");
                if (!estados.contains(key[0])) {
                    throw new Exception("Estado de partida de transicción no está incluido en la lista de estados");
                }
                if (key[1].length() != 1) {
                    throw new Exception("Simbolo no es un solo caracter");
                } else if (!simbolos.contains(key[1].charAt(0))) {
                    throw new Exception("Simbolo de transicción no está incluido en la lista de simbolos");
                }
            } else {
                String key = transicion.getKey();
                if (!estados.contains(key)) {
                    throw new Exception("Estado de partida de transicción no está incluido en la lista de estados");
                }
            }
        }
        Set<String> macroestado = new HashSet<>(iniciales);
        Set<String> nuevos = new HashSet<>();
        for (char simbolo : simbol) {
            for (String estado : macroestado) {
                lambdaClausura(estado, nuevos);
            }
            macroestado.addAll(nuevos);

            nuevos.clear();
            for (String estado : macroestado) {
                String[] siguientes = transiciones.get(formarCondicion(estado, simbolo));
                if (siguientes != null) {
                    nuevos.addAll(Arrays.asList(siguientes));
                }
            }
            macroestado.clear();
            macroestado.addAll(nuevos);
            nuevos.clear();

            if (macroestado.isEmpty()) {
                throw new Exception("El macroestado se ha quedado vacio");
            }
        }
        return finales.containsAll(macroestado);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ESTADOS: ").append(estados.toString()).append("\n")
                .append("INICIAL: ").append(iniciales).append("\n")
                .append("FINALES: ").append(finales).append("\n")
                .append("TRANSICIONES: ").append("\n");
        for (Map.Entry<String, String[]> transicion : transiciones.entrySet()) {
            String[] value = transicion.getValue();
            if (transicion.getKey().contains("-")) {
                String[] key = transicion.getKey().split("-");
                sb.append("\t").append(key[0]).append(" '").append(key[1]).append("' ");
            } else {
                String key = transicion.getKey();
                sb.append("\t").append(key).append(" -> ");
            }
            sb.append(Arrays.asList(value)).append("\n");
        }
        sb.append("FIN");
        return sb.toString();
    }
}
