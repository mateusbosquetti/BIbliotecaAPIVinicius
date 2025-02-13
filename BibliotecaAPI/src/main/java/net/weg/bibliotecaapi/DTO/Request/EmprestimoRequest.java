package net.weg.bibliotecaapi.DTO.Request;

import jakarta.validation.constraints.NotNull;

public record EmprestimoRequest (
        @NotNull Integer usuario_id,
        @NotNull Integer livro_id
) {
}
