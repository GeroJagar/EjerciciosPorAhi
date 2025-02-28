package co.edu.uniquindio.banco.bancouq.viewController;

import co.edu.uniquindio.banco.bancouq.controller.EventoController;
import co.edu.uniquindio.banco.bancouq.mapping.dto.EventoDto;
import co.edu.uniquindio.banco.bancouq.mapping.dto.UsuarioDto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Optional;

public class EventoViewController {

    EventoController EventoControllerService;
    ObservableList<EventoDto> listaEventosDto = FXCollections.observableArrayList();
    EventoDto eventoSeleccionado;

    @FXML
    private Button btnActualizarEvento;

    @FXML
    private Button btnAgregarEvento;

    @FXML
    private Button btnEliminarEvento;

    @FXML
    private Button btnNuevoEvento;

    @FXML
    private TableView<EventoDto> tablaEvento;

    @FXML
    private TableColumn<EventoDto, String> tcCapacidadMaxEvento;

    @FXML
    private TableColumn<EventoDto, String> tcDescripcionEvento;

    @FXML
    private TableColumn<EventoDto, String> tcFechaEvento;

    @FXML
    private TableColumn<EventoDto, String> tcIDEvento;

    @FXML
    private TableColumn<EventoDto, String> tcNombreEvento;

    @FXML
    private TextField txtCapacidadMaxEvento;

    @FXML
    private TextField txtDescripcionEvento;

    @FXML
    private TextField txtFechaEvento;

    @FXML
    private TextField txtIDEvento;

    @FXML
    private TextField txtNombreEvento;

    @FXML
    void initialize() {
        EventoControllerService = new EventoController();
        intiView();
    }

    private void intiView() {
        initDataBinding();
        obtenerEventos();
        tablaEvento.getItems().clear();
        tablaEvento.setItems(listaEventosDto);
        listenerSelection();
    }

