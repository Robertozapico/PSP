package semaforo_1_solo_un_coche_en_el_puente;


public class Coche {
    private String idCoche;
    private String sentido;
      
    Coche (String idCoche, String sentido){
        this.idCoche = idCoche;
        this.sentido = sentido;
    }

    public String getIdCoche() {
        return idCoche;
    }

    public String getSentido() {
        return sentido;
    }   

    @Override
    public String toString() {
        return "Coche{" + "idCoche=" + idCoche + ", sentido=" + sentido + '}';
    }
    
}
