/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
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

    private List<Integer> listaNumeros;

    public Servidor() {
        this.listaNumeros = new ArrayList<Integer>();
        for (int i = 0; i < 101; i++) {
            listaNumeros.add(i);
        }
    }

    public String enviarNumero(String nombreCliente) {
        String mensaje = "";
        try {
            //while(listaNumeros.size()>0){
                DatagramSocket socket = new DatagramSocket();
                byte[] buffer = new byte[1024];

                mensaje = Integer.toString(seleccionarNumero());
                borrarNumero(Integer.parseInt(mensaje));
                buffer = mensaje.getBytes();
                InetAddress equipoCliente = InetAddress.getByName(nombreCliente);

                DatagramPacket paquete = new DatagramPacket(buffer, buffer.length, equipoCliente, 2000);

                socket.send(paquete);
            //}
        } catch (SocketException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
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
