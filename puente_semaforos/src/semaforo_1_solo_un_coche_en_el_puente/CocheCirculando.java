package semaforo_1_solo_un_coche_en_el_puente;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CocheCirculando extends Thread {

    private Puente p;
    private Coche c;

    CocheCirculando(Coche c, Puente p) {
        this.p = p;
        this.c = c;
    }

    public void run() {
        
        p.cruzarPuente(c);

    }
}
