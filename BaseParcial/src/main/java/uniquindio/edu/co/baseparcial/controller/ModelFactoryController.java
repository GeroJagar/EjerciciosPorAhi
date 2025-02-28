package uniquindio.edu.co.baseparcial.controller;

import uniquindio.edu.co.baseparcial.mapping.mapper.ColegioMapper;
import uniquindio.edu.co.baseparcial.model.Colegio;
import uniquindio.edu.co.baseparcial.utils.ColegioUtils;
import uniquindio.edu.co.baseparcial.utils.Persistencia;

import java.io.IOException;

public class ModelFactoryController {

    Colegio colegio;
    ColegioMapper mapper = ColegioMapper.INSTANCE;
    //------------------------------  Singleton ------------------------------------------------
    // Clase estatica oculta. Tan solo se instanciara el singleton una vez
    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }
    // Método para obtener la instancia de nuestra clase
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController() {
        //1. inicializar datos y luego guardarlo en archivos
        System.out.println("invocación clase singleton");
        cargarDatosBase();
        salvarDatosPrueba();

        //2. Cargar los datos de los archivos
		cargarDatosDesdeArchivos();

        //3. Guardar y Cargar el recurso serializable binario
//        cargarResourceBinario();
//        guardarResourceBinario();

        //4. Guardar y Cargar el recurso serializable XML
//		guardarResourceXML();
//        cargarResourceXML();

        //Siempre se debe verificar si la raiz del recurso es null

        if(colegio == null){
            cargarDatosBase();
            guardarResourceXML();
        }
        registrarAccionesSistema("Inicio de sesión", 1, "inicioSesión");
    }

    private void cargarResourceBinario() {
        colegio = Persistencia.cargarRecursoBancoBinario();
    }

    private void guardarResourceXML() {
        Persistencia.guardarRecursoBancoXML(colegio);
    }

    private void salvarDatosPrueba() {
        try {
            Persistencia.guardarEstudiante(getColegio().getEstudiantes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void cargarResourceXML() {
        colegio = Persistencia.cargarRecursoBancoXML();
    }

    private void guardarResourceBinario() {
        Persistencia.guardarRecursoBancoBinario(colegio);
    }

    private void cargarDatosDesdeArchivos() {
        colegio = new Colegio();
        try {
            Persistencia.cargarDatosArchivos(colegio);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Colegio getColegio() {
        return colegio;
    }

    private void cargarDatosBase() {
        colegio = ColegioUtils.inicializarDatos();
    }

    public void registrarAccionesSistema(String mensaje, int nivel, String accion) {
        Persistencia.guardaRegistroLog(mensaje, nivel, accion);
    }
}
