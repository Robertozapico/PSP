/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import modelo.Servidor;

/**
 *
 * @author alumnop
 */
public class MainServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Se desea disponer de un servidor que tenga una colección de números,
entre 0 y 100,
        
y al cual se conectarán varios clientes CONCURRENTEMENTE,
solicitándole una vez que se conecta al servidor que le envíe números de la
colección (pudiendo ser cualquiera de la colección generando la posición del
número que se va a enviar), momento en el que el servidor envía el número
de dicha posición al cliente y eliminándose dicho elemento en el servidor.
Cada cliente cuando reciba el número irá almacenándolo en una colección
propia, y el proceso finalizará cuando el servidor se queda sin números,
momento en el que los clientes deberán mostrar su correspondiente
colección y el número de elementos que han conseguido.
El ejercicio se deberá de realizar con un monitor que gestione las peticiones
de los clientes hasta que se quede sin números el servidor, momento que
deberá avisar a los clientes para que cierren sus conexiones.
¿Dónde pondrías el monitor? En el Servidor o en el cliente*/
        /*
        EXPLICACION
        lista numeros 0-100 en el servidor
cliente solicita numero
servidor envia posicion en la coleccion (metodo enviar numero sincronizado)
al enviar el numero se elimina de la coleccion
cliente almacena numero en una coleccion propia
termina cuando el servidor no tiene numeros
al terminar los clientes muestran su coleccion y cantidad de numeros

usar monitor (countdown lunch) (mirar ejercicio camellos)
al quedarse sin numero se envia aviso a los clientes para que cierren su sesion

donde pondrias el monitor? en el servidor

solo un cliente accede y coge un numero, el resto espera
*/
        
        Servidor servidor = new Servidor();
        //
        System.out.println(servidor.seleccionarNumero());
        servidor.enviarNumero("localhost");
        //
        System.out.println(servidor.mostrarNumeros());
    }
    
}
