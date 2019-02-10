/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumnop
 */
public class Cliente {

    private String idCliente;
    private List<Integer> listaNumeros;
    private String nombreCliente = "localhost";

    public Cliente(String idCliente) {
        this.idCliente = idCliente;
        this.listaNumeros = new ArrayList<Integer>();
    }

    public Cliente() {
        this.listaNumeros = new ArrayList<Integer>();
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public List<Integer> getListaNumeros() {
        return listaNumeros;
    }

    public String recibirPaquete() {
        String msg = "";
        String host = "localhost";
        int port = 2000;
        System.out.println("Arranco cliente");
        try {
            Socket sk = new Socket(host, port);
            //...Intercambio de información
            System.out.println(sk.toString());

            InputStream inputStreamSocket = sk.getInputStream();
            DataInputStream dataInputStreamSocket = new DataInputStream(inputStreamSocket);
            msg = dataInputStreamSocket.readUTF();
            System.out.println(msg);
            inputStreamSocket.close();
            dataInputStreamSocket.close();
            //
            sk.close();
            System.out.println("Numero: " + Integer.parseInt(msg));
            listaNumeros.add(Integer.parseInt(msg));
            System.out.println("Lista de números del cliente");
            System.out.println(listaNumeros);
            System.out.println("Finaliza el cliente");
        } catch (IOException ex) {
            System.out.println("Error en la comunicación");
        }
        return msg;
        /*
        String mensaje = "";
        try {
            DatagramSocket socket = new DatagramSocket(2000);
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            socket.receive(packet);

            mensaje = new String(packet.getData(), 0, packet.getLength());
            //
            System.out.println("Número recogido por el cliente: " + mensaje);
            socket.close();
        } catch (SocketException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Numero: " + Integer.parseInt(mensaje));
        listaNumeros.add(Integer.parseInt(mensaje));
        System.out.println("Lista de números del cliente");
        System.out.println(listaNumeros);
        return mensaje;*/
    }

    public List<Integer> mostrarNumeros() {

        return listaNumeros;
    }
}
