package puentePasar_n_coches_misma_direccion;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CocheCirculando extends Thread {

    private Puente p;
    private Coche c;

    CocheCirculando(Coche c, Puente p) {
        this.p = p;
        this.c = c;

    }

    public Coche getC() {
        return c;
    }

    public void setC(Coche c) {
        this.c = c;
    }

    public void run() {
        try {

            System.out.println("Intentando " + c.getIdCoche() + " entrar en el puente");

            //mientras el coche no ha conseguido entrar en el  puente esta en el bucle
            while (!c.isHaEntradoEnElPuente()) {
                //esta en el bucle hasta que entra en el puente 
                p.entrarPuente(c);
            }
            
            //cuando sale del bucle es que ha conseguido acceder al puente y solo tiene que cruzar y salir
            p.cruzarPuente(c);
            p.salirPuente(c);

            //cuando cruza visualiza orden y muere el hilo
            System.out.println(p.getordenCochesCruzandoPuente());

        } catch (InterruptedException ex) {
            Logger.getLogger(CocheCirculando.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
