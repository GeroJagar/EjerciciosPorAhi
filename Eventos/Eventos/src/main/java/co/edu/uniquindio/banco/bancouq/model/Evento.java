package co.edu.uniquindio.banco.bancouq.model;

public class Evento {
    private String id;
    private String nombre;
    private String descripcion;
    private String fecha;
    private int capacidadMax;

    public Evento() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMax = capacidadMaxima;
    }

    public int getCapacidadMaxima() {
        return capacidadMax;
    }
}
