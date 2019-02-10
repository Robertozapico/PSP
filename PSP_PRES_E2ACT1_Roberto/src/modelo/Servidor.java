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
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public synchronized String enviarNumero(Cliente cliente) throws InterruptedException, IOException {
        String mensaje = "";
        String nombreCliente = cliente.getNombreCliente();
        System.out.println("++++ El cliente " + cliente.getIdCliente() + " intenta acceder");
        while (servidorOcupado) {
            System.out.println("Servidor ocupado, " + cliente.getIdCliente() + " espera");
            wait();
        }
        servidorOcupado = true;
        notifyAll();
        System.out.println(cliente.getIdCliente() + " entra");
        int tiempo = (int) (Math.random() * 500) + 500;
        sleep(tiempo);

        ServerSocket skServidor = new ServerSocket(2000);

        //while (listaNumeros.size() > 0) {
        Socket sCliente = skServidor.accept();

        //servidorOcupado = false;
        System.out.println(sCliente.getPort());

        OutputStream aux = sCliente.getOutputStream();

        DataOutputStream flujo_salida = new DataOutputStream(aux);
        int numeroEscogido = seleccionarNumero();
        flujo_salida.writeInt(numeroEscogido);
        borrarNumero(numeroEscogido);

        sCliente.close();

        sleep(500);

        //}
        /*try {
            DatagramSocket socket = new DatagramSocket();
            byte[] buffer = new byte[1024];

            mensaje = Integer.toString(seleccionarNumero());
            borrarNumero(Integer.parseInt(mensaje));
            buffer = mensaje.getBytes();
            InetAddress equipoCliente = InetAddress.getByName(nombreCliente);

            DatagramPacket paquete = new DatagramPacket(buffer, buffer.length, equipoCliente, 2000);

            socket.send(paquete);
            System.out.println("Cliente recoge el número " + mensaje);
            System.out.println(listaNumeros);
            System.out.println("Quedan: " + listaNumeros.size());
        } catch (SocketException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        System.out.println("Cliente recoge el número " + numeroEscogido);
        System.out.println(listaNumeros);
        System.out.println("Quedan: " + listaNumeros.size());
        System.out.println("---- Saliendo cliente " + cliente.getIdCliente());
        notifyAll();
        servidorOcupado = false;
        return mensaje;
    }

    public int seleccionarNumero() {
        return listaNumeros.get((int) Math.floor(Math.random() * listaNumeros.size()));
    }

    public void borrarNumero(int numeroABorrar) {
        listaNumeros.remove(numeroABorrar);
    }

    public List<Integer> mostrarNumeros() {

        return listaNumeros;
    }

}
