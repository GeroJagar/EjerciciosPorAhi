package uniquindio.edu.co;

//José Gerónimo Jaramillo Garzón

public class P4 implements Runnable {
    private final Buffer buffer;
    private final Consumidor consumer;
    char [] caracteres;

    public P4(Buffer buffer, char[] caracteres, Consumidor consumer) {
        this.buffer = buffer;
        this.caracteres = caracteres;
        this.consumer = consumer;
    }

    @Override
    public void run() {
        try {
                System.out.println("P4 se ejecuta");
                for (int i = 0; i < caracteres.length; i++) {
                        if(consumer.isPalabraCompleta() == false) {
                            if (isCaracterEspecial(caracteres[i]) == true) {
                                buffer.ponerChar(caracteres[i]);
                                System.out.println("P4: " + caracteres[i]);
                            }
                        }else{
                            return;
                        }
                    Thread.sleep(250);
                }
        } catch (InterruptedException e){

        }

    }

    public static boolean isCaracterEspecial(char c) {
        return c == '@' || c == '#' || c == '-' || c == '*' || c == '$' || c == '(' ||
                c == ')' || c == '/' || c == '%' || c == '+' || c == ':' || c == ';';
    }
}
