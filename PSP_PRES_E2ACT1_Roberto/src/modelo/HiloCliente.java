/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumnop
 */
public class HiloCliente extends Thread{
    private Cliente cliente;
    private Servidor servidor;

    public HiloCliente(Cliente cliente, Servidor servidor) {
        this.cliente = cliente;
        this.servidor = servidor;
    }

    @Override
    public void run() {
        
    }
/*
    public synchronized void tiempoComer() throws InterruptedException {
        if (barra.isHuecoOcupado() == true) {
            int tiempo = (int) (Math.random() * 1000) + 1000;
            sleep(tiempo);
        }
    }*/
}
