/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author nacho
 */
public class AFND implements IProceso {

    private Set<String> estados, finales;
    private String inicial;
    private Set<Character> simbolos;
    private Map<String, String[]> transiciones;

    public AFND() {
        estados = new HashSet<>();
        finales = new HashSet<>();
        simbolos = new HashSet<>();
        inicial = null;
        transiciones = new HashMap<>();
    }

    public void setinicial(String inicial) {
        this.inicial = inicial;
    }

    public Set<String> getEstados() {
        return estados;
    }

    public Set<String> getfinales() {
        return finales;
    }

    public String getinicial() {
        return inicial;
    }

    public Set<Character> getSimbolos() {
        return simbolos;
    }

    public Map<String, String[]> getTransiciones() {
        return transiciones;
    }

    @Override
    public boolean esFinal(int estado) {
        return finales.contains(estado);
    }

    public void setInicial(String inicial) {
        this.inicial = inicial;
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
     * Agrega un conjunto de estados al autómata.
     *
     * @param estados Conjunto de estados a agregar.
     */
    public void addEstados(String[] estados) {
        this.estados.addAll(Arrays.asList(estados));
    }
    
    public void addTransicion(String partida, Character simbolo, String resultado) {
        
        if(transiciones.get(formarCondicion(partida, simbolo))!=null){
            String[] valoresActuales = transiciones.get(formarCondicion(partida, simbolo));


            String[] nuevosValores = new String[valoresActuales.length + 1];
            System.arraycopy(valoresActuales, 0, nuevosValores, 0, valoresActuales.length);
            nuevosValores[nuevosValores.length - 1] = resultado;


            transiciones.put(formarCondicion(partida, simbolo), nuevosValores);
        }else{
            String[] valoresActuales = new String[]{resultado};
            transiciones.put(formarCondicion(partida, simbolo), valoresActuales);
        }
        if (!simbolos.contains(simbolo)) {
            simbolos.add(simbolo);
        }
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

        /**
     * Método que valida la estructura del autómata, verificando que esté correctamente definido.
     *
     * @throws Exception Si el autómata no está correctamente definido.
     */
    public void validar() throws Exception {
        if (estados.isEmpty()) {
            throw new Exception("No se han definido estados");
        }
        if (inicial.isEmpty()) {
            throw new Exception("Estados iniciales no definido");
        }
        if (!estados.contains(inicial)) {
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

        Set<String> macroestado = new HashSet<>();
        macroestado.add(inicial);
        Set<String> nuevos = new HashSet<>();
        for (char simbolo : simbol) {
            if (!this.simbolos.contains(simbolo)) {
                throw new Exception("Simbolo en cadena no reconocido");
            }
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
                .append("INICIAL: ").append(inicial).append("\n")
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
