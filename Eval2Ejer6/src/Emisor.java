
import aplicacion.PersonaRoberto;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alumnop
 */
public class Emisor {

    /*Crear una clase Emisor que permita enviar dicho objeto a través del puerto 2000 a un Receptor
que, en nuestro caso, estará situado en la misma máquina. La longitud será de 4096*/
    public void enviarObjeto(String receptor, PersonaRoberto persona) {

        try {
            DatagramSocket socket = new DatagramSocket();
            final int longitud = 4096;
            byte[] buffer = Serializar.toBytes(persona);
            InetAddress equipoCliente = InetAddress.getByName(receptor);
            DatagramPacket paquete = new DatagramPacket(buffer, buffer.length, equipoCliente, 2000);

            socket.send(paquete);
            socket.close();
        } catch (SocketException ex) {
            Logger.getLogger(Emisor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Emisor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Emisor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
