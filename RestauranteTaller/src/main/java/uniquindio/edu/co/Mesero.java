package uniquindio.edu.co;

import java.util.Random;
import java.util.concurrent.TimeUnit;

class Mesero implements Runnable {
    private final BufferOrdenes bufferOrdenes;
    private final BufferOrdenes bufferPlatosServidos;
    private final Random random = new Random();
    private int numeroOrden = 1;

    public Mesero(BufferOrdenes bufferOrdenes, BufferOrdenes bufferPlatosServidos) {
        this.bufferOrdenes = bufferOrdenes;
        this.bufferPlatosServidos = bufferPlatosServidos;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Generar una nueva orden
                Orden orden = Orden.generarOrden(numeroOrden++);
                System.out.println("Mesero: Tomando orden #" + orden.getNumeroOrden());

                // Poner la orden en el buffer de órdenes
                bufferOrdenes.ponerOrden(orden);

                // Simular tiempo entre órdenes
                TimeUnit.SECONDS.sleep(random.nextInt(3) + 1); // Esperar entre 2 y 5 segundos

            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
