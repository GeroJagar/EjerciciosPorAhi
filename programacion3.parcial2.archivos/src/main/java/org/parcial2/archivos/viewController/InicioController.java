package org.parcial2.archivos.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import org.parcial2.archivos.Main;

import java.util.ResourceBundle;

public class InicioController {
    @FXML
    private Button log;

    @FXML
    private TextField passwd;

    @FXML
    private TextField username;

    private Main mainApp;

    private ResourceBundle resourceBundle = ResourceBundle.getBundle("config");

    @FXML
    private void ingresarLog(ActionEvent event) {
        String user1 = resourceBundle.getString("usuario1");
        String pass1 = resourceBundle.getString("contraseña1");
        String user2 = resourceBundle.getString("usuario2");
        String pass2 = resourceBundle.getString("contraseña2");

        if ((username.getText().equals(user1) && passwd.getText().equals(pass1)) ||
                (username.getText().equals(user2) && passwd.getText().equals(pass2))) {
           mainApp.mostrarVentanaAsignacion();
        } else {
            mostrarMensaje("Notificación", "Error de datos", "La contraseña o el nombre de usuario son incorrectos", Alert.AlertType.ERROR);
        }
    }


    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }
}


