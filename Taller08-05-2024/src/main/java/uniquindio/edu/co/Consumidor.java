package uniquindio.edu.co;

//José Gerónimo Jaramillo Garzón

import uniquindio.edu.co.utils.Persistencia;

import java.io.IOException;
import java.util.ArrayList;

public class Consumidor implements Runnable {

    char[] caracteres = new char[19];
    ArrayList<Character> noUsable = new ArrayList();
    private Buffer buffer;
    private volatile boolean palabraCompleta = false;

    public Consumidor(Buffer buffer) {
        this.buffer = buffer;
    }


    @Override
    public void run() {
        System.out.println("Consumidor se ejecuta");
        char[] palabraArmada = {'u', 'n', 'i', 'v', 'e', 'r', 's', 'i', 'd', '@', 'd', '#', '2', '0', '2', '4','-','2','%'};
        try{
            while (palabraCompleta == false) {
                armarArreglo(buffer.tomarChar());
                armarArreglo(buffer.tomarChar());
                if (isIguales(palabraArmada,caracteres) == true){
                    palabraCompleta = true;
                    Persistencia.guardarCaracteresNoUsados(noUsable);
                    Persistencia.guardaRegistroLog("Se termino de armar la plabra",1,"Programa finalizado");
                }
                imprimirArreglo(caracteres);
                Thread.sleep(500);
            }
        }catch(InterruptedException e){

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public boolean isPalabraCompleta() {
        return palabraCompleta;
    }

    public static boolean isIguales(char[] arreglo1, char[] arreglo2) {
        if (arreglo1.length != arreglo2.length) {
            return false;
        }
        for (int i = 0; i < arreglo1.length; i++) {
            if (arreglo1[i] != arreglo2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void imprimirArreglo(char[] arreglo) {
        for (char c : arreglo) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public void armarArreglo(char c){
        if(c == 'i'){
            caracteres[2] = c;
            caracteres[7] = c;
        }else{
            if(c == 'd'){
                caracteres[8] = c;
                caracteres[10] = c;
            }else {
                if(c == '2'){
                    caracteres[12] = c;
                    caracteres[14] = c;
                    caracteres[17] = c;
                }else {
                    if(c == 'u'){
                        caracteres[0] = c;
                    }else{
                        if(c == 'n'){
                            caracteres[1] = c;
                        }else {
                            if(c == 'v'){
                                caracteres[3] = c;
                            }else {
                                if(c == 'e'){
                                    caracteres[4] = c;
                                }else{
                                    if(c == 'r'){
                                        caracteres[5] = c;
                                    }else{
                                        if(c == 's'){
                                            caracteres[6] = c;
                                        }else{
                                            if(c == '@'){
                                                caracteres[9] = c;
                                            }else {
                                                if(c == '0'){
                                                    caracteres[13] = c;
                                                }else {
                                                    if(c == '#'){
                                                        caracteres[11] = c;
                                                    }else{
                                                        if(c == '4'){
                                                            caracteres[15] = c;
                                                        }
                                                        else{
                                                            if(c == '-'){
                                                                caracteres[16] = c;
                                                            }else{
                                                                if(c == '%'){
                                                                    caracteres[18] = c;
                                                                }else{
                                                                    noUsable.add(c);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
