package puentePasar_n_coches_misma_direccion;

public class Coche {

    private String idCoche;
    private String sentido;
    private boolean haEntradoEnElPuente;

    Coche(String idCoche, String sentido) {
        this.idCoche = idCoche;
        this.sentido = sentido;
    }

    public String getIdCoche() {
        return idCoche;
    }

    public String getSentido() {
        return sentido;
    }

    public boolean isHaEntradoEnElPuente() {
        return haEntradoEnElPuente;
    }

    public void setHaEntradoEnElPuente(boolean haEntradoEnElPuente) {
        this.haEntradoEnElPuente = haEntradoEnElPuente;
    }

    @Override
    public String toString() {
        return "Coche{" + "idCoche=" + idCoche + ", sentido=" + sentido + ", haEntradoEnElPuente=" +haEntradoEnElPuente + '}';
    }

}
