
import aplicacion.PersonaRoberto;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
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
public class MainEmisor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, SocketException, IOException{
        File imagen = new File ("/home/alumnop/Documentos/Proyectos/PSP1819/Eval2MandarImagen/src/img/pmdm.png");
        byte[] buffer = new byte[4096];
        
        FileInputStream fis = new FileInputStream(imagen);
        DataInputStream dis = new DataInputStream(fis);
        
        int numPaquetes=(int) (imagen.length()/buffer.length);
        DatagramSocket server = new DatagramSocket();

        DatagramPacket DGP= new DatagramPacket(buffer, buffer.length, InetAddress.getByName("127.0.0.1"), 2000);
        DGP.setLength(numPaquetes);
        server.send(DGP);
        DGP.setLength(buffer.length);
        
        
        
        for (int i = 0; i < numPaquetes; i++) {
            fis.read(buffer, 0, buffer.length);
            server.send(DGP);
        }
        
        
    }

}
