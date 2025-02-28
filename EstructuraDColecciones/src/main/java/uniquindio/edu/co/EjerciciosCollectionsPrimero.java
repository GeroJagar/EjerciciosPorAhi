package uniquindio.edu.co;

import java.util.*;

public class EjerciciosCollectionsPrimero {

    public static void main(String[] args) {
        List<Integer> x = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        encontrarIndiceElemento(x, 4);

        invertirArreglo(x);

        List<Integer> vacia = new ArrayList<>();
        rellenarList(vacia, 8, 4);
        System.out.println(vacia);

//        copiarContenido(x, vacia);
//        System.out.println(x);

        System.out.println(valorMinimoList(x));
        System.out.println(valorMaximoList(x));

        compararListas(x, vacia);

        System.out.println(encontrarElSegundoMasGrande(x));
    }

    public static void encontrarIndiceElemento(List<Integer> x, int y){
        Collections.sort(x);
        System.out.println("Elemento "+y+" en posición "+Collections.binarySearch(x, y));
    }

    public static void invertirArreglo(List<Integer> x){
        Collections.sort(x, Collections.reverseOrder());
        System.out.println(x);
    }

    public static void rellenarList(List<Integer> x, int y, int i){
        for (int j = i; j < y; j++) {
            x.add(y);
        }
    }

    public static void copiarContenido(List<Integer> x, List<Integer> y){
        Collections.copy(x, y);
    }

    public static int valorMinimoList(List<Integer> x){
        return Collections.min(x);
    }

    public static int valorMaximoList(List<Integer> x){
        return Collections.max(x);
    }

    public static void compararListas(List<Integer> x, List<Integer> y){
        boolean z = false;
        ListIterator<Integer> listIteratorX = x.listIterator();
        ListIterator<Integer> listIteratorY = y.listIterator();

        if(x.size() > y.size()){

            while(listIteratorY.hasNext()){
                int h = listIteratorY.next();
                if(x.contains(h)){
                    z = true;
                    break;
                }
            }

        }else{
            while(listIteratorX.hasNext()){
                if(y.contains(listIteratorX)){
                    z = true;
                    break;
                }
            }
        }
        if (z == true){
            System.out.println("Las listas comparten un elemento.");
        }else{
            System.out.println("Las listas no comparten elementos.");
        }
    }

    public static void ordenarListaEnteros(List<Integer> x){
         Collections.sort(x);
    }

    public static int encontrarElSegundoMasGrande(List<Integer> x){
        Collections.sort(x);
        List<Integer> y = new ArrayList<>(x);
        y.remove(Collections.binarySearch(x,valorMaximoList(x)));
        return valorMaximoList(y);
    }
}
