package co.edu.uniquindio.banco.bancouq.utils;

import co.edu.uniquindio.banco.bancouq.exceptions.UsuarioException;
import co.edu.uniquindio.banco.bancouq.model.Empleado;
import co.edu.uniquindio.banco.bancouq.model.EventosUQ;
import co.edu.uniquindio.banco.bancouq.model.Usuario;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class Persistencia {


    //bancoUq/src/main/resources/persistencia/archivoClientes.txt
    public static final String RUTA_ARCHIVO_CLIENTES = "src/main/resources/persistencia/archivoClientes.txt";
    public static final String RUTA_ARCHIVO_EMPLEADOS = "src/main/resources/persistencia/archivoEmpleados.txt";
    public static final String RUTA_ARCHIVO_USUARIOS = "/src/main/resources/persistencia/archivoUsuarios.txt";
    public static final String RUTA_ARCHIVO_LOG = "src/main/resources/persistencia/log/BancoLog.txt";
    public static final String RUTA_ARCHIVO_OBJETOS = "co.edu.uniquindio.programacion3/src/main/resources/persistencia/archivoObjetos.txt";
    public static final String RUTA_ARCHIVO_MODELO_BANCO_BINARIO = "src/main/resources/persistencia/model.dat";
    public static final String RUTA_ARCHIVO_MODELO_BANCO_XML = "src/main/resources/persistencia/model.xml";
//	C:\td\persistencia



    public static void cargarDatosArchivos(EventosUQ eventosUQ) throws FileNotFoundException, IOException {
        //cargar archivo de clientes
        ArrayList<Cliente> clientesCargados = cargarClientes();
        if(clientesCargados.size() > 0)
            banco.getListaClientes().addAll(clientesCargados);

        //cargar archivos empleados
        ArrayList<Empleado> empleadosCargados = cargarEmpleados();
        if(empleadosCargados.size() > 0)
            banco.getListaEmpleados().addAll(empleadosCargados);

        //cargar archivo transcciones

        //cargar archivo empleados

        //cargar archivo prestamo

    }

    /**
     * Guarda en un archivo de texto todos la información de las personas almacenadas en el ArrayList
     * @param
     * @param
     * @throws IOException
     */
    public static void guardarClientes(ArrayList<Usuario> listaUsuario) throws IOException {
        // TODO Auto-generated method stub
        String contenido = "";
        for(Usuario cliente:listaUsuario)
        {
            contenido+= cliente.getNombre()+","+","+cliente.getCedula()+","
                    +","+cliente.getCorreo()+","+"\n";
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_CLIENTES, contenido, false);
    }

    public static void guardarEmpleados(ArrayList<Empleado> listaEmpleados) throws IOException {
        String contenido = "";
        for(Empleado empleado:listaEmpleados)
        {
            contenido+= empleado.getNombre()+
                    ","+empleado.getCedula()+
                    "\n";
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_EMPLEADOS, contenido, false);
    }



//	----------------------LOADS------------------------

    /**
     *
     * @param
     * @param
     * @return un Arraylist de personas con los datos obtenidos del archivo de texto indicado
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static ArrayList<Usuario> cargarUsuario() throws FileNotFoundException, IOException
    {
        ArrayList<Usuario> clientes =new ArrayList<Usuario>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_CLIENTES);
        String linea="";
        for (int i = 0; i < contenido.size(); i++)
        {
            linea = contenido.get(i);//juan,arias,125454,Armenia,uni1@,12454,125444
            Usuario cliente = new Usuario();
            cliente.setNombre(linea.split(",")[0]);
            cliente.setCedula(linea.split(",")[1]);
            cliente.setCorreo(linea.split(",")[3]);
            clientes.add(cliente);
        }
        return clientes;
    }


    public static ArrayList<Empleado> cargarEmpleados() throws FileNotFoundException, IOException {
        ArrayList<Empleado> empleados =new ArrayList<Empleado>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_EMPLEADOS);
        String linea="";
        for (int i = 0; i < contenido.size(); i++) {
            linea = contenido.get(i);
            Empleado empleado = new Empleado();
            empleado.setNombre(linea.split(",")[0]);
            empleado.setCedula(linea.split(",")[1]);
            empleados.add(empleado);
        }
        return empleados;
    }


    public static void guardaRegistroLog(String mensajeLog, int nivel, String accion)
    {
        ArchivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_LOG);
    }


    public static boolean iniciarSesion(String usuario, String contrasenia) throws FileNotFoundException, IOException, UsuarioExcepcion {

        if(validarUsuario(usuario,contrasenia)) {
            return true;
        }else {
            throw new UsuarioExcepcion("Usuario no existe");
        }

    }

    private static boolean validarUsuario(String usuario, String contrasenia) throws FileNotFoundException, IOException
    {
        ArrayList<Usuario> usuarios = Persistencia.cargarUsuarios(RUTA_ARCHIVO_USUARIOS);

        for (int indiceUsuario = 0; indiceUsuario < usuarios.size(); indiceUsuario++)
        {
            Usuario usuarioAux = usuarios.get(indiceUsuario);
            if(usuarioAux.getUsuario().equalsIgnoreCase(usuario) && usuarioAux.getContrasenia().equalsIgnoreCase(contrasenia)) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Usuario> cargarUsuarios(String ruta) throws FileNotFoundException, IOException {
        ArrayList<Usuario> usuarios =new ArrayList<Usuario>();

        ArrayList<String> contenido = ArchivoUtil.leerArchivo(ruta);
        String linea="";

        for (int i = 0; i < contenido.size(); i++) {
            linea = contenido.get(i);

            Usuario usuario = new Usuario();
            usuario.setUsuario(linea.split(",")[0]);
            usuario.setContrasenia(linea.split(",")[1]);

            usuarios.add(usuario);
        }
        return usuarios;
    }


//	----------------------SAVES------------------------

    /**
     * Guarda en un archivo de texto todos la información de las personas almacenadas en el ArrayList
     * @param
     * @param ruta
     * @throws IOException
     */

    public static void guardarObjetos(ArrayList<Cliente> listaClientes, String ruta) throws IOException  {
        String contenido = "";

        for(Cliente clienteAux:listaClientes) {
            contenido+= clienteAux.getNombre()+","+clienteAux.getApellido()+","+clienteAux.getCedula()+clienteAux.getDireccion()
                    +","+clienteAux.getCorreo()+","+clienteAux.getFechaNacimiento()+","+clienteAux.getTelefono()+"\n";
        }
        ArchivoUtil.guardarArchivo(ruta, contenido, true);
    }





    //------------------------------------SERIALIZACIÓN  y XML


    public static Banco cargarRecursoBancoBinario() {

        Banco banco = null;

        try {
            banco = (Banco)ArchivoUtil.cargarRecursoSerializado(RUTA_ARCHIVO_MODELO_BANCO_BINARIO);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return banco;
    }

    public static void guardarRecursoBancoBinario(Banco banco) {
        try {
            ArchivoUtil.salvarRecursoSerializado(RUTA_ARCHIVO_MODELO_BANCO_BINARIO, banco);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static Banco cargarRecursoBancoXML() {

        Banco banco = null;

        try {
            banco = (Banco)ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_BANCO_XML);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return banco;

    }



    public static void guardarRecursoBancoXML(Banco banco) {

        try {
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_BANCO_XML, banco);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }










}
