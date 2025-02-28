package co.edu.uniquindio.banco.bancouq.model;

import co.edu.uniquindio.banco.bancouq.exceptions.EmpleadoException;
import co.edu.uniquindio.banco.bancouq.exceptions.EventoException;
import co.edu.uniquindio.banco.bancouq.exceptions.ReservaException;
import co.edu.uniquindio.banco.bancouq.exceptions.UsuarioException;
import co.edu.uniquindio.banco.bancouq.model.services.IEventosUQService;

import java.util.ArrayList;


//EventosUQ es la clase que implementa la interfaz IEventosUQService y se encarga
// de gestionar los eventos de la Universidad del Quindio

//Listas de usuarios, empleados, reservas y eventos

//Metodos para crear, actualizar, eliminar y verificar la existencia de usuarios, empleados, reservas y eventos

//Metodos para obtener un usuario, empleado, reserva o evento

//Metodos para obtener la lista de usuarios, empleados, reservas o eventos

//Metodos para agregar un usuario, empleado, reserva o evento

//Metodos para verificar si un usuario, empleado, reserva o evento existe


public class EventosUQ implements IEventosUQService {
	private static final long serialVersionUID = 1L;

	ArrayList<Usuario> listaUsuarios = new ArrayList<>();
	ArrayList<Empleado> listaEmpleados = new ArrayList<>();

	ArrayList<Reserva> listaReservas = new ArrayList<>();

	ArrayList<Evento> listaEventos = new ArrayList<>();


	public EventosUQ() {

	}


	public ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public ArrayList<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	public ArrayList<Reserva> getListaReservas() {
		return listaReservas;
	}

	public void setListaReservas(ArrayList<Reserva> listaReservas) {
		this.listaReservas = listaReservas;
	}

	public ArrayList<Evento> getListaEventos() {
		return listaEventos;
	}

	public void setListaEventos(ArrayList<Evento> listaEventos) {
		this.listaEventos = listaEventos;
	}



	//Metodos usuario

	@Override
	public Usuario crearUsuario(String nombre, String cedula, String correo) throws UsuarioException{
		Usuario nuevoUsuario = null;
		boolean usuarioExiste = verificarUsuarioExistente(cedula);
		if(usuarioExiste){
			throw new UsuarioException("El usuario con cedula: "+cedula+" ya existe");
		}else{
			nuevoUsuario = new Usuario();
			nuevoUsuario.setNombre(nombre);
			nuevoUsuario.setCedula(cedula);
			nuevoUsuario.setCorreo(correo);
			getListaUsuarios().add(nuevoUsuario);
		}
		return nuevoUsuario;
	}

	public void agregarUsuario(Usuario nuevoUsuario) throws UsuarioException{
		getListaUsuarios().add(nuevoUsuario);
	}

	@Override
	public boolean actualizarUsuario (String cedulaActual, Usuario usuario) throws UsuarioException {
		Usuario usuarioActual = obtenerUsuario(cedulaActual);
		if(usuarioActual == null)
			throw new UsuarioException("El usuario a actualizar no existe");
		else{
			usuarioActual.setNombre(usuario.getNombre());

			usuarioActual.setCedula(usuario.getCedula());

			usuarioActual.setCorreo(usuario.getCorreo());

			return true;
		}
	}

	@Override
	public Boolean eliminarUsuario(String cedula) throws UsuarioException {
		Usuario usuario = null;
		boolean flagExiste = false;
		usuario = obtenerUsuario(cedula);
		if(usuario == null)
			throw new UsuarioException("El usuario a eliminar no existe");
		else{
			getListaUsuarios().remove(usuario);
			flagExiste = true;
		}
		return flagExiste;
	}

	@Override
	public boolean verificarUsuarioExistente(String cedula) throws UsuarioException {
		if(usuarioExiste(cedula)){
			throw new UsuarioException("El usuario con cedula: "+cedula+" ya existe");
		}else{
			return false;
		}
	}


	@Override
	public Usuario obtenerUsuario(String cedula) {
		Usuario usuarioEncontrado = null;
		for (Usuario usuario : getListaUsuarios()) {
			if(usuario.getCedula().equalsIgnoreCase(cedula)){
				usuarioEncontrado = usuario;
				break;
			}
		}
		return usuarioEncontrado;
	}

