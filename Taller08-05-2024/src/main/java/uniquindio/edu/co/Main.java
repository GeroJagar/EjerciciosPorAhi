package uniquindio.edu.co;

//José Gerónimo Jaramillo Garzón

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        char[] caracteres = {
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                '0', '1','2','3','4','5','6','7','8','9', '@', '#', '-', '*', '$',
                '(', ')', '/', '%', '+', ':', ';'
        };
        Buffer buffer = new Buffer();
        Consumidor consumidor = new Consumidor(buffer);
        Thread c = new Thread(consumidor);
        Thread p1 = new Thread (new P1(buffer, caracteres, consumidor)) ;
        Thread p2 = new Thread (new P2(buffer, caracteres, consumidor));
        Thread p3 = new Thread (new P3(buffer, caracteres, consumidor));
        Thread p4 = new Thread (new P4(buffer, caracteres, consumidor));
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        c.start();
    }
}