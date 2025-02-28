package uniquindio.edu.co;

//José Gerónimo Jaramillo Garzón

public class P2 implements Runnable {
    private final Buffer buffer;
    private final Consumidor consumer;
    char [] caracteres;

    public P2(Buffer buffer, char[] caracteres, Consumidor consumer) {
        this.buffer = buffer;
        this.caracteres = caracteres;
        this.consumer = consumer;
    }

    @Override
    public void run() {
        try {
                System.out.println("P2 se ejecuta");
                for (int i = 0; i < caracteres.length; i++) {
                    if(consumer.isPalabraCompleta() == false) {
                        if (isConsonante(caracteres[i]) == true) {
                            buffer.ponerChar(caracteres[i]);
                            System.out.println("P2: " + caracteres[i]);
                        }
                    }else {
                        return;
                    }
                    Thread.sleep(150);
                }
        } catch (InterruptedException e){

        }

    }

    public static boolean isConsonante(char caracter) {
        caracter = Character.toLowerCase(caracter);
        if (!isVocal(caracter) && caracter >= 'a' && caracter <= 'z') {
            return true;
        }else {
            return false;
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
