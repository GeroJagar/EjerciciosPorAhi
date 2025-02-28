//José Gerónimo Jaramillo Garzón, Mariajose Valencia Díaz, Diane Ortega Soto.
package uniquindio.edu.co;

import java.util.ArrayList;

public class Taller {
    public static void main(String[] args) {
        int [] lista = {2,3,4,5,6,7,8};
        int[][] matriz = {
                {11, 23, 45, 56},
                {77, 24, 30, 95},
                {24, 76, 32, 43}
        };
        ArrayList<Integer> lista1 = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            lista1.add(i);
        }
//        3)
        int x = 2;
        System.out.println("Taller\nPunto 3\nContar el número de apariciones de un elemento: "+x);

        System.out.println(contarElemento(lista, lista.length-1, x, 0));
//        4)
        System.out.println("\nPunto 4\nInvertir lista");
        invertirLista(lista);
        String imprimir = "";
        for (int num : lista){
            imprimir = imprimir + num + ", ";
        }
        System.out.println(imprimir);

//        5)
        System.out.println("\nPunto 5\nHallar los elementos pares de una lista");

        ArrayList<Integer> pares = new ArrayList<>();
        pares = encontrarPares(lista1, pares, 0);
        System.out.println(pares);
//        7)
        System.out.println("\nPunto 7\nDevolver el mayor de una lista, usando el paradigma Divide y vencerás");
        System.out.println(devolverMayor(lista1, 0, lista1.size()-1));
//        8)
        System.out.println("\nPunto 8\nSumar los elementos de una lista");
        System.out.println(sumarElementos(lista));
//        9)
        System.out.println("\nPunto 9\nSumar todos los elementos de una matriz");
        System.out.println(sumarElementosMatriz(matriz));
//        10)
        System.out.println("\nPunto 10\nSumar la diagonal de una matriz");
        System.out.println(sumarDiagonalMatriz(matriz));
    }
    /*
    3) Caso base: cuando primero >= n (Se recorrió todo el arreglo)
    Caso recursivo:
        1) Cuando se encuentra el elemento, retorna y se hace el llamado recursivo aumentando en 1 primero para recorrer el arreglo,
        y por fuera del llamado recursivo se suma 1.
        2) Cuando se no se encuentra el elemento, retorna y se hace el llamado recursivo aumentando en 1 primero para recorrer el arreglo.
     */
    private static int contarElemento(int[] vector, int n, int objetivo, int primero){
        if (primero >= n){
            return 0;
        }else{
            if(vector[primero] == objetivo){
                return contarElemento(vector, n, objetivo, primero+1) +1;
            }else {
                return contarElemento(vector, n, objetivo, primero+1);
            }
        }
    }
    /*
    4)
     */
    private static void invertirLista(int[] arreglo){
        invertirLista(arreglo, 0, arreglo.length-1);
    }
    private static void invertirLista(int[] arreglo, int i, int j){
        if (i < j){
            int aux = arreglo[i];
            arreglo[i] = arreglo[j];
            arreglo[j] = aux;
            invertirLista(arreglo, i+1, j-1);
        }
    }
    /*
    5)
     */
    private static ArrayList<Integer> encontrarPares(ArrayList<Integer> arreglo, ArrayList<Integer> pares, int i){
        if (i >= arreglo.size()){
            return pares;
        }else if (arreglo.get(i) % 2 == 0){
            pares.add(arreglo.get(i));
            return encontrarPares(arreglo, pares, i+1);
        }else{
            return encontrarPares(arreglo, pares, i+1);
        }
    }
    /*
    7)
     */
    private static int devolverMayor (ArrayList<Integer> arreglo, int inicio, int fin){
        if (inicio == fin){
            return arreglo.get(inicio);
        }else {
            int mitad = (inicio + fin) / 2;
            int x = devolverMayor(arreglo, inicio, mitad);
            int y = devolverMayor(arreglo, mitad+1, fin);
            return Math.max(x, y);
        }
    }
    /*
    8)
     */
    private static int sumarElementos(int[] arreglo){
        return sumarElementos(arreglo, 0, arreglo.length);
    }

    private static int sumarElementos(int[] arreglo, int inicio, int fin){
        if (inicio >= fin){
            return 0;
        }else {
                return arreglo[inicio] + sumarElementos(arreglo, inicio+1, fin);
        }
    }

    /*
      9)
     */
    private static int sumarElementosMatriz(int [][] matriz){
        return sumarElementosMatriz(matriz, 0, matriz[0].length-1);
    }
    private static int sumarElementosMatriz(int[][] matriz, int i, int j){
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
    /*
    10)
     */
    private static int sumarDiagonalMatriz(int[][] matriz){
        return sumarDiagonalMatriz(matriz, 0, 0);
    }
    private static int sumarDiagonalMatriz(int[][] matriz, int i, int j){
        if (i >= matriz.length){
            return 0;
        } else {
            if(j >= matriz[i].length){
                return sumarDiagonalMatriz(matriz, i+1, 0);
            }else{
                if (j == i){
                    return matriz[i][j] + sumarDiagonalMatriz(matriz, i, j+1);
                }else{
                    return sumarDiagonalMatriz(matriz, i, j+1);
                }
            }
        }
    }
}
