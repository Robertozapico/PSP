/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import modelo.Cliente;
import modelo.HiloCliente;

/**
 *
 * @author zapia
 */
public class MainHilo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            new HiloCliente(new Cliente()).start();

        }
        /*
        Cliente cliente = new Cliente("cliente");

        new HiloCliente(cliente).start();
         */

    }

}
