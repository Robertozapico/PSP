/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
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

    private List<Integer> listaNumeros;

    public Cliente() {
        this.listaNumeros = new ArrayList<Integer>();
    }

    public String recibirPaquete() {
        String mensaje = "";
        try {
            DatagramSocket socket = new DatagramSocket(2000);
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            socket.receive(packet);

            mensaje = new String(packet.getData(), 0, packet.getLength());
            //
            System.out.println(mensaje);
            socket.close();
        } catch (SocketException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        listaNumeros.add(Integer.parseInt(mensaje));
        return mensaje;
    }
    
    public List<Integer> mostrarNumeros(){
    
    return listaNumeros;
}
}
