/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author zapia
 */
public class Camello {

    private String id;
    private Dado dado;
    private boolean ganador;
    private int posicionesAvanzadas = 0;

    public Camello(String id, Dado dado) {
        this.id = id;
        this.dado = dado;
    }

    public boolean isGanador() {
        return ganador;
    }

    public void setGanador(boolean ganador) {
        this.ganador = ganador;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPosicionesAvanzadas() {
        return posicionesAvanzadas;
    }

    public void setPosicionesAvanzadas(int posicionesAvanzadas) {
        this.posicionesAvanzadas = posicionesAvanzadas;
    }

    public Dado getDado() {
        return dado;
    }

    public void setDado(Dado Dado) {
        this.dado = Dado;
    }

    public int avanzar() {
        posicionesAvanzadas += dado.lanzarDado();
        return posicionesAvanzadas;
    }

    @Override
    public String toString() {
        return "Camello{" + "id=" + id + ", dado=" + dado.getId() + ", ganador=" + ganador + ", posicionesAvanzadas=" + posicionesAvanzadas + '}';
    }



}
