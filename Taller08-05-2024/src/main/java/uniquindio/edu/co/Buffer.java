package uniquindio.edu.co;

import java.util.HashSet;
import java.util.Set;

public class Buffer {
    private char buffer[] = new char[12];
    private int siguiente = 0;
    // Flags para saber el estado del buffer
    private boolean estaLlena = false;
    private boolean estaVacia = true;
    private Set<Character> letrasEnviadas = new HashSet<>();

    public synchronized void ponerChar(char c) throws InterruptedException {
        while (estaLlena || letrasEnviadas.contains(c)) {
            try {
                wait(); // Se sale cuando estaLlena cambia a false
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Añade una letra en el primer lugar disponible
        buffer[siguiente] = c;
        letrasEnviadas.add(c);
        // Cambia al siguiente lugar disponible
        siguiente++;
        // Comprueba si el buffer está lleno
        if (siguiente == 6)
            estaLlena = true;
        estaVacia = false;
        // Notificar al consumidor que hay letras disponibles
        notify();
    }

    public synchronized char tomarChar() throws InterruptedException {
        while (estaVacia) {
            try {
                wait(); // Espera hasta que haya elementos en el buffer
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Verifica si hay elementos disponibles en el buffer
        if (siguiente > 0) {
            // Decrementa la cuenta, ya que va a consumir una letra
            siguiente--;
            char c = buffer[siguiente];
            // El buffer no puede estar lleno, porque acabamos
            // de consumir
            estaLlena = false;
            // Notifica al productor que hay espacio disponible
            notify();
            // Devuelve la letra al thread consumidor
            return c;
        } else {
            // Si no hay elementos disponibles, puedes manejar este caso según tu lógica
            // Por ejemplo, lanzar una excepción o devolver un valor predeterminado
            return '\0'; // Devuelve un carácter nulo por ahora
        }
    }
}
