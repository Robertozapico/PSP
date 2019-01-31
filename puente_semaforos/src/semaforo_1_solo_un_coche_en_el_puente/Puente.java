package semaforo_1_solo_un_coche_en_el_puente;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Puente {

    private String ordenCochesCruzandoPuente;
    private Semaphore semaforoPuente;


    public Puente() {
        this.ordenCochesCruzandoPuente = "";
        this.semaforoPuente = new Semaphore(1);
       }

    public  void cruzarPuente(Coche c) {
        //entrar puente
        try {
            System.out.println("Intentando entrar en el puente el coche " + c.toString());
            semaforoPuente.acquire(1);
            System.out.println("++++ El coche " + c.getIdCoche() + " sentido " + c.getSentido() + " entra en el puente ");
            ordenCochesCruzandoPuente = ordenCochesCruzandoPuente + c.getIdCoche() + " ";
            System.out.println(ordenCochesCruzandoPuente);
        } catch (InterruptedException ex) {
            Logger.getLogger(Puente.class.getName()).log(Level.SEVERE, null, ex);
        }

        //tiempo que tarda en cruzar
        int tiempo = (int) (500 + Math.random() * 500);
        try {
            Thread.sleep(tiempo);
        } catch (InterruptedException ex) {
            Logger.getLogger(CocheCirculando.class.getName()).log(Level.SEVERE, null, ex);
        }

        //salir puente
        System.out.println(c.getIdCoche() + " sentido " + c.getSentido() + " esta saliendo del puente");
        System.out.println("puente libre");
        semaforoPuente.release();
    }

    public String getordenCochesCruzandoPuente() {
        return ordenCochesCruzandoPuente;
    }
}