    private void initDataBinding() {
        tcIDEvento.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().id()));
        tcNombreEvento.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));
        tcDescripcionEvento.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().descripcion()));
        tcFechaEvento.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().fecha()));
        tcCapacidadMaxEvento.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().capacidadMax())));

    }

    private void obtenerEventos() {
        listaEventosDto.addAll(EventoControllerService.obtenerEventos());
    }

    private void listenerSelection() {
        tablaEvento.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            eventoSeleccionado = newSelection;
            mostrarInformacionEvento(eventoSeleccionado);
        });
    }

    private void mostrarInformacionEvento(EventoDto eventoSeleccionado) {
        if(eventoSeleccionado != null){
            txtIDEvento.setText(eventoSeleccionado.id());
            txtNombreEvento.setText(eventoSeleccionado.nombre());
            txtDescripcionEvento.setText(eventoSeleccionado.descripcion());
            txtFechaEvento.setText(eventoSeleccionado.fecha());
            txtCapacidadMaxEvento.setText(String.valueOf(eventoSeleccionado.capacidadMax()));
        }
    }

    @FXML
    void nuevoEventoAction(ActionEvent event) {
        txtIDEvento.setText("Ingrese el ID");
        txtNombreEvento.setText("Ingrese el nombre");
        txtDescripcionEvento.setText("Ingrese la descripcion");
        txtFechaEvento.setText("Ingrese la fecha");
        txtCapacidadMaxEvento.setText("Ingrese la capacidad maxima");
    }

    @FXML
    void agregarEventoAction(ActionEvent event) {
        crearEvento();
    }

    @FXML
    void eliminarEventoAction(ActionEvent event) {
        eliminarEvento();
    }


    @FXML
    void actualizarEventoAction(ActionEvent event) {
        actualizarEvento();
    }

    private void crearEvento() {
        //1. Capturar los datos
        EventoDto eventoDto = construirEventoDto();
        //2. Validar la información
        if(datosValidos(eventoDto)){
            if(EventoControllerService.agregarEvento(eventoDto)){
                listaEventosDto.add(eventoDto);
                mostrarMensaje("Notificación Evento", "Evento creado", "El Evento se ha creado con éxito", Alert.AlertType.INFORMATION);
                limpiarCamposEvento();
            }else{
                mostrarMensaje("Notificación Evento", "Evento no creado", "El Evento no se ha creado con éxito", Alert.AlertType.ERROR);
            }
        }else{
            mostrarMensaje("Notificación Evento", "Evento no creado", "Los datos ingresados son invalidos", Alert.AlertType.ERROR);
        }
    }

    private void eliminarEvento() {
        boolean eventoEliminado = false;
        if (eventoSeleccionado != null) {
            if (mostrarMensajeConfirmacion("¿Estas seguro de eliminar el Evento?")) {
                eventoEliminado = EventoControllerService.eliminarEvento(eventoSeleccionado.id());
                if (eventoEliminado) {
                    listaEventosDto.remove(eventoSeleccionado);
                    eventoSeleccionado = null;
                    tablaEvento.getSelectionModel().clearSelection();
                    limpiarCamposEvento();
                    mostrarMensaje("Notificación Evento", "Evento eliminado", "El Evento se ha eliminado con éxito", Alert.AlertType.INFORMATION);
                } else {
                    mostrarMensaje("Notificación Evento", "Evento no eliminado", "El Evento no se puede eliminar", Alert.AlertType.ERROR);
                }
            }
        } else {
            mostrarMensaje("Notificación Evento", "Evento no seleccionado", "Selecciona un Evento de la lista", Alert.AlertType.WARNING);
        }
    }

    private void actualizarEvento() {
        boolean eventoActualizado = false;
        //1. Capturar los datos
        String idActual = eventoSeleccionado.id();
        EventoDto eventoDto = construirEventoDto();
        //2. verificar el evento seleccionado
        if(eventoSeleccionado != null){
            //3. Validar la información
            if(datosValidos(eventoDto)){
                eventoActualizado = EventoControllerService.actualizarEvento(idActual, eventoDto);
                if(eventoActualizado){
                    listaEventosDto.remove(eventoSeleccionado);
                    listaEventosDto.add(eventoDto);
                    tablaEvento.refresh();
                    mostrarMensaje("Notificación Evento", "Evento actualizado", "El Evento se ha actualizado con éxito", Alert.AlertType.INFORMATION);
                    limpiarCamposEvento();
                }else{
                    mostrarMensaje("Notificación Evento", "Evento no actualizado", "El Evento no se ha actualizado con éxito", Alert.AlertType.INFORMATION);
                }
            }else{
                mostrarMensaje("Notificación Evento", "Evento no creado", "Los datos ingresados son invalidos", Alert.AlertType.ERROR);
            }
        }
    }

    private EventoDto construirEventoDto() {
        return new EventoDto(
                txtIDEvento.getText(),
                txtNombreEvento.getText(),
                txtDescripcionEvento.getText(),
                txtFechaEvento.getText(),
                Integer.valueOf(txtCapacidadMaxEvento.getText())
        );
    }

    private void limpiarCamposEvento() {
        txtIDEvento.setText("");

        txtNombreEvento.setText("");

        txtDescripcionEvento.setText("");

        txtFechaEvento.setText("");

        txtCapacidadMaxEvento.setText("");

    }

    private boolean datosValidos(EventoDto eventoDto) {
        String mensaje = "";
        if(eventoDto.id() == null || eventoDto.id().equals(""))
            mensaje += "El ID es invalido \n" ;
        if(eventoDto.nombre() == null || eventoDto.nombre().equals(""))
            mensaje += "El nombre es invalido \n" ;
        if(eventoDto.descripcion() == null || eventoDto.descripcion().equals(""))
            mensaje += "La descripcion es invalida \n" ;
        if(eventoDto.fecha() == null || eventoDto.fecha().equals(""))
            mensaje += "La fecha es invalida \n" ;
        if(eventoDto.capacidadMax() == null || eventoDto.capacidadMax().equals(""))
            mensaje += "La capacidad maxima es invalida \n" ;
        if(mensaje.equals("")){
            return true;
        }else{
            mostrarMensaje("Notificación cliente","Datos invalidos",mensaje, Alert.AlertType.WARNING);
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
