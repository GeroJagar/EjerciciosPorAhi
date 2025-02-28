package org.example;

import java.util.ArrayList;
public class Main {

    //─────▄████▀█▄
//        ───▄█████████████████▄
//    ▄    ─▄█████.▼.▼.▼.▼.▼.▼▼▼▼
//         ██████
//         ██       @autor Geronimo
//         ██████
//        ▄███████▄.▲.▲▲▲▲▲▲▲▲
//        ████████████████████▀▀
    public static void main(String[] args) {
//-------------------------------------------------------Trabajo En Clase-------------------------------------------------------------------------------------------
//        String[][] matrix = new String[][]{
//                {"Pollo", "Cuca"},
//                {"Arbol", "Tronco"}
//        };
//        int i = matrix.length - 1;
//        int j = matrix[i].length - 1;
//        int cont = 0;
//
//        int totalVocales = contarVocalesArreglo(matrix, i, j, cont);
//
//        System.out.println(totalVocales);
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 1--------------------------------------------------------------------------------------
//        int n = 19478;
//        int numeroCeros = contarCeros(n);
//        System.out.println(numeroCeros);
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 2--------------------------------------------------------------------------------------
//
//        int[] arregloEnteros = new int[]{
//                20130,48290,1000,40
//        };
//        int n = 0;
//        int cerosArreglo = contarCerosArreglo(arregloEnteros, n);
//
//        System.out.println(cerosArreglo);
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 3--------------------------------------------------------------------------------------
//
//        int[] arregloEnteros = new int[]{
//                    20130,48290,1000,40
//        };
//        int inicio = 0;
//        int fin = arregloEnteros.length-1;
//        System.out.println(recorrerVector(arregloEnteros, inicio, fin));
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 4--------------------------------------------------------------------------------------
//
//        int n = 48912;
//        int x = sumarCifras(n);
//        System.out.println(x);
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 5--------------------------------------------------------------------------------------
//
//        int[] arregloEnteros = new int[]{
//                    4,4,1,4,3,2
//        };
//        int inicio = 0;
//        int fin = arregloEnteros.length-1;
//        int elem = 4;
//        int repeticion = contarElemento(arregloEnteros, inicio, fin, elem);
//        System.out.println(repeticion);
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 6--------------------------------------------------------------------------------------
//
//        ArrayList<String> StrawberryFieldsForever = new ArrayList<>();
//        int inicio = 0;
//
//        String x1 = "let me take you down";
//        String x2 = "because im going to";
//        String x3 = "Strawberry fields forever";
//
//        StrawberryFieldsForever.add(x1);
//        StrawberryFieldsForever.add(x2);
//        StrawberryFieldsForever.add(x3);
//
//        System.out.println(recorrerArray(StrawberryFieldsForever, inicio));
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 9--------------------------------------------------------------------------------------
//
//        int[][] matriz = {
//                {11, 23, 45, 20},
//                {77, 24, 30, 1},
//                {2, 7, 32, 3}
//        };
//        int i = 0;
//        int j = 0;
//        int sumaDiagonal = sumarDiagonalMatriz(matriz, i, j);
//        System.out.println(sumaDiagonal);
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 10--------------------------------------------------------------------------------------
//
//        String palabra = "racsO nohJ a oidO";
//        int i = palabra.length()-1;
//        System.out.println(invertirPalabra(palabra, i));
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 11--------------------------------------------------------------------------------------
//
//        int[][] matriz = {
//                {11, 23, 45, 20},
//                {77, 24, 30, 1},
//                {2, 7, 32, 3}
//        };
//        int i = 0;
//        int j = matriz[i].length-1;
//
//        int sumaElementosMatriz = sumarElementosMatriz(matriz, i, j);
//        System.out.println(sumaElementosMatriz);
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 12--------------------------------------------------------------------------------------
//
//        int base = 2;
//        int potencia = 3;
//        int recursion = 0;
//
//        int resultado = calcularPotencia(base, potencia, recursion);
//
//        System.out.println(resultado);
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 13--------------------------------------------------------------------------------------
//
//
//        ESTE PUNTO ES EXACTAMENTE EL MISMO DEL PUNTO 11
//
//
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 14--------------------------------------------------------------------------------------
//
//        String[] vectorDeString = {"Como", "va", "jhon", "a", "escribir", "mal su nombre"};
//        int n = vectorDeString.length-1;
//        int primero = 0;
//        String objetivo = "jhon";
//
//        System.out.println(contarElemento2(vectorDeString, n, objetivo, primero));
//
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 15--------------------------------------------------------------------------------------
//
//        double[][] matriz = {
//                {11, 23, 45, 20},
//                {77, 24, 30, 1},
//                {2, 7, 32, 3}
//        };
//        int i = 0;
//        int j = 0;
//        double prom = 0;
//        double suma = 0;
//        double promedioDiagonalMatriz = promedioDiagonalMatriz(matriz, i, j, prom, suma);
//        System.out.println(promedioDiagonalMatriz);
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 16--------------------------------------------------------------------------------------
//
//        int[][] matriz1 = {
//                {11, 23, 45, 20},
//                {77, 24, 30, 1},
//                {2, 7, 32, 3}
//        };
//        int[][] matriz2 = {
//                {0, 1, 1},
//                {1, 0, 1},
//                {1, 1, 0}
//        };
//        int i = 0;
//        int j = 0;
//
//
//        boolean isCuadrada1 = isMatrizSimetrica(matriz1, i, j);
//        boolean isCuadrada2 = isMatrizSimetrica(matriz2, i, j);
//
//
//        System.out.println("La primera matriz es "+isCuadrada1+", la segunda focking matriz es, "+isCuadrada2+"FOCKING JHON OSCAR");
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 17--------------------------------------------------------------------------------------
//
//        int[][] matriz1 = {
//                {11, 23, 45, 20},
//                {77, 24, 30, 1},
//                {2, 7, 32, 3}
//        };
//        int i = 0;
//        int j = 0;
//        int comp = 0;
//        int suma = 0;
//
//        int x = hallarMayorMatriz(matriz1, i, j, comp, suma);
//
//        System.out.println(x);
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 18--------------------------------------------------------------------------------------
//
//        System.out.println(isPotencia(16, 2)+""+isPotencia(81, 3)+isPotencia(50, 10));
//
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 19--------------------------------------------------------------------------------------
//
//        int x1 = 17;
//        int x2 = 18;
//        System.out.println(isPrimo(x1, x1-1)+" "+isPrimo(x2,x2-1));
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 20--------------------------------------------------------------------------------------
//
//
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 21--------------------------------------------------------------------------------------
//
//
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 22--------------------------------------------------------------------------------------
//
//        int i = 0;
//        String palabra = "Blood bath, Rib cage, Soft tail";
//        String consonantes = devolverConsonantes(palabra,i);
//        System.out.println(consonantes);
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 23--------------------------------------------------------------------------------------
//
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 24--------------------------------------------------------------------------------------
//
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 25--------------------------------------------------------------------------------------
//
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 26--------------------------------------------------------------------------------------
//
        int n = 6;
        int d = n-1;
        int suma = 0;
        System.out.println(isNumeroPerfecto(n, d, suma));
    }

