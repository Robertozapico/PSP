/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CyclicBarrier;
import modelo.Camello;
import modelo.Dado;
import modelo.HiloCamello;

/**
 *
 * @author zapia
 */
public class Carrera {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Camello> listadoDeCamellos = new ArrayList<>();
        Scanner miTeclado = new Scanner(System.in);

        System.out.println("¿Cuantos camellos van a competir?");
        int numCamellosCompiten = miTeclado.nextInt();
        CyclicBarrier cantidadCamellos = new CyclicBarrier(numCamellosCompiten);
        //Se crean los camellos
        for (int i = 0; i < numCamellosCompiten; i++) {
            Dado dado = new Dado("d" + i);
            Camello camello = new Camello("c" + i, dado);
            HiloCamello hiloCamello = new HiloCamello(camello, cantidadCamellos, listadoDeCamellos);
            hiloCamello.start();
        }
        try {
            //sin el sleep salta error
            Thread.sleep(500);
            System.out.println("Todos los camellos han alcanzado la meta");
            System.out.println("Ha ganado " + listadoDeCamellos.get(0).getId());
            listadoDeCamellos.get(0).setGanador(true);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
