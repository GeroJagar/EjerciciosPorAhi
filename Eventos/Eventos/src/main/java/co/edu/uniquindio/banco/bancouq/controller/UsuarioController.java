package co.edu.uniquindio.banco.bancouq.controller;

import co.edu.uniquindio.banco.bancouq.controller.service.IUsuarioControllerService;
import co.edu.uniquindio.banco.bancouq.mapping.dto.UsuarioDto;
import co.edu.uniquindio.banco.bancouq.model.Usuario;

import java.util.List;

public class UsuarioController implements IUsuarioControllerService {
    ModelFactoryController modelFactoryController;

    public UsuarioController(){
        modelFactoryController = ModelFactoryController.getInstance();
    }

    public List<UsuarioDto> obtenerUsuarios() {
        return modelFactoryController.obtenerUsuarios();
    }

    @Override
    public boolean agregarUsuario(UsuarioDto usuarioDto) {
        return modelFactoryController.agregarUsuario(usuarioDto);
    }

    @Override
    public boolean eliminarUsuario(String cedula) {
        return modelFactoryController.eliminarUsuario(cedula);
    }

    @Override
    public boolean actualizarUsuario(String cedulaActual, UsuarioDto usuarioDto) {
        return modelFactoryController.actualizarUsuario(cedulaActual, usuarioDto);
    }
}
