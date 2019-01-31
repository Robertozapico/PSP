/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2.logica;

import Ejercicio2.modelo.Jugador;
import Ejercicio2.modelo.JugadoresJuego;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CyclicBarrier;

/**
 *
 * @author alumnop
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Jugador> listaJugadores = new ArrayList<>();
        int diferencia;
        Scanner miTeclado = new Scanner(System.in);

        System.out.println("¿Cuantos jugadores van a competir?");
        int numJugadoresCompiten = miTeclado.nextInt();
        CyclicBarrier cantidadJugadores = new CyclicBarrier(numJugadoresCompiten);
        //Se crean los camellos
        for (int i = 0; i < numJugadoresCompiten; i++) {
            Jugador jugador = new Jugador("j"+i);
            JugadoresJuego jugadoresjuego = new JugadoresJuego(jugador, cantidadJugadores, listaJugadores);
            jugadoresjuego.start();
        }
        try {
            //sin el sleep salta error
            Thread.sleep(500);
            for (Jugador jugador : listaJugadores) {
                for (Jugador jugador2 : listaJugadores) {
                    if(jugador.getNumeroAlcanzado()<jugador2.getNumeroAlcanzado()){
                        jugador.setVictoria(true);
                        jugador2.setVictoria(false);
                    }else{
                        jugador.setVictoria(false);
                        jugador.setVictoria(true);
                    }
                        
                }
            }
            //System.out.println("Ha ganado " + listadoDeCamellos.get(0).getId());
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