    public static boolean isVocal(char c) {
        c = Character.toLowerCase(c);
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        } else {
            return false;
        }
    }

    public static int contarVocales(String p, int i) {
        if (i >= p.length()) {
            return 0;
        } else {
            if (isVocal(p.charAt(i))) {
                return contarVocales(p, ++i) + 1;
            } else {
                return contarVocales(p, ++i);
            }
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------------
    // --------------------------------------------------------------TRABAJO EN CLASE --------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------------------------------------------------------------------
    public static int contarVocalesArreglo(String[][] lista, int i, int j, int cont) {
        if (i < 0 || j < 0) {
            return cont;
        } else {
            cont = contarVocales(lista[i][j], 0) + cont;
            j--;
            if (j < 0) {
                i--;
                if (i >= 0) {
                    j = lista[i].length - 1;
                }
            }
            return contarVocalesArreglo(lista, i, j, cont);
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------------
    // --------------------------------------------------------------Taller Punto 1 --------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------------------------------------------------------------------

    // Cantidad de cifras de un número:
    //Hallar la cantidad de cifras de un número entero. Parámetro: n (número entero)

    public static int contarCeros(int n){
        String x = String.valueOf(n);
        if (n == 0){
            return 0;
        }else if (x.charAt(x.length()-1) == '0'){
            return contarCeros(n/10)+1;
        }else {
            return contarCeros(n/10);
        }
    }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 2--------------------------------------------------------------------------------------
//
//Contar la cantidad de ceros que se encuentran dentro de un arreglo unidimensional de enteros. Parámetros: int arreglo[], int n

    public static int contarCerosArreglo(int[]arreglo, int n){
        if (n >= arreglo.length){
            return 0;
        }else {
            return contarCeros(arreglo[n]) + contarCerosArreglo(arreglo, n+1) ;
        }
    }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 3--------------------------------------------------------------------------------------
//
//El recorrido del arreglo se realiza de inicio a fin. El criterio de parada es cuando inicio y fin son iguales.
//   Parámetros: vector[] (es el arreglo en el cual se encuentran los elementos), inicio (Es el inicio del arreglo),
//   fin (Es el fin del arreglo y su valor es el tamaño del arreglo - 1).

    public static String recorrerVector(int[] vector, int inicio, int fin){
        if (inicio == fin){
            return "Fin del fockign arreglo";
        }else{
            return recorrerVector(vector, inicio+1, fin);
        }
    }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 4--------------------------------------------------------------------------------------
//
//    Sume las cifras de un número. Parámetros: int n
    public static int sumarCifras(int n){
        if (n == 0){
            return 0;
        }else {
            return n % 10 + sumarCifras(n/10);
        }
    }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 5--------------------------------------------------------------------------------------
//
//    Recorra el arreglo desde la primera posición hasta la última posición y retorne el número de veces que se repite el elemento.
//    Parámetros: vector[] (arreglo en el cual se encuentran los elementos), inicio (es el inicio del vector), fin (es el fin del vector),
//    elem (es el número a buscar dentro del arreglo)
    public static int contarElemento(int[] arreglo, int inicio, int fin, int elem){
        if (inicio >= fin){
            return 0;
        }else {
            if (arreglo[inicio] == elem){
                return contarElemento(arreglo, inicio+1, fin, elem)+1;
            }else {
                return contarElemento(arreglo, inicio+1, fin, elem);
            }
        }
    }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 6--------------------------------------------------------------------------------------
//
//Recorrer un array de forma recursiva

    public static String recorrerArray(ArrayList<String> arreglo, int inicio){
        if (inicio >= arreglo.size()-1){
            return "Fin del focking arreglo";
        }else {
            return recorrerArray(arreglo, inicio+1);
        }
    }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 9--------------------------------------------------------------------------------------
//
//Sumar la diagonal de una matriz de forma recursiva.
    public static int sumarDiagonalMatriz(int[][] matriz, int i, int j){
        if (i >= matriz.length){
            return 0;
        } else {
            if(j < matriz[i].length) {
                if (i == j) {
                    return sumarDiagonalMatriz(matriz, i, j + 1) + matriz[i][j];
                } else {
                    return sumarDiagonalMatriz(matriz, i, j+1);
                }
            }else{
                j = 0;
                return sumarDiagonalMatriz(matriz, i+1, j);
            }
        }
    }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 10--------------------------------------------------------------------------------------
//
//Invertir una palabra de forma recursiva
    public static String invertirPalabra(String palabra, int i){
        if (i < 0){
            return "";
        }else {
            return palabra.charAt(i) + invertirPalabra(palabra, i-1);
        }
    }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 11--------------------------------------------------------------------------------------
//
//    Programar un algoritmo recursivo que permita sumar los elementos de una matriz.
//    El recorrido tiene que ser retrocediendo en columnas y avanzando en las filas.
//    Parámetros( matriz, i, j).
    public static int sumarElementosMatriz(int[][] matriz, int i, int j){
        if (i >= matriz.length){
            return 0;
        }else {
            if (j >= 0){
                return sumarElementosMatriz(matriz, i, j-1) + matriz [i][j];
            }else{
                ++i;
                if(i < matriz.length) {
                    j = matriz[i].length - 1;
                    return sumarElementosMatriz(matriz, i, j);
                }else{
                    return 0;
                }
            }
        }
    }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 12--------------------------------------------------------------------------------------
//
//Programar un algoritmo recursivo que permita calcular y retornar cualquier potencia para cualquier número. Por ejemplo base = 2 potencia = 3
    public static int calcularPotencia (int base, int potencia, int recursion){
        if (recursion >= potencia){
            return 1;
        }else {
            return calcularPotencia(base, potencia, recursion+1) * base;
        }
    }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 13--------------------------------------------------------------------------------------
//
//    Programar un algoritmo recursivo que permita sumar la diagonal principal de una matriz. Filas y columnas avanzando.
//    Parámetros( matriz, i, j)
    public static int sumarDiagonalMatriz2(int[][] matriz, int i, int j){
        if (i >= matriz.length){
            return 0;
        } else {
            if(j < matriz[i].length) {
                if (i == j) {
                    return sumarDiagonalMatriz2(matriz, i, j + 1) + matriz[i][j];
                } else {
                    return sumarDiagonalMatriz2(matriz, i, j+1);
                }
            }else{
                j = 0;
                return sumarDiagonalMatriz2(matriz, i+1, j);
            }
        }
    }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 14--------------------------------------------------------------------------------------
//
//    Buscar un número en vector
//    Dado un vector de n enteros,
//    el problema a resolver recursivamente consiste en contar el número  de veces que un valor dado aparece en dicho vector:
    public static int contarElemento2(String[] vector, int n, String objetivo, int primero){
        if (primero >= n){
            return 0;
        }else{
            if(vector[primero].equals(objetivo)){
                return contarElemento2(vector, n, objetivo, primero+1) +1;
            }else {
                return contarElemento2(vector, n, objetivo, primero+1);
            }
        }
    }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 15--------------------------------------------------------------------------------------
//
//    Hallar recursivamente el promedio de los elementos de la diagonal de una matriz cuadrada.
    public static double promedioDiagonalMatriz(double[][] matriz, int i, int j, double prom, double suma){
        if (i >= matriz.length){
            return suma/prom;
        } else {
            if(j < matriz[i].length) {
                if (i == j) {
                    suma += matriz[i][j];
                    prom++;
                }
                return promedioDiagonalMatriz(matriz, i, j+1, prom, suma);
            }else{
                j = 0;
                return promedioDiagonalMatriz(matriz, i+1, j, prom, suma);
            }
        }
    }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 16--------------------------------------------------------------------------------------
//
//    Determinar si una matriz es o no simétrica
//    (es cuadrada y sus elementos por encima de la diagonal son iguales a los elementos de por debajo en forma de espejo)
    public static boolean isMatrizSimetrica(int[][] matriz, int i, int j){
        if (i >= matriz.length){
            return true;
        }else {
            if (j >= matriz[i].length){
                i++;
                j = 0;
                return isMatrizSimetrica(matriz, i, j);
            }else{
                if (matriz[i][j] != matriz[j][i]){
                    return false;
                }else{
                    return isMatrizSimetrica(matriz, i, j+1);
                }
            }
        }
    }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 17--------------------------------------------------------------------------------------
//
//    Retornar el número de la fila de la matriz cuya suma de todos sus elementos sea mayor.
    public static int hallarMayorMatriz(int[][] matriz, int i, int j, int comparador, int suma){
        if (i >= matriz.length){
            return comparador;
        }else{
            if(j < matriz[i].length){
                suma += matriz[i][j];
                return hallarMayorMatriz(matriz, i, j+1, comparador, suma);
            }else{
                if (suma > comparador){
                    comparador = suma;
                }
                return hallarMayorMatriz(matriz, i+1, 0, comparador, 0);
            }
        }
    }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 18--------------------------------------------------------------------------------------
//
//    Escribir una función que reciba 2 enteros n y b y devuelva true si n es potencia de b.
//    Ej. 16 es potencia de 2, 64 es potencia de 4, 50 no es potencia de 10.
    public static boolean isPotencia (int n, int b){
        if (n == b){
            return true;
        }else
            if (n < b){
                return false;
            }else {
                return isPotencia(n/b, b);
            }
    }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 19--------------------------------------------------------------------------------------
//
//    Determinar numero primo
    public static boolean isPrimo(int n, int divisor){
        if (n <= 1){
            return false;
        }else{
            if(divisor == 1){
                return true;
            }else{
                if(n % divisor == 0){
                    return false;
                }else{
                    return isPrimo(n, divisor-1);
                }
            }
        }
    }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 20--------------------------------------------------------------------------------------
//
//    Ordenar un array de forma descendente recursivamente.
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 21--------------------------------------------------------------------------------------
//
//    Ordenar un array de forma ascendente recursivamente.
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 22--------------------------------------------------------------------------------------
//
//    Devolver solamente las consonantes de una cadena de caracteres. Ej. Datos = dts

    public static String devolverConsonantes(String p, int i) {
        if (i >= p.length()) {
            return "";
        } else {
            if (!isVocal(p.charAt(i))) {
                return p.charAt(i) + devolverConsonantes(p, ++i);
            } else {
                return devolverConsonantes(p, ++i);
            }
        }
    }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 23--------------------------------------------------------------------------------------
//
//    La búsqueda binaria implica que un array esté ordenado,
//    el algoritmo consiste en dividir el array por su elemento medio en dos subarrays más pequeños,
//    y comparar el elemento con el del centro. Si coinciden, la búsqueda se termina. Si el elemento es menor,
//    debe estar (si está) en el primer subarray, y si es mayor está en el segundo. Escriba un método recursivo de búsqueda binaria.


//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 24--------------------------------------------------------------------------------------
//
//    Escriba un método que retorne la matriz transpuesta de una matriz de tamaño mxn.
//    La transpuesta de una matriz consiste en intercambiar las filas por las columnas. Ejemplo:


//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 25--------------------------------------------------------------------------------------
//
//    Sumar todos los elementos de una matriz no cuadrada.


//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 26--------------------------------------------------------------------------------------
//
//    Sumar dos matrices.

//-------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------Taller Punto 26--------------------------------------------------------------------------------------
//
//    Haga un programa que diga si un número es o no perfecto.
//    Un número N es perfecto si la suma de sus divisores (excluido el propio N) es N.
//    por ejemplo 28 es perfecto, pues sus divisores  (excluido el 28) son 1,2,4,7 y 14 su suma da 28.

    public static boolean isNumeroPerfecto (int n, int d, int suma){
        if (d <= 0 && suma == n){
            return true;
        }
        if (d <= 0 && suma != n){
            return false;
        }
    }
}


