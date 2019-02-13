/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioshibernate;

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
        Actor actor = new Actor();
        short id = 400;
        actor.setActorId(id);
        actor.setFirstName("Rodolfo");
        actor.setLastName("Zapico");
        Date fechita = new Date();
        actor.setLastUpdate(fechita);
        logica.guardaActor(actor);
        
        //ARRIBA FUNCIONA
        actor.setLastName("Zapi");
        logica.actualizaActor(actor);
    }
    
}
