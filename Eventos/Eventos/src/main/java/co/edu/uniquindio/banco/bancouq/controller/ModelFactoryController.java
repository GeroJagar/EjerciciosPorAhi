package co.edu.uniquindio.banco.bancouq.controller;

import co.edu.uniquindio.banco.bancouq.mapping.dto.EventoDto;
import co.edu.uniquindio.banco.bancouq.mapping.dto.UsuarioDto;
import co.edu.uniquindio.banco.bancouq.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.banco.bancouq.mapping.dto.ReservaDto;
import co.edu.uniquindio.banco.bancouq.mapping.mappers.EventosUQMapper;
import co.edu.uniquindio.banco.bancouq.model.*;
import co.edu.uniquindio.banco.bancouq.exceptions.*;
import co.edu.uniquindio.banco.bancouq.controller.service.IModelFactoryService;
import co.edu.uniquindio.banco.bancouq.utils.EventosUQUtils;
import co.edu.uniquindio.banco.bancouq.utils.Persistencia;

//import java.io.IOException;
//import java.time.LocalDateTime;
import java.io.IOException;
import java.util.List;
//import java.util.logging.Logger;
//import java.util.logging.FileHandler;
//import java.util.logging.SimpleFormatter;

public class ModelFactoryController implements IModelFactoryService {
    EventosUQ eventosUQ;
    EventosUQMapper mapper = EventosUQMapper.INSTANCE;

//    private static final Logger LOGGER = Logger.getLogger(UserLog.class.getName());

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
        System.out.println("invocación clase singleton");
        cargarDatosBase();
    }

    private void cargarDatosBase() {
        eventosUQ = EventosUQUtils.inicializarDatos();
    }

    public EventosUQ getBanco() {
        return eventosUQ;
    }

    public void setBanco(EventosUQ eventosUQ) {
        this.eventosUQ = eventosUQ;
    }


    @Override
    public List<UsuarioDto> obtenerUsuarios() {
       return  mapper.getUsuariosDto(eventosUQ.getListaUsuarios());
    }

    @Override
    public boolean agregarUsuario(UsuarioDto usuarioDto) {
        try{
            if(!eventosUQ.verificarUsuarioExistente(usuarioDto.cedula())) {
                Usuario usuario = mapper.usuarioDtoToUsuario(usuarioDto);
                getBanco().agregarUsuario(usuario);
            }
            return true;
        }catch (UsuarioException e){
            e.getMessage();
            return false;
        }
    }

    @Override
    public boolean eliminarUsuario(String cedula) {
        boolean flagExiste = false;
        try {
            flagExiste = getBanco().eliminarUsuario(cedula);
        } catch (UsuarioException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flagExiste;
    }

    @Override
    public boolean actualizarUsuario (String cedulaActual, UsuarioDto usuarioDto) {
        try {
            Usuario usuario = mapper.usuarioDtoToUsuario(usuarioDto);
            getBanco().actualizarUsuario(cedulaActual, usuario);
            return true;
        } catch (UsuarioException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<EmpleadoDto> obtenerEmpleados() {
        return  mapper.getEmpleadosDto(eventosUQ.getListaEmpleados());
    }

    @Override
    public boolean agregarEmpleado(EmpleadoDto empleadoDto) {
        try{
            if(!eventosUQ.verificarEmpleadoExistente(empleadoDto.cedula())) {
                Empleado empleado = mapper.empleadoDtoToEmpleado(empleadoDto);
                getBanco().agregarEmpleado(empleado);
            }
            return true;
        }catch (EmpleadoException e){
            e.getMessage();
            return false;
        }
    }

    @Override
    public boolean eliminarEmpleado(String cedula) {
        boolean flagExiste = false;
        try {
            flagExiste = getBanco().eliminarEmpleado(cedula);
        } catch (EmpleadoException e) {
            e.printStackTrace();
        }
        return flagExiste;
    }

    @Override
    public boolean actualizarEmpleado(String cedulaActual, EmpleadoDto empleadoDto) {
        try {
            Empleado empleado = mapper.empleadoDtoToEmpleado(empleadoDto);
            getBanco().actualizarEmpleado(cedulaActual, empleado);
            return true;
        } catch (EmpleadoException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<ReservaDto> obtenerReservas() {
        return  mapper.getReservasDto(eventosUQ.getListaReservas());
    }

    @Override
    public boolean agregarReserva(ReservaDto reservaDto) {
        try{
            if(!eventosUQ.verificarReservaExistente(reservaDto.id())) {
                Reserva reserva = mapper.reservaDtoToReserva(reservaDto);
                getBanco().agregarReserva(reserva);
            }
            return true;
        }catch (ReservaException e){
            e.getMessage();
            return false;
        }
    }

    @Override
    public boolean eliminarReserva(String id) {
        boolean flagExiste = false;
        try {
            flagExiste = getBanco().eliminarReserva(id);
        } catch (ReservaException e) {
            e.printStackTrace();
        }
        return flagExiste;
    }

    @Override
    public boolean actualizarReserva(String idActual, ReservaDto reservaDto) {
        try {
            Reserva reserva = mapper.reservaDtoToReserva(reservaDto);
            getBanco().actualizarReserva(idActual, reserva);
            return true;
        } catch (ReservaException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<EventoDto> obtenerEventos() {
        return  mapper.getEventosDto(eventosUQ.getListaEventos());
    }

    @Override
    public boolean agregarEvento(EventoDto eventoDto) {
        try{
            if(!eventosUQ.verificarEventoExistente(eventoDto.id())) {
                Evento evento = mapper.eventoDtoToEvento(eventoDto);
                getBanco().agregarEvento(evento);
            }
            return true;
        }catch (EventoException e){
            e.getMessage();
            return false;
        }
    }

    @Override
    public boolean eliminarEvento(String id) {
        boolean flagExiste = false;
        try {
            flagExiste = getBanco().eliminarEvento(id);
        } catch (EventoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flagExiste;
    }

    @Override
    public boolean actualizarEvento (String idActual, EventoDto eventoDto) {
        try {
            Evento evento = mapper.eventoDtoToEvento(eventoDto);
            getBanco().actualizarEvento(idActual, evento);
            return true;
        } catch (EventoException e) {
            e.printStackTrace();
            return false;
        }
    }
    private void cargarDatosDesdeArchivos() {
        EventosUQ = new Evento();
        try {
            Persistencia.cargarDatosArchivos(EventosUQ);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    public void registrarLOG(String ruta, String accion, String informacion) throws IOException {
//        FileHandler archivoLogger = new FileHandler(ruta, true);
//        archivoLogger.setFormatter(new SimpleFormatter());
//        LOGGER.addHandler(archivoLogger);
//        LOGGER.info(accion+informacion+", a las "+ LocalDateTime.now());
//    }


}
