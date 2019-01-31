
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alumnop
 */
/*MONITORES: Se dispone de una pizza de N raciones. Hay M amigos y pasado un
tiempo aleatorio (500 y 1000 milisegundos) a cada uno de ellos le entran ganas de
comer. En la mesa solo hay una silla y para comer es necesario sentarse en dicha
silla. El amigo que consiga sentarse en la silla se pone a comer un ración de pizza
(que tardará entre 1000 y 2000 milisegundos), levantándose a continuación y
poniéndose a charlar de nuevo, dejando la silla libre para que se siente otro amigo.
Simular mediante un programa el funcionamiento esta escena hasta que se acaben
las raciones de pizza momento en el cual deberá de mostrarse el número de raciones
que ha comido cada amigo.
Probar a realizar el ejercicio con 4 amigos y una pizza de 10 raciones.
Se deberán de mostrar los mensajes:
AMIGO-i charlando  cuando está charlando
AMIGO -i tiene hambre, intentado pillar la silla  cuando le entra hambre y
quiere pillar la silla
AMIGO -i se ha sentado en la silla -- SILLA OCUPADA  cuando consigue
la silla
SILLA ESTA OCUPADA POR OTRO, AMIGO-i vuelve a ponerse a charlar
 cuando consigue no consigue silla
AMIGO -i COMIENDO ración de PIZZA  cuando esta comiendo
AMIGO -i finaliza de comer, se levanta de la silla – SILLA LIBRE  cuando
acaba de comer y deja la silla libre
Cuando se acaben las raciones se deberá de mostrar --- SE ACABO LA PIZZA
Si un niño se sienta y ya no quedan raciones de tarta --- YA NO QUEDAN
RACIONES DE PIZZA, LO SIENTO
Cuando muere el hilo indicar ******** AMIGO -i ha comido x raciones de
PIZZA
2. Modifica el ejercicio anterior teniendo en cuenta que hay dos sillas y solo puede
coger ración de pizza de uno en uno, es decir coge la ración uno y mientras este la
coge el otro no puede coger su ración hasta que el otro deje la pizza libre. Una vez
que coge la ración de la pizza puede comerla durante un tiempo X dejando la silla al
finalizar. Habrá que tener en cuenta que quede raciones.*/
public class HiloAmigo extends Thread {

    private Amigo amigo;
    private Mesa mesa;

    public HiloAmigo(Amigo amigo, Mesa mesa) {
        this.amigo = amigo;
        this.mesa = mesa;
    }

    @Override
    public void run() {

            mesa.sentarse(amigo);


            /*mesa.tiempoEntrarPersona(personaQueEntra);

        servicio.salirPersona(personaQueEntra);
        System.out.println(servicio.getSexos().toString());
        System.out.println("Cantidad de hombres: " + servicio.getContadorPersonasH());
        System.out.println("Cantidad de mujeres: " + servicio.getContadorPersonasM());*/
    }

}
