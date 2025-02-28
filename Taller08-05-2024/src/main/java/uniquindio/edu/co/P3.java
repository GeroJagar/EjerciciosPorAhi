package uniquindio.edu.co;

//José Gerónimo Jaramillo Garzón

public class P3 implements Runnable {
    private final Buffer buffer;
    private final Consumidor consumer;
    char [] caracteres;

    public P3(Buffer buffer, char[] caracteres, Consumidor consumer) {
        this.buffer = buffer;
        this.caracteres = caracteres;
        this.consumer = consumer;
    }

    @Override
    public void run() {
        try {
                System.out.println("P3 se ejecuta");
                for (int i = 0; i < caracteres.length; i++) {
                    if(consumer.isPalabraCompleta() == false) {
                        if (isNumero(caracteres[i]) == true) {
                            buffer.ponerChar(caracteres[i]);
                            System.out.println("P3: " + caracteres[i]);
                        }
                    }else{
                        return;
                    }
                    Thread.sleep(250);
                }

        } catch (InterruptedException e){

        }

    }

    public static boolean isNumero(char caracter) {
        return caracter >= '0' && caracter <= '9';
    }
}
