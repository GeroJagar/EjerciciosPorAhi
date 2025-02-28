package uniquindio.edu.co.baseparcial.utils;

import uniquindio.edu.co.baseparcial.model.Colegio;
import uniquindio.edu.co.baseparcial.model.Estudiante;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Persistencia {
    public static final String RUTA_ARCHIVO_ESTUDIANTES = "src/main/resources/persistencia/archivoEstudiante.txt";
    public static final String RUTA_ARCHIVO_MODELO_COLEGIO_XML = "src/main/resources/persistencia/model.xml";
    public static final String RUTA_ARCHIVO_LOG = "src/main/resources/persistencia/log/ColegioLog.txt";
    public static final String RUTA_ARCHIVO_MODELO_COLEGIO_BINARIO = "src/main/resources/persistencia/model.dat";

    public static void guardarEstudiante(ArrayList<Estudiante> listaEstudiante) throws IOException {
        String contenido = "";
        for(Estudiante estudiante:listaEstudiante)
        {
            contenido+= estudiante.getNombre()+
                    "@@"+estudiante.getCodigo()+
                    "@@"+estudiante.getNota1()+
                    "@@"+estudiante.getNota2()+
                    "@@"+estudiante.getNota3()+"\n";
        }
        ArchivoUtils.guardarArchivo(RUTA_ARCHIVO_ESTUDIANTES, contenido, false);
    }

    public static void cargarDatosArchivos(Colegio colegio) throws FileNotFoundException, IOException {
        //cargar archivo de clientes
        ArrayList<Estudiante> estudiantesCargados = cargarEstudiantes();
        if(estudiantesCargados.size() > 0) {
            colegio.getEstudiantes().addAll(estudiantesCargados);
        }
    }

    public static ArrayList<Estudiante> cargarEstudiantes() throws FileNotFoundException, IOException
    {
        ArrayList<Estudiante> estudiantes =new ArrayList<Estudiante>();
        ArrayList<String> contenido = ArchivoUtils.leerArchivo(RUTA_ARCHIVO_ESTUDIANTES);
        String linea="";
        for (int i = 0; i < contenido.size(); i++)
        {
            linea = contenido.get(i);//juan,arias,125454,Armenia,uni1@,12454,125444
            Estudiante estudiante = new Estudiante();
            estudiante.setNombre(linea.split("@@")[0]);
            estudiante.setCodigo(linea.split("@@")[1]);
            estudiante.setNota1(Double.parseDouble(linea.split("@@")[2]));
            estudiante.setNota2(Double.parseDouble(linea.split("@@")[3]));
            estudiante.setNota3(Double.parseDouble(linea.split("@@")[4]));
            estudiantes.add(estudiante);
        }
        return estudiantes;
    }

    public static Colegio cargarRecursoBancoBinario() {

        Colegio colegio = null;

        try {
            colegio = (Colegio)ArchivoUtils.cargarRecursoSerializado(RUTA_ARCHIVO_MODELO_COLEGIO_BINARIO);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return colegio;
    }

    public static void guardarRecursoBancoBinario(Colegio colegio) {
        try {
            ArchivoUtils.salvarRecursoSerializado(RUTA_ARCHIVO_MODELO_COLEGIO_BINARIO, colegio);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Colegio cargarRecursoBancoXML() {

        Colegio colegio = null;

        try {
            colegio = (Colegio)ArchivoUtils.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_COLEGIO_XML);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return colegio;

    }

    public static void guardarRecursoBancoXML(Colegio colegio) {

        try {
            ArchivoUtils.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_COLEGIO_XML, colegio);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void guardaRegistroLog(String mensajeLog, int nivel, String accion)
    {
        ArchivoUtils.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_LOG);
    }
}
