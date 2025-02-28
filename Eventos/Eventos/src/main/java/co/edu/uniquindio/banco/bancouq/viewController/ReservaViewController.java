package co.edu.uniquindio.banco.bancouq.viewController;

import co.edu.uniquindio.banco.bancouq.controller.EmpleadoController;
import co.edu.uniquindio.banco.bancouq.controller.ReservaController;
import co.edu.uniquindio.banco.bancouq.mapping.dto.ReservaDto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Optional;

public class ReservaViewController {

    ReservaController ReservaControllerService;
    ObservableList<ReservaDto> listaReservaDto = FXCollections.observableArrayList();
    ReservaDto reservaSeleccionada;

    @FXML
    private Button btnActualizarReserva;

    @FXML
    private Button btnAgregarReserva;

    @FXML
    private Button btnEliminarReserva;

    @FXML
    private Button btnNuevoReserva;

    @FXML
    private TableView<ReservaDto> tablaReserva;

    @FXML
    private TableColumn<ReservaDto, String> tcFechaReserva;

    @FXML
    private TableColumn<ReservaDto, String> tcIDReserva;


    @FXML
    private TextField txtFechaSolicitud;

    @FXML
    private TextField txtIDReserva;

    @FXML
    void initialize() {
        ReservaControllerService = new ReservaController();
        intiView();
    }

    private void intiView() {
        initDataBinding();
        obtenerReservas();
        tablaReserva.getItems().clear();
        tablaReserva.setItems(listaReservaDto);
        listenerSelection();
    }

    private void initDataBinding() {
        tcIDReserva.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().id()));
        tcFechaReserva.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().fechaSolicitud()));

    }

    private void obtenerReservas() {
            listaReservaDto.addAll(ReservaControllerService.obtenerReservas());
    }

    private void listenerSelection() {
        tablaReserva.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            reservaSeleccionada = newSelection;
            mostrarInformacionReserva(reservaSeleccionada);
        });
    }

    private void mostrarInformacionReserva(ReservaDto reservaSeleccionada) {
        if(reservaSeleccionada != null){
            txtFechaSolicitud.setText(reservaSeleccionada.fechaSolicitud());
            txtIDReserva.setText(reservaSeleccionada.id());
        }
    }

    @FXML
    void nuevoReservaAction(ActionEvent event) {
        txtIDReserva.setText("Ingrese el ID");
        txtFechaSolicitud.setText("Ingrese la fecha de solicitud");
    }

    @FXML
    void agregarReservaAction(ActionEvent event) {
        crearReserva();
    }

    @FXML
    void eliminarReservaAction(ActionEvent event) {
        eliminarReserva();
    }


    @FXML
    void actualizarReservaAction(ActionEvent event) {
        actualizarReserva();
    }

    private void crearReserva() {
        //1. Capturar los datos
        ReservaDto reservaDto = construirReservaDto();
        //2. Validar la información
        if(datosValidos(reservaDto)){
            if(ReservaControllerService.agregarReserva(reservaDto)){
                listaReservaDto.add(reservaDto);
                mostrarMensaje("Notificación reserva", "Reserva creada", "La reserva se ha creado con éxito", Alert.AlertType.INFORMATION);
                limpiarCamposReserva();
            }else{
                mostrarMensaje("Notificación reserva", "Reserva no creada", "La reserva no se ha creado con éxito", Alert.AlertType.ERROR);
            }
        }else{
            mostrarMensaje("Notificación reserva", "Reserva no creada", "Los datos ingresados son invalidos", Alert.AlertType.ERROR);
        }
    }

    private void eliminarReserva() {
        boolean reservaEliminada = false;
        if (reservaSeleccionada != null) {
            if (mostrarMensajeConfirmacion("¿Estas seguro de eliminar la Reserva?")) {
                reservaEliminada = ReservaControllerService.eliminarReserva(reservaSeleccionada.id());
                if (reservaEliminada == true) {
                    listaReservaDto.remove(reservaSeleccionada);
                    reservaSeleccionada = null;
                    tablaReserva.getSelectionModel().clearSelection();
                    limpiarCamposReserva();
                    mostrarMensaje("Notificación Reserva", "Reserva eliminada", "La Reserva se ha eliminado con éxito", Alert.AlertType.INFORMATION);
                } else {
                    mostrarMensaje("Notificación Reserva", "Reserva no eliminada", "La Reserva no se puede eliminar", Alert.AlertType.ERROR);
                }
            }
        } else {
            mostrarMensaje("Notificación Reserva", "Reserva no seleccionada", "Seleccionado una Reserva de la lista", Alert.AlertType.WARNING);
        }
    }

    private void actualizarReserva() {
        boolean reservaActualizada = false;
        //1. Capturar los datos
        String idActual = reservaSeleccionada.id();
        ReservaDto reservaDto = construirReservaDto();
        //2. verificar la reserva seleccionada
        if(reservaSeleccionada != null){
            //3. Validar la información
            if(datosValidos(reservaDto)){
                reservaActualizada = ReservaControllerService.actualizarReserva(idActual,reservaDto);
                if(reservaActualizada){
                    listaReservaDto.remove(reservaSeleccionada);
                    listaReservaDto.add(reservaDto);
                    tablaReserva.refresh();
                    mostrarMensaje("Notificación Reserva", "Reserva actualizada", "La Reserva se ha actualizado con éxito", Alert.AlertType.INFORMATION);
                    limpiarCamposReserva();
                }else{
                    mostrarMensaje("Notificación Reserva", "Reserva no actualizado", "El Reserva no se ha actualizado con éxito", Alert.AlertType.INFORMATION);
                }
            }else{
                mostrarMensaje("Notificación Reserva", "Reserva no creado", "Los datos ingresados son invalidos", Alert.AlertType.ERROR);
            }
        }
    }

    private ReservaDto construirReservaDto() {
        return new ReservaDto(
                txtIDReserva.getText(),
                txtFechaSolicitud.getText()
        );
    }

    private void limpiarCamposReserva() {
        txtIDReserva.setText("");
        txtFechaSolicitud.setText("");
    }

    private boolean datosValidos(ReservaDto reservaDto) {
        String mensaje = "";
        if(reservaDto.id() == null || reservaDto.id().equals(""))
            mensaje += "El ID es invalido \n" ;
        if(reservaDto.fechaSolicitud() == null || reservaDto.fechaSolicitud().equals(""))
            mensaje += "La fecha de solicitud es invalida \n" ;
        if(mensaje.equals("")){
            return true;
        }else{
            mostrarMensaje("Notificación reserva","Datos invalidos",mensaje, Alert.AlertType.WARNING);
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
