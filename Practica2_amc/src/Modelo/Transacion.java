/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class Transacion{

    String EstadoInicial;
    ArrayList<String> EstadoFinal;
    char Simbolo;

    public Transacion(String EstadoInicial,ArrayList<String> EstadoFinal, char Simbolo) {
        this.EstadoInicial = EstadoInicial;
        this.EstadoFinal = EstadoFinal;
        this.Simbolo = Simbolo;
    }
    

    public String getEstadoInicial() {
        return EstadoInicial;
    }


    public ArrayList<String> getEstadoFinal() {
        return EstadoFinal;
    }

    public char getSimbolo() {
        return Simbolo;
    }
    
}
