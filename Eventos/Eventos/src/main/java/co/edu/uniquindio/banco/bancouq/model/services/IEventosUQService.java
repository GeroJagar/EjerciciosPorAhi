package co.edu.uniquindio.banco.bancouq.model.services;

import co.edu.uniquindio.banco.bancouq.exceptions.EventoException;
import co.edu.uniquindio.banco.bancouq.exceptions.UsuarioException;
import co.edu.uniquindio.banco.bancouq.mapping.dto.ReservaDto;
import co.edu.uniquindio.banco.bancouq.model.Evento;
import co.edu.uniquindio.banco.bancouq.model.Reserva;
import co.edu.uniquindio.banco.bancouq.model.Usuario;
import co.edu.uniquindio.banco.bancouq.exceptions.EmpleadoException;
import co.edu.uniquindio.banco.bancouq.exceptions.ReservaException;
import co.edu.uniquindio.banco.bancouq.model.Empleado;

import java.util.ArrayList;


public interface IEventosUQService {
	public Usuario crearUsuario(String nombre, String cedula, String correo) throws UsuarioException;
	public Boolean eliminarUsuario(String cedula)throws UsuarioException;
	boolean actualizarUsuario(String cedulaActual, Usuario usuario) throws UsuarioException;
	public boolean  verificarUsuarioExistente(String cedula) throws UsuarioException;
	public Usuario obtenerUsuario(String cedula);
	public ArrayList<Usuario> obtenerUsuarios();

	public Empleado crearEmpleado(String nombre, String cedula, String correo) throws EmpleadoException;
	public void agregarEmpleado(Empleado nuevoEmpleado) throws EmpleadoException;
	boolean actualizarEmpleado(String cedulaActual, Empleado empleado) throws EmpleadoException;
	public Boolean eliminarEmpleado(String cedula) throws EmpleadoException;
	public boolean verificarEmpleadoExistente(String cedula) throws EmpleadoException;
	public Empleado obtenerEmpleado(String cedula);
	public ArrayList<Empleado> obtenerEmpleados();

	public Reserva crearReserva(String id, String fechaSolicitud) throws ReservaException;
	public void agregarReserva(Reserva nuevaReserva) throws ReservaException;
	boolean actualizarReserva(String idActual, Reserva reserva) throws ReservaException;

	public Boolean eliminarReserva(String id) throws ReservaException;
	public boolean verificarReservaExistente(String id) throws ReservaException;
	public Reserva obtenerReserva(String id);
	public ArrayList<Reserva> obtenerReservas();

	Evento crearEvento(String id, String nombre, String descripcion, String fecha, int capacidadMaxima) throws EventoException;

	boolean actualizarEvento (String idActual, Evento evento) throws EventoException;

	Boolean eliminarEvento(String id) throws EventoException;

	boolean verificarEventoExistente(String id) throws EventoException;

	Evento obtenerEvento(String id);

	ArrayList<Evento> obtenerEventos();
}
