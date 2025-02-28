package uniquindio.edu.co.utils;

import java.io.IOException;
import java.util.ArrayList;

public class Persistencia {
    public static final String RUTA_ARCHIVO_LOG = "src/main/resources/persistencia/log/TallerLog.txt";
    public static final String RUTA_ARCHIVO_CHARACTERES = "src/main/resources/persistencia/TallerCaracteresNoUsados.txt";
    public static void guardaRegistroLog(String mensajeLog, int nivel, String accion) {
        ArchivoUtils.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_LOG);
    }
    public static void guardarCaracteresNoUsados(ArrayList<Character> caracteres) throws IOException {
        String contenido = "";
        for(Character c:caracteres)
        {
            contenido+= c;
        }
        ArchivoUtils.guardarArchivo(RUTA_ARCHIVO_CHARACTERES, contenido, false);
    }
}
