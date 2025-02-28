package co.edu.uniquindio.banco.bancouq.controller.service;

import co.edu.uniquindio.banco.bancouq.mapping.dto.ReservaDto;

import java.util.List;

public interface IReservaControllerService {
    List<ReservaDto> obtenerReservas();

    boolean agregarReserva(ReservaDto reservaDto);

    boolean eliminarReserva(String id);

    boolean actualizarReserva(String idActual, ReservaDto reservaDto);
}
