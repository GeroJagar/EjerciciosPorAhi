package uniquindio.edu.co;

class Consumidor implements Runnable {
    private final Buffer buffer;

    public Consumidor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                int dato = buffer.consumir(); // Consumir datos
                System.out.println("Consumidor consume: " + dato);
                Thread.sleep(2000); // Simular consumo
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
