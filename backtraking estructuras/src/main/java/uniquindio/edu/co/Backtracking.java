//─────▄████▀█▄
//        ───▄█████████████████▄
//    ▄    ─▄█████.▼.▼.▼.▼.▼.▼▼▼▼
//         ██████
//         ██       @autor Geronimo
//         ██████
//        ▄███████▄.▲.▲▲▲▲▲▲▲▲
//        ████████████████████▀▀
package uniquindio.edu.co;

import java.util.ArrayList;
import java.util.List;

public class Backtracking {


    public static void main(String[] args) {
//
//        System.out.println(sumaPrimerosNumeros(5));
//
//        matrushka(10);
//
//        ArrayList<Integer> lista = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            lista.add(i);
//        }
//        recorrerArregloRecursivo(lista, 0);
        int[][] matriz = {
                {11, 23, 45},
                {77, 24, 30},
                {2, 7, 32}
        };
//        recorrerMatrizRecursiva(matriz, 0, 0);
       volverMatrizTranspuestaRecursiva(matriz, 0, 0);
//        recorrerMatrizDiagonalRecursiva(matriz,0,0);
//
//
//        Suma recursiva divide y vencerás
//
//        int[][] matriz = {
//                {11, 23},
//                {77, 24}
//        };
//
//        int sumaElementosMatriz = sumarElementosMatriz(matriz, 0, matriz.length - 1, 0, matriz[0].length - 1);
//        System.out.println("La suma de los elementos de la matriz es: "+sumaElementosMatriz);
//
//        Permutación Backtracking
        int[] nums = {100, 200, 300, 400, 500, 600, 700, 800};
//        List<List<Integer>> permutacion = new ArrayList<>();
//        permutacion(nums, new ArrayList<>(), permutacion, new boolean[nums.length]);
//
//        for (List<Integer> perm : permutacion) {
//            System.out.println(perm);
//      }
//
//        TALLER EJERCICIOS BAJA COMPLEJIDAD
//        1)
//        System.out.println(factorial(7));
//        2)
//        System.out.println(fibonacci(4));
//        3)
//        System.out.println(sumarDigitos(11));
//        4)
//        System.out.println(potencia(2,4,0));
//        5)
//        nosMorimos(10, 900);
//        6)
//        System.out.println(contDigitos(1234567891, 0));
//        7)
//        String x = ".arbalap anu ritrevni arap ovisrucer odotéM";
//        System.out.println(invertirString(x, x.length()-1));
//        8)
//        System.out.println(sumaN(4));
//        9)
//        System.out.println(hallarMCDEuclides(120,156));
//        10)
//        String x = "rapar";
//        System.out.println(verificarPalindromo(x,0,x.length()-1));
//        11)
//        System.out.println(multiplicarSumando(2,5,0));
//        12)
//        System.out.println(padovan(10));
//        13)
//        System.out.println(conversionDecimalBinaria(8,""));
//        14)
//        String f = "If i";
//        char u = ' ';
//        String e = "";
//        System.out.println(eliminarCaracter(f, u, contarApariciones(f,u,0,0),0,0,e));
//        15)
//        String[] words = {"a", "b", "c", "d", "e", "f", "g", "h", "A"};
//        System.out.println(contarAparicionesArreglo(words, "a"));
//        16)

//        TRABAJO EN CLASE BUSQUEDA BINARIA
//        System.out.println(busquedaBinaria(nums, 400));
    }


    /*
                        Metodo recursivo basico para la suma de los primeros numeros de n ejemplo: 5 en este metodo tendria resultado 15
                        asi seria la tabla del resultado
                        1 + 2 = 3
                        3 + 3 = 6
                        6 + 4 = 10
                        10 + 5 = 15

                        Parámetros: int n (El numero al cual se requiere hacer la suma)

                        Caso base: n = 1 (Cuando n llega a 1 significa que ya no se puede devolver más, por lo que empezaría con la suma  de la pila)

                        Tipo de recursividad: Directa, Lineal y No de Cola.
    */

