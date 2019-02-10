/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cliente;
import modelo.HiloCliente;
import modelo.Servidor;

/**
 *
 * @author zapia
 */
public class MainHilo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Servidor server = new Servidor("servidor1");
        for (int i = 0; i < 3; i++) {
            Cliente cliente = new Cliente("cliente"+i);

            new HiloCliente(cliente, server).start();
            
                int tiempoEspera = (int) (Math.random() * 1000) + 1000;
            try {
                Thread.sleep(tiempoEspera);
            } catch (InterruptedException ex) {
                Logger.getLogger(MainHilo.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    
}
