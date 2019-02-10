/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author alumnop
 */
public class HiloCliente extends Thread {

    private Cliente cliente;
    private Servidor servidor;

    public HiloCliente(Cliente cliente/*, Servidor */) {
        this.cliente = cliente;
        //this.servidor = servidor;
    }

    @Override
    public synchronized void run() {
        int numeroServidor = 0;
        do {
            System.out.println(this.getName() + " Ejecutandose");
            numeroServidor = cliente.recibirPaquete();

        } while (numeroServidor != -1);

        System.out.println("No quedan más números");
        System.out.println("Cantidad de números recogidos: " + cliente.getListaNumeros().size());
        System.out.println("Números recogidos: " + cliente.getListaNumeros());

    }
}
