package net.weg.bibliotecaapi.DTO.Response;

import java.time.LocalDate;

public record EmprestimoResponse (
        Integer id,
        Integer usuario_id,
        Integer livro_id,
        LocalDate horarioFeito
) {
}
