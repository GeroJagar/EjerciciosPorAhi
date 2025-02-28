package uniquindio.edu.co;

public class MajoPilas {
    public static void main(String[] args) {
        System.out.println(potencia(3,4));
    }
    public static int potencia(int base, int exponente) {
        if (exponente == 0) return 1; // Caso base

        int mitad = potencia(base, exponente / 2); // Llamada recursiva reduciendo a la mitad

        if (exponente % 2 == 0) return mitad * mitad; // Si el exponente es par
        else return base * mitad * mitad; // Si el exponente es impar
    }
}
