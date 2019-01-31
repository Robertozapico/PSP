/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1.Modelo;

import static java.lang.Math.random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author alumnop
 */
public class Bombo {

    //private String ordenJugadoresHanAccedidoAlBombo = "";
    //private String sentidoCochesPuente = null;
    private int numGanador = 0;
    private int numerosPosibles;
    private int numeroJugadores;
    private Semaphore semaforoBombo;
    private boolean condicionVictoriaCumplida;
    private Jugador jugadorGanador;
    private int numerosSacadosDelBombo;

    public Bombo(int numerosPosibles, int numeroJugadores) {
        this.numerosPosibles = numerosPosibles;
        this.numeroJugadores = numeroJugadores;
        //creamos el número de permits = número de jugadores que pueden acceder al bombo a la vez
        semaforoBombo = new Semaphore(1);
        //System.out.println(this.toString());

        if (semaforoBombo.availablePermits() == 1) {
            System.out.println("------- Se puede acceder al bombo ------");
        }

    }

    public boolean isCondicionVictoriaCumplida() {
        return condicionVictoriaCumplida;
    }

    public Jugador getJugadorGanador() {
        return jugadorGanador;
    }

    public synchronized void accederAlBombo(Jugador j) throws InterruptedException {
        System.out.println("++++ El jugador " + j.getId() + " intenta acceder al bombo ");

        //visualizo situacion del bombo
        System.out.println(this.toString());

        //intenta pillar un permit
        semaforoBombo.acquire(1);

        if (semaforoBombo.availablePermits() == 0) {
            System.out.println("Bombo ocupado");
        } else if (condicionVictoriaCumplida) {
            System.out.println("El juego ha terminado");
        } else {
            j.setHaAccedidoAlBombo(true);
        }
        Thread.yield();
        Thread.sleep(100);
    }

    public void jugadorMeteLaManoEnElBombo(Jugador j) throws InterruptedException {
        //---------------- TIEMPO EN CRUZAR EL PUENTE ---------
        if (!condicionVictoriaCumplida) {
            Thread.sleep((long) (random() * 500));
            int numeroSacado = (int) ((Math.random()) * numerosPosibles);
            numerosSacadosDelBombo++;
            j.setNumeroSacado(numeroSacado);
            //System.out.println(this.toString());
            j.setNumeroIntentos(j.getNumeroIntentos() + 1);
            System.out.println("Jugador " + j.getId() + " ha sacado " + j.getNumeroSacado());
            if (j.getNumeroSacado() == 0) {
                condicionVictoriaCumplida = true;
                this.jugadorGanador = j;
                j.setHaGanado(true);
                System.out.println("El jugador " + j.getId() + " ha ganado, ha necesitado " + j.getNumeroIntentos() + " intentos");
                System.out.println("Se han sacado un total de "+numerosSacadosDelBombo);
            }
        }
        //una vez cruzado soltamos el permit para que lo intente otro
        semaforoBombo.release(1);
        Thread.yield();

    }

    public void dejarLibreBombo(Jugador j) {
        j.setHaAccedidoAlBombo(false);
        System.out.println("**************" + j.getId() + " deja libre el bombo y ha sacado " + j.getNumeroSacado());

    }

    @Override
    public String toString() {
        return "Bombo{" + "numGanador=" + numGanador + ", numerosPosibles=" + numerosPosibles + ", numeroJugadores=" + numeroJugadores + ", semaforoBombo=" + semaforoBombo + ", condicionVictoriaCumplida=" + condicionVictoriaCumplida + ", jugadorGanador=" + jugadorGanador + ", numerosSacadosDelBombo=" + numerosSacadosDelBombo + '}';
    }

}
