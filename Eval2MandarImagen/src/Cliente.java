
import java.awt.Desktop;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alumnop
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        final int TAMANO_PAKETE=300;
        int port = 1234;
        File file = new File("copia.jpg");
        FileOutputStream fos = new FileOutputStream(file);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        DatagramSocket mySocket = new DatagramSocket(port);
        System.out.println("Esperando recibir datagramas del servidor");

        byte[] buffer = new byte[TAMANO_PAKETE];
        DatagramPacket datagram = new DatagramPacket(buffer, TAMANO_PAKETE);
        mySocket.receive(datagram);
        buffer = datagram.getData();
        int numDePackets = buffer[0];
        System.out.println("Numero de paquetes a recibir " + numDePackets);

        for (int i = 0; i < numDePackets; i++) {
            mySocket.receive(datagram);
            System.out.println("Packet " +(i+1));
            bos.write(buffer,0,buffer.length);
        }
        mySocket.close();
        //Desktop.getDesktop().open(file);

    }

}
