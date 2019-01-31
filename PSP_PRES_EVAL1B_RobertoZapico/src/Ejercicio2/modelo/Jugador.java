/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2.modelo;

/**
 *
 * @author alumnop
 */
public class Jugador {

    private String nombre;
    private int edad;
    private boolean victoria;
    private Dado dado;
    private int numeroAlcanzado=0;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isVictoria() {
        return victoria;
    }

    public void setVictoria(boolean victoria) {
        this.victoria = victoria;
    }

    public Dado getDado() {
        return dado;
    }

    public void setDado(Dado dado) {
        this.dado = dado;
    }

    public int getNumeroAlcanzado() {
        return numeroAlcanzado;
    }

    public void setNumeroAlcanzado(int numeroAlcanzado) {
        this.numeroAlcanzado = numeroAlcanzado;
    }

    public int hacerJugada() {
        int numeroSacado = dado.lanzarDado();
        //numeroAlcanzado = numeroAlcanzado+numeroSacado;
        System.out.println("Ha sacado " + numeroSacado);
        return numeroAlcanzado;
    }
}
