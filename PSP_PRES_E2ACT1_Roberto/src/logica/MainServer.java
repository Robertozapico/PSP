/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Servidor;

/**
 *
 * @author alumnop
 */
public class MainServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        Llegados a un punto salta una excepcion de que el index esta fuera del tamaño de la coleccion
        pero todas las veces es mentira porque el index era 12 y el tamaño 12, o 14-14 o 28-28, etc.
        */
        Servidor servidor = new Servidor();
        try {
            servidor.enviarNumero();
        } catch (InterruptedException ex) {
            Logger.getLogger(MainServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainServer.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(servidor.mostrarNumeros());
    }

}
