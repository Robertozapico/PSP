import aplicacion.Persona;
import java.io.File;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
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
public class Receptor {

    private String nombre = "localhost";

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void recibirDatagrama() {
        final int longitud = 90;
        try {
            DatagramSocket socket = new DatagramSocket(2000);
            byte[] buffer = new byte[longitud];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            socket.receive(packet);

            Persona mensaje = (Persona) Serializar.toObject(buffer);
            System.out.println("El receptor ha recibido a: " +mensaje);
            socket.close();
            
            
            //double numDePackets = Math.ceil((int)new File("tmp.mp4")).length()) /
            
        } catch (SocketException ex) {
            Logger.getLogger(Receptor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Receptor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
