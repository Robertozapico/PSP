/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1.Logica;

import Ejercicio1.Modelo.Bombo;
import Ejercicio1.Modelo.Jugador;
import Ejercicio1.Modelo.JugadorParticipando;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author alumnop
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //List<Jugador> listaJugadores = new ArrayList<>();
        Scanner miTeclado = new Scanner(System.in);
        Bombo b;
        System.out.println("Introduzca numero máximo de jugadores:");
        int numMaxJugadores = miTeclado.nextInt();

        System.out.println("Introduzca la cantidad de numeros");
        int cantidadNumeros = miTeclado.nextInt();
        b = new Bombo(cantidadNumeros, numMaxJugadores);
        System.out.println(b.toString());
        for (int i = 0; i < numMaxJugadores; i++) {
            Jugador j = new Jugador("j" + i);
            System.out.println("CREANDO " + j.toString());
            (new JugadorParticipando(j, b)).start();
            //listaJugadores.add(j);
        }
        /*System.out.println("_/_/_/_/_/_/_/_/_/_/_/_/_/_/");
        System.out.println("LISTADO DE JUGADORES");
        System.out.println("_/_/_/_/_/_/_/_/_/_/_/_/_/_/");
        for (Jugador jugador : listaJugadores) {
            System.out.println(jugador.toString());
        }*/
    }

}
