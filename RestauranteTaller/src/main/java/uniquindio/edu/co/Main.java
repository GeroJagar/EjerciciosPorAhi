package uniquindio.edu.co;

public class Main {
    public static void main(String[] args) {
        BufferOrdenes bufferOrdenes = new BufferOrdenes(16);
        BufferOrdenes bufferPlatosServidos = new BufferOrdenes(16);

        Mesero mesero = new Mesero(bufferOrdenes, bufferPlatosServidos);
        Cocinero cocinero = new Cocinero(bufferOrdenes, bufferPlatosServidos);

        Thread hiloMesero = new Thread(mesero);
        Thread hiloCocinero = new Thread(cocinero);

        hiloMesero.start();
        hiloCocinero.start();
    }
}