	@Override
	public ArrayList<Usuario> obtenerUsuarios() {
		// TODO Auto-generated method stub
		return getListaUsuarios();
	}

	public boolean usuarioExiste(String cedula) {
		boolean usuarioEncontrado = false;
		for (Usuario usuario : getListaUsuarios()) {
			if(usuario.getCedula().equalsIgnoreCase(cedula)){
				usuarioEncontrado = true;
				break;
			}
		}
		return usuarioEncontrado;
	}



	//Metodos empleado

	@Override
	public Empleado crearEmpleado(String nombre, String cedula, String correo) throws EmpleadoException {
		Empleado nuevoEmpleado = null;
		boolean empleadoExiste = verificarEmpleadoExistente(cedula);
		if(empleadoExiste){
			throw new EmpleadoException("El empleado con cedula: "+cedula+" ya existe");
		}else{
			nuevoEmpleado = new Empleado();
			nuevoEmpleado.setNombre(nombre);
			nuevoEmpleado.setCedula(cedula);
			nuevoEmpleado.setCorreo(correo);
			getListaEmpleados().add(nuevoEmpleado);
		}
		return nuevoEmpleado;
	}

	public void agregarEmpleado(Empleado nuevoEmpleado) throws EmpleadoException {
		getListaEmpleados().add(nuevoEmpleado);
	}

	@Override
	public boolean actualizarEmpleado(String cedulaActual, Empleado empleado) throws EmpleadoException {
		Empleado empleadoActual = obtenerEmpleado(cedulaActual);
		if(empleadoActual == null)
			throw new EmpleadoException("El empleado a actualizar no existe");
		else{
			empleadoActual.setNombre(empleado.getNombre());
			empleadoActual.setCedula(empleado.getCedula());
			empleadoActual.setCorreo(empleado.getCorreo());
			return true;
		}
	}

	@Override
	public Boolean eliminarEmpleado(String cedula) throws EmpleadoException {
		Empleado empleado = null;
		boolean flagExiste = false;
		empleado = obtenerEmpleado(cedula);
		if(empleado == null)
			throw new EmpleadoException("El empleado a eliminar no existe");
		else{
			getListaEmpleados().remove(empleado);
			flagExiste = true;
		}
		return flagExiste;
	}

	@Override
	public boolean verificarEmpleadoExistente(String cedula) throws EmpleadoException {
		if(empleadoExiste(cedula)){
			throw new EmpleadoException("El empleado con cedula: "+cedula+" ya existe");
		}else{
			return false;
		}
	}

	@Override
	public Empleado obtenerEmpleado(String cedula) {
		Empleado empleadoEncontrado = null;
		for (Empleado empleado : getListaEmpleados()) {
			if(empleado.getCedula().equalsIgnoreCase(cedula)){
				empleadoEncontrado = empleado;
				break;
			}
		}
		return empleadoEncontrado;
	}

	@Override
	public ArrayList<Empleado> obtenerEmpleados() {
		return getListaEmpleados();
	}

	public boolean empleadoExiste(String cedula) {
		boolean empleadoEncontrado = false;
		for (Empleado empleado : getListaEmpleados()) {
			if(empleado.getCedula().equalsIgnoreCase(cedula)){
				empleadoEncontrado = true;
				break;
			}
		}
		return empleadoEncontrado;
	}


	//Metodos reserva


	@Override
	public Reserva crearReserva(String id, String fechaSolicitud) throws ReservaException {
		Reserva nuevaReserva = null;
		boolean reservaExiste = verificarReservaExistente(id);
		if(reservaExiste){
			throw new ReservaException("La reserva con ID: "+id+" ya existe");
		}else{
			nuevaReserva = new Reserva();
			nuevaReserva.setId(id);
			nuevaReserva.setFechaSolicitud(fechaSolicitud);
			getListaReservas().add(nuevaReserva);
		}
		return nuevaReserva;
	}

	public void agregarReserva(Reserva nuevaReserva) throws ReservaException{
		getListaReservas().add(nuevaReserva);
	}

	@Override
	public boolean actualizarReserva (String idActual, Reserva reserva) throws ReservaException {
		Reserva reservaActual = obtenerReserva(idActual);
		if(reservaActual == null)
			throw new ReservaException("La reserva a actualizar no existe");
		else{
			reservaActual.setId(reserva.getId());

			reservaActual.setFechaSolicitud(reserva.getFechaSolicitud());

			return true;
		}
	}



