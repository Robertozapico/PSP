
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
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
public class Servidor {

    static final int Puerto = 2000;

    public Servidor() {
        int numRandom = (int) (Math.random() * 100);

        //Plataforma
        try {
            ServerSocket skServidor = new ServerSocket(Puerto);
            System.out.println("Escucho el puerto " + Puerto);
            for (int nCli = 0; nCli < 3; nCli++) {
                //socketDinamicoDeComunicacionConElCliente
                Socket sCliente = skServidor.accept();

                //peticiones del cliente
                System.out.println("Sirvo al cliente " + nCli);
                OutputStream aux = sCliente.getOutputStream();
                DataOutputStream flujo_salida = new DataOutputStream(aux);
                flujo_salida.writeUTF("Hola cliente " + nCli);
                Scanner miTeclado = new Scanner(System.in);
                System.out.println("Introduce un número");
                int numeroUsuario = miTeclado.nextInt();
                if(numeroUsuario>numRandom){
                    System.out.println("El número es menor");
                }else if(numeroUsuario<numRandom){
                    System.out.println("El número es mayor");
                }else{
                    System.out.println("ACERTASTE");
                }
                //fin de peticiones del cliente
                sCliente.close();
            }
            System.out.println("Ya se han atendido los 3 clientes");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] arg) {
        new Servidor();
    }
}
