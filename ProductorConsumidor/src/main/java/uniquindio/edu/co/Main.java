package uniquindio.edu.co;

public class Main {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(5); // Crear un buffer de capacidad 5

        Thread productorThread = new Thread(new Productor(buffer));
        Thread consumidorThread = new Thread(new Consumidor(buffer));

        productorThread.start();
        consumidorThread.start();
    }
}