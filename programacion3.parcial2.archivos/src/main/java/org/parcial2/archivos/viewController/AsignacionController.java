package org.parcial2.archivos.viewController;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AsignacionController {

    @FXML
    private TableColumn<List<String>, String> CAM;

    @FXML
    private TableColumn<List<String>, String> CDM;

    @FXML
    private TableColumn<List<String>, String> CEM;

    @FXML
    private TableColumn<List<String>, String> CMM;

    @FXML
    private TextField asignacionCodigo;

    @FXML
    private ComboBox<String> datosMateria;

    @FXML
    private TableColumn<List<String>, String> IDE;

    @FXML
    private TableColumn<List<String>, String> IDP;

    @FXML
    private TableColumn<List<String>, String> NombreE;

    @FXML
    private TableColumn<List<String>, String> NombreP;


    @FXML
    private TableView<List<String>> tablaE;

    @FXML
    private TableView<List<String>> tablaP;

    @FXML
    private TableView<List<String>> tablaA;


    public void initialize() {
        List<String> materias = obtenerMaterias();
        ObservableList<String> data = FXCollections.observableArrayList(materias);
        datosMateria.setItems(data);

        //DATOS ESTUDIANTES
        List<List<String>> estudiantes = obtenerEstudiantes();
        ObservableList<List<String>> dataEstudiantes = FXCollections.observableArrayList(estudiantes);
        IDE.setCellValueFactory(data1 -> new SimpleStringProperty(data1.getValue().get(0)));
        NombreE.setCellValueFactory(data1 -> new SimpleStringProperty(data1.getValue().get(1)));
        tablaE.setItems(dataEstudiantes);

        //DATOS PROFESORES
        List<List<String>> profesores = obtenerProfesores();
        ObservableList<List<String>> dataProfesores = FXCollections.observableArrayList(profesores);
        IDP.setCellValueFactory(data1 -> new SimpleStringProperty(data1.getValue().get(0)));
        NombreP.setCellValueFactory(data1 -> new SimpleStringProperty(data1.getValue().get(1)));
        tablaP.setItems(dataProfesores);

        CAM.setCellValueFactory(data2 -> new SimpleStringProperty(data2.getValue().get(0)));
        CMM.setCellValueFactory(data2 -> new SimpleStringProperty(data2.getValue().get(1)));
        CDM.setCellValueFactory(data2 -> new SimpleStringProperty(data2.getValue().get(2)));
        CEM.setCellValueFactory(data2 -> new SimpleStringProperty(data2.getValue().get(3)));

        tablaE.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }

    private List<String> obtenerMaterias() {
        List<String> materias = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/persistencia/materia.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                materias.add(line.split("@@")[0] + " " + line.split("@@")[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return materias;
    }

    private List<List<String>> obtenerEstudiantes() {
        List<List<String>> estudiantes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/persistencia/estudiante.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 5) {
                    String id = parts[4];
                    String nombre = parts[0];
                    estudiantes.add(List.of(id, nombre));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return estudiantes;
    }

    private List<List<String>> obtenerProfesores() {
        List<List<String>> profesores = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/persistencia/profesor.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 5) {
                    String id = parts[4];
                    String nombre = parts[0];
                    profesores.add(List.of(id, nombre));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return profesores;
    }

    @FXML
    private void agregarATablaA() {
        // Obtener los datos seleccionados de las tablas y del ComboBox
        ObservableList<List<String>> estudiantesSeleccionados = tablaE.getSelectionModel().getSelectedItems();
        List<String> profesorSeleccionado = tablaP.getSelectionModel().getSelectedItem();
        String materiaSeleccionada = datosMateria.getSelectionModel().getSelectedItem();
        String codigoAsignacion = asignacionCodigo.getText();

        // Verificar que se haya seleccionado al menos un estudiante, un profesor, una materia y que el TextField no esté vacío
        if(estudiantesSeleccionados.isEmpty() || profesorSeleccionado == null || materiaSeleccionada == null || codigoAsignacion.isEmpty()){
            mostrarMensaje("Error", "Datos incompletos", "Por favor, complete todos los campos", Alert.AlertType.ERROR);
        }else if
            (!estudiantesSeleccionados.isEmpty() && profesorSeleccionado != null && materiaSeleccionada != null && !codigoAsignacion.isEmpty()) {
            // Concatenar los IDs de los estudiantes seleccionados en una sola cadena, separados por "@@"
            String estudiantesConcatenados = estudiantesSeleccionados.stream()
                    .map(estudiante -> estudiante.get(0))
                    .collect(Collectors.joining("@@"));

            // Crear una nueva lista con los datos a agregar a tablaA
            List<String> datosNuevos = List.of(codigoAsignacion, materiaSeleccionada, profesorSeleccionado.get(0), estudiantesConcatenados);

            // Agregar los datos nuevos a tablaA
            tablaA.getItems().add(datosNuevos);
        }
    }

        @FXML
        private void exportarTxt () {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/resources/persistencia/asignacion.txt"))) {
                for (List<String> fila : tablaA.getItems()) {
                    String linea = String.join("@@", fila);
                    bw.write(linea);
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

}

