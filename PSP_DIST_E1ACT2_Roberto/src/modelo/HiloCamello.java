/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zapia
 */
public class HiloCamello extends Thread {

    private List<Camello> camellosCarreraLlegadaAmeta;
    private Camello camello;
    private CyclicBarrier cantidadDeCamellosSalida;
    private int lineaDeMeta = 100;
    private String distanciaRecorrida = "";

    public HiloCamello(Camello camello, CyclicBarrier cantidadDeCamellosSalida, List<Camello> camellosCarreraLlegadaAmeta) {
        this.camello = camello;
        this.cantidadDeCamellosSalida = cantidadDeCamellosSalida;
        this.camellosCarreraLlegadaAmeta=camellosCarreraLlegadaAmeta;
    }

    public Camello getCamello() {
        return camello;
    }

    public void setCamello(Camello camello) {
        this.camello = camello;
    }

    @Override
    public void run() {

        try {
            System.out.println("Camello " + camello.getId() + " posicionado en la salida"); //freno la ejecución del hilo
            cantidadDeCamellosSalida.await(); //cuando se generen los x hilos se ejecutan

            do {
                int tirada = camello.getDado().lanzarDado();
                System.out.println("Camello " + camello.getId() + " avanza " + tirada + " posiciones");
                int avance = camello.getPosicionesAvanzadas() + tirada;
                camello.setPosicionesAvanzadas(avance);
                if (camello.getPosicionesAvanzadas() <= lineaDeMeta) {
                    for (int i = 0; i < tirada; i++) {
                        distanciaRecorrida += "-";
                    }
                    System.out.println(camello.getId() + ": " + distanciaRecorrida);
                    distanciaRecorrida += " ";
                } else {
                    System.out.println(camello.getId() + ": " + distanciaRecorrida);
                    System.out.println(camello.getId() + " ha llegado a la meta.");
                    camellosCarreraLlegadaAmeta.add(camello);
                }
            } while (camello.getPosicionesAvanzadas() < lineaDeMeta);
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloCamello.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BrokenBarrierException ex) {
            Logger.getLogger(HiloCamello.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
