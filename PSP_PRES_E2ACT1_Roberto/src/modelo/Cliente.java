/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumnop
 */
public class Cliente {

    private String idCliente;
    private List<Integer> listaNumeros;
    private String nombreCliente = "localhost";

    public Cliente(String idCliente) {
        this.idCliente = idCliente;
        this.listaNumeros = new ArrayList<Integer>();
    }

    public Cliente() {
        this.listaNumeros = new ArrayList<Integer>();
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public List<Integer> getListaNumeros() {
        return listaNumeros;
    }

    public int recibirPaquete() {
        
        int numeroCogido=0;
        String host = "localhost";
        int port = 2000;
        System.out.println("Arranco cliente");
        try {
            Socket sk = new Socket(host, port);
            //...Intercambio de información
            System.out.println(sk.toString());
            InputStream inputStreamSocket = sk.getInputStream();
            DataInputStream dataInputStreamSocket = new DataInputStream(inputStreamSocket);
            numeroCogido = dataInputStreamSocket.readInt();
            inputStreamSocket.close();
            dataInputStreamSocket.close();
            //
            sk.close();
            System.out.println("Numero: " + numeroCogido);
            listaNumeros.add(numeroCogido);
            System.out.println("Lista de números del cliente");
            System.out.println(listaNumeros);
            System.out.println("Finaliza el cliente");
        } catch (IOException ex) {
            System.out.println("Error en la comunicación");
        }
        return numeroCogido;
    }

    public List<Integer> mostrarNumeros() {

        return listaNumeros;
    }
}
