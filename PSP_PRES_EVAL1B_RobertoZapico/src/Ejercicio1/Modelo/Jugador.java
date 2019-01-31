/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1.Modelo;

/**
 *
 * @author alumnop
 */
public class Jugador {

    private String id;
    private boolean haAccedidoAlBombo;
    private int numeroSacado;
    private boolean haGanado;
    private int numeroIntentos;

    public Jugador(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isHaAccedidoAlBombo() {
        return haAccedidoAlBombo;
    }

    public void setHaAccedidoAlBombo(boolean haAccedidoAlBombo) {
        this.haAccedidoAlBombo = haAccedidoAlBombo;
    }

    public int getNumeroSacado() {
        return numeroSacado;
    }

    public void setNumeroSacado(int numeroSacado) {
        this.numeroSacado = numeroSacado;
    }

    public boolean isHaGanado() {
        return haGanado;
    }

    public void setHaGanado(boolean haGanado) {
        this.haGanado = haGanado;
    }

    public int getNumeroIntentos() {
        return numeroIntentos;
    }

    public void setNumeroIntentos(int numeroIntentos) {
        this.numeroIntentos = numeroIntentos;
    }

    @Override
    public String toString() {
        return "Jugador{" + "id=" + id + ", haGanado=" + haGanado + ", numeroIntentos=" + numeroIntentos + '}';
    }

}
