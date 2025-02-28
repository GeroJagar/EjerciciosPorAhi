package uniquindio.edu.co.baseparcial.utils;

import uniquindio.edu.co.baseparcial.model.Colegio;
import uniquindio.edu.co.baseparcial.model.Estudiante;

public class ColegioUtils {

    public static Colegio inicializarDatos() {
        Colegio colegio = new Colegio();

        Estudiante estudiante1 = new Estudiante();
        estudiante1.setNombre("Juan Arias");
        estudiante1.setCodigo("195878390");
        estudiante1.setNota1(3.0);
        estudiante1.setNota2(4.0);
        estudiante1.setNota3(5.0);
        colegio.getEstudiantes().add(estudiante1);

        Estudiante estudiante2 = new Estudiante();
        estudiante2.setNombre("Juan Arias");
        estudiante2.setCodigo("195878390");
        estudiante2.setNota1(3.0);
        estudiante2.setNota2(4.0);
        estudiante2.setNota3(5.0);
        colegio.getEstudiantes().add(estudiante2);

        System.out.println("Información del colegio creada");
        return colegio;
    }
}
