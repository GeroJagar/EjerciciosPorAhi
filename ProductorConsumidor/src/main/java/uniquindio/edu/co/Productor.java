package uniquindio.edu.co;

class Productor implements Runnable {
    private final Buffer buffer;

    public Productor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                buffer.producir(i); // Producir datos
                System.out.println("Productor produce: " + i);
                Thread.sleep(1000); // Simular producción
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
