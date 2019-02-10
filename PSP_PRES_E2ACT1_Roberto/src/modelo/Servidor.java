/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import static java.lang.Thread.sleep;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumnop
 */
public class Servidor {

    private String idServidor;
    private List<Integer> listaNumeros;
    private boolean servidorOcupado;

    public Servidor(String idServidor) {
        this.idServidor = idServidor;
        this.listaNumeros = new ArrayList<Integer>();
        for (int i = 0; i < 101; i++) {
            listaNumeros.add(i);
        }
    }

    public Servidor() {
        this.listaNumeros = new ArrayList<Integer>();
        for (int i = 0; i < 101; i++) {
            listaNumeros.add(i);
        }
    }

    public String getIdServidor() {
        return idServidor;
    }

    public void setIdServidor(String idServidor) {
        this.idServidor = idServidor;
    }

    public List<Integer> getListaNumeros() {
        return listaNumeros;
    }

    public synchronized String enviarNumero() throws InterruptedException, IOException {
        String mensaje = "";
        int numeroEscogido;
        System.out.println("++++ El cliente intenta acceder");
        while (servidorOcupado) {
            System.out.println("Servidor ocupado, espera");
            wait();
        }
        servidorOcupado = true;
        notifyAll();
        System.out.println("Un cliente entra");
        int tiempo = (int) (Math.random() * 500) + 500;
        sleep(tiempo);
        ServerSocket skServidor = new ServerSocket(2000);
        while (listaNumeros.size() > 0) {
            Socket sCliente = skServidor.accept();
            System.out.println(sCliente.getPort());

            OutputStream aux = sCliente.getOutputStream();

            DataOutputStream flujo_salida = new DataOutputStream(aux);
            numeroEscogido = seleccionarNumero();
            if (listaNumeros.size() == 0) {
                numeroEscogido = -1;
            } else {
                while (numeroEscogido > listaNumeros.size()) {
                    numeroEscogido = seleccionarNumero();
                }
            }
            flujo_salida.writeInt(numeroEscogido);
            if (numeroEscogido != -1) {
                borrarNumero(numeroEscogido);
            }
            sCliente.close();
            sleep(500);
            System.out.println("Cliente recoge el número " + numeroEscogido);
            System.out.println(listaNumeros);
            System.out.println("Quedan: " + listaNumeros.size());
            System.out.println("---- Saliendo cliente ");
            notifyAll();
            servidorOcupado = false;
        }
        return mensaje;
    }

    public synchronized int seleccionarNumero() {
        return listaNumeros.get((int) Math.floor(Math.random() * listaNumeros.size()));
    }

    public synchronized void borrarNumero(int numeroABorrar) {
        listaNumeros.remove(numeroABorrar);
    }

    public List<Integer> mostrarNumeros() {

        return listaNumeros;
    }

}
