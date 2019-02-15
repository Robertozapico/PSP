/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioshibernate;

import java.util.Calendar;
import java.util.Date;
import modelo.Actor;

/**
 *
 * @author alumnop
 */
public class EjerciciosHibernate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Logica logica = new Logica();
        ActoresDAO daoActores = new ActoresDAO();
        Actor actor = new Actor();
        short id = 198;
        actor.setActorId(id);
        actor.setFirstName("Pascualo");
        actor.setLastName("Zapi");
        Date fechita = new Date();

        actor.setLastUpdate(fechita);
        /*logica.guardaActor(actor);
        
        
        actor.setLastName("Zapi");
        logica.actualizaActor(actor);
        logica.eliminaActor(actor);
        actor = logica.obtenActor(id);
        System.out.println(actor.getFirstName());
        System.out.println(logica.obtenListaActores());
        
        
        daoActores.guardaActor(actor);
        actor.setLastName("ZapiCo");
        daoActores.actualizaActor(actor);
        logica.eliminaActor(actor);
        actor = daoActores.obtenActor(id);
        System.out.println(actor.getFirstName());
        System.out.println(daoActores.obtenListaActor());
         */
        //ARRIBA FUNCIONA
        
    }

}
