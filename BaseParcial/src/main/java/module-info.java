module uniquindio.edu.co.baseparcial {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.logging;
    requires org.mapstruct;
    requires java.desktop;

    opens uniquindio.edu.co.baseparcial to javafx.fxml;
    exports uniquindio.edu.co.baseparcial;
    exports uniquindio.edu.co.baseparcial.controller.service;
    opens uniquindio.edu.co.baseparcial.controller.service to javafx.fxml;
}