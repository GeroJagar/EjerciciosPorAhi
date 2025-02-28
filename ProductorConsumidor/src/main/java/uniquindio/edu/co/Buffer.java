package uniquindio.edu.co;

import java.util.LinkedList;
import java.util.Queue;

class Buffer {
    private final Queue<Integer> queue;
    private final int capacidad;

    public Buffer(int capacidad) {
        this.capacidad = capacidad;
        this.queue = new LinkedList<>();
    }

    public synchronized void producir(int dato) throws InterruptedException {
        while (queue.size() == capacidad) {
            wait(); // Esperar si el buffer está lleno
        }
        queue.offer(dato); // Agregar dato al buffer
        notify(); // Notificar a los hilos en espera
    }

    public synchronized int consumir() throws InterruptedException {
        while (queue.isEmpty()) {
            wait(); // Esperar si el buffer está vacío
        }
        int dato = queue.poll(); // Consumir dato del buffer
        notify(); // Notificar a los hilos en espera
        return dato;
    }
}