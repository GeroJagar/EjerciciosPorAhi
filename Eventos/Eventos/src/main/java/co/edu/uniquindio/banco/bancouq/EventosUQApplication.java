package co.edu.uniquindio.banco.bancouq;

import co.edu.uniquindio.banco.bancouq.model.UserLog;
import co.edu.uniquindio.banco.bancouq.viewController.EventosUQViewController;
import co.edu.uniquindio.banco.bancouq.viewController.LoginViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

//Clase principal de la aplicacion
//Esta clase se encarga de cargar la ventana de login
//y de cargar la ventana principal de la aplicacion
//dependiendo del usuario que se loguee


public class EventosUQApplication extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        this.primaryStage = stage;
        this.primaryStage.setTitle("Eventos UQ");
        mostrarVentanaLogin();
    }

    public void mostrarVentanaLogin() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(EventosUQApplication.class.getResource("Login.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            LoginViewController loginViewController = loader.getController();
            loginViewController.setMainApp(this);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarVentanaPrincipal(UserLog user) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(EventosUQApplication.class.getResource("EventosUQ.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            EventosUQViewController bancoViewController = loader.getController();
            bancoViewController.setUser(user);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}