package uniquindio.edu.co.punto1;

public class p2 implements Runnable {

    private final Buffer buffer;
    private final Consumer consumer;
    char[] caracteres;

    public p2(Buffer buffer, char[] caracteres, Consumer consumer) {
        this.buffer = buffer;
        this.caracteres = caracteres;
        this.consumer = consumer;
    }

    @Override
    public void run() {
        System.out.println("p2 se ejecuta");
        while (!consumer.isPalabraCompleta()) {
            try {
                for (char c : caracteres) {
                    if (!consumer.isPalabraCompleta()) {
                        if (isVocal(c) || isNumero(c)) {
                            buffer.ponerChar(c);
                            System.out.println("p2 pone " + c);
                        }
                    } else {
                        return;
                    }
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isNumero(char caracter) {
        return caracter >= '0' && caracter <= '9';
    }

    public static boolean isVocal(char caracter) {
        caracter = Character.toLowerCase(caracter);
        return caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u';
    }
}
