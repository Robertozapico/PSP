/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2.modelo;

import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumnop
 */
public class JugadoresJuego extends Thread {

    private CyclicBarrier cantidadDeJugadores;
    private Jugador jugador;
    List <Jugador> listaJugadores;
    
    public JugadoresJuego(Jugador jugador, CyclicBarrier cantidadDeJugadores, List<Jugador> listaJugadores) {
        this.cantidadDeJugadores = cantidadDeJugadores;
        this.jugador = jugador;
        Dado dado = new Dado();
        jugador.setDado(dado);
        this.listaJugadores=listaJugadores;
        this.listaJugadores.add(jugador);
        
    }

    @Override
    public void run() {

        try {
            System.out.println("Jugador " + jugador.getNombre() + " esperando a todos los jugadores"); //freno la ejecución del hilo
            cantidadDeJugadores.await(); //cuando se generen los x hilos se ejecutan

            do {

                if (jugador.getNumeroAlcanzado() <= 50) {
                    int tirada = jugador.getDado().lanzarDado();
                    System.out.println("Jugador " + jugador.getNombre() + ", saca " + tirada);
                    jugador.setNumeroAlcanzado(tirada+jugador.getNumeroAlcanzado());
                    //System.out.println(jugador.getNumeroAlcanzado());
                } else {
                    System.out.println("ACABE: " + jugador.getNombre() + " puntuacion " + jugador.getNumeroAlcanzado());
                }
            } while (jugador.getNumeroAlcanzado() < 50);
        } catch (InterruptedException ex) {
            Logger.getLogger(JugadoresJuego.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BrokenBarrierException ex) {
            Logger.getLogger(JugadoresJuego.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
