package uniquindio.edu.co.punto1;

public class p1 implements Runnable {

    private final Buffer buffer;
    private final Consumer consumer;
    char[] caracteres;

    public p1(Buffer buffer, char[] caracteres, Consumer consumer) {
        this.buffer = buffer;
        this.caracteres = caracteres;
        this.consumer = consumer;
    }

    @Override
    public void run() {
        System.out.println("p1 se ejecuta");
        while (!consumer.isPalabraCompleta()) {
            try {
                for (char c : caracteres) {
                    if (!consumer.isPalabraCompleta()) {
                        if (isConsonante(c) || isCaracterEspecial(c)) {
                            buffer.ponerChar(c);
                            System.out.println("p1 pone " + c);
                        }
                    } else {
                        return;
                    }
                    Thread.sleep(150);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isCaracterEspecial(char caracter) {
        return caracter == '@' || caracter == '#' || caracter == '/' || caracter == '%' ||
                caracter == '+' || caracter == ':' || caracter == ';' || caracter == '_';
    }

    public boolean isConsonante(char caracter) {
        caracter = Character.toLowerCase(caracter);
        return !isVocal(caracter) && caracter >= 'a' && caracter <= 'z';
    }

    public static boolean isVocal(char caracter) {
        caracter = Character.toLowerCase(caracter);
        return caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u';
    }
}
