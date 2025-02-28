module org.parcial2.archivos {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.parcial2.archivos.viewController to javafx.fxml;
    exports org.parcial2.archivos;
}