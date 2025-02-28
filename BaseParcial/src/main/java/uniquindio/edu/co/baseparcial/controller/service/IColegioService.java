package uniquindio.edu.co.baseparcial.controller.service;

import uniquindio.edu.co.baseparcial.exceptions.EstudianteException;
import uniquindio.edu.co.baseparcial.model.Estudiante;

public interface IColegioService {
    Estudiante obtenerEstudiante(String codigo);
    boolean actualizarEmpleado(String cedulaActual, Estudiante estudiante) throws EstudianteException;
}
