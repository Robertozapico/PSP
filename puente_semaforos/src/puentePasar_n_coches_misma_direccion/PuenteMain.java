package puentePasar_n_coches_misma_direccion;


import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PuenteMain {
    final static String IDA="IDA"; //sentido 0 es ida
    final static String VUELTA="VUELTA"; //sentido 1 es vuelta
    
    public static void main(String[] args) {
        
        Puente p;
        int numMaxCochesPuenteMismoSentido=2;

        p = new Puente(numMaxCochesPuenteMismoSentido);
        System.out.println(p.toString());            
        for (int i=1;i<=5;i++){
            String sentido = ((int) Math.floor(Math.random()*2 + 1)==1)?IDA:VUELTA;  // Valor entre 0 y 1

            Coche c = new Coche("c"+i, sentido);
            System.out.println( "CREANDO " +c.toString());
            (new CocheCirculando(c, p)).start();
           
        }      
    }
}
