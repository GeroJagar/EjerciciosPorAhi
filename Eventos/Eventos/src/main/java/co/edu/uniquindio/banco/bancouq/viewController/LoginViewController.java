package co.edu.uniquindio.banco.bancouq.viewController;

import co.edu.uniquindio.banco.bancouq.EventosUQApplication;
import co.edu.uniquindio.banco.bancouq.model.LoginService;
import co.edu.uniquindio.banco.bancouq.model.UserLog;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginViewController {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    private EventosUQApplication mainApp;
    private LoginService loginService;

    public LoginViewController() {
        loginService = new LoginService();
    }

    public void setMainApp(EventosUQApplication mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        UserLog user = loginService.login(username, password);
        if (user != null) {
            mainApp.mostrarVentanaPrincipal(user);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de inicio de sesión");
            alert.setHeaderText(null);
            alert.setContentText("Usuario no válido");

            alert.showAndWait();
        }
    }
}