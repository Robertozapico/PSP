
import aplicacion.PersonaRoberto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumnop
 */
public class MainEmisor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Emisor emisor = new Emisor();
        PersonaRoberto persona = new PersonaRoberto();
        
        System.out.println(emisor.getClass().getTypeName());
        persona.setNombre("Paco");
        persona.setEdad(25);
            
        emisor.enviarObjeto("localhost", persona);
        
        
    }

}