	@Override
	public Boolean eliminarReserva(String id) throws ReservaException {
		Reserva reserva = null;
		boolean flagExiste = false;
		reserva = obtenerReserva(id);
		if(reserva == null)
			throw new ReservaException("La reserva a eliminar no existe");
		else{
			getListaReservas().remove(reserva);
			flagExiste = true;
		}
		return flagExiste;
	}

	@Override
	public boolean verificarReservaExistente(String id) throws ReservaException {
		if(reservaExiste(id)){
			throw new ReservaException("La reserva con id: "+id+" ya existe");
		}else{
			return false;
		}
	}


	@Override
	public Reserva obtenerReserva(String id) {
		Reserva reservaEncontrada = null;
		for (Reserva reserva : getListaReservas()) {
			if(reserva.getId().equalsIgnoreCase(id)){
				reservaEncontrada = reserva;
				break;
			}
		}
		return reservaEncontrada;
	}

	@Override
	public ArrayList<Reserva> obtenerReservas() {
		// TODO Auto-generated method stub
		return getListaReservas();
	}


	public boolean reservaExiste(String id) {
		boolean reservaEncontrada = false;
		for (Reserva reserva : getListaReservas()) {
			if(reserva.getId().equalsIgnoreCase(id)){
				reservaEncontrada = true;
				break;
			}
		}
		return reservaEncontrada;
	}



	//Metodos evento



	@Override
	public Evento crearEvento(String id, String nombre, String descripcion, String fecha, int capacidadMaxima) throws EventoException {
		Evento nuevoEvento = null;
		boolean eventoExiste = verificarEventoExistente(id);
		if(eventoExiste){
			throw new EventoException("El evento con ID: "+id+" ya existe");
		}else{
			nuevoEvento = new Evento();
			nuevoEvento.setId(id);
			nuevoEvento.setNombre(nombre);
			nuevoEvento.setDescripcion(descripcion);
			nuevoEvento.setFecha(fecha);
			nuevoEvento.setCapacidadMaxima(capacidadMaxima);
			getListaEventos().add(nuevoEvento);
		}
		return nuevoEvento;
	}

	public void agregarEvento(Evento nuevoEvento) throws EventoException{
		getListaEventos().add(nuevoEvento);
	}

	@Override
	public boolean actualizarEvento(String idActual, Evento evento) throws EventoException {
		Evento eventoActual = obtenerEvento(idActual);
		if(eventoActual == null)
			throw new EventoException("El evento a actualizar no existe");
		else{
			eventoActual.setId(evento.getId());

			eventoActual.setNombre(evento.getNombre());

			eventoActual.setDescripcion(evento.getDescripcion());

			eventoActual.setFecha(evento.getFecha());

			eventoActual.setCapacidadMaxima(evento.getCapacidadMaxima());

			return true;
		}
	}

	@Override
	public Boolean eliminarEvento(String id) throws EventoException {
		Evento evento = null;
		boolean flagExiste = false;
		evento = obtenerEvento(id);
		if(evento == null)
			throw new EventoException("El evento a eliminar no existe");
		else{
			getListaEventos().remove(evento);
			flagExiste = true;
		}
		return flagExiste;
	}

	@Override
	public boolean verificarEventoExistente(String id) throws EventoException {
		if(eventoExiste(id)){
			throw new EventoException("El evento con cedula: "+id+" ya existe");
		}else{
			return false;
		}
	}


	@Override
	public Evento obtenerEvento(String id) {
		Evento eventoEncontrado = null;
		for (Evento evento : getListaEventos()) {
			if(evento.getId().equalsIgnoreCase(id)){
				eventoEncontrado = evento;
				break;
			}
		}
		return eventoEncontrado;
	}

	@Override
	public ArrayList<Evento> obtenerEventos() {
		// TODO Auto-generated method stub
		return getListaEventos();
	}

	public boolean eventoExiste(String id) {
		boolean eventoEncontrado = false;
		for (Evento evento : getListaEventos()) {
			if(evento.getId().equalsIgnoreCase(id)){
				eventoEncontrado = true;
				break;
			}
		}
		return eventoEncontrado;
	}
}
