package uniquindio.edu.co;

//José Gerónimo Jaramillo Garzón

public class P1 implements Runnable {
    private final Buffer buffer;
    private final Consumidor consumer;
    char [] caracteres;

    public P1(Buffer buffer, char[] caracteres, Consumidor consumer) {
        this.buffer = buffer;
        this.caracteres = caracteres;
        this.consumer = consumer;
    }

    @Override
    public void run() {
        try {
                System.out.println("P1 se ejecuta");
                for (int i = 0; i < caracteres.length; i++) {
                    if (consumer.isPalabraCompleta() == false) {
                        if (isVocal(caracteres[i]) == true) {
                            buffer.ponerChar(caracteres[i]);
                            System.out.println("P1: " + caracteres[i]);
                        }
                    }else{
                        return;
                    }
                    Thread.sleep(100);
                }

        }catch (InterruptedException e) {

        }
    }

    public static boolean isVocal(char caracter) {
        caracter = Character.toLowerCase(caracter);
            if (caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u' ) {
                return true;
            }else {
                return false;
            }
    }
}
