/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pingpong;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mario
 */
public class PingPong {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Semaphore semaforo = new Semaphore(1);
        
        new HiloPingPong(semaforo, "Ping", 100).start();
        new HiloPingPong(semaforo, "Pong", 100).start();
/*
        CyclicBarrier algoBarrier = new CyclicBarrier(4+1);
        for (int i = 0; i < 4; i++) {
            Thread hilo = new Thread() {
                public void run() {
                    try {
                        System.out.println("ALGO");
                        algoBarrier.await();
                        System.out.println(new Date().getTime());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            hilo.start();
        }

        try {
            algoBarrier.await();
            System.out.println("MUCHO");
        } catch (InterruptedException ex) {
            Logger.getLogger(PingPong.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BrokenBarrierException ex) {
            Logger.getLogger(PingPong.class.getName()).log(Level.SEVERE, null, ex);
        }
*/
    }

}
