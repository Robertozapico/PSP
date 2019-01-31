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
public class OPManillares extends Thread {

    private Semaphore hayEspacioParaManillares;
    private Semaphore hayManillar;

    public OPManillares(Semaphore p_hayEspMani, Semaphore p_hayManillar) {
        hayEspacioParaManillares = p_hayEspMani;
        hayManillar = p_hayManillar;
    }

    public void run() {
        while (true) {
            try {
                //si hay espacio para manillares adquiere un permit
                hayEspacioParaManillares.acquire();
//---fabricar manillar
                sleep(400);
                System.out.println("Se fabricó un manillar ... espacio para" + hayEspacioParaManillares.availablePermits());
                hayManillar.release();
            } catch (InterruptedException e) {
            }
        }
    }

}
