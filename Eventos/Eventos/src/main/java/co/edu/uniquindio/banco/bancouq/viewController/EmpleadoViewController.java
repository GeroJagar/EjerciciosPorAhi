package co.edu.uniquindio.banco.bancouq.viewController;

import co.edu.uniquindio.banco.bancouq.controller.EmpleadoController;
import co.edu.uniquindio.banco.bancouq.controller.UsuarioController;
import co.edu.uniquindio.banco.bancouq.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.banco.bancouq.model.UserLog;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class EmpleadoViewController {

    EmpleadoController EmpleadoControllerService;
    ObservableList<EmpleadoDto> listaEmpleadosDto = FXCollections.observableArrayList();
    EmpleadoDto empleadoSeleccionado;
    private static final Logger LOGGER = Logger.getLogger(UserLog.class.getName());

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizarEmpleado;

    @FXML
    private Button btnAgregarEmpleado;

    @FXML
    private Button btnEliminarEmpleado;

    @FXML
    private Button btnNuevoEmpleado;

    @FXML
    private TableView<EmpleadoDto> tablaEmpleados;

    @FXML
    private TableColumn<EmpleadoDto, String> tcCorreoEmpleado;

    @FXML
    private TableColumn<EmpleadoDto, String> tcIDEmpleado;

    @FXML
    private TableColumn<EmpleadoDto, String> tcNombreEmpleado;

    @FXML
    private TextField txtCorreoEmpleado;

    @FXML
    private TextField txtIDEmpleado;

    @FXML
    private TextField txtNombreEmpleado;

    @FXML
    void initialize() {
        EmpleadoControllerService = new EmpleadoController();
        intiView();
    }

    private void intiView() {
        initDataBinding();
        obtenerEmpleados();
        tablaEmpleados.getItems().clear();
        tablaEmpleados.setItems(listaEmpleadosDto);
        listenerSelection();
    }

    private void initDataBinding() {
        tcNombreEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));
        tcIDEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().cedula()));
        tcCorreoEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().correo()));

    }

    private void obtenerEmpleados() {
        listaEmpleadosDto.addAll(EmpleadoControllerService.obtenerEmpleados());
    }

    private void listenerSelection() {
        tablaEmpleados.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            empleadoSeleccionado = newSelection;
            mostrarInformacionEmpleado(empleadoSeleccionado);
        });
    }

    private void mostrarInformacionEmpleado(EmpleadoDto empleadoSeleccionado) {
        if(empleadoSeleccionado != null){
            txtNombreEmpleado.setText(empleadoSeleccionado.nombre());
            txtIDEmpleado.setText(empleadoSeleccionado.cedula());
            txtCorreoEmpleado.setText(empleadoSeleccionado.correo());
        }
    }

    @FXML
    void nuevoEmpleadoAction(ActionEvent event) {
        txtNombreEmpleado.setText("Ingrese el nombre");
        txtIDEmpleado.setText("Ingrese la cedula");
        txtCorreoEmpleado.setText("Ingrese el correo");
    }

    @FXML
    void agregarEmpleadoAction(ActionEvent event) {

        try {
            crearEmpleado();
        } catch (IOException e) {

        }
    }

    @FXML
    void eliminarEmpleadoAction(ActionEvent event) {
        try {
            eliminarEmpleado();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void actualizarEmpleadoAction(ActionEvent event) {
        actualizarEmpleado();
    }

    private void crearEmpleado() throws IOException {
        //1. Capturar los datos
        EmpleadoDto empleadoDto = construirEmpleadoDto();
        //2. Validar la información
        if(datosValidos(empleadoDto)){
            if(EmpleadoControllerService.agregarEmpleado(empleadoDto)){
                FileHandler archivoLogger = new FileHandler("src/main/resources/persistencia/log/logproyecto_LOG.txt", true);
                archivoLogger.setFormatter(new SimpleFormatter());
                LOGGER.addHandler(archivoLogger);
                LOGGER.info("Se registro el empleado: "+empleadoDto.nombre()+", a las "+ LocalDateTime.now());
                listaEmpleadosDto.add(empleadoDto);
                mostrarMensaje("Notificación empleado", "Empleado creado", "El empleado se ha creado con éxito", Alert.AlertType.INFORMATION);
                limpiarCamposEmpleado();
            }else{
                mostrarMensaje("Notificación empleado", "Empleado no creado", "El empleado no se ha creado con éxito", Alert.AlertType.ERROR);
            }
        }else{
            mostrarMensaje("Notificación empleado", "Empleado no creado", "Los datos ingresados son invalidos", Alert.AlertType.ERROR);
        }
    }

    private void eliminarEmpleado() throws IOException {
        boolean empleadoEliminado = false;
        if (empleadoSeleccionado != null) {
            if (mostrarMensajeConfirmacion("¿Estas seguro de eliminar al Empleado?")) {
                empleadoEliminado = EmpleadoControllerService.eliminarEmpleado(empleadoSeleccionado.cedula());
                if (empleadoEliminado == true) {
                    FileHandler archivoLogger = new FileHandler("src/main/resources/persistencia/log/logproyecto_LOG.txt", true);
                    archivoLogger.setFormatter(new SimpleFormatter());
                    LOGGER.addHandler(archivoLogger);
                    LOGGER.info("Se elimino el empleado: "+empleadoSeleccionado.nombre()+", a las "+ LocalDateTime.now());
                    listaEmpleadosDto.remove(empleadoSeleccionado);
                    empleadoSeleccionado = null;
                    tablaEmpleados.getSelectionModel().clearSelection();
                    limpiarCamposEmpleado();
                    mostrarMensaje("Notificación Empleado", "Empleado eliminado", "El Empleado se ha eliminado con éxito", Alert.AlertType.INFORMATION);
                } else {
                    mostrarMensaje("Notificación Empleado", "Empleado no eliminado", "El Empleado no se puede eliminar", Alert.AlertType.ERROR);
                }
            }
        } else {
            mostrarMensaje("Notificación Empleado", "Empleado no seleccionado", "Seleccionado un Empleado de la lista", Alert.AlertType.WARNING);
        }
    }

    private void actualizarEmpleado() {
        boolean empleadoActualizado = false;
        //1. Capturar los datos
        String cedulaActual = empleadoSeleccionado.cedula();
        EmpleadoDto empleadoDto = construirEmpleadoDto();
        //2. verificar el empleado seleccionado
        if(empleadoSeleccionado != null){
            //3. Validar la información
            if(datosValidos(empleadoDto)){
                empleadoActualizado = EmpleadoControllerService.actualizarEmpleado(cedulaActual,empleadoDto);
                if(empleadoActualizado){
                    listaEmpleadosDto.remove(empleadoSeleccionado);
                    listaEmpleadosDto.add(empleadoDto);
                    tablaEmpleados.refresh();
                    mostrarMensaje("Notificación Empleado", "Empleado actualizado", "El Empleado se ha actualizado con éxito", Alert.AlertType.INFORMATION);
                    limpiarCamposEmpleado();
                }else{
                    mostrarMensaje("Notificación Empleado", "Empleado no actualizado", "El Empleado no se ha actualizado con éxito", Alert.AlertType.INFORMATION);
                }
            }else{
                mostrarMensaje("Notificación Empleado", "Empleado no creado", "Los datos ingresados son invalidos", Alert.AlertType.ERROR);
            }
        }
    }

    private EmpleadoDto construirEmpleadoDto() {
        return new EmpleadoDto(
                txtNombreEmpleado.getText(),
                txtIDEmpleado.getText(),
                txtCorreoEmpleado.getText()
        );
    }

    private void limpiarCamposEmpleado() {
        txtNombreEmpleado.setText("");
        txtIDEmpleado.setText("");
        txtCorreoEmpleado.setText("");
    }

    private boolean datosValidos(EmpleadoDto empleadoDto) {
        String mensaje = "";
        if(empleadoDto.nombre() == null || empleadoDto.nombre().equals(""))
            mensaje += "El nombre es invalido \n" ;
        if(empleadoDto.cedula() == null || empleadoDto.cedula().equals(""))
            mensaje += "El documento es invalido \n" ;
        if(empleadoDto.correo() == null || empleadoDto.correo().equals(""))
            mensaje += "El correo es invalido \n" ;
        if(mensaje.equals("")){
            return true;
        }else{
            mostrarMensaje("Notificación empleado","Datos invalidos",mensaje, Alert.AlertType.WARNING);
            return false;
        }
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

    private boolean mostrarMensajeConfirmacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText(mensaje);
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }
}
