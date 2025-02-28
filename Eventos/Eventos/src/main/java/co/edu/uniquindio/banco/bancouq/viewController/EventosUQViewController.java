package co.edu.uniquindio.banco.bancouq.viewController;

import co.edu.uniquindio.banco.bancouq.controller.EventosUQController;
import co.edu.uniquindio.banco.bancouq.controller.service.IEventosUQControllerService;
import co.edu.uniquindio.banco.bancouq.model.Rol;
import co.edu.uniquindio.banco.bancouq.model.UserLog;
import co.edu.uniquindio.banco.bancouq.model.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class EventosUQViewController {

    IEventosUQControllerService eventosUQControllerService;

    @FXML
    private Tab tabEmpleado;

    @FXML
    private Tab tabEvento;

    @FXML
    private Tab tabReserva;

    @FXML
    private Tab tabUsuario;

    @FXML
    private TabPane tabPaneCompleto;

    public void setUser(UserLog user) {
        switch (user.getRol()) {
            case "admin":
                // todos los tabs son visibles
                tabEmpleado.setDisable(false);
                tabEvento.setDisable(false);
                tabReserva.setDisable(false);
                tabUsuario.setDisable(false);
                break;
            case "usuario":
                // solo los tabs de usuario y reserva son visibles
                tabEmpleado.setDisable(true);
                tabEvento.setDisable(true);
                tabReserva.setDisable(false);
                tabUsuario.setDisable(false);
                break;
            case "empleado":
                // solo los tabs de empleado y evento son visibles
                tabEmpleado.setDisable(false);
                tabEvento.setDisable(false);
                tabReserva.setDisable(true);
                tabUsuario.setDisable(true);
                break;
            default:
                // manejar rol desconocido
                tabEmpleado.setDisable(true);
                tabEvento.setDisable(true);
                tabReserva.setDisable(true);
                tabUsuario.setDisable(true);
                break;
        }
    }

    @FXML
    void initialize() {

    }

}
