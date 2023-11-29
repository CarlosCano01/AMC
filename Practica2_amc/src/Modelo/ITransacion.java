/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo;

/**
 *
 * @author carlo
 */
public interface ITransacion {
    /**
     * Devuelve el código del estado inicial.
     * @return String con el código del estado inicial.
     */
    String getEstadoInicial();

    /**
     * Devuelve el código del estado final.
     * @return String con el código del estado final.
     */
    String getEstadoFinal();

    /**
     * Devuelve el carácter (símbolo) que produce la transición.
     * @return Char con el carácter que produce la transición.
     */
    char getSimbolo();
}
