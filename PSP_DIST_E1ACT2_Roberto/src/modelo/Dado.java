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
public class Dado {

    private int cara;
    private String id;

    public Dado(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCara() {
        return cara;
    }

    public int lanzarDado() {
        cara = (int) (Math.random() * 5 + 1);
        return cara;
    }

}
