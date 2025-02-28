package uniquindio.edu.co.baseparcial.mapping.mapper;

import uniquindio.edu.co.baseparcial.mapping.dto.EstudianteDto;
import uniquindio.edu.co.baseparcial.model.Estudiante;
import java.util.List;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

public interface ColegioMapper {
    ColegioMapper INSTANCE = Mappers.getMapper(ColegioMapper.class);

    @Named("estudianteToEstudianteDto")
    EstudianteDto estudianteToEstudianteDto(Estudiante estudiante);

    Estudiante empleadoDtoToEmpleado(EstudianteDto estudianteDto);

    @IterableMapping(qualifiedByName = "empleadoToEmpleadoDto")
    List<EstudianteDto> getEstudiantesDto(List<Estudiante> listaEstudiantes);

//    @Named("mappingToEstudianteDto")
//    EstudianteDto mappingToEstudianteDto(Estudiante estudiante);

}
