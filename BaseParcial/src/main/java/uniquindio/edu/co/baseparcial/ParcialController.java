package uniquindio.edu.co.baseparcial;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ParcialController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}