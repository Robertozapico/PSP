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
public class HiloCliente extends Thread {

    private Cliente cliente;
    private Servidor servidor;

    public HiloCliente(Cliente cliente, Servidor servidor) {
        this.cliente = cliente;
        this.servidor = servidor;
    }

    @Override
    public void run() {
        do{
        try {
            servidor.enviarNumero(cliente);
            cliente.recibirPaquete();
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        }while(servidor.getListaNumeros().size()>0);
        if(servidor.getListaNumeros().size()==0){
            System.out.println("No quedan más números");
            System.out.println("Cantidad de números recogidos: " +cliente.getListaNumeros().size());
            System.out.println("Números recogidos: " +cliente.getListaNumeros());
        }
    }
}
