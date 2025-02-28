//------─────▄████▀█▄
//        ───▄█████████████████▄
//    ▄    ─▄█████.▼.▼.▼.▼.▼.▼▼▼▼
//         ██████
//         ██       @autor Geronimo (solo nacio locas)
//         ██████
//        ▄███████▄.▲.▲▲▲▲▲▲▲▲
//        ████████████████████▀▀
package uniquindio.edu.co.baseparcial.model;

import uniquindio.edu.co.baseparcial.controller.service.IColegioService;
import uniquindio.edu.co.baseparcial.exceptions.EstudianteException;

import java.io.Serializable;
import java.util.ArrayList;

public class Colegio implements Serializable, IColegioService {
    private static final long serialVersionUID = 1L;

    ArrayList<Estudiante> estudiantes = new ArrayList<>();
    public Colegio() {}

    public boolean actualizarEmpleado(String codigo, Estudiante estudiante) throws EstudianteException {
        Estudiante estudianteActual = obtenerEstudiante(codigo);
        if(estudianteActual == null)
            throw new EstudianteException("El estudiante a actualizar no existe");
        else{
            estudianteActual.setNombre(estudiante.getNombre());
            estudianteActual.setCodigo(estudiante.getCodigo());
            estudianteActual.setNota1(estudiante.getNota1());
            estudianteActual.setNota2(estudiante.getNota2());
            estudianteActual.setNota3(estudiante.getNota3());
            return true;
        }
    }


    public Estudiante obtenerEstudiante(String codigo){
        Estudiante empleadoEncontrado = null;
        for (Estudiante estudiante : getEstudiantes()) {
            if(estudiante.getCodigo().equalsIgnoreCase(codigo)){
                empleadoEncontrado = estudiante;
                break;
            }
        }
        return empleadoEncontrado;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
}
