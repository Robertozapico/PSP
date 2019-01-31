/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pingpong;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mario
 */
public class HiloPingPong extends Thread {

    private Semaphore semaforo;
    private String sonido;
    private int retraso;

    public HiloPingPong(Semaphore semaforo, String sonido, int retraso) {
        this.semaforo = semaforo;
        this.sonido = sonido;
        this.retraso = retraso;
    }

    @Override
    public void run() {

        while (true) {
            while (semaforo.availablePermits() > 0) {
                System.out.println(sonido);                
                try {
                    semaforo.acquire();
                } catch (InterruptedException ex) {
                    Logger.getLogger(HiloPingPong.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                    sleep(retraso);
                } catch (InterruptedException ex) {
                    Logger.getLogger(HiloPingPong.class.getName()).log(Level.SEVERE, null, ex);
                }
            semaforo.release();
            yield();
        }

    }

}
