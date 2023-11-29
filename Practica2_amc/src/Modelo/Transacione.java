/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author carlo
 */
public class Transacione implements ITransacion{

    @Override
    public String getEstadoInicial() {
        return"1";
    }

    @Override
    public String getEstadoFinal() {
        return"1";
    }

    @Override
    public char getSimbolo() {
        return 'c';
    }
    
}
