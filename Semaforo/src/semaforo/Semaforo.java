/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Mario
 */
public class Semaforo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Semaphore hayEspacioParaMarcos = new Semaphore(4);
        //inicializamos el semaforo como no disponible
        Semaphore hayMarco = new Semaphore(0);
        Semaphore hayEspacioParaRuedas = new Semaphore(10);
        //inicializamos el semaforo como no disponible
        Semaphore hayRueda = new Semaphore(0);
        Semaphore hayEspacioParaManillares = new Semaphore(10);
        //inicializamos el semaforo como no disponible
        Semaphore hayManillar = new Semaphore(0);
        OPRuedas op1 = new OPRuedas(hayEspacioParaRuedas, hayRueda);
        OPMarcos op2 = new OPMarcos(hayEspacioParaMarcos, hayMarco);
        OPManillares op3 = new OPManillares(hayEspacioParaManillares, hayManillar);
        Montador montador = new Montador(hayEspacioParaRuedas, hayRueda,
                hayEspacioParaMarcos, hayMarco,
                hayEspacioParaManillares, hayManillar);
//--iniciar los hilos
        op1.start();
        op2.start();
        op3.start();
        montador.start();
    }

}
