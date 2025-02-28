package co.edu.uniquindio.banco.bancouq.controller.service;

import co.edu.uniquindio.banco.bancouq.mapping.dto.EventoDto;

import java.util.List;

public interface IEventoControllerService {
    List<EventoDto> obtenerEventos();

    boolean agregarEvento(EventoDto eventoDto);

    boolean eliminarEvento(String id);

    boolean actualizarEvento(String idActual, EventoDto eventoDto);
}
