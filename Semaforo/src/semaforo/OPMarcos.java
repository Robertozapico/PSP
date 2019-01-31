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
public class OPMarcos extends Thread {

    private Semaphore hayEspacioParaMarcos;
    private Semaphore hayMarco;

    public OPMarcos(Semaphore p_hayEspMar, Semaphore p_hayMarco) {
        hayEspacioParaMarcos = p_hayEspMar;
        hayMarco = p_hayMarco;
    }

    public void run() {
        while (true) {
            try {
                //si hay espacio para marcos, entonces adquiere un permit
                hayEspacioParaMarcos.acquire();
//---fabricar marcos
                sleep(500);
                System.out.println(
                        "Se fabricó un marco...espacio para" + hayEspacioParaMarcos.availablePermits());
                hayMarco.release();
            } catch (InterruptedException e) {
            }
        }
    }

}
