package semaforo_1_solo_un_coche_en_el_puente;


import java.util.ArrayList;


public class PuenteMain {
    final static String IDA="IDA"; //sentido 0 es ida
    final static String VUELTA="VUELTA"; //sentido 1 es vuelta
    
    public static void main(String[] args) {
        Puente p = new Puente();
                    
        for (int i=1;i<=10;i++){
            String sentido = ((int) Math.floor(Math.random()*2 + 1)==1)?IDA:VUELTA;  // Valor entre 0 y 1

            Coche c = new Coche("c"+i, sentido);
            (new CocheCirculando(c, p)).start();
        }      
    }
}
