/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1.Modelo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumnop
 */
public class JugadorParticipando extends Thread {

    private Jugador j;
    private Bombo b;

    public JugadorParticipando(Jugador j, Bombo b) {
        this.j = j;
        this.b = b;
    }

    public void run() {
        System.out.println("Intentando " + j.getId() + " acceder al bombo");
        while (!j.isHaGanado() && !b.isCondicionVictoriaCumplida()) {
            try {
                b.accederAlBombo(j);
            } catch (InterruptedException ex) {
                Logger.getLogger(JugadorParticipando.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                b.jugadorMeteLaManoEnElBombo(j);
                b.dejarLibreBombo(j);
            } catch (InterruptedException ex) {
                Logger.getLogger(JugadorParticipando.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println(j.toString());
    }

}
