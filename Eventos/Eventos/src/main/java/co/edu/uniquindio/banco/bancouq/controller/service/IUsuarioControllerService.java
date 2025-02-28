package co.edu.uniquindio.banco.bancouq.controller.service;

import co.edu.uniquindio.banco.bancouq.mapping.dto.UsuarioDto;

import java.util.List;

public interface IUsuarioControllerService {
    List<UsuarioDto> obtenerUsuarios();

    boolean agregarUsuario(UsuarioDto usuarioDto);

    boolean eliminarUsuario(String cedula);

    boolean actualizarUsuario(String cedulaActual, UsuarioDto usuarioDto);
}
