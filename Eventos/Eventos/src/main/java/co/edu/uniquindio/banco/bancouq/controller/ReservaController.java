package co.edu.uniquindio.banco.bancouq.controller;

import co.edu.uniquindio.banco.bancouq.controller.service.IReservaControllerService;
import co.edu.uniquindio.banco.bancouq.mapping.dto.ReservaDto;
import co.edu.uniquindio.banco.bancouq.model.Empleado;

import java.util.List;

public class ReservaController implements IReservaControllerService {
    ModelFactoryController modelFactoryController;

    public ReservaController(){
        modelFactoryController = ModelFactoryController.getInstance();
    }

    public List<ReservaDto> obtenerReservas() {
        return modelFactoryController.obtenerReservas();
    }

    @Override
    public boolean agregarReserva(ReservaDto reservaDto) {
        return modelFactoryController.agregarReserva(reservaDto);
    }

    @Override
    public boolean eliminarReserva(String id) {
        return modelFactoryController.eliminarReserva(id);
    }

    @Override
    public boolean actualizarReserva(String idActual, ReservaDto reservaDto) {
        return modelFactoryController.actualizarReserva(idActual, reservaDto);
    }
}
