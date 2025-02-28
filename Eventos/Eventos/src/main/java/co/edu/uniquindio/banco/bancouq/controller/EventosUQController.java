package co.edu.uniquindio.banco.bancouq.controller;

import co.edu.uniquindio.banco.bancouq.controller.service.IEventosUQControllerService;

public class EventosUQController implements IEventosUQControllerService {

    ModelFactoryController modelFactoryController;

    public EventosUQController(){
        System.out.println("Llamando al singleton desde BancoServiceController");
        modelFactoryController = ModelFactoryController.getInstance();
    }
}