    private static int sumaPrimerosNumeros(int n){
        if (n == 1) return 1;
        else return n + sumaPrimerosNumeros(n - 1);
    }
    /*
                        Método recursivo para explicar el funcionamiento de las pilas de los métodos recursivos de tipo No de cola, mediante el
                        uso de los System.out.println(), haciendo que los que contengan el mensaje "Abriendo muñeca "+n se ejecuten primero de forma
                        descendente, despues llega al caso base que es 0 y ejecuta el siguiente mensaje:, "Se llego a la
                        última muñeca", y se devuelva en la pila, mostrando en orden ascendente el siguiente mensaje "Cerrando muñeca "+n

                        Parámetros: int n (Esta vendria a ser el número de muñecas que se necesitan abrir)
                        caso base: n-1 = 0 (Esto significa que ya no hay más muñecas a las cuales abrir)

                        Tipo de recursividad: Directa, Lineal y No de Cola.
     */

    private static void matrushka(int n){
        if(n == 0){
            System.out.println("Se llego a la ultima muñeca");
        }else{
            System.out.println("Abriendo muñeca "+n);
            matrushka(n-1);
            System.out.println("Cerrando muñeca "+n);
        }
    }

    /*
                        Método recursivo para recorrer un arreglo de tipo ArrayList (tengo que probar si funciona tambien
                        con otros tipos de datos que no sea Integer, pero como no opero nada del arreglo supongo que si funciona).
                        Funciona por medio de un índice que va a recorrer el arreglo hasta que llegue al límite del mismo.

                        Parámetros: ArrayList<Integer> lista, int indice (El arraylist a recorrer, e indice que su nombre
                        da explicación).

                        Caso base: indice = tamaño del arreglo.

                        Tipo de recursividad: Directa, Lineal y de Cola.
     */

    private static void recorrerArregloRecursivo(ArrayList<Integer> lista, int indice){
        if (indice == lista.size()){
            System.out.println("Fin del arreglo");
        }else{
            System.out.println("Posición "+ lista.indexOf(indice));
            recorrerArregloRecursivo(lista, indice+1);
        }
    }
    /*
                        Método recursivo para recorrer una matriz de int, igual que el arreglo pero con matriz no hay mayor ciencia

                        Parámetros: int[][] matriz, int i, int j (la matriz a recorrer, i indice, j sub indice de la matriz, i y j para
                        recorrer toda la matriz)

                        Caso base: Cuando i llegue al limite del tamaño de la matriz.

                        Tipo de recursividad: Directa, Lineal y de Cola.
     */

    private static void recorrerMatrizRecursiva(int[][] matriz, int i, int j){

        if (i >= matriz.length){
            System.out.println("Fin de la matriz");
        } else {
            if(j < matriz[i].length) {
                System.out.println("Posición en la matriz: (" + i + "," + j + ")");
                recorrerMatrizRecursiva(matriz, i, j+1);
            }else{
                recorrerMatrizRecursiva(matriz, i+1, 0);
            }
        }
    }

