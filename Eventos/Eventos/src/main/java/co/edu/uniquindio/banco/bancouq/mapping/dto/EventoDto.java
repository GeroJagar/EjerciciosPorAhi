package co.edu.uniquindio.banco.bancouq.mapping.dto;

public record EventoDto(
        String id,
        String nombre,
        String descripcion,
        String fecha,
        Integer capacidadMax) {
}
