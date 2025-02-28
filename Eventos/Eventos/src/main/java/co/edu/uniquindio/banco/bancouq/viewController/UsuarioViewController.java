package co.edu.uniquindio.banco.bancouq.viewController;

import co.edu.uniquindio.banco.bancouq.controller.UsuarioController;
import co.edu.uniquindio.banco.bancouq.mapping.dto.UsuarioDto;
import co.edu.uniquindio.banco.bancouq.mapping.dto.UsuarioDto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class UsuarioViewController {
    UsuarioController UsuarioControllerService;
    ObservableList<UsuarioDto> listaUsuariosDto = FXCollections.observableArrayList();
    UsuarioDto usuarioSeleccionado;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNombre;


    @FXML
    private TextField txtCedula;


    @FXML
    private TextField txtCorreo;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnNuevo;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnEliminar;

    @FXML
    private TableView<UsuarioDto> tablaUsuario;

    @FXML
    private TableColumn<UsuarioDto, String> tcNombre;

    @FXML
    private TableColumn<UsuarioDto, String> tcCedula;

    @FXML
    private TableColumn<UsuarioDto, String> tcCorreo;

    @FXML
    void initialize() {
        UsuarioControllerService = new UsuarioController();
        intiView();
    }

    private void intiView() {
        initDataBinding();
        obtenerUsuarios();
        tablaUsuario.getItems().clear();
        tablaUsuario.setItems(listaUsuariosDto);
        listenerSelection();
    }

    private void initDataBinding() {
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));
        tcCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().cedula()));
        tcCorreo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().correo()));

    }

    private void obtenerUsuarios() {
        listaUsuariosDto.addAll(UsuarioControllerService.obtenerUsuarios());
    }

    private void listenerSelection() {
        tablaUsuario.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            usuarioSeleccionado = newSelection;
            mostrarInformacionUsuario(usuarioSeleccionado);
        });
    }

    private void mostrarInformacionUsuario(UsuarioDto usuarioSeleccionado) {
        if(usuarioSeleccionado != null){
            txtNombre.setText(usuarioSeleccionado.nombre());
            txtCedula.setText(usuarioSeleccionado.cedula());
            txtCorreo.setText(usuarioSeleccionado.correo());
        }
    }

    @FXML
    void nuevoUsuarioAction(ActionEvent event) {
        txtNombre.setText("Ingrese el nombre");
        txtCedula.setText("Ingrese la cedula");
        txtCorreo.setText("Ingrese el correo");
    }

    @FXML
    void agregarUsuarioAction(ActionEvent event) {
        crearUsuario();
    }

    @FXML
    void eliminarUsuarioAction(ActionEvent event) {
        eliminarUsuario();
    }


    @FXML
    void actualizarUsuarioAction(ActionEvent event) {
        actualizarUsuario();
    }

    private void crearUsuario() {
        //1. Capturar los datos
        UsuarioDto usuarioDto = construirUsuarioDto();
        //2. Validar la información
        if(datosValidos(usuarioDto)){
            if(UsuarioControllerService.agregarUsuario(usuarioDto)){
                listaUsuariosDto.add(usuarioDto);
                mostrarMensaje("Notificación Usuario", "Usuario creado", "El Usuario se ha creado con éxito", AlertType.INFORMATION);
                limpiarCamposUsuario();
            }else{
                mostrarMensaje("Notificación Usuario", "Usuario no creado", "El Usuario no se ha creado con éxito", AlertType.ERROR);
            }
        }else{
            mostrarMensaje("Notificación Usuario", "Usuario no creado", "Los datos ingresados son invalidos", AlertType.ERROR);
        }

    }

    private void eliminarUsuario() {
        boolean usuarioEliminado = false;
        if (usuarioSeleccionado != null) {
            if (mostrarMensajeConfirmacion("¿Estas seguro de elmininar al Usuario?")) {
                usuarioEliminado = UsuarioControllerService.eliminarUsuario(usuarioSeleccionado.cedula());
                if (usuarioEliminado == true) {
                    listaUsuariosDto.remove(usuarioSeleccionado);
                    usuarioSeleccionado = null;
                    tablaUsuario.getSelectionModel().clearSelection();
                    limpiarCamposUsuario();
                    mostrarMensaje("Notificación Usuario", "Empleado Usuario", "El Usuario se ha eliminado con éxito", AlertType.INFORMATION);
                } else {
                    mostrarMensaje("Notificación Usuario", "Usuario no eliminado", "El Usuario no se puede eliminar", AlertType.ERROR);
                }
            }
        } else {
            mostrarMensaje("Notificación Usuario", "Usuario no seleccionado", "Seleccionado un Usuario de la lista", AlertType.WARNING);
        }
    }

    private void actualizarUsuario() {
        boolean clienteActualizado = false;
        //1. Capturar los datos
        String cedulaActual = usuarioSeleccionado.cedula();
        UsuarioDto usuarioDto = construirUsuarioDto();
        //2. verificar el empleado seleccionado
        if(usuarioSeleccionado != null){
            //3. Validar la información
            if(datosValidos(usuarioSeleccionado)){
                clienteActualizado = UsuarioControllerService.actualizarUsuario(cedulaActual,usuarioDto);
                if(clienteActualizado){
                    listaUsuariosDto.remove(usuarioSeleccionado);
                    listaUsuariosDto.add(usuarioDto);
                    tablaUsuario.refresh();
                    mostrarMensaje("Notificación Usuario", "Usuario actualizado", "El Usuario se ha actualizado con éxito", AlertType.INFORMATION);
                    limpiarCamposUsuario();
                }else{
                    mostrarMensaje("Notificación Usuario", "Usuario no actualizado", "El Usuario no se ha actualizado con éxito", AlertType.INFORMATION);
                }
            }else{
                mostrarMensaje("Notificación Usuario", "Usuario no creado", "Los datos ingresados son invalidos", AlertType.ERROR);
            }

        }
    }

    private UsuarioDto construirUsuarioDto() {
        return new UsuarioDto(
                txtNombre.getText(),
                txtCedula.getText(),
                txtCorreo.getText()
        );
    }

    private void limpiarCamposUsuario() {
        txtNombre.setText("");

        txtCedula.setText("");

        txtCorreo.setText("");

    }

    private boolean datosValidos(UsuarioDto usuarioDto) {
        String mensaje = "";
        if(usuarioDto.nombre() == null || usuarioDto.nombre().equals(""))
            mensaje += "El nombre es invalido \n" ;
        if(usuarioDto.cedula() == null || usuarioDto.cedula().equals(""))
            mensaje += "El documento es invalido \n" ;
        if(usuarioDto.correo() == null || usuarioDto.correo().equals(""))
            mensaje += "El correo es invalido \n" ;
        if(mensaje.equals("")){
            return true;
        }else{
            mostrarMensaje("Notificación cliente","Datos invalidos",mensaje, AlertType.WARNING);
            return false;
        }
    }

    private void mostrarMensaje(String titulo, String header, String contenido, AlertType alertType) {
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
