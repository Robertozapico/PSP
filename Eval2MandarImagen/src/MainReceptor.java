
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumnop
 */
public class MainReceptor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, SocketException, IOException {
        
        File imagenDescargada = new File("imagenDescargada.jpg");
        byte[] buffer = new byte[4096];
        
        FileOutputStream fos = new FileOutputStream(imagenDescargada);
        
        DatagramSocket cliente = new DatagramSocket(2000);
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        cliente.receive(packet);
        int numPaquetes = packet.getLength();
        
        for (int i = 0; i < numPaquetes; i++) {
            cliente.receive(packet);
            fos.write(buffer);
            
            
        }
        fos.close();
        Desktop.getDesktop().open(imagenDescargada);
    }

}