    private static void volverMatrizTranspuestaRecursiva(int[][] matriz, int i, int j){
        if (i >= matriz.length){
            return;
        } else {
            if(j < matriz[i].length) {
                System.out.println(matriz[j][i]);
                volverMatrizTranspuestaRecursiva(matriz, i, j+1);
            }else{
                volverMatrizTranspuestaRecursiva(matriz, i+1, 0);
            }
        }
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int elemento : fila) {
                System.out.print(elemento + "\t"); // Tabulación para mejor visualización
            }
            System.out.println(); // Salto de línea al final de cada fila
        }
    }

    /*
                        Lo mismo que el de arriba pero solo imprime cuando i es igual a j
                        Mismos parámetros, caso base y tipo de recursividad.
     */

    private static void recorrerMatrizDiagonalRecursiva(int[][] matriz, int i, int j){
        if (i >= matriz.length){
            System.out.println("Fin de la matriz");
        } else {
            if(j < matriz[i].length) {
                if(i == j) {
                    System.out.println("Posición en la matriz: (" + i + "," + j + ")");
                    recorrerMatrizDiagonalRecursiva(matriz, i, j + 1);
                }else{
                    recorrerMatrizDiagonalRecursiva(matriz, i, j + 1);
                }
            }else{
                j = 0;
                recorrerMatrizDiagonalRecursiva(matriz, i+1, j);
            }
        }
    }

    /*

                                                DIVIDE Y VENCERÁS

    Método recursivo para sumar los elementos de una matriz aplicando el paradigma divide y vencerás, haciendo diviciones de 4 de la matriz
    hasta obtener un elemento o se salga de los indices, si los indices estan fuera de la matriz, retorná 0, en el caso que la matriz ó
    submatriz sea de un solo elemento, retornará dicho elemento para ser sumado después en la pila.

        Párametros: int[][] matriz, int fInicio, int fFin, int cInicio, int cFin.

        Casos base:
        1) Cuando los indices se salgan de la matriz.
        2) Cuando los indices de fila sean iguales, y los indices de columna sean iguales.

        Tipo de recursividad: Directa, Lineal, No de Cola.
     */

    public static int sumarElementosMatriz(int[][] matriz, int fInicio, int fFin, int cInicio, int cFin) {
        if (fInicio == fFin && cInicio == cFin) {
            return matriz[fInicio][cInicio];
        }
        if (fInicio > fFin || cInicio > cFin) {
            return 0;
        }

        int fMedia = (fInicio + fFin) / 2;
        int cMedia = (cInicio + cFin) / 2;

        int suma1 = sumarElementosMatriz(matriz, fInicio, fMedia, cInicio, cMedia);
        int suma2 = sumarElementosMatriz(matriz, fInicio, fMedia, cMedia + 1, cFin);
        int suma3 = sumarElementosMatriz(matriz, fMedia + 1, fFin, cInicio, cMedia);
        int suma4 = sumarElementosMatriz(matriz, fMedia + 1, fFin, cMedia + 1, cFin);

        return suma1 + suma2 + suma3 + suma4;
    }

    /*

                                                TALLER EJERCICIOS BAJA COMPLEJIDAD (1-10)

     1) Metodo recursivo para hallar el factorial de un numero n.

        Parámetros: int n (El numero al cual se requiere hacer el factorial).

        Caso base: n = 1 (Cuando n llega a 1 significa que ya no se puede devolver más, por lo que empezaría con la multiplicación  de la pila)

        Tipo de recursividad: Directa, Lineal y No de Cola.
     */
    private static int factorial(int n){
        if (n == 1) return 1;
        else return n * factorial(n - 1);
    }

    /*
    2) Método recursivo para calcular el n-ésimo termino de la sución de Fibonacci

       Parámetros: int n (el numero de iteraciones de la suceción fibonacci)

       Casos base:
       1) n <= 0.
       2) n == 1.

       Tipo de recursividad: Directa, multiple, No de Cola.
     */
    private static int fibonacci(int n){
        if (n <= 0){
            return 0;
        }else{
            if(n==1){
                return 1;
            }else {
                return fibonacci(n - 1) + fibonacci(n - 2);
            }
        }
    }
    /*
    3) Método recursivo para sumar los digitos de un numero, asegurandose que siempre que siempre funcione incluso con números negativos

       Parámetros: int n (número el cual se va a sumar sus digitos)

       Caso base: n = 0.

       Tipo de recursividad: Directa, Lineal, No de Cola.
     */
    private static int sumarDigitos(int n){
        if (n == 0) {
            return 0;
        }else{
         return Math.abs(n % 10) + sumarDigitos(n / 10);
        }
    }
    /*
    4) Método recursivo para hallar la potencia de un número (Base^Exponente)

     Parámetros: int base, int exponente, int cont (se necesita el contador para saber cuantas veces se debe iterar)

     Caso base: cont = exponente.

     Tipo de recursividad: Directa, Lineal, No de Cola.
     */
    private static int potencia(int base, int exponente, int cont){
        if (cont == exponente) {
            return 1;
        }else{
            return base*(potencia(base, exponente, cont+1));
        }
    }
    /*
    5) Método recursivo para hacer una cuenta regresiva (yo le meti el .sleep de mera alegría porque estaba muy sencilla esta vaina)

    Parámetros:  int n, int sleep (el sleep es para jugar con la función no es parte del problema)

    Caso base: n = 0.

    Tipo de recursividad: Lineal, Directa, Cola.
     */
    private static void nosMorimos(int n, int sleep){
        if(n == 0){
            try{
                Thread.sleep(sleep);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(n+" (NOS MATAMOS)");
        }else{
            try{
                Thread.sleep(sleep);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(n);
            nosMorimos(n-1, sleep-70);
        }
    }
    /*
    6) Método recursivo para contar la cantidad de digitos de un numero (¿en serio?)

    Parámetros: int n, int cont.

    Caso base: n = 0.

    Tipo de recursividad: Directa, Lineal, Cola.
     */
    private static int contDigitos(int n, int cont){
        if(n == 0){
            return cont;
        }else{
            return contDigitos(n/10, cont+1);
        }
    }
    /*
    7) .arbalap anu ritrevni arap ovisrucer odotéM

    Parámetros: String palabra, int i (indice para invertir)

    Caso base: i < 0.

    Tipo de recursividad: Directa, Lineal, No de Cola.
     */
    public static String invertirString(String a, int i){
        if (i < 0){
            return "";
        }else {
            return a.charAt(i) + invertirString(a, i-1);
        }
    }
    /*
    8) Método recursivo para sumar los primero N número (la dificultad radica en la cantidad?)

    Parámetros: int n.

    Caso base: n = 0.

    Tipo de recursividad: Directa, Lineal, No de Cola
     */
    private static int sumaN(int n) {
        if (n == 0) return 0;
        else return n + sumaN(n - 1);
    }
    /*
    9) Método recursivo para hallar el Máximo común divisor(MCD) de dos números, usando algoritmo de Euclides.

    Parámetros: int n, int m.

    Caso base: n = 1 && m == 1

    Tipo de recursividad: Directa, Lineal, Cola.
     */
    private static int hallarMCDEuclides(int a, int b){
        if (a < b ){
            return hallarMCDEuclides(b, a);
        }else {
            if (b == 0) {
                return a;
            } else {
                return hallarMCDEuclides(b, a % b);
            }
        }
    }
    /*
    10) Método recursivo para hallar una palabra palindroma.

    Parámetros: String x, int i, int j

    Casos base
    1) i >= j
    2) x.charAt(i) != x.charAt(j)

    Tipo de recursividad: Directa, Lineal, Cola.
     */
    private static boolean verificarPalindromo(String x, int i, int j){
        if (i >= j){
            return true;
        }else if (x.charAt(i) != x.charAt(j) ){
            return false;
        }else return verificarPalindromo (x, i+1, j-1);
    }
    /*
                    EJERCICIOS DE FOKIN MEDIA COMPLEJIDAD!!!! (11-20)
     11)Producto de dos números usando sumas (¿en serio esto es complejidad media?)

     Parámetros : int n, int x, int cont (n será el número que contemos x veces, cont controlará las iteraciones)

     Caso base: cont = x

     Tipo de recursividad: Directa, Lineal, No de Cola.
     */
    private static int multiplicarSumando(int n, int x, int cont){
        if (cont == x){
            return 0;
        }else {
            return n + multiplicarSumando(n, x, cont+1);
        }
    }
    /*
    12) Método recursivo serie de padovan

    Parámetros: int n

    Caso base: n <= 2, n < 0.

    Tipo de recursividad: Directa, Lineal, No de Cola.
     */
    private static int padovan(int n){
        if (n < 0){
            return 0;
        }else{
            if(n <= 2){
                return 1;
            }else {
                return padovan(n - 2) + padovan(n - 3);
            }
        }
    }
    /*
    13) Método recursivo para convertir un numero decimal a binario.

    Parámetros: int n.

    Caso base: Directa, Lineal, No de Cola.
     */
    private static int conversionDecimalBinaria(int n, String residuo){
        if(n == 1){
            residuo = "1" + residuo;
            return Integer.parseInt(residuo);
        }else if( n == 0){
            residuo = "0" + residuo ;
            return Integer.parseInt(residuo);
        }else{
            residuo = n % 2 + residuo ;
            return conversionDecimalBinaria(n/2 , residuo);
        }
    }
    /*
    14)Método recursivo para eliminar un caracter especifico de un String usando el paradigma "Divide y vencerás"(supongo)
    para contar el numerod e apariciones de ese carácter en la cadena.

    Parámetros: String c(cadena a modificar), char b(carácter que se quiere eliminar), int n(número de apariciones de ese carácter
    en la cadena), int cont(cuenta cuantas veces se ha borrado ese carácter de la cadena), int i(indice iterador de la cadena), String a(nueva cadena).

    Casos base:
    1) n = 0 (el carácter que se quiere eleminar de la cadena no esta en la misma).
    2) cont = n (significa que ya se eliminó todas las apariciones de ese carácter).
     */

    private static String eliminarCaracter(String c, char b,int n, int cont, int i, String a){
        if (n == 0){
            return c;
        }else{
            if (cont == n) {
                return a + terminarPalabra(c, i);
            } else if (Character.toLowerCase(c.charAt(i)) == Character.toLowerCase(b) && i < c.length()) {
                return eliminarCaracter(c, b, n, cont + 1, i + 1, a);
            } else if (i< c.length()){
                a = a + c.charAt(i);
                return eliminarCaracter(c, b, n, cont, i + 1, a);
            }
            return a;
        }
    }

    private static String terminarPalabra(String x, int i){
        if (x.length() == i){
            return "";
        }else{
            return x.charAt(i) + terminarPalabra(x, i+1);
        }
    }
    private static int contarApariciones(String x, char b, int i, int n){
        if (i == x.length()){
            return n;
        }else if (Character.toLowerCase(x.charAt(i)) == Character.toLowerCase(b)){
            return contarApariciones(x, b, i+1, n+1);
        }else{
            return contarApariciones(x, b, i+1, n);
        }
    }
    /*
    15) Método recursivo para contar la cantidad de veces que un elemento se repite en un arreglo
     */
    private static int contarAparicionesArreglo(String[] arreglo, String elemento){
        return contarAparicionesArreglo(arreglo, elemento, 0, 0);
    }
    private static int contarAparicionesArreglo(String[] arreglo, String elemento,int cont, int i){
        if (i == arreglo.length){
            return cont;
        }else if (arreglo[i].toLowerCase().equals(elemento.toLowerCase()) == true ){
            return contarAparicionesArreglo(arreglo, elemento, cont+1, i+1);
        }else {
            return contarAparicionesArreglo(arreglo, elemento, cont, i+1);
        }
    }
    /*
    16) QuickSort
     */
    private static void quickSort(int[] array){
        quickSort(array, 0, array.length-1, array[array.length-1]);
    }
    private static void quickSort(int[] array, int inicio, int fin, int pivote){
        if (array[inicio] <= pivote &&  inicio < fin){

        }
    }
    /*
                    TRABAJO EN CLASE BUSQUEDA BINARIA

     */
    private static int busquedaBinaria(int[]arreglo, int x){
        return busquedaBinaria(arreglo, x, 0, arreglo.length-1);
    }
    private static int busquedaBinaria(int[] arreglo,int x, int inicio, int fin){
        if(inicio <= fin) {
            int mitad = (inicio + fin) / 2;
            if (arreglo[mitad] == x) {
                return x;
            } else if (x < arreglo[mitad]) {
                return busquedaBinaria(arreglo, x, inicio, mitad);
            } else {
                return busquedaBinaria(arreglo, x, mitad + 1, fin);
            }
        }else return 0;
    }
    /*
                backtracking?
     */

    private static void permutacion(int[] nums, List<Integer> actual, List<List<Integer>> result, boolean[] used) {
        if (actual.size() == nums.length) {
            result.add(new ArrayList<>(actual));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                actual.add(nums[i]);
                permutacion(nums, actual, result, used);
                actual.remove(actual.size() - 1);
                used[i] = false;
            }
        }
    }
}
/*                              TAREAS
        Consultas que es divide y venceras en la programación.

Divide y venceras en la programación, se refiere a descomponer problemas complejos en problemas mucho
más sencillos, resolviendolos de forma recursiva. Luego combinar la soluciones de estos subproblemas para
así obtener la solucion al problema complejo u original.
 */