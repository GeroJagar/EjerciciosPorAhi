package co.edu.uniquindio.banco.bancouq.controller.service;

import co.edu.uniquindio.banco.bancouq.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.banco.bancouq.mapping.dto.EventoDto;
import co.edu.uniquindio.banco.bancouq.mapping.dto.UsuarioDto;
import co.edu.uniquindio.banco.bancouq.mapping.dto.ReservaDto;

import java.util.ArrayList;
import java.util.List;


public interface IModelFactoryService {

	List<UsuarioDto> obtenerUsuarios();
	boolean agregarUsuario(UsuarioDto usuarioDto);

	boolean eliminarUsuario(String cedula);

	boolean actualizarUsuario(String cedulaActual, UsuarioDto usuarioDto);

	boolean agregarEmpleado(EmpleadoDto empleadoDto);

	List<EmpleadoDto> obtenerEmpleados();

	boolean eliminarEmpleado(String cedula);

	boolean actualizarEmpleado(String cedulaActual, EmpleadoDto empleadoDto);

	List<ReservaDto> obtenerReservas();
	boolean agregarReserva(ReservaDto reservaDto);

	boolean eliminarReserva(String id);

	boolean actualizarReserva(String idActual, ReservaDto reservaDto);

	List<EventoDto> obtenerEventos();
	boolean agregarEvento(EventoDto eventoDto);

	boolean eliminarEvento(String id);

	boolean actualizarEvento(String idActual, EventoDto eventoDto);
}
