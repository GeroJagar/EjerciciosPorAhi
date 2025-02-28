package co.edu.uniquindio.banco.bancouq.model;

public class Reserva {
    private String id;
    private String fechaSolicitud;

    public Reserva() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }
}
