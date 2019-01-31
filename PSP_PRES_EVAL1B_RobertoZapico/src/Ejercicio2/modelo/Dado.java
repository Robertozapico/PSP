/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2.modelo;

/**
 *
 * @author alumnop
 */
public class Dado {

    public Dado() {
    }
    
    public int lanzarDado(){
        int numeroSacado = (int) (((Math.random())*19)+1);
        
        return numeroSacado;
    }
    
}
