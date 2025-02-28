package co.edu.uniquindio.banco.bancouq;

import co.edu.uniquindio.banco.bancouq.controller.ModelFactoryController;
import co.edu.uniquindio.banco.bancouq.mapping.dto.UsuarioDto;

import java.util.List;

public class MainEventosUQ {

    public static void main(String[] args) {
        ModelFactoryController modelFactoryController = ModelFactoryController.getInstance();

        UsuarioDto usuarioDto = new UsuarioDto(
                "juan arias",
                "1095208375",
                "juan@gmail.com"
                );

        if(modelFactoryController.agregarUsuario(usuarioDto)){
            System.out.println("No existe se agrgeo correctamente");
        }else{
            System.out.println("Ya existe");
        }

        List<UsuarioDto> usuarioDtoList = modelFactoryController.obtenerUsuarios();
        usuarioDtoList.forEach(System.out::println);
    }
}
