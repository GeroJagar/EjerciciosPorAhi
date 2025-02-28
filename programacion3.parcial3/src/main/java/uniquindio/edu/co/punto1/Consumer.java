package uniquindio.edu.co.punto1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Consumer implements Runnable {

    private final char[] caracteres = new char[20];  // Aumentar tamaño a 20 para que coincida con palabraArmada
    private final ArrayList<Character> noUsable = new ArrayList<>();
    private volatile boolean palabraCompleta = false;
    private final Buffer buffer;
    static String fechaSistema = "";

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        System.out.println("Consumer iniciado");
        char[] palabraArmada = {'p', 'r', 'o', 'g', 'r', '@', 'm', 'a', 'c', 'i', 'o', 'n', '_', '3', '#', '2', '0', '2', '4', '%'};
        while (!palabraCompleta) {
            try {
                if (isIguales(palabraArmada, caracteres)) {
                    imprimirLetrasNoUsadas(noUsable);
                    guardarCaracteresNoUsados(noUsable);
                    guardarRegistroLog("Se armó la palabra con éxito",1,"Programa finalizado","src/main/java/uniquindio/edu/co/punto1/punto1LOG.txt");
                    setPalabraCompleta(true);
                    return;
                } else {
                    for (int i = 0; i < 5; i++) {  // Consumir 5 letras
                        char c = buffer.tomarChar();
                        if (c != '\0') {
                            System.out.print("Consumidor toma: "+c+"\n");
                            armarArreglo(c);
                        }
                    }
                }
                imprimirPalabraFormada(caracteres);
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void imprimirLetrasNoUsadas(ArrayList<Character> noUsable) {
        StringBuilder print = new StringBuilder();
        for (char c : noUsable) {
            print.append(c);
        }
        System.out.println("Las letras no usadas fueron: " + print);
    }

    public static void imprimirPalabraFormada(char[] arreglo) {
        StringBuilder print = new StringBuilder();
        for (char c : arreglo) {
            print.append(c);
        }
        System.out.println("La palabra formada es: " + print);
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

    public void armarArreglo(char c) {
        if (c == 'p') {
            caracteres[0] = c;
        } else if (c == 'r') {
            caracteres[1] = c;
            caracteres[4] = c;
        } else if (c == 'o') {
            caracteres[2] = c;
            caracteres[10] = c;
        } else if (c == 'g') {
            caracteres[3] = c;
        } else if (c == '@') {
            caracteres[5] = c;
        } else if (c == 'm') {
            caracteres[6] = c;
        } else if (c == 'a') {
            caracteres[7] = c;
        } else if (c == 'c') {
            caracteres[8] = c;
        } else if (c == 'i') {
            caracteres[9] = c;
        } else if (c == 'n') {
            caracteres[11] = c;
        } else if (c == '_') {
            caracteres[12] = c;
        } else if (c == '3') {
            caracteres[13] = c;
        } else if (c == '#') {
            caracteres[14] = c;
        } else if (c == '2') {
            caracteres[15] = c;
            caracteres[17] = c;
        } else if (c == '0') {
            caracteres[16] = c;
        } else if (c == '4') {
            caracteres[18] = c;
        } else if (c == '%') {
            caracteres[19] = c;
        } else {
            noUsable.add(c);
        }
    }

    public boolean isPalabraCompleta() {
        return palabraCompleta;
    }

    public void setPalabraCompleta(boolean palabraCompleta) {
        this.palabraCompleta = palabraCompleta;
    }

    public static void guardarCaracteresNoUsados(ArrayList<Character> caracteres) throws IOException {
        StringBuilder contenido = new StringBuilder();
        for (Character c : caracteres) {
            contenido.append(c).append(", ");
        }
        contenido.append("\n");
        guardarArchivo("src/main/java/uniquindio/edu/co/punto1/letrasSobrantes.txt", contenido.toString(), true);
    }

    public static void guardarArchivo(String ruta, String contenido, Boolean flagAnexarContenido) throws IOException {
        try (FileWriter fw = new FileWriter(ruta, flagAnexarContenido);
             BufferedWriter bfw = new BufferedWriter(fw)) {
            bfw.write(contenido);
        }
    }

    public static void guardarRegistroLog(String mensajeLog, int nivel, String accion, String rutaArchivo) {
        String log = "";
        Logger LOGGER = Logger.getLogger(accion);
        FileHandler fileHandler =  null;
        cargarFechaSistema();
        try {
            fileHandler = new FileHandler(rutaArchivo,true);
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandler);
            switch (nivel) {
                case 1:
                    LOGGER.log(Level.INFO,accion+", "+mensajeLog+", "+fechaSistema) ;
                    break;

                case 2:
                    LOGGER.log(Level.WARNING,accion+", "+mensajeLog+", "+fechaSistema) ;
                    break;

                case 3:
                    LOGGER.log(Level.SEVERE,accion+", "+mensajeLog+", "+fechaSistema) ;
                    break;

                default:
                    break;
            }

        } catch (SecurityException e) {

            LOGGER.log(Level.SEVERE,e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            LOGGER.log(Level.SEVERE,e.getMessage());
            e.printStackTrace();
        }
        finally {

            fileHandler.close();
        }
    }
    private static void cargarFechaSistema() {

        String dayN = "";
        String monthN = "";
        String yearN = "";

        Calendar cal1 = Calendar.getInstance();


        int  day = cal1.get(Calendar.DATE);
        int month = cal1.get(Calendar.MONTH)+1;
        int year = cal1.get(Calendar.YEAR);
        int hour = cal1.get(Calendar.HOUR);
        int minute = cal1.get(Calendar.MINUTE);


        if(day < 10){
            dayN+="0"+day;
        }
        else{
            dayN+=""+day;
        }
        if(month < 10){
            monthN+="0"+month;
        }
        else{
            monthN+=""+month;
        }

        //		fecha_Actual+= año+"-"+mesN+"-"+ diaN;
        //		fechaSistema = año+"-"+mesN+"-"+diaN+"-"+hora+"-"+minuto;
        fechaSistema = year+"-"+monthN+"-"+dayN;
        //		horaFechaSistema = hora+"-"+minuto;
    }
}
