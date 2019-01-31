/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semaforo;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mario
 */
public class Montador extends Thread {

    private Semaphore hayEspacioParaMarcos;
    private Semaphore hayMarco;
    private Semaphore hayEspacioParaRuedas;
    private Semaphore hayRueda;
    private Semaphore hayEspacioParaManillares;
    private Semaphore hayManillar;

    public Montador(Semaphore p_hayEspRuedas, Semaphore p_hayRueda,
            Semaphore p_hayEspMar, Semaphore p_hayMarco,
            Semaphore p_hayEspMani, Semaphore p_hayManillar) {
        hayEspacioParaRuedas = p_hayEspRuedas;
        hayRueda = p_hayRueda;
        hayEspacioParaMarcos = p_hayEspMar;
        hayMarco = p_hayMarco;
        hayEspacioParaManillares = p_hayEspMani;
        hayManillar = p_hayManillar;
    }

    public void run() {

        while (true) {
            try {
                hayRueda.acquire();
//--coger rueda
                System.out.println("Se tomó la 1ª rueda...");

                sleep(50);
                hayEspacioParaRuedas.release(); //--libera un espacio para una rueda

                hayRueda.acquire();
//--coger rueda
                System.out.println("Se tomó la 2ª rueda...");
                sleep(50);
                hayEspacioParaRuedas.release(); //--libera un espacio para otra rueda

                hayMarco.acquire();
//--coge un marco
                sleep(100);
                System.out.println("\t\tSe tomó un marco...");
                hayEspacioParaMarcos.release(); //--libera un espacio para un marco

                hayManillar.acquire();
//--coge un manillar
                System.out.println("\t\t\t\tSe tomó un manillar....");
                sleep(60);
                hayEspacioParaManillares.release(); //--libera un espacio para un manillar

//--MONTAR LA BICICLETA
                sleep(200);
                System.out.println("SE ARMO UNA BICICLETA...");
            } catch (InterruptedException ex) {
                Logger.getLogger(Montador.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
