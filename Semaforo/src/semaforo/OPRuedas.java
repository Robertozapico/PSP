/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo;

import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Mario
 */
public class OPRuedas extends Thread {

    private Semaphore hayEspacioParaRuedas;
    private Semaphore hayRueda;

    public OPRuedas(Semaphore hayEspacioParaRuedas, Semaphore hayRueda) {
        this.hayEspacioParaRuedas = hayEspacioParaRuedas;
        this.hayRueda = hayRueda;
    }

    public void run() {
        while (true) {
            try {
                //si hay espacio para ruedas adquiere un permit
                hayEspacioParaRuedas.acquire();
//--Hacer Rueda
                sleep(100);
                System.out.println("Se fabricó una rueda, espacio para " + hayEspacioParaRuedas.availablePermits());
                hayRueda.release();
            } catch (InterruptedException e) {
            }
        }
    }
}
