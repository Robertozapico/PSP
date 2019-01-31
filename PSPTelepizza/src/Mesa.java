/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumnop
 */
public class Mesa extends Thread {

    private Pizza pizza;
    private Silla silla;

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Silla getSilla() {
        return silla;
    }

    public void setSilla(Silla silla) {
        this.silla = silla;
    }

    public synchronized void sentarse(Amigo persona) {

    }

    public synchronized void levantarse(Amigo persona) {

    }

    public synchronized void tiempoComer() {

    }

}
