package puentePasar_n_coches_misma_direccion;

import static java.lang.Math.random;
import static java.lang.Thread.yield;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Puente {

    private String ordenCochesCruzandoPuente = "";
    private String sentidoCochesPuente = null;
    private int numMaxCochesPuenteMismoSentido;
    private Semaphore semaforoPuente;

    public  Puente(int numMaxCochesPuenteMismoSentido) {
        this.numMaxCochesPuenteMismoSentido = numMaxCochesPuenteMismoSentido;

        //creamos el número de permits = número de coches máximos sobre el puente en el mismo sentido
        semaforoPuente = new Semaphore(numMaxCochesPuenteMismoSentido);

        //miro el estado del puente
        System.out.println(this.toString());

        if (semaforoPuente.availablePermits() == numMaxCochesPuenteMismoSentido) {
            System.out.println("------- PUENTE VACIO ------");
        }

    }

    public synchronized void entrarPuente(Coche c) throws InterruptedException {
        System.out.println("++++ El coche " + c.getIdCoche() + " sentido " + c.getSentido() + " intenta entrar en el puente ");

        //visualizo situacion del puente
        System.out.println(this.toString());

        //intenta pillar un permit
        semaforoPuente.acquire(1);

        //---------------- INTENTA CRUZAR ---------
        //si pilla un permit es que puente no esta lleno 
        //y comprueba si el sentido de los coches del puente es null o es el mismo
        if (sentidoCochesPuente == c.getSentido() || sentidoCochesPuente == null) {

            //-----------------  ENTRA EN EL PUENTE -------------------------
            //si entra aqui o está vacio el puente o el sentido del puente es el mismo que el del coche
            System.out.println(".................. " + c.getIdCoche() + " ENTRA en el puente");
            
             //si puente vacio el coche entra
            if (sentidoCochesPuente == null) {
                //puente vacio le indico la direccion del puente que es la del coche que entra cuando esta vacio
                sentidoCochesPuente = c.getSentido();
            }
            
            System.out.println("Sentido coches del puente " + sentidoCochesPuente + " sentido coche " + c.getIdCoche() + " " + c.getSentido());
          

            //podría darse el caso de que con este coche el puente se llene, si no quedan permits
            //es que el puente se ha llenado 
            if (semaforoPuente.availablePermits() == 0) {
                //si no quedan permits y ha llegado aqui es porque:
                // con este coche se llena el puente                                      

                System.out.println("PUENTE LLENO");
            }
            
             //el coche lo marco como que haentrado en el puente para que el hilo salga del bucle en su run
             //y pueda hacer cruzarPuente y dejarPuente
             c.setHaEntradoEnElPuente(true); 
           

        } else {

            //-------- NO PUEDE ENTRAR EN EL PUENTE SENTIDO CONTRARIO  -------
            //el coche no ha podido entrar en el puente por que estan pasando coches
            //en distinto sentido, necesita volverlo a intentar mas tarde soltando previamente el permit
            System.out.println("ESPERO. Sentido coches del puente " + sentidoCochesPuente + " sentido coche " + c.getIdCoche() + " " + c.getSentido() + " lo intento de nuevo");

            //soltamos el permit ya que no puede cruzar por ser de sentido contrario y que lo intente otro
            semaforoPuente.release(1);
            Thread.yield();
        }

        if (semaforoPuente.availablePermits() == numMaxCochesPuenteMismoSentido) {
            System.out.println("------- PUENTE VACIO ------");
            sentidoCochesPuente = null;
        }
    }

    public void cruzarPuente(Coche c) throws InterruptedException {
        //---------------- TIEMPO EN CRUZAR EL PUENTE ---------
        Thread.sleep((long) (random() * 500));

        //visualizo situacion del puente
        System.out.println(this.toString());
        
        //una vez cruzado soltamos el permit para que lo intente otro coche
        semaforoPuente.release(1);
    }

    public void salirPuente(Coche c) {
        //----------------- FINALIZA CRUZAR EL PUENTE Y SALE DEL PUENTE----------------
       
        System.out.println("**************" + c.getIdCoche() + "HA CRUZADO el puente");
        ordenCochesCruzandoPuente = ordenCochesCruzandoPuente + " " + c.getIdCoche();
    }

    public String getordenCochesCruzandoPuente() {
        return ordenCochesCruzandoPuente;
    }

    @Override
    public String toString() {
        return "Puente{ ordenCochesCruzandoPuente=" + ordenCochesCruzandoPuente + ", sentido=" + sentidoCochesPuente + ", numMaxCochesPuenteMismoSentido=" + numMaxCochesPuenteMismoSentido + ", numCochesPuente=" + (numMaxCochesPuenteMismoSentido - semaforoPuente.availablePermits()) + '}';
    }
}
