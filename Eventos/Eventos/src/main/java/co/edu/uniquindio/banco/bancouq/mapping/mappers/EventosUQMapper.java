package co.edu.uniquindio.banco.bancouq.mapping.mappers;
import co.edu.uniquindio.banco.bancouq.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.banco.bancouq.mapping.dto.EventoDto;
import co.edu.uniquindio.banco.bancouq.mapping.dto.ReservaDto;
import co.edu.uniquindio.banco.bancouq.mapping.dto.UsuarioDto;
import co.edu.uniquindio.banco.bancouq.model.Empleado;
import co.edu.uniquindio.banco.bancouq.model.Evento;
import co.edu.uniquindio.banco.bancouq.model.Usuario;
import co.edu.uniquindio.banco.bancouq.model.Reserva;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

//Clase que se encarga de mapear los objetos de la aplicacion
//a objetos DTO y viceversa

@Mapper
public interface EventosUQMapper {
    EventosUQMapper INSTANCE = Mappers.getMapper(EventosUQMapper.class);


    //Mapea un objeto Usuario a un objeto UsuarioDto
    //Recibe un objeto Usuario y retorna un objeto UsuarioDto
    @Named("usuarioToUsuarioDto")
    UsuarioDto usuarioToUsuarioDto(Usuario usuario);

    Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto);

    @IterableMapping(qualifiedByName = "usuarioToUsuarioDto")
    List<UsuarioDto> getUsuariosDto(List<Usuario> listaUsuarios);

    @Named("empleadoToEmpleadoDto")
    EmpleadoDto empleadoToEmpleadoDto(Empleado empleado);

    Empleado empleadoDtoToEmpleado(EmpleadoDto empleadoDto);

    @IterableMapping(qualifiedByName = "empleadoToEmpleadoDto")
    List<EmpleadoDto> getEmpleadosDto(List<Empleado> listaEmpleados);

    @Named("reservaToReservaDto")
    ReservaDto reservaToReservaDto(Reserva reserva);

    Reserva reservaDtoToReserva(ReservaDto reservaDto);

    @IterableMapping(qualifiedByName = "reservaToReservaDto")
    List<ReservaDto> getReservasDto(List<Reserva> listaReservas);

    @Named("eventoToEventoDto")
    EventoDto eventoToEventoDto(Evento evento);

    Evento eventoDtoToEvento(EventoDto eventoDto);

    @IterableMapping(qualifiedByName = "eventoToEventoDto")
    List<EventoDto> getEventosDto(List<Evento> listaEventos);

}
