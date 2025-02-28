package co.edu.uniquindio.banco.bancouq.controller;


import co.edu.uniquindio.banco.bancouq.controller.service.IEventoControllerService;
import co.edu.uniquindio.banco.bancouq.mapping.dto.EventoDto;
import co.edu.uniquindio.banco.bancouq.model.Usuario;

import java.util.List;

public class EventoController implements IEventoControllerService {
    ModelFactoryController modelFactoryController;

    public EventoController(){
        modelFactoryController = ModelFactoryController.getInstance();
    }

    public List<EventoDto> obtenerEventos() {
        return modelFactoryController.obtenerEventos();
    }

    @Override
    public boolean agregarEvento(EventoDto eventoDto) {
        return modelFactoryController.agregarEvento(eventoDto);
    }

    @Override
    public boolean eliminarEvento(String id) {
        return modelFactoryController.eliminarEvento(id);
    }

    @Override
    public boolean actualizarEvento(String idActual, EventoDto eventoDto) {
        return modelFactoryController.actualizarEvento(idActual, eventoDto);
    }
}
