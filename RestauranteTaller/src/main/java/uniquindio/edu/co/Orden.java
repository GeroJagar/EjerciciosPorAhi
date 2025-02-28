package uniquindio.edu.co;

import java.util.ArrayList;
import java.util.Random;

public class Orden {
    private String plato;
    private String bebida;
    private int numeroOrden;

    private static final String[] PLATOS = {"Arroz paisa", "Bandeja paisa", "Empanada", "Trucha frita"};
    private static final String[] BEBIDAS = {"Jugo de uva", "Jugo de guayaba", "Limonada"};

    public Orden(String plato, String bebida, int numeroOrden) {
        this.plato = plato;
        this.bebida = bebida;
        this.numeroOrden = numeroOrden;
    }

    public String getPlato() {
        return plato;
    }

    public String getBebida() {
        return bebida;
    }

    public int getNumeroOrden() {
        return numeroOrden;
    }

    public static Orden generarOrden(int numeroOrden) {
        Random random = new Random();
        String plato = PLATOS[random.nextInt(PLATOS.length)];
        String bebida = BEBIDAS[random.nextInt(BEBIDAS.length)];
        return new Orden(plato, bebida, numeroOrden);
    }

    public void imprimirOrden() {
        System.out.println("Orden #" + numeroOrden);
        System.out.println("Plato: " + plato);
        System.out.println("Bebida: " + bebida);
    }


}
