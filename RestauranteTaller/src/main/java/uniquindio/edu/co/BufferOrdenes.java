package uniquindio.edu.co;

import java.util.concurrent.ArrayBlockingQueue;

public class BufferOrdenes {
    private final ArrayBlockingQueue<Orden> buffer;
    private final ArrayBlockingQueue<Orden> bufferServido;

    public BufferOrdenes(int tamano) {
        buffer = new ArrayBlockingQueue<>(tamano);
        bufferServido = new ArrayBlockingQueue<>(tamano);
    }

    public synchronized void ponerOrden(Orden orden) throws InterruptedException {
        buffer.put(orden);
        notify(); // Notificar a los hilos en espera
    }

    public synchronized Orden tomarOrden() throws InterruptedException {
        while (buffer.isEmpty()) {
            wait(); // Esperar si el buffer está vacío
        }
        return buffer.take();
    }

    public synchronized void ponerOrdenServida(Orden orden) throws InterruptedException {
        bufferServido.put(orden);
        notify(); // Notificar a los hilos en espera
    }

    public synchronized Orden tomarOrdenServida() throws InterruptedException {
        while (bufferServido.isEmpty()) {
            wait(); // Esperar si el buffer de órdenes servidas está vacío
        }
        return bufferServido.take();
    }
}
