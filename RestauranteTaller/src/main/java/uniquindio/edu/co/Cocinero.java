package uniquindio.edu.co;

import java.util.Random;
import java.util.concurrent.TimeUnit;

class Cocinero implements Runnable {
    private final BufferOrdenes bufferOrdenes;
    private final BufferOrdenes bufferPlatosServidos;
    private final Random random = new Random();

    public Cocinero(BufferOrdenes bufferOrdenes, BufferOrdenes bufferPlatosServidos) {
        this.bufferOrdenes = bufferOrdenes;
        this.bufferPlatosServidos = bufferPlatosServidos;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Tomar una orden del buffer de órdenes
                Orden orden = bufferOrdenes.tomarOrden();
                System.out.println("Cocinero: Tomando orden #" + orden.getNumeroOrden() + " para preparar");

                // Simular tiempo de preparación del plato
                TimeUnit.SECONDS.sleep(random.nextInt(4) + 2); // Esperar entre 2 y 5 segundos

                // Poner el plato servido en el buffer de platos servidos
                bufferPlatosServidos.ponerOrdenServida(orden);
                System.out.println("Cocinero: Plato preparado para la orden #" + orden.getNumeroOrden());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
