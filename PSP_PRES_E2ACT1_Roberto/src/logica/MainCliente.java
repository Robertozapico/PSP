/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import modelo.Cliente;

/**
 *
 * @author alumnop
 */
public class MainCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.recibirPaquete();
        //
        System.out.println(cliente.mostrarNumeros());
    }
    
}
