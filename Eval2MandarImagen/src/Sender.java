
import java.io.BufferedInputStream;
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
public class Sender {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, SocketException, IOException, InterruptedException {
        FileInputStream fis = null;
        File myFile = new File("/home/alumnop/Documentos/Proyectos/PSP1819/Eval2MandarImagen/src/img/loguito.jpg");
        int packetsize = 10240;
        int numPaketes = (int) Math.ceil(((float) myFile.length()) / packetsize);

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(myFile));

        InetAddress receiverHost = InetAddress.getByName("localhost");
        int receiverPort = 1234;
        ///////
        DatagramSocket mySocket = new DatagramSocket();
        byte[] buffer = new byte[packetsize];
        DatagramPacket datagram = new DatagramPacket(buffer, buffer.length, receiverHost, receiverPort);

        Integer numPaquetesObjeto = numPaketes;
        buffer[0] = numPaquetesObjeto.byteValue();

        datagram.setData(buffer);
        datagram.setLength(buffer.length);

        mySocket.send(datagram);
        System.out.println("Enviando en numero de paquetes" + numPaketes);
        for (double i = 0; i < numPaketes; i++) {
            bis.read(buffer, 0, buffer.length);
            System.out.println("packet" + (i + 1));
            datagram.setData(buffer);
            datagram.setLength(buffer.length);
            System.out.println("Enviando datagrama:" + i);
            Thread.sleep(25);
        }
        mySocket.close();
    }

}
