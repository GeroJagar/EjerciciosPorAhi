package uniquindio.edu.co.punto1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Punto1Main {

    public static void main(String[] args) throws IOException {
        char[] caracteres = cargarLetras();
        Buffer buffer = new Buffer();
        Consumer consumidor = new Consumer(buffer);
        Thread c = new Thread(consumidor);
        Thread p1 = new Thread (new p1(buffer, caracteres, consumidor)) ;
        Thread p2 = new Thread (new p2(buffer, caracteres, consumidor));
        p1.start();
        p2.start();
        c.start();

        try {
            p1.join();
            p2.join();
            c.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Programa terminado");

    }

    public static char[] cargarLetras() throws FileNotFoundException, IOException {
        char[] caracteres = new char[87];
        ArrayList<Character> contenido = leerArchivo("src/main/java/uniquindio/edu/co/punto1/letras.txt");

        for (int i = 0; i < contenido.size() && i < caracteres.length; i++) {
            caracteres[i] = contenido.get(i);
        }

        return caracteres;
    }

    public static ArrayList<Character> leerArchivo(String ruta) throws IOException {
        ArrayList<Character> contenido = new ArrayList<>();
        FileReader fr = new FileReader(ruta);
        BufferedReader bfr = new BufferedReader(fr);
        int c;
        while ((c = bfr.read()) != -1) {  // Leer carácter por carácter
            contenido.add((char) c);
        }
        bfr.close();
        fr.close();
        return contenido;
    }
}
